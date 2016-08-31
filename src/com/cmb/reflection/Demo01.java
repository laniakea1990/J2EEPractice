package com.cmb.reflection;

/*
 * ���Ը�������(class,interface,enum,annotation,primitive type, void)��Ӧ��java.lang.Class����Ļ�ȡ��ʽ
 */
//@SuppressWarnings("all")
public class Demo01 {

	public static void main(String[] args){
		String path = "com.cmb.test.bean.User";
		
		try {
			Class clazz =  Class.forName(path);
			//�����Ǳ�ʾ���װһЩ���ݡ�һ���౻���غ�JVM�ᴴ��һ����Ӧ�����Class������������ṹ��Ϣ��ŵ���Ӧ��Class�����С�
			//���Class�������һ�澵��һ����ͨ�����澵�ӿ��Կ�����Ӧ���ȫ����Ϣ
			System.out.println(clazz);
			System.out.println(clazz.hashCode());
			
			Class clazz2 =  Class.forName(path);
			System.out.println(clazz2.hashCode());//һ����ֻ��Ӧһ��Class����
			
			Class<String> strClazz = String.class;
			Class strClazz2 = path.getClass();
			System.out.println(strClazz==strClazz2);//pathΪString����
			
			Class<Integer> intClazz = int.class;
			System.out.println(intClazz.hashCode());
			
			int[] arr01 = new int[10];
			int[] arr02 = new int[20];
			int[][] arr03 = new int [30][30];
			double[] arr04 = new double[40];
			System.out.println(arr01.getClass().hashCode());
			System.out.println(arr02.getClass().hashCode());
			System.out.println(arr03.getClass().hashCode());
			System.out.println(arr04.getClass().hashCode());
			
			
		} catch (ClassNotFoundException e) {
			// TODO �Զ����ɵ� catch ��
			e.printStackTrace();
		}
	}
}
