package com.renhaixyz.common.xmlbean;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 
 * @author renjihai 2015年2月11日
 *
 */
@Target(value = { ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface XmlBean {
	public boolean isList() default false;

	public String name() default "";

	public Class<?> clazz() default Object.class;
}
