package com.xyq.maventest.collection.bean;

/****
 * 学生实体类
* @ClassName: Student 
* @Description: 学生的几个属性，和对应的set、get方法，和参数构造方法 
* @author youqiang.xiong
* @date 2018年1月15日 下午4:46:03 
*
 */
public class Student {

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
