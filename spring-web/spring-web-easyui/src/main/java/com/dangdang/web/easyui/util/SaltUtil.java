package com.dangdang.web.easyui.util;
import java.util.Random;
/**
 * 给密码加盐的工具类
 * @author MaXn
 *
 */
public class SaltUtil {
	public static String getSalt(int length){
		String str = "8hga023gas-q2basda=q324bqas/zsfdbzxvdas12yazgB23GASD0QsdbGHDcb877#$%^yG23G@#df";
		StringBuilder sb = new StringBuilder();
		char[] chars = str.toCharArray();
		Random random = new Random();
		for(int i=0;i<length;i++){
			int nextInt = random.nextInt(chars.length);
			sb.append(chars[nextInt]);
		}
		return sb.toString();
	}
}
