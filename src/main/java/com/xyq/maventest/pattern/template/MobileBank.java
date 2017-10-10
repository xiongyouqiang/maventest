package com.xyq.maventest.pattern.template;

import com.xyq.maventest.pattern.template.bean.User;

public class MobileBank extends Bank {

	@Override
	public boolean validateUser(User user) {
		
		if(user.getUsername().startsWith("mobile") && user.getPassword().startsWith("mobile")){
			return true;
		}
		return false;
	}

	@Override
	public void welcome() {
		 
		System.out.println("welcome come in the  mobile system.");
	}

}
