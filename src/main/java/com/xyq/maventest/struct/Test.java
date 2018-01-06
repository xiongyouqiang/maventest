package com.xyq.maventest.struct;

public class Test {

	public static void main(String[] args) throws Exception {
		
//		MyArrayList  list = new MyArrayList();
//		MyLinkedList  list = new MyLinkedList();
//		list.add(8);
//		list.add(9);
//		list.add(4);
//		list.add(6);
//		list.add(7);
//		
//		list.set(1, 12);
//		list.remove(2);
//		
//		list.clear();
		
//		for (int i = 0; i < list.getSize(); i++) {
//			System.out.println(list.get(i));
//		}
		
		MyStack stack = new MyStack();
		
		for(int i = 1;i<=50;i++){
			stack.push(i);
		}
		
		Object temp = null;
		while((temp=stack.pop())!=null){
			
			System.out.println(temp);
		}
	}
}
