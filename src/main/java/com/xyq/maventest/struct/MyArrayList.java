 
/**
 * @author xiongyouqiang
 *
 */
package com.xyq.maventest.struct;

public class MyArrayList{
	
	Object[] objs = new Object[10];
	
	int size = 0;
	
	public void add(Object value){
		if(size <= objs.length - 1){
			
		}else{
			Object[] tempArray = new Object[(int) (objs.length* 2)];
			for(int i=0;i<objs.length;i++){
				tempArray[i] = objs[i];
			}
			objs = tempArray;
		}
		objs[size] = value;
	    size++;
	}
	
	public void set(int index,Object value) throws Exception{
		
		if(index < 0 || index >= objs.length-1){
			throw new Exception("数组越界异常");
		}
		
		objs[index] = value; 
		
	}
	
	public void remove(int index) throws Exception{
		
		if(index < 0 || index >= objs.length-1){
			throw new Exception("数组越界异常");
		}
		for(int i=index+1;i<size;i++){
			objs[i-1] = objs[i];
		}
	}
	
	public void clear(){
		
		size = 0;
		objs = new Object[4];
	}
	
	
	
	public Object get(int index) throws Exception{
		
		if(index < 0 || index >= objs.length-1){
			throw new Exception("数组越界异常");
		}
		return objs[index];
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}
	
	
	
}