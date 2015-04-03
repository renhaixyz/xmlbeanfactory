package com.renhaixyz.tests.xmlbean.bean;

import com.renhaixyz.common.xmlbean.XmlAttribute;
import com.renhaixyz.common.xmlbean.XmlRoot;

@XmlRoot(name = "supports-screens")
public class SupportsScreens {
	@XmlAttribute(name = "android:anyDensity")
	public String anyDensity;
	@XmlAttribute(name = "android:largeScreens")
	public String largeScreens;
	@XmlAttribute(name = "android:normalScreens")
	public String normalScreens;
	@XmlAttribute(name = "android:resizeable")
	public String resizeable;
	@XmlAttribute(name = "android:smallScreens")
	public String smallScreens;

	@Override
	public String toString() {
		return "SupportsScreens [anyDensity=" + anyDensity + ", largeScreens="
				+ largeScreens + ", normalScreens=" + normalScreens
				+ ", resizeable=" + resizeable + ", smallScreens="
				+ smallScreens + "]";
	}
}
