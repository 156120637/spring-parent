package com.dangdang.web.easyui.controller;

import com.dangdang.service.biz.service.OrderService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;

/**
 * 导出excel文件
 */
@Controller
@RequestMapping("/excel")
public class ExcelController {

    @Autowired
    private OrderService orderService;

    /**
     * 导出订单的excel详细信息
     * @param response
     */
    @GetMapping("/export")
    public void exportExcel(HttpServletResponse response){
        response.setContentType("application/binary;charset=ISO8859-1");
        try
        {
            ServletOutputStream outputStream = response.getOutputStream();
            String fileName = new String(("书画网-订单详情").getBytes(), "ISO8859-1");
            /*xlsx 跟xls的工作蒲使用工具类不同*/
            response.setHeader("Content-disposition", "attachment; filename=" + URLEncoder.encode(fileName,"ISO8859-1") + ".xlsx");// 组装附件名称和格式
            XSSFWorkbook workbook = orderService.orderExcel();
            workbook.write(outputStream);
//            workbook.close();
            outputStream.flush();
            outputStream.close();
        } catch (IOException e)  {
            e.printStackTrace();
        }
    }
}
