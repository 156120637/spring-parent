package com.dangdang.common.utils;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.util.Assert;
import org.springframework.util.ClassUtils;

import java.beans.PropertyDescriptor;
import java.io.ByteArrayOutputStream;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;

/**
 * Create by tianjiaqin 2018/11/12
 */
public class StringToBeanUtils {

    public static void copyProperties(Object source, Object target) throws BeansException {
        copyProperties(source, target, null);
    }

    public static void copyProperties(Object source, Object target, String... ignoreProperties) throws BeansException {
        Assert.notNull(source, "Source must not be null");
        Assert.notNull(target, "Target must not be null");
        Class actualEditable = target.getClass();

        PropertyDescriptor[] targetPds = BeanUtils.getPropertyDescriptors(actualEditable);
        List ignoreList = ignoreProperties != null ? Arrays.asList(ignoreProperties) : null;
        PropertyDescriptor[] var7 = targetPds;
        int var8 = targetPds.length;

        for (int var9 = 0; var9 < var8; ++var9) {
            PropertyDescriptor targetPd = var7[var9];
            Method writeMethod = targetPd.getWriteMethod();
            if (writeMethod != null && (ignoreList == null || !ignoreList.contains(targetPd.getName()))) {
                PropertyDescriptor sourcePd = BeanUtils.getPropertyDescriptor(source.getClass(), targetPd.getName());
                if (sourcePd != null) {
                    Method readMethod = sourcePd.getReadMethod();
                    if (readMethod != null) {
                        try {
                            if (!Modifier.isPublic(readMethod.getDeclaringClass().getModifiers())) {
                                readMethod.setAccessible(true);
                            }

                            Object ex = readMethod.invoke(source, new Object[0]);
                            if (null == ex) {
                                continue;
                            }
                            if (!Modifier.isPublic(writeMethod.getDeclaringClass().getModifiers())) {
                                writeMethod.setAccessible(true);
                            }

                            Class targetType = targetPd.getPropertyType();
                            if (ClassUtils.isAssignable(targetType, Integer.class)) {
                                ex = Integer.valueOf(String.valueOf(ex));
                            } else if (ClassUtils.isAssignable(targetType, Long.class)) {
                                ex = Long.valueOf(String.valueOf(ex));
                            } else if (ClassUtils.isAssignable(targetType, Float.class)) {
                                ex = Float.valueOf(String.valueOf(ex));
                            } else if (ClassUtils.isAssignable(targetType, Double.class)) {
                                ex = Double.valueOf(String.valueOf(ex));
                            } else if (ClassUtils.isAssignable(targetType, Boolean.class)) {
                                ex = Boolean.valueOf(String.valueOf(ex));
                            }

                            writeMethod.invoke(target, new Object[]{ex});
                        } catch (Throwable var15) {
                            throw new FatalBeanException("Could not copy property \'" + targetPd.getName() + "\' from source to target", var15);
                        }
                    }
                }
            }
        }

    }


    public static void main(String[] args) {
        try {
            byte[] ss = "天安门".getBytes("UTF-8");
            System.out.println(new String(ss, "UTF-8"));
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            bos.write(ss);
            byte[] st = bos.toByteArray();
            System.out.println(new String(st, "iso8859-1"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

