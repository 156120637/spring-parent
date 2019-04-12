package com.dangdang.common.utils;

import com.dangdang.common.enums.BaseCodeEnum;
import com.dangdang.common.exception.BaseException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;
import java.util.*;

/**
 * Create by tianjiaqin 2018/11/12
 */
@Slf4j
public class SaltUtils {


    private static final String TOKEN = "fpowkennfi";

    /**
     * 获取盐
     *
     * @param obj
     * @return
     * @throws BaseException
     */
    public static String getSalt(Object obj) throws BaseException {
        Set<String> fieldList = new TreeSet<>();
        try {
            Class superClaz = obj.getClass();
            List<Field> fields = new ArrayList(Arrays.asList(superClaz.getDeclaredFields()));
            while ((superClaz = superClaz.getSuperclass()) != null) {
                fields.addAll(Arrays.asList(superClaz.getDeclaredFields()));
            }
            for (Field field : fields) {
                field.setAccessible(true);

                Object target = field.get(obj);
                if (null == target || StringUtils.isBlank(target.toString())) {
                    continue;
                }
                // 获取盐
                String name = field.getName();
                if ("salt".equals(name)) {
                    continue;
                } else if ("serialVersionUID".equalsIgnoreCase(name)) {
                    continue;
                }

                fieldList.add(name + "=" + field.get(obj));
            }
        } catch (Throwable e) {
            log.error("真实异常打印:{}", e);
            throw new BaseException(BaseCodeEnum.BASE_PARAMS_ERROR.getCode(), BaseCodeEnum.BASE_PARAMS_ERROR.getMsg());
        }
        StringBuffer digest = new StringBuffer();
        Iterator<String> iterator = fieldList.iterator();
        while (iterator.hasNext()) {
            String key = iterator.next();
            if (key.indexOf("salt=") >= 0) {
                continue;
            } else if (key.indexOf("serialVersionUID") >= 0) {
                continue;
            }
            digest.append(key).append("&");
        }
        digest.append(TOKEN);
        log.info("加密前参数：{}", digest.toString());
        String salt = null;
        try {
            salt = Md5Utils.encryptMD5(digest.toString(), null).toUpperCase();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return salt;
    }

    /**
     * salt校验
     *
     * @param obj
     * @param salt
     * @throws BaseException
     */
    public static void validSalt(Object obj, String salt) throws BaseException {
        String newSalt = getSalt(obj);
        if (!salt.equalsIgnoreCase(newSalt)) {
            throw new BaseException(BaseCodeEnum.BASE_PARAMS_ERROR.getCode(), BaseCodeEnum.BASE_PARAMS_ERROR.getMsg());
        }
    }

}
