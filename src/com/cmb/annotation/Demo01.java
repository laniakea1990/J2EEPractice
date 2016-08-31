package com.cmb.annotation;

import java.util.Date;

public class Demo01 /*extends Object*/{
	
	@Override
	public String toString(){
		return "";
	}

	@Deprecated
	public static void test(){
		System.out.println();
	}

	
	@SuppressWarnings("deprecation")
	public static void main(String[] args){
		Date date = new Date();
		Date.parse(date.toString());//parse方法不鼓励使用
		
		test();
	}
}
