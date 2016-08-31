package com.cmb.annotation;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;

/*
 * ʹ�÷����ȡע�����Ϣ��ģ�⴦��ע����Ϣ������
 * @author RaiseKing
 */
public class Demo03 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException{
		try {
			Class clazz = Class.forName("com.cmb.annotation.Student");
			//������������Чע��
			Annotation[] annotations = clazz.getAnnotations();
			for(Annotation a:annotations){
				System.out.println(a);
			}
			
			//������ָ����ע��
			TableAnnotation tableAnnotation = (TableAnnotation) clazz.getAnnotation(TableAnnotation.class);
			System.out.println(tableAnnotation.value());
			
			//���������Ե�ע��
			Field field = clazz.getDeclaredField("studentName");
			FieldAnnotation fieldAnnotation = field.getAnnotation(FieldAnnotation.class);
			System.out.println(fieldAnnotation.columnName()+"--"+fieldAnnotation.type()+"--"+fieldAnnotation.length());
			
			//���ݻ�õı������ֶε���Ϣ��ƴ��DDL��䣬Ȼ��ʹ��JDBCִ�����SQL��䣬�����ݿ�������صı�
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
