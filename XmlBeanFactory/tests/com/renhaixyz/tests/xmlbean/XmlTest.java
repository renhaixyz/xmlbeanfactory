package com.renhaixyz.tests.xmlbean;

import java.io.File;

import junit.framework.TestCase;

import org.junit.Test;

import com.renhaixyz.common.xmlbean.XmlBeanFactory;
import com.renhaixyz.tests.xmlbean.bean.TestMain;

/**
 * renjihai 2015年2月27日
 */
public class XmlTest extends TestCase {

    public static void main(String[] args) {
    }

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    @Test
    public void testXmlBean() {
        String pkg = getClass().getPackage().getName().replaceAll("\\.", "\\\\");
        String xmlPathString = System.getProperty("user.dir") + File.separator + "tests"
                + File.separator + pkg + File.separator + "AndroidManifest.xml";
        File file = new File(xmlPathString);
        TestMain xmlBean = XmlBeanFactory.xmlBean(TestMain.class, file);
        System.err.println(xmlBean);
    }

}
