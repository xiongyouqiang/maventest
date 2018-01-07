package com.xyq.maventest.pattern.handler;

import com.xyq.maventest.pattern.handler.bean.Level;
import com.xyq.maventest.pattern.handler.bean.Request;
import com.xyq.maventest.pattern.handler.bean.Response;

public class ConcreteHandler1 extends Handler {

	@Override
	protected Level getHandlerLevel() {
		return new Level(1);
	}

	@Override
	public Response response(Request request) {
		System.out.println("请求由处理器1进行处理");
		return null;
	}

}
