package com.cmb.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.cmb.test.bean.User;

/*
 * ######非常重要！！！######
 * 通过反射API动态的操作：构造器、方法、属性
 */
public class Demo03 {

	public static void main(String[] args) {
		String path = "com.cmb.test.bean.User";
		
		try {
			Class<User> clazz = (Class<User>)Class.forName(path);
			
			//通过动态调用构造方法，构造对象
			User user = clazz.newInstance(); //其实是调用了User的无参数构造方法
			System.out.println(user);
			
			Constructor<User> constructor = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User user2 = constructor.newInstance(1111,18,"RaiseKing");//调用有参数构造方法创建对象
			System.out.println(user2.getUname());
			
			//通过反射API调用普通方法
			User user3 = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(user3, "gokuliz");//user3.setUname("gokuliz");
			System.out.println(user3.getUname());
			
			//通过反射API操作属性
			User user4 = clazz.newInstance();
			Field field = clazz.getDeclaredField("uname");
			field.setAccessible(true);//这个属性不需要做安全检查了，可以直接访问
			field.set(user4, "Gokuliz");//通过反射直接写属性
			System.out.println(user4.getUname());//通过反射直接读属性
			System.out.println(field.get(user4));
		} catch (Exception e) {
			// TODO 自动生成的 catch 块
			e.printStackTrace();
		}
	}
}
