package com.cmb.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

import com.cmb.test.bean.User;

/*
 * ######�ǳ���Ҫ������######
 * ͨ������API��̬�Ĳ�����������������������
 */
public class Demo03 {

	public static void main(String[] args) {
		String path = "com.cmb.test.bean.User";
		
		try {
			Class<User> clazz = (Class<User>)Class.forName(path);
			
			//ͨ����̬���ù��췽�����������
			User user = clazz.newInstance(); //��ʵ�ǵ�����User���޲������췽��
			System.out.println(user);
			
			Constructor<User> constructor = clazz.getDeclaredConstructor(int.class,int.class,String.class);
			User user2 = constructor.newInstance(1111,18,"RaiseKing");//�����в������췽����������
			System.out.println(user2.getUname());
			
			//ͨ������API������ͨ����
			User user3 = clazz.newInstance();
			Method method = clazz.getDeclaredMethod("setUname", String.class);
			method.invoke(user3, "gokuliz");//user3.setUname("gokuliz");
			System.out.println(user3.getUname());
			
			//ͨ������API��������
			User user4 = clazz.newInstance();
			Field field = clazz.getDeclaredField("uname");
			field.setAccessible(true);//������Բ���Ҫ����ȫ����ˣ�����ֱ�ӷ���
			field.set(user4, "Gokuliz");//ͨ������ֱ��д����
			System.out.println(user4.getUname());//ͨ������ֱ�Ӷ�����
			System.out.println(field.get(user4));
		} catch (Exception e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
