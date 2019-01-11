package com.dangdang.web.easyui.controller;

import com.dangdang.service.biz.service.OrderService;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@RequestMapping("/email")
public class EmailController {

    @Autowired
    JavaMailSenderImpl mailSender;/*邮箱工具类*/

    @Autowired
    private OrderService orderService;/*订单信息*/


    /**
     * 发送邮件
     * @param email
     * @return
     */
    @RequestMapping("/sendMail")
    @ResponseBody
    public void sendMail(String email){
        MimeMessage mimeMessage = mailSender.createMimeMessage();

        try {
            // 这里的true是发送附件的意思
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage,true);
            helper.setSubject("书画网-订单详情附件");
            // true 是解析html标签
            Date date = new Date();
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
            String format = simpleDateFormat.format(date);
            String html = "<!DOCTYPE html><html><head><meta charset='utf-8' /><title></title></head><body style='background-color: #F7F7F7;text-align: left;'><div><br /><div id='' style='background-color: #FFFFFF;padding: 10px;border:1px #DCDCDC solid;'><h3>亲爱的用户:</h3><p>您好!感谢使用书画网提供的服务,您收到了一封来自书画网的邮件,请及时查看.再次感谢您的使用.</p><br /><br /><p>书画网-团队<br /><span>时间:"+format+"</span></p></div></div></body></html>";
            helper.setText(html,true);

            helper.setTo(email);/*接收地址*/

            helper.setFrom("xxxxx@qq.com");/*发送人的邮箱地址*/

            XSSFWorkbook workbook = orderService.orderExcel();
            FileOutputStream fileOutputStream = new FileOutputStream("E:\\img\\"+"order.xlsx");
            workbook.write(fileOutputStream);
            //生成本地
            helper.addAttachment("书画网-订单详情.xlsx" , new File("E:\\img\\"+"order.xlsx"));
        } catch (MessagingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        /*发送邮件*/
        mailSender.send(mimeMessage);

    }
    public ByteArrayInputStream parse(OutputStream out) throws Exception
    {
        ByteArrayOutputStream baos=new   ByteArrayOutputStream();
        baos=(ByteArrayOutputStream) out;
        ByteArrayInputStream swapStream = new ByteArrayInputStream(baos.toByteArray());
        return swapStream;
    }


    /**
     * 跳转到填写email界面
     * @return
     */
    @RequestMapping("/toAddEmail")
    public String toAddEmail(){
        /*跳转到发送email地址的界面*/
        return "order/email";
    }


}
