package com.dangdang.common.utils;

import lombok.AccessLevel;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.POIXMLDocument;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.ss.util.RegionUtil;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.Assert;

import javax.servlet.http.HttpServletResponse;
import java.beans.PropertyDescriptor;
import java.io.*;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.sql.Timestamp;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Create by tianjiaqin 2018/11/12
 */
@Slf4j
@NoArgsConstructor(access = AccessLevel.PRIVATE)
public final class ExcelUtils {

    /**
     * Excel行注释-用于获取Excel表头
     **/
    @Documented
    @Target(ElementType.FIELD)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Header {

        String name() default "";
    }

    @Documented
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Version {

        /**
         * excel版本号:根据年份来
         **/
        String number() default "2007";

        /**
         * 2003版本后缀是xls
         **/
        String suffix() default "xlsx";
    }

    /**
     * Excel版本号
     **/
    private static final String VERSION_2003 = "2003";

    private static final String VERSION_2007 = "2007";

    private static final String VERSION_2003_SUFFIX = "xls";

    private static final String VERSION_2007_SUFFIX = "xlsx";

    /**
     * 回车符
     **/
    private static final String ENTER_SIGN = "(\n)";

    /**
     * 字体大小设置
     **/
    private static final Short FONT_SIZE = 11;

    /**
     * 字体类型
     **/
    private static final String FONT_NAME = "微软雅黑";

    /**
     * 每一个sheet的最大可识别行数
     **/
    private static final int DEFAULT_EXCEL_ROW_NUM = 20000;

    /**
     * Excel首个有效行和Excel表头之间的行数差
     **/
    private static final int MAX_HEADER_ROW_NUM = 20;

    /**
     * 默认单元格宽度
     **/
    private static final int DEFAULT_CELL_WIDTH = 25;

    /**
     * 默认行高
     **/
    private static final int DEFAULT_ROW_HEIGHT = 20 * 25;

    /**
     * 默认列宽的倍数
     **/
    private static final int DEFAULT_CELL_WIDTH_MULTIPLE = 256;

    /**
     * 默认序号列title名称
     **/
    private static final String DEFAULT_SERIAL_NUM = "序号";

    /**
     * 标准的日期格式化字符串
     **/
    private static final String DATE_FORMAT = "yyyy/MM/dd";

    /**
     * 标准的日期时间格式化字符串
     **/
    private static final String DATETIME_FORMAT = "yyyy-MM-dd hh:mm:ss";

    /**
     * 中文正则
     **/
    private static final String CHINESE_REGEX = "﻿([\u3001-\u3003]|[\u4E00-\u9FA5]|[\uFE30-\uFFA0])+";

    /**
     * 取余常量
     **/
    private static final int EVEN = 2;

    /**
     * 中文左括号
     **/
    private static final String CHINA_LEFT_BRACKET = "（";

    /**
     * 回车换行
     **/
    private static final String NEW_LINE_SIGN = "\r\n";

    /**
     * 通过文件读取excel
     *
     * @param filePath 文件路径
     * @param clazz    数据类
     * @return 返回数据集
     * @throws Exception 异常
     */
    public static <T> List<T> loadFromExcel(String filePath, Class<T> clazz) throws Exception {
        FileInputStream in = new FileInputStream(new File(filePath));
        return loadFromExcel(in, clazz);
    }

    /**
     * 通过数据流读取excel
     * 使用扩展字段
     *
     * @param in    输入流
     * @param clazz 数据类
     * @param <T>   数据对象
     * @return 返回数据集
     * @throws Exception 异常
     */
    public static <T> List<T> loadFromExcel(InputStream in, Class<T> clazz) throws Exception {

        Map<String, String> headerNames = new LinkedHashMap<>(10);
        /*根据clazz获取excel需要的表头**/
        getTitles(in, clazz, headerNames);

        /*根据数据流新建excel对象**/
        Workbook xwb = newExcelByInputStream(in);

        /*获取xwb中数据对象**/
        Sheet sheet = xwb.getSheetAt(0);

        /*根据clazz注解文字和excel表头比较,校验表头是否一致**/
        Row headerRow = validExcelFormatAndGetHeaderRow(sheet, headerNames);

        /*转移数据，从excel到list**/
        List<T> list = transferExcelData(clazz, headerNames, sheet, headerRow);

        return list;
    }

    /**
     * 数据写出到excel文件
     *
     * @param response 输出流
     * @param clazz    数据类
     * @param list     数据列表
     * @param <T>      数据列中-对应的数据对象
     * @return 返回成功或失败
     */
    public static <T> boolean writeToExcel(HttpServletResponse response, Class<T> clazz, List<T> list, String fileNamePrefix) {
        return writeToExcel(response, clazz, list, fileNamePrefix, null);
    }

    /**
     * 数据写出到excel文件
     *
     * @param response            输出流
     * @param clazz               数据类
     * @param list                数据列表
     * @param <T>                 数据列中-对应的数据对象
     * @param specialTitleContent 特殊表头
     * @return 返回成功或失败
     */
    public static <T> boolean writeToExcel(HttpServletResponse response, Class<T> clazz, List<T> list, String fileNamePrefix, String specialTitleContent) {

        Assert.notNull(list, "导出的内容为空,写入失败");
        Assert.notEmpty(list, "导出的内容为空,写入失败");

        try {
            response.setContentType("application/form-data");
            String fileName = new String(fileNamePrefix.getBytes("utf-8"), "ISO8859-1");
            fileName = fileName + "." + suffixExcelByVersion(clazz);
            response.setHeader("Content-Disposition", "attachment;filename=" + fileName);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        Workbook workbook = newExcelByVersion(clazz);
        writeToWorkbook(workbook, clazz, list, specialTitleContent);
        if (null == workbook) {
            Assert.notEmpty(list, "Excel对象创建失败");
        }
        boolean returnVal = false;
        try {
            workbook.write(response.getOutputStream());
            returnVal = true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnVal;
    }

    /**
     * 写入数据到excel对象中
     *
     * @param <T>                 数据对象泛型
     * @param clazz               数据类
     * @param list                数据列表
     * @param specialTitleContent 特殊表头内容
     * @return 返回workbook
     */
    public static <T> Workbook writeToWorkbook(Workbook workbook, Class<T> clazz, List<T> list, String specialTitleContent) {

        Map<String, String> headerTitles = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        List<String> headerNames = getTitles(headerTitles, fields);
        if (headerTitles.isEmpty()) {
            Assert.notEmpty(list, "表头为空,不创建Excel");
        }

        CellStyle specialHeaderStyle = newTableSpecialHeaderStyle(workbook, specialTitleContent);
        CellStyle headerStyle = newTableHeaderStyle(workbook);
        CellStyle evenStyle = newTableEvenCellStyle(workbook);
        CellStyle oddStyle = newTableOddCellStyle(workbook);

        Row row;
        int rowNumber = 0;
        Sheet sheet = null;
        /*默认行高*/
        Short rowHeight = DEFAULT_ROW_HEIGHT;
        Map<Integer, Integer> columnWidths = new LinkedHashMap<>();
        for (int i = 0, length = list.size(); i < length; i++) {

            if (rowNumber == 0 || rowNumber % DEFAULT_EXCEL_ROW_NUM == 0) {
                rowNumber = 0;
                sheet = workbook.createSheet();
                //设置特殊的表头(表格备注等)
                setExcelSpecialTitleDatas(sheet, specialTitleContent, headerNames, specialHeaderStyle, rowHeight, columnWidths, rowNumber);
                if (!StringUtils.isBlank(specialTitleContent)) {
                    rowNumber++;
                }
                //设置正常的表头
                setExcelTitleDatas(sheet, headerNames, headerStyle, rowHeight, columnWidths, rowNumber);
                rowNumber++;
            }

            row = sheet.createRow(rowNumber % DEFAULT_EXCEL_ROW_NUM);
            row.setHeight(rowHeight);
            for (int j = 0; j < headerNames.size(); j++) {
                setExcelCellData(row, list, headerTitles, headerNames, evenStyle, oddStyle, rowNumber, columnWidths, i, j);
            }

            rowNumber++;
            setColumnsWidth(sheet, columnWidths);
        }
        return workbook;
    }

    /**
     * 写数据到WorkBook中
     * 和方法writeToWorkbook的区别是: 设置单元格宽度的方式不同
     *
     * @param clazz               数据集中对象类型
     * @param list                数据集
     * @param <T>                 数据集对象
     * @param specialTitleContent 特殊表头内容
     * @return 返回excel-workbook
     * @throws Exception 异常
     */
    public static <T> Workbook writeToWorkbook2(Class<T> clazz, List<T> list, String specialTitleContent) throws Exception {

        Map<String, String> headerTitles = new HashMap<>();
        Field[] fields = clazz.getDeclaredFields();
        List<String> headerNames = getTitles(headerTitles, fields);
        if (headerTitles.isEmpty()) {
            Assert.notEmpty(list, "表头为空,不创建Excel");
        }
        Workbook workbook = new HSSFWorkbook();
        CellStyle specialHeaderStyle = newTableSpecialHeaderStyle(workbook, specialTitleContent);
        CellStyle headerStyle = newTableHeaderStyle(workbook);
        CellStyle evenStyle = newTableEvenCellStyle(workbook);
        CellStyle oddStyle = newTableOddCellStyle(workbook);

        Row row;
        int rowNumber = 0;
        Sheet sheet = null;
        Short rowHeight = DEFAULT_ROW_HEIGHT;
        Map<Integer, Integer> columnWidths = new LinkedHashMap<>();
        for (int i = 0, length = list.size(); i < length; i++) {

            if (rowNumber == 0 || rowNumber % DEFAULT_EXCEL_ROW_NUM == 0) {
                rowNumber = 0;
                sheet = workbook.createSheet();
                //设置特殊的表头(表格备注等)
                setExcelSpecialTitleDatas(sheet, specialTitleContent, headerNames, specialHeaderStyle, rowHeight, columnWidths, rowNumber);
                //设置正常的表头
                setExcelTitleDatas(sheet, headerNames, headerStyle, rowHeight, columnWidths, rowNumber);
                rowNumber++;
            }

            row = sheet.createRow(rowNumber % DEFAULT_EXCEL_ROW_NUM);
            row.setHeight(rowHeight);
            for (int j = 0; j < headerNames.size(); j++) {
                setExcelCellData2(sheet, row, list, headerTitles, headerNames, evenStyle, oddStyle, rowNumber, columnWidths, i, j);
            }

            rowNumber++;
        }
        return workbook;
    }



    /*
     ****************************************私有方法区*******************************************
                   _               _                           _    _                 _
                  (_)             | |                         | |  | |               | |
      _ __   _ __  _ __   __ __ _ | |_  ___   _ __ ___    ___ | |_ | |__    ___    __| |
     | '_ \ | '__|| |\ \ / // _` || __|/ _ \ | '_ ` _ \  / _ \| __|| '_ \  / _ \  / _` |
     | |_) || |   | | \ V /| (_| || |_|  __/ | | | | | ||  __/| |_ | | | || (_) || (_| |
     | .__/ |_|   |_|  \_/  \__,_| \__|\___| |_| |_| |_| \___| \__||_| |_| \___/  \__,_|
     | |
     |_|
     ****************************************私有方法区*******************************************
     */


    /**
     * 转移数据，从excel到list
     **/
    private static <T> List<T> transferExcelData(Class<T> clazz, Map<String, String> headerNames, Sheet sheet, Row headerRow) throws Exception {
        List<T> list = new ArrayList<>();
        boolean hasOneRight = false;
        Integer firstNum = sheet.getFirstRowNum();
        Integer beginRowNum = headerRow.getRowNum();
        if (beginRowNum > firstNum) {
            firstNum = beginRowNum;
        }
        for (int i = firstNum + 1; i <= DEFAULT_EXCEL_ROW_NUM; i++) {

            Row row = sheet.getRow(i);
            if (null == row) {
                break;
            }
            T t = clazz.newInstance();

            //原来逻辑:--整行为空,则跳出循环
            //现在的逻辑:--整行为空时,结束本层循环读取下一行
            /*设置每一行的数据**/
            if (getExcelLineData(headerNames, headerRow, row, t)) {
                continue;
            }
            list.add(t);

            hasOneRight = true;
        }
        /*至少有一行数据**/
        if (!hasOneRight) {
            throw new RuntimeException("模板文件错误");
        }
        if (list.size() > DEFAULT_EXCEL_ROW_NUM) {
            throw new RuntimeException("超出模板单sheet行数限制");
        }
        return list;
    }

    /**
     * 从Excel获取每一行的数据
     **/
    private static <T> boolean getExcelLineData(Map<String, String> headerNames, Row headerRow, Row row, T t) throws Exception {
        //是否整行为空
        boolean isAllBlank = true;
        for (int j = 0; j < row.getLastCellNum(); j++) {
            Cell cell = row.getCell(j);
            //获取首行 对应列的字段
            String propertyName = headerNames.get(getCellValueByType(headerRow.getCell(j), String.class));

            if (StringUtils.isNotBlank(propertyName)) {
                //获取当前列对应的bean字段
                PropertyDescriptor descriptor = PropertyUtils.getPropertyDescriptor(t, propertyName);
                //获取bean字段的数据类型
                Class<?> type = descriptor.getPropertyType();

                String cellValue = getCellValueByType(cell, type);
                if (!StringUtils.isBlank(cellValue)) {
                    isAllBlank = false;
                }

                //给当前行对应的bean对象的某个字段赋值
                PropertyUtils.setSimpleProperty(t, propertyName, transferStringToObject(type, cellValue));
            }
        }
        return isAllBlank;
    }

    /**
     * 根据clazz注解文字和excel表头比较,校验是否符合
     **/
    private static Row validExcelFormatAndGetHeaderRow(Sheet sheet, Map<String, String> headerNames) throws Exception {
        Integer firstRowNum = sheet.getFirstRowNum();
        Integer maxNum = firstRowNum + MAX_HEADER_ROW_NUM;
        for (int j = firstRowNum; j < maxNum; j++) {
            Row headerRow = sheet.getRow(j);
            if (null == headerRow && j < maxNum - 1) {
                continue;
            }
            if (null == headerRow) {
                log.error("Excel有效行和表头之间间隔超过20行");
                break;
            }
            boolean isAllTitleRight = true;
            int cellNum = headerRow.getLastCellNum();
            for (int i = 0; i < cellNum; i++) {
                String titleName = headerRow.getCell(i).getStringCellValue();
                String fieldName = headerNames.get(titleName);
                if (StringUtils.isEmpty(fieldName)) {
                    isAllTitleRight = false;
                }
            }
            if (isAllTitleRight) {
                return headerRow;
            }

            if (j == maxNum - 1) {
                log.error("Excel有效行和表头之间间隔达到20行");
                break;
            }
        }
        throw new RuntimeException("文件模板错误，请更改模板格式！");
    }

    /**
     * 根据数据流新建excel对象
     **/
    private static Workbook newExcelByInputStream(InputStream inp) throws IOException, InvalidFormatException {
        if (!inp.markSupported()) {
            inp = new PushbackInputStream(inp, 8);
        }
        //操作Excel2003以前（包括2003）的版本，扩展名是.xls
        if (POIFSFileSystem.hasPOIFSHeader(inp)) {
            return new HSSFWorkbook(inp);
        }
        //操作Excel2007的版本，扩展名是.xlsx
        if (POIXMLDocument.hasOOXMLHeader(inp)) {
            return new XSSFWorkbook(OPCPackage.open(inp));
        }
        throw new IllegalArgumentException("Excel文件格式错误,请使用2003版本的Excel上传！");
    }

    /**
     * 根据数据流获取excel版本
     **/
    private static String suffixExcelByVersion(Class clazz) {
        Version version = (Version) clazz.getAnnotation(Version.class);
        if (null == version) {
            //默认2007版本
            return VERSION_2007_SUFFIX;
        }

        if (VERSION_2007.equals(version.number())) {
            return VERSION_2007_SUFFIX;
        }

        if (VERSION_2003.equals(version.number())) {
            return VERSION_2003_SUFFIX;
        }

        //默认2007版本
        return VERSION_2007_SUFFIX;
    }

    /**
     * 根据数据流新建excel对象
     **/
    private static <T> Workbook newExcelByVersion(Class<T> clazz) {
        Version version = clazz.getAnnotation(Version.class);
        if (null == version) {
            //默认2007版本
            return new XSSFWorkbook();
        }

        if (VERSION_2007.equals(version.number())) {
            return new XSSFWorkbook();
        }

        if (VERSION_2003.equals(version.number())) {
            return new HSSFWorkbook();
        }

        //默认2007版本
        return new XSSFWorkbook();
    }

    /**
     * 获取单元格的值
     * 单元格类型：
     * Cell.CELL_TYPE_BLANK 空白
     * Cell.CELL_TYPE_NUMERIC 数字类型
     * Cell.CELL_TYPE_STRING 字符类型
     * Cell.CELL_TYPE_FORMULA 公式类型
     * Cell.CELL_TYPE_BOOLEAN BOOL类型
     * Cell.CELL_TYPE_ERROR 单元格格式错误类型
     *
     * @param cell  单元格对象
     * @param clazz 单元格数据类型
     * @return 返回转换之后的字符串值
     */
    private static String getCellValueByType(Cell cell, Class clazz) {
        try {
            if (null == cell) {
                return "";
            }
            if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
                return "";
            }
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    SimpleDateFormat sdf = new SimpleDateFormat(DATE_FORMAT);
                    return sdf.format(HSSFDateUtil.getJavaDate(cell.getNumericCellValue()));
                }
                DecimalFormat df = new DecimalFormat("0");
                if (clazz.equals(BigDecimal.class)) {
                    df = new DecimalFormat("0.00");
                }
                //TODO BigDecimal类型数据转换时,不会四舍五入
                df.setRoundingMode(RoundingMode.DOWN);
                return df.format(cell.getNumericCellValue());
            }
            if (cell.getCellType() == Cell.CELL_TYPE_STRING) {
                return cell.getStringCellValue();
            }
            if (cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
                return cell.getCellFormula();
            }
            if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
                return String.valueOf(cell.getBooleanCellValue());
            }
            if (cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                return String.valueOf(cell.getErrorCellValue());
            }
            return cell.getStringCellValue();
        } catch (RuntimeException e) {
            log.error("单元格字符值获取,错误信息{}", e.getMessage());
        }
        return "";
    }

    /**
     * 根据单元格类型，设置单元格的值
     *
     * @param cell  单元格对象
     * @param value 单元格值
     */
    private static void setCellValueByType(Cell cell, Object value) {
        if (null == value) {
            return;
        }
        if (value instanceof BigDecimal) {
            cell.setCellValue(String.valueOf(value));
        } else if (value instanceof Long) {
            cell.setCellValue(((Long) value));
        } else if (value instanceof Integer) {
            cell.setCellValue(((Integer) value));
        } else if (value instanceof Float) {
            cell.setCellValue(String.valueOf(value));
        } else if (value instanceof Double) {
            cell.setCellValue(String.valueOf(value));
        } else if (value instanceof Boolean) {
            cell.setCellValue((Boolean) value);
        } else if (value instanceof Byte) {
            cell.setCellValue(((Byte) value));
        } else if (value instanceof String) {
            cell.setCellValue(String.valueOf(value));
        } else if (value instanceof Timestamp) {
            SimpleDateFormat dateFormat = new SimpleDateFormat(DATETIME_FORMAT);
            cell.setCellValue(dateFormat.format(value));
        }
    }


    /**
     * 字符串转对象
     *
     * @param clazz 对象类
     * @param str   字符串内容
     * @return 返回转换之后的对象值
     * @throws Exception 异常
     */
    private static Object transferStringToObject(Class<?> clazz, String str) throws Exception {
        Object o = str;
        if (clazz == BigDecimal.class) {
            if (StringUtils.isBlank(str)) {
                o = BigDecimal.valueOf(0);
            } else {
                o = new BigDecimal(str);
            }
        } else if (clazz == Long.class) {
            if (StringUtils.isBlank(str)) {
                o = 0;
            } else {
                o = new Long(str);
            }
        } else if (clazz == Integer.class) {
            if (StringUtils.isBlank(str)) {
                o = 0;
            } else {
                o = new Integer(str);
            }
        } else if (clazz == int.class) {
            o = Integer.parseInt(str);
        } else if (clazz == float.class) {
            o = Float.parseFloat(str);
        } else if (clazz == boolean.class) {
            o = Boolean.parseBoolean(str);
        } else if (clazz == byte.class) {
            o = Byte.parseByte(str);
        }
        return o;
    }

    /**
     * 根据clazz获取excel需要的表头
     **/
    private static <T> void getTitles(InputStream in, Class<T> clazz, Map<String, String> headerNames) throws Exception {
        Field[] fields = clazz.getDeclaredFields();
        for (Field m : fields) {
            if (m.isAnnotationPresent(Header.class)) {
                // 获取该字段的注解对象
                Header anno = m.getAnnotation(Header.class);
                headerNames.put(anno.name(), m.getName());
            }
        }
        if (headerNames.isEmpty()) {
            if (null != in) {
                in.close();
            }
            throw new RuntimeException("模板文件错误");
        }
    }

    /**
     * 从对象中获取Excel表头
     *
     * @param headerTitles title名称和字段名称的对应关系
     * @param fields       对象对应的字段
     * @return 返回Title名称
     */
    private static List<String> getTitles(Map<String, String> headerTitles, Field[] fields) {
        List<String> headerNames = new ArrayList<>();
        for (Field m : fields) {
            if (m.isAnnotationPresent(Header.class)) {
                Header anno = m.getAnnotation(Header.class);
                headerTitles.put(anno.name(), m.getName());
                headerNames.add(anno.name());
            }
        }
        return headerNames;
    }

    /**
     * 新建表头单元格样式
     *
     * @param wb                  workbook对象
     * @param specialTitleContent 特殊表头
     * @return 返回单元格格式
     */
    private static CellStyle newTableSpecialHeaderStyle(Workbook wb, String specialTitleContent) {
        if (StringUtils.isBlank(specialTitleContent)) {
            return null;
        }
        CellStyle style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setAlignment(CellStyle.ALIGN_LEFT);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.WHITE.getIndex());
        style.setWrapText(true);
        Font font = wb.createFont();
        font.setColor(IndexedColors.RED.index);
        font.setFontHeightInPoints(FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        return style;
    }

    /**
     * 新建表头单元格样式
     *
     * @param wb workbook对象
     * @return 返回单元格格式
     */
    private static CellStyle newTableHeaderStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setVerticalAlignment(CellStyle.VERTICAL_CENTER);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.BLUE_GREY.getIndex());
        style.setWrapText(true);
        Font font = wb.createFont();
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        font.setFontHeightInPoints(FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        return style;
    }

    /**
     * 新建偶数行单元格样式
     *
     * @param wb workbook对象
     * @return 返回单元格格式
     */
    private static CellStyle newTableEvenCellStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        style.setFillForegroundColor(IndexedColors.GREY_25_PERCENT.getIndex());
        Font font = wb.createFont();
        font.setFontHeightInPoints(FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        return style;
    }

    /**
     * 新建奇数行单元格样式
     *
     * @param wb workbook对象
     * @return 返回单元格格式
     */
    private static CellStyle newTableOddCellStyle(Workbook wb) {
        CellStyle style = wb.createCellStyle();
        style.setBorderRight(CellStyle.BORDER_THIN);
        style.setRightBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderBottom(CellStyle.BORDER_THIN);
        style.setBottomBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderLeft(CellStyle.BORDER_THIN);
        style.setLeftBorderColor(IndexedColors.BLACK.getIndex());
        style.setBorderTop(CellStyle.BORDER_THIN);
        style.setTopBorderColor(IndexedColors.BLACK.getIndex());
        style.setAlignment(CellStyle.ALIGN_CENTER);
        style.setWrapText(true);
        Font font = wb.createFont();
        font.setFontHeightInPoints(FONT_SIZE);
        font.setFontName(FONT_NAME);
        style.setFont(font);
        return style;
    }

    /**
     * 收集列宽数据
     *
     * @param columnWidths 列宽数据列表
     * @param headerName   表头名称
     * @param content      单元格内容
     * @param j            列编号
     */
    private static void gatherColumnsWidth(Map<Integer, Integer> columnWidths, String headerName, String content, int j) {
        int length = content.getBytes().length;
        if (headerName.equalsIgnoreCase(content)) {
            if (headerName.indexOf(CHINA_LEFT_BRACKET) > 0) {
                headerName = headerName.replace(CHINA_LEFT_BRACKET, NEW_LINE_SIGN + CHINA_LEFT_BRACKET);
                String lengthStr = headerName.substring(0, headerName.indexOf(CHINA_LEFT_BRACKET));
                length = lengthStr.getBytes().length;
            }
            columnWidths.put(j, length);
        } else {
            if (!content.matches(CHINESE_REGEX)) {
                length = length * 2;
            }
            int oldLength = null == columnWidths.get(j) ? 0 : columnWidths.get(j);
            if (length > DEFAULT_CELL_WIDTH) {
                oldLength = oldLength > DEFAULT_CELL_WIDTH ? oldLength : DEFAULT_CELL_WIDTH;
            } else {
                oldLength = oldLength > length ? oldLength : length;
            }
            columnWidths.put(j, oldLength);
        }
    }

    /**
     * 统一设置列宽
     *
     * @param sheet        表格sheet
     * @param columnWidths 列宽度
     */
    private static void setColumnsWidth(Sheet sheet, Map<Integer, Integer> columnWidths) {
        for (Map.Entry<Integer, Integer> entry : columnWidths.entrySet()) {
            sheet.setColumnWidth(entry.getKey(), (entry.getValue()) * DEFAULT_CELL_WIDTH_MULTIPLE);
        }
    }

    /**
     * 设置excel单元格数据
     **/
    private static <T> void setExcelCellData(Row row, List<T> list, Map<String, String> map, List<String> headerNames, CellStyle evenStyle, CellStyle oddStyle, int rowNumber, Map<Integer, Integer> columnWidths, int i, int j) {
        Cell cell = row.createCell(j);
        if (i % EVEN == 0) {
            cell.setCellStyle(oddStyle);
        } else {
            cell.setCellStyle(evenStyle);
        }
        String headerName = headerNames.get(j);
        if (headerName.equals(DEFAULT_SERIAL_NUM)) {
            setCellValueByType(cell, rowNumber % DEFAULT_EXCEL_ROW_NUM);
        } else {
            T obj = list.get(i);
            Object value;
            try {
                value = PropertyUtils.getSimpleProperty(obj, map.get(headerName));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }

            gatherColumnsWidth(columnWidths, headerName, String.valueOf(value), j);
            setCellValueByType(cell, value);
        }
    }

    /**
     * 设置excel单元格数据
     **/
    private static <T> void setExcelCellData2(Sheet sheet, Row row, List<T> list, Map<String, String> map, List<String> headerNames, CellStyle evenStyle, CellStyle oddStyle, int rowNumber, Map<Integer, Integer> columnWidths, int i, int j) throws Exception {
        Cell cell = row.createCell(j);
        if (i % EVEN == 0) {
            cell.setCellStyle(oddStyle);
        } else {
            cell.setCellStyle(evenStyle);
        }
        String headerName = headerNames.get(j);
        if (headerName.equals(DEFAULT_SERIAL_NUM)) {
            setCellValueByType(cell, rowNumber % DEFAULT_EXCEL_ROW_NUM);
        } else {
            T obj = list.get(i);
            Object value = PropertyUtils.getSimpleProperty(obj, map.get(headerName));
            /*收集列宽度数据**/
            gatherColumnsWidth(columnWidths, headerName, String.valueOf(value), j);
            /*在这里直接对列宽度进行设置**/
            Integer width = columnWidths.get(j);
            sheet.setColumnWidth(j, (width) * DEFAULT_CELL_WIDTH_MULTIPLE);
            setCellValueByType(cell, value);
        }
    }

    /**
     * 设置表头
     *
     * @param sheet        sheet对象
     * @param headerNames  表头数据
     * @param headerStyle  表头单元格
     * @param rowHeight    行高数据
     * @param columnWidths 列宽数据
     * @param rowNumber    行数
     */
    private static void setExcelTitleDatas(Sheet sheet, List<String> headerNames, CellStyle headerStyle, Short rowHeight, Map<Integer, Integer> columnWidths, int rowNumber) {
        Row row;
        row = sheet.createRow(rowNumber % DEFAULT_EXCEL_ROW_NUM);
        row.setHeight(rowHeight);
        for (int j = 0; j < headerNames.size(); j++) {
            Cell headCell = row.createCell(j);
            headCell.setCellStyle(headerStyle);
            String headerName = headerNames.get(j);
            gatherColumnsWidth(columnWidths, headerName, headerName, j);
            setCellValueByType(headCell, headerNames.get(j));
        }
    }

    /**
     * 设置特殊的表头
     **/
    private static void setExcelSpecialTitleDatas(Sheet sheet, String specialTitleContent, List<String> headerNames, CellStyle headerStyle, Short rowHeight, Map<Integer, Integer> columnWidths, int rowNumber) {
        if (StringUtils.isBlank(specialTitleContent)) {
            return;
        }
        Row row = sheet.createRow(rowNumber % DEFAULT_EXCEL_ROW_NUM);
        Cell headCell = row.createCell(0);
        headCell.setCellStyle(headerStyle);
        setCellValueByType(headCell, specialTitleContent);

        /*统计\n符号在文本中的个数**/
        List<String> colgroups = new ArrayList<>();
        gatherCharactorCount(specialTitleContent, colgroups);
        row.setHeight((short) (rowHeight * (colgroups.size())));

        Integer length = headerNames.size();
        /*
         * 设定合并单元格区域范围
         *  firstRow  0-based
         *  lastRow   0-based
         *  firstCol  0-based
         *  lastCol   0-based
         */
        CellRangeAddress cra = new CellRangeAddress(rowNumber, rowNumber, 0, length - 1);
        sheet.addMergedRegion(cra);
        RegionUtil.setBorderBottom(1, cra, sheet, sheet.getWorkbook());
        RegionUtil.setBorderLeft(1, cra, sheet, sheet.getWorkbook());
        RegionUtil.setBorderRight(1, cra, sheet, sheet.getWorkbook());
        RegionUtil.setBorderTop(1, cra, sheet, sheet.getWorkbook());
    }

    /**
     * 统计字符在文本中出现的次数
     **/
    private static void gatherCharactorCount(String specialTitleContent, List<String> colgroups) {
        Pattern p1 = Pattern.compile(ENTER_SIGN);
        Matcher m1 = p1.matcher(specialTitleContent);
        while (m1.find()) {
            for (int i = 0; i < m1.groupCount(); i++) {
                String test1 = m1.group(i);
                colgroups.add(test1);
            }
        }
    }

}
