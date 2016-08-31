package com.cmb.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

import com.cmb.test.bean.User;

/*
 * ͨ�������ȡ������Ϣ
 */
public class Demo05 {
	
	public void test01(Map<String, User> map, List<User> list){
		System.out.println("Demo05.test01()");
	}
	
	public Map<Integer, User> test02(){
		System.out.println("Demo05.test02()");
		return null;
	}
	
	public static void main(String[] args){
		try{
			
			//���ָ����������������Ϣ
			Method method = Demo05.class.getMethod("test01", Map.class,List.class);
			Type[] types = method.getGenericParameterTypes();
			for(Type paramType:types){
				System.out.println("#"+paramType);
				if(paramType instanceof ParameterizedType){
					Type[] genericTypes = ((ParameterizedType) paramType).getActualTypeArguments();
					for(Type genericType:genericTypes){
						System.out.println("�������ͣ�"+genericType);
					}
				}
			}
			
			//���ָ����������ֵ������Ϣ
			Method method2 = Demo05.class.getMethod("test02", null);
			Type returnType = method2.getGenericReturnType();
			
			if(returnType instanceof ParameterizedType){
				Type[] genericTypes = ((ParameterizedType) returnType).getActualTypeArguments();
				for(Type genericType: genericTypes)
					System.out.println("����ֵ���������ͣ�"+genericType);
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}
}
