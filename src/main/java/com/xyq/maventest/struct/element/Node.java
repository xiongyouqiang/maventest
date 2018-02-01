/**
 * 
 */
/**
 * @author lenovo
 *
 */
package com.xyq.maventest.struct.element;

/***
 * 
* @ClassName: Node 
* @Description: linkedList的节点对象 
* @author youqiang.xiong
* @date 2018年1月23日 上午11:53:15 
*
 */
public class Node{
	
	private Object data;
	
	private Node next;

	
	
	
	public Node(Object data) {
		super();
		this.data = data;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Node getNext() {
		return next;
	}

	public void setNext(Node next) {
		this.next = next;
	}
	
	
	
	
}