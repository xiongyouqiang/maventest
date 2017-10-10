package com.xyq.maventest.pattern.template;

import com.xyq.maventest.pattern.template.bean.User;

public class NetworkBank extends Bank {

	@Override
	public boolean validateUser(User user) {
	 
		if(user.getUsername().startsWith("network") && user.getPassword().startsWith("network")){
			return true;
		}
		return false;
	}

	@Override
	public void welcome() {
	 
		System.out.println("welcome come in the network system.");
	}

}
