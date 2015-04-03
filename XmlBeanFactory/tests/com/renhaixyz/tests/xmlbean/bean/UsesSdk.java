package com.renhaixyz.tests.xmlbean.bean;

import com.renhaixyz.common.xmlbean.XmlAttribute;

/**
 * renjihai 2015年2月27日
 */
public class UsesSdk {
	@XmlAttribute(name = "android:minSdkVersion")
	public String minSdkVersion;
	@XmlAttribute(name = "android:targetSdkVersion")
	public String targetSdkVersion;

	@Override
	public String toString() {
		return "UsesSdk [minSdkVersion=" + minSdkVersion
				+ ", targetSdkVersion=" + targetSdkVersion + "]";
	}

}
