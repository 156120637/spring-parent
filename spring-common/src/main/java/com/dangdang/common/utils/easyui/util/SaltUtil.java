package com.dangdang.common.utils.easyui.util;
import java.util.Random;

/**
 * Create by tianjiaqin 2019/4/12-23-12
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
