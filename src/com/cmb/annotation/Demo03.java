package com.cmb.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/*
 * 使用反射读取注解的信息，模拟处理注解信息的流程
 * @author RaiseKing
 */
public class Demo03 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException{
		try {
			Class clazz = Class.forName("com.cmb.annotation.Student");
			//获得类的所有有效注解
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation a:annotations){
				System.out.println(a);
			}
			
			//获得类的指定的注解
			TableAnnotation tableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
			System.out.println(tableAnnotation.value());
			
			//获得类的属性的注解
			Field field = clazz.getDeclaredField("studentName");
			FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
			System.out.println(fieldAnnotation.columnName()+"--"+fieldAnnotation.type()+"--"+fieldAnnotation.length());
			
			//根据获得的表名、字段的信息，拼出DDL语句，然后使用JDBC执行这个SQL语句，在数据库生成相关的表
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
