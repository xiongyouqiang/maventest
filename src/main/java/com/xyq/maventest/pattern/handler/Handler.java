package com.xyq.maventest.pattern.handler;

import com.xyq.maventest.pattern.handler.bean.Level;
import com.xyq.maventest.pattern.handler.bean.Request;
import com.xyq.maventest.pattern.handler.bean.Response;

public abstract class Handler {

	private Handler nextHandler;
	
	public final Response handleRequest(Request request){
		
		Response response = null;
		
		if(this.getHandlerLevel().above(request.getLevel())){
			response = this.response(request);
		}else{
			if(this.nextHandler !=null){
				this.nextHandler.handleRequest(request);
			}else{
				System.out.println("---------没有合适的处理器-------");
			}
		}
		return response;
	}
	
	//获取当前handler的level
	protected abstract Level getHandlerLevel();
	
	//处理请求返回结果
	public abstract Response response(Request request);
	

	public Handler getNextHandler() {
		return nextHandler;
	}

	public void setNextHandler(Handler nextHandler) {
		this.nextHandler = nextHandler;
	}
	
	
	
	
}
