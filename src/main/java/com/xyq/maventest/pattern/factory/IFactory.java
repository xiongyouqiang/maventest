package com.xyq.maventest.pattern.factory;

/****
 * 
 * @author youqiang.xiong
 * <p> TODO 工程接口，定义抽象方法返回产品</p>
 * 2018年1月6日上午10:42:26
 */
public interface IFactory {

	public IProduct createProduct(String name);
	
	public IProduct2 createProduct2(String name,String type);
	
	
}
