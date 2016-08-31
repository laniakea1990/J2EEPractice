package com.cmb.reflection;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import com.cmb.test.bean.User;

/*
 * 通过跳过安全检查，提高反射效率
 * 三种执行方法的效率差异比较
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
		System.out.println("普通方法调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
		
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
		System.out.println("反射动态方法调用，执行10亿次，耗时："+(endTime-startTime)+"ms");
	}
	
	public static void test03() throws Exception{
		User user = new User();
		Class clazz = user.getClass();
		Method method = clazz.getDeclaredMethod("getUname", null);
		method.setAccessible(true);//不执行安全检查
		
		long startTime  = System.currentTimeMillis();
		
		for(int i = 0; i < 1000000000L; i++){
			method.invoke(user, null);
		}
		
		long endTime = System.currentTimeMillis();
		System.out.println("反射动态方法调用，跳过安全检查，执行10亿次，耗时："+(endTime-startTime)+"ms");
	}
}
