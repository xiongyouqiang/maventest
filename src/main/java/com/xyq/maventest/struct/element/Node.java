/**
 * 
 */
/**
 * @author lenovo
 *
 */
package com.xyq.maventest.struct.element;

/****
 * linkedlist存放数据的节点
 * @author lenovo
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