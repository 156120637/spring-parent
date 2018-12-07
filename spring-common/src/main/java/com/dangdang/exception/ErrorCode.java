package com.dangdang.exception;

/**
 * Create by tianjiaqin 2018-12-7
 */
public class ErrorCode {

    public static final Integer REQUEST_ERROR_CODE = 9999;
    public static final String REQUEST_ERROR_MSG = "请求失败";

    /**
     * 基本校验
     */
    public static class Valid {

        public static final Integer PARAM_ERROR_CODE = 1000;
        public static final String PARAM_ERROR_MSG = "请求参数校验异常";

    }

    public static final class Excel {
        public static final Integer EXCEL_FORMAT_ERROR_CODE = 1101;
        public static final String EXCEL_FORMAT_ERROR_MSG = "文件导入格式有误！";
        public static final Integer TEMPLAET_IS_WRONG_CODE = 1102;
        public static final String TEMPLAET_IS_WRONG_MSG = "导入Excel文件不符合要求";
        public static final Integer EXCEL_HEADROW_ERROR_CODE = 1103;
        public static final String EXCEL_HEADROW_ERROR_MSG = "模板导入头部格式错误";
        public static final Integer EXCEL_IS_EMPTY_CODE = 1104;
        public static final String EXCEL_IS_EMPTY_MSG = "导入Excel文件为空";
        public static final Integer READ_EXCEL_ERROR_CODE = 1105;
        public static final String READ_EXCEL_ERROR_MSG = "读取excel失败！";
        public static final Integer IMPORT_QUANTITY_CODE = 1106;
        public static final String IMPORT_QUANTITY_MSG = "无法处理大于5000条的数据";

        public static final Integer EXPORT_EXCEL_IS_EMPTY_CODE = 1107;
        public static final String EXPORT_EXCEL_IS_EMPTY_MSG = "导出excel数据为空！";
    }

}
