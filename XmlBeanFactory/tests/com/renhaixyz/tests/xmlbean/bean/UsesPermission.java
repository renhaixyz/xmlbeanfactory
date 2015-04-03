package com.renhaixyz.tests.xmlbean.bean;

import com.renhaixyz.common.xmlbean.XmlAttribute;

public class UsesPermission {
	@XmlAttribute(name = "android:name")
	public String name;

	@Override
	public String toString() {
		return "UsesPermission [name=" + name + "]";
	}
	
}
