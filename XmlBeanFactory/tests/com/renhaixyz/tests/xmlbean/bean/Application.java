package com.renhaixyz.tests.xmlbean.bean;

import java.util.List;

import com.renhaixyz.common.xmlbean.XmlAttribute;
import com.renhaixyz.common.xmlbean.XmlBean;
import com.renhaixyz.common.xmlbean.XmlRoot;

@XmlRoot(name = "application")
public class Application {
	@XmlAttribute(name = "android:name")
	public String name;
	@XmlAttribute(name = "android:allowBackup")
	public String allowBackup;
	@XmlAttribute(name = "android:hardwareAccelerated")
	public String hardwareAccelerated;
	@XmlAttribute(name = "android:icon")
	public String icon;
	@XmlAttribute(name = "android:label")
	public String label;
	@XmlAttribute(name = "android:debuggable")
	public String debuggable;
	@XmlAttribute(name = "android:theme")
	public String theme;
	@XmlAttribute(name = "android:largeHeap")
	public String largeHeap;

	@XmlBean(isList = true, clazz = MetaData.class, name = "meta-data")
	public List<MetaData> metaDatas;

	@XmlBean(isList = true, clazz = Activity.class)
	public List<Activity> activity;

	@Override
	public String toString() {
		return "Application [name=" + name + ", allowBackup=" + allowBackup
				+ ", hardwareAccelerated=" + hardwareAccelerated + ", icon="
				+ icon + ", label=" + label + ", debuggable=" + debuggable
				+ ", theme=" + theme + ", largeHeap=" + largeHeap
				+ ", metaDatas=" + metaDatas + ", activity=" + activity + "]";
	}
}
