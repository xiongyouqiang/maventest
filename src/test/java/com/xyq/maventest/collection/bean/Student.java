package com.xyq.maventest.collection.bean;

import java.io.Serializable;

/****
 * 学生实体类
* @ClassName: Student 
* @Description: 学生的几个属性，和对应的set、get方法，和参数构造方法 
* @author youqiang.xiong
* @date 2018年1月15日 下午4:46:03 
*
 */
public class Student implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/****
	 * 学号
	 */
	private Integer no;
	
	/****
	 * 姓名
	 */
	private String name;
	
	/****
	 * 性别
	 */
	private Character sex;
	
	/****
	 * 班级
	 */
	private String banji;

	
	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((banji == null) ? 0 : banji.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((no == null) ? 0 : no.hashCode());
		result = prime * result + ((sex == null) ? 0 : sex.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		if (banji == null) {
			if (other.banji != null)
				return false;
		} else if (!banji.equals(other.banji))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (no == null) {
			if (other.no != null)
				return false;
		} else if (!no.equals(other.no))
			return false;
		if (sex == null) {
			if (other.sex != null)
				return false;
		} else if (!sex.equals(other.sex))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Student [no=" + no + ", name=" + name + ", sex=" + sex
				+ ", banji=" + banji + "]";
	}

	public Integer getNo() {
		return no;
	}

	public void setNo(Integer no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Character getSex() {
		return sex;
	}

	public void setSex(Character sex) {
		this.sex = sex;
	}

	public String getBanji() {
		return banji;
	}

	public void setBanji(String banji) {
		this.banji = banji;
	}

	public Student(Integer no, String name, Character sex, String banji) {
		super();
		this.no = no;
		this.name = name;
		this.sex = sex;
		this.banji = banji;
	}

	public Student() {
		super();
	}
	
	
	
	
	
}
