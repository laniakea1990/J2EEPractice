package com.cmb.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * ######�ǳ���Ҫ������######
 * Ӧ�÷����API����ȡ�����Ϣ��������֡����ԡ��������������ȣ�
 */
//@SuppressWarnings("all")
public class Demo02 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException{
		String path = "com.cmb.test.bean.User";
		
		try {
			Class clazz =  Class.forName(path);
			
			//��ȡ�������
			System.out.println(clazz.getName());//��ð���+����
			System.out.println(clazz.getSimpleName());//�������
			
			//��ȡ������Ϣ
			Field[] field = clazz.getFields();//ֻ�ܻ��public��field
			Field[] field2 = clazz.getDeclaredFields();//������е�field������private����
			Field field3 = clazz.getDeclaredField("uname");
			System.out.println(field.length);
			System.out.println(field2.length);
			System.out.println(field3);
			for(Field temp:field2){
				System.out.println("���ԣ�"+temp);
			}
			
			//��ȡ������Ϣ
			Method[] method = clazz.getDeclaredMethods();
			Method method2 = clazz.getDeclaredMethod("getUname", null);
			//��������в���������봫�ݲ������Ͷ�Ӧ��class����
			Method method3 = clazz.getDeclaredMethod("setUname", String.class);
			for(Method m:method){
				System.out.println("������"+m);
			}
			
			//��ù��죨����������Ϣ
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor constructor = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("��ù��캯����"+constructor);
			for(Constructor c:constructors){
				System.out.println("���캯����"+c);
			}
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
