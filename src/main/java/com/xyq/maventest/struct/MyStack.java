package com.xyq.maventest.struct;

public class MyStack {

	Object[]  objs = new Object[12];
	
	int size = 0;
	
	public void push(Object data){
		if(size <= objs.length - 1){
			
		}else{
			Object[] tempArray = new Object[(int) (objs.length* 2)];
			for(int i=0;i<objs.length;i++){
				tempArray[i] = objs[i];
			}
			objs = tempArray;
		}
		objs[size] = data;
	    size++;
	}
	
	public Object pop(){
		
		Object data = null;
		if(size == 0)  return null;
		if(size <= objs.length - 1){
			data = objs[size-1];
			//objs[size] = null;
			size -- ;
		}
		
		return data;
	}
}
