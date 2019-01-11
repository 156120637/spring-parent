package com.dangdang.common.utils.easyui.util;

import org.apache.poi.ss.usermodel.BorderStyle;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.ss.util.CellRangeAddress;
import org.apache.poi.xssf.usermodel.*;

public class ExcelUtil {
    private XSSFWorkbook wb = null;

    private XSSFSheet sheet = null;

    /**
     * @param wb
     * @param sheet
     */
    public ExcelUtil(XSSFWorkbook wb, XSSFSheet sheet) {
        this.wb = wb;
        sheet.autoSizeColumn(1);// 自适应列宽
        this.sheet = sheet;
    }

    /**
     * 合并单元格后给合并后的单元格加边框
     *
     * @param region
     * @param cs
     */
    public void setRegionStyle(CellRangeAddress region, XSSFCellStyle cs) {

        int toprowNum = region.getFirstRow();
        for (int i = toprowNum; i <= region.getLastRow(); i++) {
            XSSFRow row = sheet.getRow(i);
            for (int j = region.getFirstColumn(); j <= region.getLastColumn(); j++) {
                XSSFCell cell = row.getCell(j);
                cell.setCellStyle(cs);
            }
        }
    }

    /**
     * 设置表头的单元格样式
     *
     * @return
     */
    public XSSFCellStyle getHeadStyle() {
        // 创建单元格样式
        XSSFCellStyle cellStyle = wb.createCellStyle();
        // 设置单元格垂直居中对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 创建单元格内容显示不下时自动换行
        cellStyle.setWrapText(true);
        // 设置单元格居中对齐
        cellStyle.setAlignment(HorizontalAlignment.CENTER);

        // 设置单元格字体样式
        XSSFFont font = wb.createFont();
        // 设置字体加粗
        font.setBold(true);
        font.setFontName("宋体");
//        font.setFontHeight((short) 250);
        cellStyle.setFont(font);
        // 设置单元格边框为细线条
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        return cellStyle;
    }

    /**
     * 设置表体的单元格样式
     *
     * @return
     */
    public XSSFCellStyle getBodyStyle() {
        // 创建单元格样式
        XSSFCellStyle cellStyle = wb.createCellStyle();
        // 设置单元格居中对齐
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        // 设置单元格垂直居中对齐
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        // 创建单元格内容显示不下时自动换行
        cellStyle.setWrapText(true);
        // 设置单元格字体样式
        XSSFFont font = wb.createFont();
        // 设置字体加粗
        // font.setBold(true);// 粗体显示
        font.setFontName("宋体");
        font.setFontHeight((short) 200);
        cellStyle.setFont(font);
        // 设置单元格边框为细线条
        cellStyle.setBorderBottom(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        cellStyle.setBorderRight(BorderStyle.THIN);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        return cellStyle;
    }
}
