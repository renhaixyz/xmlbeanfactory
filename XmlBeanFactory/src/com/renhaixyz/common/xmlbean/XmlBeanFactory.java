package com.renhaixyz.common.xmlbean;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

/**
 * 
 * @author renjihai
 *
 */
public class XmlBeanFactory {

    /**
     * 将xml映射成java bean
     * 
     * @param t
     *            指定java类型,可以是内部节点
     * @param file
     *            xml文件
     * @return
     */
    public static <T> T xmlBean(Class<T> t, File file) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(file);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        try {
            return parse(t, root);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将xml映射成java bean
     * 
     * @see #xmlBean(Class, File)
     * 
     * @param t
     * @param inputSource
     * @return
     */
    public static <T> T xmlBean(Class<T> t, InputSource inputSource) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(inputSource);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        try {
            return parse(t, root);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将xml映射成java bean
     * 
     * @see #xmlBean(Class, File)
     * @param t
     * @param inputStream
     * @return
     */
    public static <T> T xmlBean(Class<T> t, InputStream inputStream) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(inputStream);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        try {
            return parse(t, root);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将xml映射成java bean
     * 
     * @see #xmlBean(Class, File)
     * @param t
     * @param uri
     * @return
     */
    public static <T> T xmlBean(Class<T> t, String uri) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(uri);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        try {
            return parse(t, root);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 将xml映射成java bean
     * 
     * @see #xmlBean(Class, File)
     * @param t
     * @param is
     * @param systemId
     * @return
     */
    public static <T> T xmlBean(Class<T> t, InputStream is, String systemId) {
        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder documentBuilder = null;
        try {
            documentBuilder = factory.newDocumentBuilder();
        } catch (ParserConfigurationException e) {
            e.printStackTrace();
        }
        Document document = null;
        try {
            document = documentBuilder.parse(is, systemId);
        } catch (SAXException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Element root = document.getDocumentElement();
        try {
            return parse(t, root);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解析xml
     * 
     * @param clazz
     * @param rootElement
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static <T> T parse(Class<T> clazz, Element rootElement) throws InstantiationException,
            IllegalAccessException {
        String xmlRoot = XmlReflextUtils.getRootElementName(clazz);

        T t = getXmlRoot(clazz, rootElement, xmlRoot);
        if (t == null) {
            return null;
        }
        Element element = getElement(rootElement, xmlRoot);
        if (element == null) {
            return null;
        }
        parse(t, element);
        return t;
    }

    /**
     * 获取配置的根节点
     * 
     * @param root
     * @param name
     * @return
     */
    private static Element getElement(Element root, String name) {
        if (root.getTagName().equals(name)) {
            return root;
        }

        NodeList elementsByTagName = root.getElementsByTagName(name);
        if (elementsByTagName != null && elementsByTagName.getLength() > 0) {
            return (Element) elementsByTagName.item(0);
        }

        NodeList childNodes = root.getChildNodes();
        int childNodeLength = 0;
        if (childNodes != null && (childNodeLength = childNodes.getLength()) > 0) {
            for (int i = 0; i < childNodeLength; i++) {
                Element element = getElement((Element) childNodes.item(i), name);
                if (element != null) {
                    return element;
                }
            }
        }
        return null;
    }

    /**
     * 根据xml root配置,初始化返回对象,如果xml中没有该节点,则返回空
     * 
     * @param clazz
     * @param element
     * @param xmlRootName
     * @return
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static <T> T getXmlRoot(Class<T> clazz, Element element, String xmlRootName)
            throws InstantiationException, IllegalAccessException {
        String tagName = element.getTagName();
        if (xmlRootName.equals(tagName)) {
            return clazz.newInstance();
        }
        NodeList nodeList = element.getElementsByTagName(xmlRootName);
        int length = 0;
        if (nodeList != null && (length = nodeList.getLength()) > 0) {
            for (int i = 0; i < length; i++) {
                Node node = nodeList.item(i);
                T t = getXmlRoot(clazz, (Element) node, xmlRootName);
                if (t != null) {
                    return t;
                }
            }
        }
        return null;
    }

    /**
     * 根据bean中的配置,映射关系,解析xml
     * 
     * @param object
     * @param element
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void parse(Object object, Element element) throws IllegalArgumentException,
            IllegalAccessException, InstantiationException {
        List<Field> xmlFields = XmlReflextUtils.getXmlField(object.getClass());
        if (element == null) {
            return;
        }
        for (Field field : xmlFields) {
            String fieldElementName = XmlReflextUtils.getXmlFieldName(field);
            System.err.println("xml: " + fieldElementName);
            boolean isList = XmlReflextUtils.isFieldList(field);
            parseField(object, field, element, fieldElementName, isList);
        }

        List<Field> xmlAttributeFields = XmlReflextUtils.getXmlAttributeFields(object.getClass());
        for (Field field : xmlAttributeFields) {
            String fieldElementName = XmlReflextUtils.getXmlAttributeName(field);
            System.err.println("xml: " + fieldElementName);
            parseAttribute(object, field, element, fieldElementName);
        }

        List<Field> xmlBeanFields = XmlReflextUtils.getXmlBeanFields(object.getClass());
        for (Field field : xmlBeanFields) {
            String fieldElementName = XmlReflextUtils.getXmlBeanName(field);
            System.err.println("xml: " + fieldElementName);
            boolean isList = XmlReflextUtils.isXmlBeanList(field);
            parseBean(object, field, element, fieldElementName, isList);
        }
    }

    /**
     * 解析xml节点中的属性
     * {@link #parseAttribute(Object, Field, Element, String, boolean)}
     * 
     * @param object
     * @param field
     * @param element
     * @param fieldElementName
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private static void parseAttribute(Object object, Field field, Element element,
            String fieldElementName) throws IllegalArgumentException, IllegalAccessException {
        parseAttribute(object, field, element, fieldElementName, false);
    }

    /**
     * 解析xml节点中的属性
     * 
     * @param object
     * @param field
     * @param element
     * @param fieldElementName
     * @param isList
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     */
    private static void parseAttribute(Object object, Field field, Element element,
            String fieldElementName, boolean isList) throws IllegalArgumentException,
            IllegalAccessException {
        field.setAccessible(true);
        String attribute = element.getAttribute(fieldElementName);
        XmlReflextUtils.initField(object, field, attribute);
    }

    /**
     * 解析xml中的子节点
     * 
     * @param object
     * @param field
     * @param element
     * @param fieldElementName
     * @param isList
     * @throws InstantiationException
     * @throws IllegalAccessException
     */
    private static void parseBean(Object object, Field field, Element element,
            String fieldElementName, boolean isList) throws InstantiationException,
            IllegalAccessException {
        field.setAccessible(true);
        if (!isList) {
            Class<?> type = field.getType();
            Object newInstance = type.newInstance();
            field.set(object, newInstance);
            NodeList childNodes = element.getElementsByTagName(fieldElementName);
            Node item = childNodes.item(0);
            parse(newInstance, (Element) item);
        } else {
            Class<?> clazz = XmlReflextUtils.getXmlBeanType(field);
            ArrayList<Object> list = new ArrayList<Object>();
            NodeList elements = element.getElementsByTagName(fieldElementName);
            int length = elements.getLength();
            for (int i = 0; i < length; i++) {
                Node item = elements.item(i);
                Object newInstance = clazz.newInstance();
                parse(newInstance, (Element) item);
                list.add(newInstance);
            }
            field.set(object, list);
        }
    }

    /**
     * 解析节点中的值
     * 
     * @param object
     * @param field
     * @param element
     * @param fieldElementName
     * @param isList
     * @throws IllegalArgumentException
     * @throws IllegalAccessException
     * @throws InstantiationException
     */
    private static void parseField(Object object, Field field, Element element,
            String fieldElementName, boolean isList) throws IllegalArgumentException,
            IllegalAccessException, InstantiationException {
        field.setAccessible(true);
        NodeList elementsByTagName = element.getElementsByTagName(fieldElementName);
        if (!isList) {
            if (elementsByTagName.getLength() > 0) {
                Node item = elementsByTagName.item(0);
                String nodeValue = item.getNodeValue();
                XmlReflextUtils.initField(object, field, nodeValue);
                return;
            }
        } else {
            List<String> list = new ArrayList<String>();
            int length = 0;
            if (elementsByTagName != null && (length = elementsByTagName.getLength()) > 0) {
                for (int i = 0; i < length; i++) {
                    Node item = elementsByTagName.item(i);
                    String textContent = item.getTextContent();
                    list.add(textContent);
                }
            }
            field.set(object, list);
        }
    }

}
