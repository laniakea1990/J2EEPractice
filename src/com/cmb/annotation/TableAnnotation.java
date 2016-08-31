package com.cmb.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(value={ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface TableAnnotation {

	String value();//只有一个参数建议起名value
}
