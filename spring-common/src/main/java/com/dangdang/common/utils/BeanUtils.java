package com.dangdang.common.utils;

import com.dangdang.common.utils.annotation.BeanUtilsDontRead;
import com.dangdang.common.utils.data.FieldDescription;
import lombok.extern.slf4j.Slf4j;

import java.beans.Introspector;
import java.beans.PropertyDescriptor;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.*;
import java.net.URLDecoder;
import java.util.*;

/**
 * Create by tianjiaqin 2018/11/12
 */
@Slf4j
public class BeanUtils {

    public static Map<String, Object> getDifferences(Object reference, Object byReference, Class<?> baseClass) {
        return getDifferences(reference, byReference, baseClass, reference, true);
    }

    public static Map<String, Object> getDifferences(Object reference, Object byReference, Class<?> baseClass,
                                                     Object returnReference) {
        return getDifferences(reference, byReference, baseClass, returnReference, true);
    }

    public static Map<String, Object> getDifferences(Object reference, Object byReference, Class<?> baseClass,
                                                     Object returnReference, boolean onlyPrimitive) {
        Map result = new HashMap();
        try {
            Map referenceProperties = getPropertiesMap(reference, true, false);
            Map byReferenceProperties = getPropertiesMap(byReference, true, false);
            Map returnReferenceProperties = getPropertiesMap(returnReference, true, false);
            List<FieldDescription> compareFields = getAllPrimitiveField(baseClass, onlyPrimitive);
            for (FieldDescription field : compareFields) {
                String fieldName = field.getName();
                if ((referenceProperties.containsKey(fieldName)) && (byReferenceProperties.containsKey(fieldName))) {
                    if (!isEquals(referenceProperties.get(fieldName), byReferenceProperties.get(fieldName))) {
                        result.put(fieldName, returnReferenceProperties.get(fieldName));
                    }
                }
            }
        } catch (Exception e) {
            log.error("对象对比失败！", e);
        }
        return result;
    }

    public static boolean isEquals(Object obj1, Object obj2) {
        if (obj1 == null) {
            if (obj2 != null) {
                return false;
            }
        } else if (!obj1.equals(obj2)) {
            return false;
        }
        return true;
    }

    public static Map<String, Object> getPropertiesMap(Object obj) {
        return getPropertiesMap(obj, true, true);
    }

    public static Map<String, Object> getPropertiesMap(Object obj, boolean onlyPrimitive, boolean onlyNotNull) {
        Map objMap = new HashMap();
        if (obj == null) {
            return objMap;
        }
        if ((obj instanceof Map)) {
            Map<String, Object> map = (Map) obj;
            for (String key : map.keySet()) {
                Object value = map.get(key);
                if ((onlyNotNull) && (value == null)) {
                    if (!onlyNotNull) {
                        objMap.put(key, value);
                    }
                } else {
                    Class fieldClass = value.getClass();
                    if ((!onlyPrimitive) || (isPrimitive(fieldClass)) || (fieldClass.equals(String.class)) || (Date.class.isAssignableFrom(fieldClass))) {
                        objMap.put(key, value);
                    }
                }
            }
            return objMap;
        }
        log.debug("propertiesMap[" + obj.getClass() + "]" + obj);
        try {
            List objFields = getAllPrimitiveField(obj.getClass(), onlyPrimitive);

            for (Iterator iterator = objFields.iterator(); iterator.hasNext(); ) {
                FieldDescription objField = (FieldDescription) iterator.next();
                PropertyDescriptor propertyDescriptor = objField.getPropertyDescriptor();
                Method readMethod = propertyDescriptor.getReadMethod();
                if ((readMethod != null) && (readMethod.getAnnotation(BeanUtilsDontRead.class) == null)) {
                    Object value = readMethod.invoke(obj, new Object[0]);
                    if ((!onlyNotNull) && (value == null)) {
                        objMap.put(propertyDescriptor.getName(), value);
                    } else if (value != null) {
                        if (Date.class.isAssignableFrom(propertyDescriptor.getPropertyType())) {
                            objMap.put(propertyDescriptor.getName(), ((Date) value).clone());
                        } else {
                            objMap.put(propertyDescriptor.getName(), value);
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error("map转化失败！", e);
        }
        return objMap;
    }

    public static List<FieldDescription> getAllPrimitiveField(Class<?> claz, boolean onlyPrimitive) {
        List primitiveFieldList = new ArrayList();
        try {
            Class superClaz = claz;
            List<Field> fieldList = new ArrayList(Arrays.asList(superClaz.getDeclaredFields()));
            while ((superClaz = superClaz.getSuperclass()) != null) {
                fieldList.addAll(Arrays.asList(superClaz.getDeclaredFields()));
            }
            Map fieldMap = new HashMap();
            for (Field field : fieldList) {
                fieldMap.put(field.getName(), field);
            }
            PropertyDescriptor[] objFields = Introspector.getBeanInfo(claz).getPropertyDescriptors();
            for (PropertyDescriptor objField : objFields) {
                String propertyName = objField.getName();
                if (fieldMap.keySet().contains(propertyName)) {
                    Class fieldClass = objField.getPropertyType();
                    if (!Class.class.equals(fieldClass)) {
                        if ((!onlyPrimitive) || (isPrimitive(fieldClass)) || (fieldClass.equals(String.class))
                                || (Date.class.isAssignableFrom(fieldClass))) {
                            primitiveFieldList.add(new FieldDescription((Field) fieldMap.get(propertyName), objField,
                                    propertyName, fieldClass, null));
                        }
                    }
                }
            }
        } catch (Exception e) {
            log.error(claz.getName() + "解析失败！", e);
        }

        return primitiveFieldList;
    }

    public static FieldDescription getFieldDescription(Object obj, Class<? extends Annotation> annotationClass) {
        List<FieldDescription> fields = getFields(obj, true);
        for (FieldDescription field : fields) {
            Annotation annotation = field.getField().getAnnotation(annotationClass);
            Method readMethod = field.getPropertyDescriptor().getReadMethod();
            Method writeMethod = field.getPropertyDescriptor().getWriteMethod();
            if ((annotation == null) && (readMethod != null)) {
                annotation = readMethod.getAnnotation(annotationClass);
            }
            if ((annotation == null) && (writeMethod != null)) {
                annotation = writeMethod.getAnnotation(annotationClass);
            }
            if (annotation != null) {
                return field;
            }
        }
        return null;
    }

    public static List<FieldDescription> getFieldDescriptionList(Object obj,
                                                                 Class<? extends Annotation> annotationClass) {
        List result = new ArrayList();
        List<FieldDescription> fields = getFields(obj, true);
        for (FieldDescription field : fields) {
            if ((field.getField().getAnnotation(annotationClass) != null)
                    || (field.getPropertyDescriptor().getReadMethod().getAnnotation(annotationClass) != null)
                    || (field.getPropertyDescriptor().getWriteMethod().getAnnotation(annotationClass) != null)) {
                result.add(field);
            }
        }
        return result;
    }

    public static <T> List<T> subList(List<T> list, int size, int index) {
        int start = size * index;
        int end = Math.min(size * (index + 1), list.size());
        return list.subList(start, end);
    }

    public static <T> T convertMap(Map<String, Object> map, Class<T> resultClass) {
        try {
            Object result = resultClass.newInstance();
            List<FieldDescription> sourceFields = getFields(map, false);
            List<FieldDescription> targetFields = getFields(result, false);
            for (FieldDescription sourceField : sourceFields) {
                for (FieldDescription targetField : targetFields) {
                    if ((sourceField.getName().equals(targetField.getName()))
                            && (targetField.getPropertyDescriptor().getWriteMethod() != null)) {
                        Object sourceValue = sourceField.getValue();
                        if ((sourceValue != null) && ((sourceValue instanceof Map))) {
                            targetField.setValue(convertMap((Map) sourceValue, targetField.getType()));
                        } else {
                            targetField.setValue(cloneObj(sourceValue));
                        }

                        if ((sourceValue != null) && ((sourceValue instanceof List))
                                && (List.class.isAssignableFrom(targetField.getType()))) {
                            Class targetItemClass = null;
                            Type genericType = targetField.getField().getGenericType();
                            if ((genericType != null) && ((genericType instanceof ParameterizedType))) {
                                targetItemClass = (Class) ((ParameterizedType) genericType).getActualTypeArguments()[0];
                            }
                            List targetList = new ArrayList();
                            for (
                                    Iterator localIterator3 = ((List) targetField.getValue()).iterator(); localIterator3
                                    .hasNext(); ) {
                                Object item = localIterator3.next();
                                if ((item instanceof Map)) {
                                    targetList.add(convertMap((Map) item, targetItemClass));
                                } else if (!(item instanceof List)) {
                                    targetList.add(cloneObj(item));
                                }
                            }
                            targetField.setValue(targetList);
                        }
                        targetField.getPropertyDescriptor().getWriteMethod().invoke(result,
                                new Object[]{targetField.getValue()});
                        break;
                    }
                }
            }
            return (T) result;
        } catch (Exception e) {
            log.error("map转化失败！", e);
        }
        return null;
    }

    public static void copy(Object source, Object target) {
        copy(source, target, false);
    }

    public static void copy(Object source, Object target, boolean deepOrNot) {
        try {
            List<FieldDescription> sourceFields = getFields(source, false);
            List<FieldDescription> targetFields = getFields(target, false);
            for (FieldDescription sourceField : sourceFields) {
                if (targetFields.contains(sourceField)) {
                    FieldDescription targetField = (FieldDescription) targetFields
                            .get(targetFields.indexOf(sourceField));
                    Object sourceValue = sourceField.getValue();
                    if (targetField.getPropertyDescriptor().getWriteMethod() != null && null != sourceValue) {
                        if (deepOrNot) {
                            if ((sourceValue != null) && ((sourceValue instanceof Map))) {
                                Object targetObject = targetField.getType().newInstance();
                                copy(sourceValue, targetObject, deepOrNot);
                                targetField.setValue(targetObject);
                            } else {
                                targetField.setValue(cloneObj(sourceValue));
                            }
                        } else {
                            targetField.setValue(sourceField.getValue());
                        }
                        targetField.getPropertyDescriptor().getWriteMethod().invoke(target,
                                new Object[]{targetField.getValue()});
                    }
                }
            }
        } catch (Exception e) {
            log.error("copy失败！", e);
        }
    }

    public static void copyHasNull(Object source, Object target) {
        copyHasNull(source, target, false);
    }

    public static void copyHasNull(Object source, Object target, boolean deepOrNot) {
        try {
            List<FieldDescription> sourceFields = getFields(source, false);
            List<FieldDescription> targetFields = getFields(target, false);
            for (FieldDescription sourceField : sourceFields) {
                if (targetFields.contains(sourceField)) {
                    FieldDescription targetField = (FieldDescription) targetFields
                            .get(targetFields.indexOf(sourceField));
                    Object sourceValue = sourceField.getValue();
                    if (targetField.getPropertyDescriptor().getWriteMethod() != null) {
                        if (deepOrNot) {
                            if ((sourceValue != null) && ((sourceValue instanceof Map))) {
                                Object targetObject = targetField.getType().newInstance();
                                copyHasNull(sourceValue, targetObject, deepOrNot);
                                targetField.setValue(targetObject);
                            } else {
                                targetField.setValue(cloneObj(sourceValue));
                            }
                        } else {
                            targetField.setValue(sourceField.getValue());
                        }
                        targetField.getPropertyDescriptor().getWriteMethod().invoke(target,
                                new Object[]{targetField.getValue()});
                    }
                }
            }
        } catch (Exception e) {
            log.error("copy失败！", e);
        }
    }

    private static Object cloneObj(Object obj) throws Exception {
        if (obj != null) {
            Class claz = obj.getClass();
            if ((claz.equals(String.class)) || (isPrimitive(claz))) {
                return obj;
            }
            if ((obj instanceof Date)) {
                return ((Date) obj).clone();
            }
            if (List.class.isAssignableFrom(claz)) {
                List sourceList = (List) obj;
                List targetList = new ArrayList();
                for (Iterator localIterator = sourceList.iterator(); localIterator.hasNext(); ) {
                    Object sourceObj = localIterator.next();
                    targetList.add(cloneObj(sourceObj));
                }
                return targetList;
            }
            int i;
            if (claz.isArray()) {
                int length = Array.getLength(obj);
                Object newObj = Array.newInstance(claz.getComponentType(), length);
                for (i = 0; i < length; i++) {
                    Array.set(newObj, i, cloneObj(Array.get(obj, i)));
                }
                return newObj;
            }
            if ((obj instanceof Map)) {
                Map newObj = new HashMap();

                for (Iterator i1 = ((Map) obj).keySet().iterator(); i1.hasNext(); ) {
                    Object key = i1.next();
                    newObj.put(key, ((Map) obj).get(key));
                }
                return newObj;
            }
            Object newObj = claz.newInstance();
            copy(obj, newObj, true);
            return newObj;
        }

        return obj;
    }

    public static List<FieldDescription> getFields(Object obj, boolean onlyPrimitive) {
        List<FieldDescription> fields = new ArrayList();
        Iterator mapIt;
        if ((obj instanceof Map)) {
            Map map = (Map) obj;
            mapIt = map.keySet().iterator();
            while (mapIt.hasNext()) {
                Object key = mapIt.next();
                Object value = map.get(key);
                fields.add(new FieldDescription(key.toString(), value != null ? value.getClass() : null, value));
            }
        } else {
            fields = getAllPrimitiveField(obj.getClass(), onlyPrimitive);
            for (FieldDescription field : fields) {
                Method readMethod = field.getPropertyDescriptor().getReadMethod();
                Object value = null;
                if ((readMethod != null) && (readMethod.getAnnotation(BeanUtilsDontRead.class) == null)) {
                    try {
                        value = readMethod.invoke(obj, new Object[0]);
                    } catch (Exception e) {
                        log.warn("获取属性值失败！" + field.getName(), e);
                    }
                }
                if ((value != null) && (Date.class.isAssignableFrom(field.getType()))) {
                    value = ((Date) value).clone();
                }
                field.setValue(value);
            }
        }
        return fields;
    }

    public static boolean isPrimitive(Class<?> claz) {
        try {
            return claz.isPrimitive() ? true : ((Class) claz.getField("TYPE").get(null)).isPrimitive();
        } catch (Exception e) {
        }
        return false;
    }

    public static boolean isPrimitiveEqual(Class<?> clazA, Class<?> clazB) {
        try {
            if (clazA.isPrimitive()) {
                return clazA == clazB;
            }
            if (clazB.isPrimitive()) {
                return clazA.getField("TYPE").get(null) == clazB;
            }
            return (clazA.equals(clazB)) || (clazA.isAssignableFrom(clazB)) || (clazB.isAssignableFrom(clazA));
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 对字符串进行decode操作后赋值
     *
     * @param obj
     * @param clazz
     * @throws IllegalAccessException
     */
    public static void decodeObjString(Object obj, Class clazz) {

        Field[] fields = clazz.getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true);
            try {

                Object target = field.get(obj);

                if (null == target) {
                    continue;
                }

                if ("salt".equals(field.getName())) {
                    // 获取盐
                    continue;
                }

                Object value = field.get(obj);

                if (value instanceof String) {
                    //如果有中文参数,需要urlencode来协调一致 如果需要decode 就decode
                    if (UrlEncoderUtils.hasUrlEncoded(String.valueOf(value))) {
                        value = URLDecoder.decode(String.valueOf(value), "utf-8");
                        String setMethodName = "set" + captureName(field.getName());
                        Method method = clazz.getDeclaredMethod(setMethodName, String.class);
                        method.invoke(obj, value);
                    }

                }

            } catch (UnsupportedEncodingException e) {
                log.error("{}", e);
                log.error("urlEncoder 编码错误");
            } catch (NoSuchMethodException e) {
                log.error("{}", e);
                log.error("没有这个方法 编码错误");
            } catch (InvocationTargetException e) {
                log.error("{}", e);
                log.error("反射方法 调用错误");
            } catch (IllegalAccessException e) {
                log.error("{}", e);
                log.error("获取属性 调用错误");

            }

        }


//		return obj;
    }

    /**
     * 首字母大写方法
     *
     * @param name
     * @return
     */

    public static String captureName(String name) {
        //     name = name.substring(0, 1).toUpperCase() + name.substring(1);
//        return  name;
        char[] cs = name.toCharArray();
        cs[0] -= 32;
        return String.valueOf(cs);

    }


    /**
     * 转换实体
     *
     * @param object
     * @param clazz
     * @return
     * @author YangJie [2017年10月23日 下午1:08:43]
     */
    public static <T> T transformBean(Object object, Class<T> clazz) {
        T t = org.springframework.beans.BeanUtils.instantiate(clazz);
        org.springframework.beans.BeanUtils.copyProperties(object, t);
        return t;
    }

    /**
     * 转换List中实体
     *
     * @param objList
     * @param clazz
     * @return
     * @author YangJie [2017年10月23日 下午1:08:43]
     */
    public static <T> List<T> transformList(Object objList, Class<T> clazz) {
        List<T> tList = new ArrayList<T>();
        if (objList != null && objList instanceof List<?>) {
            for (Object obj : (List<?>) objList) {
                tList.add(transformBean(obj, clazz));
            }
        }
        return tList;
    }
}