package com.renhaixyz.tests.xmlbean.bean;

import java.util.List;

import com.renhaixyz.common.xmlbean.XmlField;
import com.renhaixyz.common.xmlbean.XmlRoot;

/**
 * renjihai 2015年2月28日
 */
@XmlRoot(name = "manifest")
public class Manifest {
	@XmlField(isList = true)
	public List<String> name;

	@Override
	public String toString() {
		return "Manifest [name=" + name + "]";
	}

}
