package com.renhaixyz.tests.xmlbean.bean;

import com.renhaixyz.common.xmlbean.XmlAttribute;
import com.renhaixyz.common.xmlbean.XmlRoot;

/**
 * 
 * @author renjihai
 *
 */
@XmlRoot(name = "activity")
public class Activity {
	@XmlAttribute(name = "android:name")
	public String name;
	@XmlAttribute(name = "android:clearTaskOnLaunch")
	public String clearTaskOnLaunch;
	@XmlAttribute(name = "android:configChanges")
	public String configChanges;
	@XmlAttribute(name = "android:label")
	public String label;
	@XmlAttribute(name = "android:launchMode")
	public String launchMode;
	@XmlAttribute(name = "android:screenOrientation")
	public String screenOrientation;
	@XmlAttribute(name = "android:theme")
	public String theme;
	@XmlAttribute(name = "android:windowSoftInputMode")
	public String windowSoftInputMode;

	@Override
	public String toString() {
		return "Activity [name=" + name + ", clearTaskOnLaunch="
				+ clearTaskOnLaunch + ", configChanges=" + configChanges
				+ ", label=" + label + ", launchMode=" + launchMode
				+ ", screenOrientation=" + screenOrientation + ", theme="
				+ theme + ", windowSoftInputMode=" + windowSoftInputMode + "]";
	}

}
