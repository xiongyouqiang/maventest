package com.xyq.maventest.pattern.component;

/****
 * 组合模式调用实例
 * @author youqiang.xiong
 * <p> TODO 简单描述此类的用途</p>
 * 2018年1月7日上午11:04:44
 */
public class Client {

	public static void main(String[] args) {
		
		Employer programmer = new Programmer("程序员1");
		Employer programmer2 = new Programmer("程序员2");

		Employer pa = new ProjectAssistant("项目助理1");
	
		Employer pm = new ProjectManager("项目管理1");
		pm.add(programmer);
		pm.add(programmer2);
		pm.add(pa);
		
		Employer pm2 = new ProjectManager("项目老大");
		pm2.add(pm);
		
		printAll(pm2);
		
	}
	
	public static void printAll(Employer pm){
		
		for(Employer emp:pm.getEmployers()){
			emp.printInfo(); 
			if(emp.getEmployers()!=null){
				printAll(emp);
			}
		}
	}
}
