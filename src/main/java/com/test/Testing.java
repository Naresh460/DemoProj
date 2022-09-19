package com.test;

public class Testing {

	public static void main(String[] args) {
		String name="Naresh";
		StringBuilder sb=new StringBuilder();
		sb.append(name);
		String revName= sb.reverse().toString();
		for(int i=0;i<revName.length();i++) {
		char ch=revName.charAt(i);
		System.out.println(ch);
		
		}
	}
}
