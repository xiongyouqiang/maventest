package com.xyq.maventest.pattern.template;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyq.maventest.pattern.template.bean.User;

public abstract class Bank {

	private Logger log =  LoggerFactory.getLogger(Bank.class);
	
	public void login(User user){
		
		if(validateUser(user)){
			welcome();
		}else{
			log.info("username or password is wrong");
		}
	}
	
	public abstract boolean validateUser(User user);
	
	public abstract void welcome();
	
	
}
