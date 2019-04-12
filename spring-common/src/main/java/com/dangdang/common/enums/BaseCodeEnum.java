package com.dangdang.common.enums;

import lombok.Getter;

/**
 * Create by tianjiaqin 2018/11/12
 */
@Getter
public enum BaseCodeEnum {

    /**
     * 基本参数
     */
    BASE_REQUEST_SUCCESS(0, "请求成功"),
    BASE_PARAMS_ERROR(1, "参数错误"),
    BASE_SYSTEM_ERROR(2, "系统错误"),
    BASE_OTHER_ERROR(3, "其他错误"),

    /**
     * excel
     */
    EXCEL_IMPORT_FORMAT_ERROR(1101, "文件导入格式有误！"),
    EXCEL_IMPORT_TEMPLATE_ERROR(1102, "导入Excel文件不符合要求"),
    EXCEL_IMPORT_HEADROW_ERROR(1103, "模板导入头部格式错误"),
    EXCEL_IMPORT_EMPTY_ERROR(1104, "导入Excel文件为空"),
    EXCEL_READ_ERROR(1105, "读取excel失败"),
    EXCEL_IMPORT_DATA_BIG_ERROR(1106, "无法处理大于5000条的数据"),
    EXCEL_EXPORT_EMPTY_ERROR(1107, "导出excel数据为空"),

    /**
     * 短信
     */
    SMS_SEND_REPEAT_ERROR(1201, "the sms has been sent, can't repeat send it!"),
    SMS_SEND_MOBILE_ERROR(1202, "the mobile is error, can't send message!"),
    SMS_SEND_FAIL_ERROR(1203, "send sms message is failed"),

    /**
     * 调用第三方
     */
    THIRD_CALL_EXCEPTION_ERROR(1301, "调用第三方异常"),
    THIRD_RETURN_DATA_EMPTY_ERROR(1302, "调用第三方返回数据为空"),

    /**
     * 工具类
     */
    UTILS_RSA_ENCRYPT_EXCEPTION_ERROR(1401, "RSA加解密异常"),
    ;

    private Integer code;
    private String msg;

    BaseCodeEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
