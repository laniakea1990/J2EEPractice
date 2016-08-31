package com.cmb.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.cmb.test.bean.User;

/*
 * ͨ��������ȫ��飬��߷���Ч��
 * ����ִ�з�����Ч�ʲ���Ƚ�
 */
public class Demo04 {
	
	public static void main(String[] args) throws Exception{
		 
		test01();
		test02();
		test03();
	}
	
	public static void test01(){
		User user = new User();
		
		long startTime = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000000L; i++){
			user.getUname();
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("��ͨ�������ã�ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
		
	}
	
	public static void test02() throws Exception{
		User user = new User();
		Class clazz = user.getClass();
		Method method = clazz.getDeclaredMethod("getUname", null);
//		method.setAccessible(true);
		
		long startTime  = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000000L; i++){
			method.invoke(user, null);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
	}
	
	public static void test03() throws Exception{
		User user = new User();
		Class clazz = user.getClass();
		Method method = clazz.getDeclaredMethod("getUname", null);
		method.setAccessible(true);//��ִ�а�ȫ���
		
		long startTime  = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000000L; i++){
			method.invoke(user, null);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("���䶯̬�������ã�������ȫ��飬ִ��10�ڴΣ���ʱ��"+(endTime-startTime)+"ms");
	}
}
