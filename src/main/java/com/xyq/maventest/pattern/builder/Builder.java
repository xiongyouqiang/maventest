package com.xyq.maventest.pattern.builder;

public abstract class Builder {

	public abstract void setPart(String name,String type);
	
	public abstract Product getProuct();
}
