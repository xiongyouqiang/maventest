package com.xyq.maventest.struct;

import com.xyq.maventest.struct.element.Node;
/****
 * 自定义的链表
* @ClassName: MyLinkedList 
* @Description:  
* @author youqiang.xiong
* @date 2018年1月23日 上午11:53:40 
*
 */
public class MyLinkedList {

	private Node head = null;
	
	private int size = 0;
	
	public void add(Object data){
		
		Node node = new Node(data);
		if(head == null){
			head = node;
		}else{
			Node temp = head;
			while(temp.getNext() !=null){
				temp = temp.getNext();
			}
			
			temp.setNext(node);
		}
		
		size ++ ;
	}
	
	/***
	 * 修改指定位置索引的数据
	 * @param index
	 * @param data
	 */
	public void set(int index,Object data){
		
		if(index < 0 || index > size -1  ){
		    	
		}
		Node node = new Node(data);
		Node temp = head;
		for (int i = 0; i < index-1; i++) {
			temp = temp.getNext();
		}
		
		node.setNext(temp.getNext().getNext());
		temp.setNext(node);
		
	}
	/***
	 * 删除指定位置索引的数据
	 * @param index
	 * @param data
	 */
	public void remove(int index){
		
		if(index < 0 || index > size -1  ){
			
		}
		Node temp = head;
		for (int i = 0; i < index-1; i++) {
			temp = temp.getNext();
		}
		
		temp.setNext(temp.getNext().getNext());
		size--;
	}
	
	public void clear(){
		
		head = null;
		size = 0;
	}
	
	public Object get(int index){
		
		if(index < 0 || index > size -1  ){
	    	
		}
		Node temp = head;
		for (int i = 0; i < index; i++) {
			temp = temp.getNext();
		}
		
		return temp.getData();
		 
	}
	
	
	

	public Node getHead() {
		return head;
	}

	public void setHead(Node head) {
		this.head = head;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
}
