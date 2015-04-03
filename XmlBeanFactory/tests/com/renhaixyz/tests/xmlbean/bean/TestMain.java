package com.renhaixyz.tests.xmlbean.bean;

import java.util.List;

import com.renhaixyz.common.xmlbean.XmlAttribute;
import com.renhaixyz.common.xmlbean.XmlBean;
import com.renhaixyz.common.xmlbean.XmlRoot;

@XmlRoot(name = "manifest")
public class TestMain {
	@XmlAttribute(name = "package")
	public String packageName;

	@XmlAttribute(name = "xmlns:tools")
	public String tools;

	@XmlAttribute(name = "xmlns:android")
	public String android;

	@XmlAttribute(name = "android:versionCode")
	public String versionCode;

	@XmlAttribute(name = "android:versionName")
	public String versionName;

	@XmlBean(name = "supports-screens")
	public SupportsScreens supportsScreens;

	@XmlBean(name = "uses-sdk")
	public UsesSdk usesSdk;

	@XmlBean(name = "uses-permission", clazz = UsesPermission.class, isList = true)
	public List<UsesPermission> usesPermission;

	// @XmlField(type = FieldType.BEAN)
	@XmlBean(clazz = Application.class)
	public Application application;

	@Override
	public String toString() {
		return "TestMain [packageName=" + packageName + ", tools=" + tools
				+ ", android=" + android + ", versionCode=" + versionCode
				+ ", versionName=" + versionName + ", supportsScreens="
				+ supportsScreens + ", usesSdk=" + usesSdk
				+ ", usesPermission=" + usesPermission + ", application="
				+ application + "]";
	}

}
