package com.renhaixyz.common.xmlbean;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author renjihai 2015年2月11日
 *
 */
public class XmlReflextUtils {
    /**
     * 获取根节点的label
     * 
     * @param clazz
     * @return
     */
    public static String getRootElementName(Class<?> clazz) {
        XmlRoot annotation = clazz.getAnnotation(XmlRoot.class);
        if (annotation == null || XmlRoot.strDefault.equals(annotation.name())) {
            return clazz.getName();
        } else {
            return annotation.name();
        }
    }

    /**
     * 获取变量对应的xml节点名称
     * 
     * @param field
     * @return
     */
    public static String getXmlFieldName(Field field) {
        XmlField xmlField = field.getAnnotation(XmlField.class);
        if (xmlField == null || "".equals(xmlField.name())) {
            return field.getName();
        } else {
            return xmlField.name();
        }
    }

    /**
     * @see #getXmlFieldName(Field)
     * 
     * @param field
     * @return
     */
    public static String getXmlAttributeName(Field field) {
        XmlAttribute xmlAttribute = field.getAnnotation(XmlAttribute.class);
        if (xmlAttribute == null || "".equals(xmlAttribute.name())) {
            return field.getName();
        } else {
            return xmlAttribute.name();
        }
    }

    /**
     * @see #getXmlFieldName(Field)
     * 
     * @param field
     * @return
     */
    public static String getXmlBeanName(Field field) {
        XmlBean xmlBean = field.getAnnotation(XmlBean.class);
        if (xmlBean == null || "".equals(xmlBean.name())) {
            return field.getName();
        } else {
            return xmlBean.name();
        }
    }

    /**
     * 判断某个属性是否对应xml中的节点是否为列表
     * 
     * @param field
     * @return
     */
    public static boolean isFieldList(Field field) {
        XmlField xmlField = field.getAnnotation(XmlField.class);
        if (xmlField == null) {
            return false;
        } else {
            return xmlField.isList();
        }
    }

    /**
     * @see #isXmlBeanList(Field)
     * @param field
     * @return
     */
    public static boolean isXmlBeanList(Field field) {
        XmlBean xmlBean = field.getAnnotation(XmlBean.class);
        if (xmlBean == null) {
            return false;
        } else {
            return xmlBean.isList();
        }
    }

    /**
     * 针对属性为列表的,没办法获取列表中的类属性,只能通过指定的方式来获取列表中的类型
     * 
     * @param field
     * @return
     */
    public static Class<?> getXmlBeanType(Field field) {
        XmlBean xmlBean = field.getAnnotation(XmlBean.class);
        if (xmlBean == null) {
            return Object.class;
        } else {
            return xmlBean.clazz();
        }
    }

    /**
     * 获取某个类中,对应于xml中节点的属性
     * 
     * @param clazz
     * @return
     */
    public static List<Field> getXmlBeanFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<Field>();
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getAnnotation(XmlBean.class) != null) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }

    /**
     * @see #getXmlBeanFields(Class)
     * @param clazz
     * @return
     */
    public static List<Field> getXmlAttributeFields(Class<?> clazz) {
        List<Field> fields = new ArrayList<Field>();
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getAnnotation(XmlAttribute.class) != null) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }

    /**
     * 给字段赋值
     * 
     * @param object
     *            字段所在对象
     * @param field
     *            赋值字段
     * @param value
     *            赋值的字符串类型
     * @throws IllegalAccessException
     * @throws IllegalArgumentException
     */
    public static void initField(Object object, Field field, String value)
            throws IllegalAccessException, IllegalArgumentException {
        String typeName = field.getType().getName();
        if (!TextUtils.isEmpty(value)) {
            if (Integer.class.getName().equals(typeName) || "int".equals(typeName)) {
                Integer integer = 0;
                if (value.toLowerCase().startsWith("0x")) {
                    value = value.replace("0x", "").replace("0X", "");
                    integer = Integer.parseInt(value, 16);
                } else {
                    integer = Integer.parseInt(value);
                }
                field.set(object, integer);
            } else if (Short.class.getName().equals(typeName) || "short".equals(typeName)) {
                Short short1 = 0;
                if (value.toLowerCase().startsWith("0x")) {
                    value = value.replace("0x", "").replace("0X", "");
                    short1 = Short.parseShort(value, 16);
                } else {
                    short1 = Short.parseShort(value);
                }
                field.set(object, short1);
            } else if (Byte.class.getName().equals(typeName) || "byte".equals(typeName)) {
                Byte byte1 = 0;
                if (value.toLowerCase().startsWith("0x")) {
                    value = value.replace("0x", "").replace("0X", "");
                    byte1 = Byte.parseByte(value, 16);
                } else {
                    byte1 = Byte.parseByte(value);
                }
                field.set(object, byte1);
            } else if (Long.class.getName().equals(typeName) || "long".equals(typeName)) {
                Long long1 = 0L;
                if (value.toLowerCase().startsWith("0x")) {
                    value = value.replace("0x", "").replace("0X", "");
                    long1 = Long.parseLong(value, 16);
                } else {
                    long1 = Long.parseLong(value);
                }
                field.set(object, long1);
            } else if (Float.class.getName().equals(typeName) || "float".equals(typeName)) {
                Float float1 = Float.parseFloat(value);
                field.set(object, float1);
            } else if (Double.class.getName().equals(typeName) || "double".equals(typeName)) {
                Double double1 = Double.parseDouble(value);
                field.set(object, double1);
            } else {
                field.set(object, value);
            }
        } else {
            field.set(object, value);
        }
    }

    /**
     * @see #getXmlBeanFields(Class)
     * @param clazz
     * @return
     */
    public static List<Field> getXmlField(Class<?> clazz) {
        List<Field> fields = new ArrayList<Field>();
        Field[] declaredFields = clazz.getDeclaredFields();
        if (declaredFields != null && declaredFields.length > 0) {
            for (Field field : declaredFields) {
                if (field.getAnnotation(XmlField.class) != null) {
                    fields.add(field);
                }
            }
        }
        return fields;
    }
}
