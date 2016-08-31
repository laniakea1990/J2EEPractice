package com.cmb.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/*
 * ######非常重要！！！######
 * 应用反射的API，获取类的信息（类的名字、属性、方法、构造器等）
 */
//@SuppressWarnings("all")
public class Demo02 {

	public static void main(String[] args) throws NoSuchFieldException, SecurityException, NoSuchMethodException{
		String path = "com.cmb.test.bean.User";
		
		try {
			Class clazz =  Class.forName(path);
			
			//获取类的名字
			System.out.println(clazz.getName());//获得包名+类名
			System.out.println(clazz.getSimpleName());//获得类名
			
			//获取属性信息
			Field[] field = clazz.getFields();//只能获得public的field
			Field[] field2 = clazz.getDeclaredFields();//获得所有的field，包括private属性
			Field field3 = clazz.getDeclaredField("uname");
			System.out.println(field.length);
			System.out.println(field2.length);
			System.out.println(field3);
			for(Field temp:field2){
				System.out.println("属性："+temp);
			}
			
			//获取方法信息
			Method[] method = clazz.getDeclaredMethods();
			Method method2 = clazz.getDeclaredMethod("getUname", null);
			//如果方法有参数，则必须传递参数类型对应的class对象
			Method method3 = clazz.getDeclaredMethod("setUname", String.class);
			for(Method m:method){
				System.out.println("方法："+m);
			}
			
			//获得构造（器）函数信息
			Constructor[] constructors = clazz.getDeclaredConstructors();
			Constructor constructor = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			System.out.println("获得构造函数："+constructor);
			for(Constructor c:constructors){
				System.out.println("构造函数："+c);
			}
		} catch (ClassNotFoundException e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
