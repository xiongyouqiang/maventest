package com.xyq.maventest.pattern.command;

/****
 * 命令模式的使用场景：
 * 1.对于大多数请求-相应模式的功能，比较适合使用命令模式，正如命令模式所定义的那样，
 * 命令模式对实现记录日志，撤销操作等功能比较方便
 * @author youqiang.xiong
 * <p> TODO 简单描述此类的用途</p>
 * 2018年1月6日下午3:49:24
 */
public class Client {

	public static void main(String[] args) {
		Receiver receiver = new Receiver();
		Command command = new ConcreteCommand(receiver);
		
		//客户端直接执行具体命令方式（此方式与类图相符）
		command.excute();
		
		//客户端通过调用者来执行命令
		Invoker invoker = new Invoker(command);
		invoker.action();
	}
}
