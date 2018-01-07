package com.xyq.maventest.pattern.handler.bean;

public class Level {

	private int level = 0;

	public Level(int level) {
		super();
		this.level = level;
	}
	
	public boolean above(Level level){
	
		if(this.level >= level.level){
			return true;
		}
		
		return false;
	}
	
}

