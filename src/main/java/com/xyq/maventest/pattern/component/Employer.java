package com.xyq.maventest.pattern.component;

import java.util.List;

public abstract class Employer {

	//员工姓名
	private String name;

	
	public List<Employer> employers;
	
	public abstract void add(Employer employer);
	
	public abstract void remove(Employer employer);
	
	public List<Employer> getEmployers() {
		return employers;
	}

	public void setEmployers(List<Employer> employers) {
		this.employers = employers;
	}

	public void printInfo(){
		System.out.println(name);
	}
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
