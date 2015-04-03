package com.renhaixyz.common.xmlbean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 对应于xml中的子节点,不再包含子节点
 * 
 * @author renjihai 2015年2月11日
 */
@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlField {
	public String name() default "";

	public boolean isList() default false;

}
