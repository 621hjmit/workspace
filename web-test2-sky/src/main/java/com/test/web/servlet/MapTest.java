package com.test.web.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Test2{
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	@Override
	public String toString() {
		return "Test [name=" + name + ", age=" + age + "]";
	}
	
}
public class MapTest {
	public static void main(String[] args) {
		List<Map<String,String>> strs = new ArrayList<>();
		Map<String, String> param = new HashMap<>();
		param.put("fileName","name");
		param.put("value", "하하");
		strs.add(param);
		param = new HashMap<>();
		param.put("fileName","age");
		param.put("value", "33");
		strs.add(param);
		Test2 t = new Test2();
		for(Map<String, String>m :strs) {
			if(m.get("fileName").equals("name")){
				String value = m.get("value");
				t.setName(value);
			}else if(m.get("fileName").equals("age")) {
				String value = m.get("value");
				t.setAge(Integer.parseInt(value));
			}
		}
		System.out.println(t);
	}
}
