package com.renhaixyz.common.xmlbean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对应于xml中的根节点
 * 
 * @author renjihai 2015年2月11日
 *
 */
@Target(value = { ElementType.TYPE })
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlRoot {

	public static final String strDefault = "";

	public String name() default strDefault;
}
