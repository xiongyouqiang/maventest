package com.xyq.maventest.pattern.component;

public class Programmer extends Employer {

	public Programmer(String name) {
		setName(name);
		employers = null;
	}

	@Override
	public void add(Employer employer) {
		// TODO Auto-generated method stub

	}

	@Override
	public void remove(Employer employer) {
		// TODO Auto-generated method stub

	}

}
