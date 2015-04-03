package com.renhaixyz.tests.xmlbean.bean;

import com.renhaixyz.common.xmlbean.XmlAttribute;
import com.renhaixyz.common.xmlbean.XmlRoot;

@XmlRoot(name = "meta-data")
public class MetaData {
	@XmlAttribute(name = "android:name")
	public String name;
	@XmlAttribute(name = "android:value")
	public String value;

	@Override
	public String toString() {
		return "MetaData [name=" + name + ", value=" + value + "]";
	}
}
