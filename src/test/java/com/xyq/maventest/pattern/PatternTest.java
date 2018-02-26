package com.xyq.maventest.pattern;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.xyq.maventest.pattern.singelton.Singleton;
import com.xyq.maventest.pattern.template.Bank;
import com.xyq.maventest.pattern.template.MobileBank;
import com.xyq.maventest.pattern.template.NetworkBank;
import com.xyq.maventest.pattern.template.bean.User;

public class PatternTest {
 
	Logger log =  LoggerFactory.getLogger(PatternTest.class);
	
	
	 
	
	
	@Test
	public void testSingelton(){
		
		Singleton s1 = Singleton.getInstance();
		Singleton s2 = Singleton.getInstance();
		System.out.println(log.isDebugEnabled()+"---"+log.isInfoEnabled());
		if(log.isInfoEnabled()){
			
			if(s1==s2){
				log.info("s1 is the same as s2");
			}else{
				log.info("s1 is not the same as s2");
			}
		}
	}
	
	@Test
	public void testTemplate(){
		
		User user = new User();
		user.setPassword("mobile1");
		user.setUsername("mobile1");
		
		User user1 = new User();
		user1.setPassword("network1");
		user1.setUsername("network1");
		
		Bank bank1 =  new MobileBank();
		bank1.login(user1);
		
		Bank bank2 =  new NetworkBank();
		bank2.login(user1);
		
		
	}
}
