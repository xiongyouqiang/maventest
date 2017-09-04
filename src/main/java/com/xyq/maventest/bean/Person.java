package com.xyq.maventest.bean;


public class Person {
	
	private Integer age; //年龄
	
	private String name; // 姓名

	public Person() {
		super();
	}

	public Person(Integer age, String name) {
		super();
		this.age = age;
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
	

}
