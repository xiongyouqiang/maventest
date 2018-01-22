package com.xyq.maventest.pattern.command;

public class ConcreteCommand implements Command {

	private Receiver receiver = null;
	
	
	
	public ConcreteCommand(Receiver receiver) {
		super();
		this.receiver = receiver;
	}



	@Override
	public void excute() {

		this.receiver.doSomething();
	}



	public Receiver getReceiver() {
		return receiver;
	}



	public void setReceiver(Receiver receiver) {
		this.receiver = receiver;
	}

	
	
}
