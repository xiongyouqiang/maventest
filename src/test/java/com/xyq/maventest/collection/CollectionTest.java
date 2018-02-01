package com.xyq.maventest.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;
import java.util.Vector;

import org.junit.Test;

import com.xyq.maventest.collection.bean.Student;
/****
 * 集合练习类
* @ClassName: CollectionTest 
* @Description:  
* @author youqiang.xiong
* @date 2018年1月15日 下午4:02:35 
*
 */
public class CollectionTest {

	
	private Scanner scan;

	/****
	 * 从控制台接受10个整数进行排序，按降序在控制台输出。
	 */
	@Test
	public void testDemo1(){
		
	      List<Integer> list = new ArrayList<Integer>();
		  while(list.size() <10){
			  System.out.print("请输入数据：");
			  scan = new Scanner(System.in);
			  String read = scan.nextLine();
			  list.add(Integer.parseInt(read));
		  }
		  //打印原有的数据顺序
		  System.out.println("打印原有的数据");
		  printArray(list);
		  System.out.println();
		  //排序 利用Collections工具类自带的方法
		  System.out.println("将原有数据倒叙排序，并打印.");
		  Collections.sort(list);
		  Collections.reverse(list);
		  printArray(list);

	}
	
	private void printArray(List<Integer> list){
		for (Integer integer : list) {
			System.out.print(integer+"  ");
		  }
	}
	
	/***
	 * 写一个程序随机生成30个数，要求分别统计出奇数和偶数的个数
	 */
	@Test
	public void testDemo2(){
		
		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		List<Integer> jsList = new ArrayList<Integer>();
		List<Integer> osList = new ArrayList<Integer>();
		while(list.size() < 30){
			int temp =random.nextInt(100);
			list.add(temp);
		}
		//打印随机生成的数据
		System.out.println("原有的30个整数分别为:");
		printArray(list);
		System.out.println();
		//计算奇数和偶数的个数分别添加到对应的list中
		for (Integer i : list) {
			if(i%2 == 0){
				osList.add(i);
			}else{
				jsList.add(i);
				
				
			}
		}
		System.out.println("奇数个数共："+jsList.size() +"个，分别如下所示:");
		Collections.sort(jsList);
		printArray(jsList);
		System.out.println();
		System.out.println("偶数个数共："+osList.size() +"个，分别如下所示:");
		Collections.sort(osList);
		printArray(osList);
	}
	
	/****
	 * 写一个程序通过集合类Vector，实现现有学生添加、修改、查询、删除功能。
	 * 要求
	 * 1.学生对象（Student）属性：学号、姓名、性别、班级
	 * 2.通过构造函数向Vector集合中添加5个学生对象到集合。
	 * 3.分别写4个方法，实现添加，按编号修改制定学生，编号查询学生，根据编号删除
	 */
	@Test
	public void testDemo3(){
		
		Vector<Student> students = new Vector<Student>();
		for (int i = 1; i <= 5; i++) {
			Student s = new Student();
			s.setNo(i);
			s.setName("name"+i);
			s.setSex(new Character('a'));
			s.setBanji("banji"+i);
			students.add(s);
		}
		
		 
	}
	
	
	@Test
	public void testDemo4(){
	
		
		List<String> list = new ArrayList<String>();
		list.add("b");
		list.add("ba");
		list.add("abg");
		list.add("bg");
		list.add("bc");
		list.add("bc");
		list.add("bbc");
		list.add("cb");
		list.add("abc");
		list.add("ba");
		
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < list.size(); i++) {
			for(int j= i+1;j<list.size();j++){
				if( list.get(i) == list.get(j)){
					set.add(list.get(i));
				}
			}
		}
		list.clear();
		list.addAll(set);
		System.out.println("存在重复的元素如下所示：");
		for (String s : list) {
			System.out.println(s+"\t");
		}
	}
	
	
	@Test
	public void testDemo5()
	{

		List<Integer> list = new ArrayList<Integer>();
		Random random = new Random();
		while(list.size() < 30){
			int temp =random.nextInt(20);
			list.add(temp);
		}
		//打印随机生成的数据
		System.out.println("原有的30个整数分别为:");
		Collections.sort(list);
		printArray(list);
		System.out.println();
//		reomveDuplicateByFor(list);
//		removeDuplicateByHashSet(list);
		removeDuplicateWithOrder(list);
		System.out.println("去除重复的对象后，数据分别为:");
		printArray(list);
		
	}
	
	@Test
	public void testDemo6(){
		
		List<String> list = new ArrayList<String>();
		list.add("b");
		list.add("ba");
		list.add("abg");
		list.add("bg");
		list.add("bc");
		list.add("bc");
		list.add("bbc");
		list.add("cb");
		list.add("abc");
		list.add("ba");
		
		Set<String> set = new HashSet<String>();
		for (int i = 0; i < list.size(); i++) {
			for(int j= i+1;j<list.size();j++){
				if( list.get(i).equals(list.get(j))){
					set.add(list.get(i));
				}
			}
		}
		System.out.println("存在重复的元素如下所示：");
		for (String s : set) {
			System.out.print(s+"\t");
		}
		System.out.println("\n非重复元素如下所示：");
		Iterator<String> iter = list.iterator();
		while(iter.hasNext()){
			if(set.contains(iter.next())){
				iter.remove();
			}
		}
		for (String s : list) {
			System.out.print(s+"\t");
		}
	}
	
	
	@SuppressWarnings({ "rawtypes", "unused" })
	private void reomveDuplicateByFor(List list){
		
		for (int i = 0; i < list.size(); i++) {
			for (int j = list.size() - 1; j > i; j--) {
				if(list.get(j).equals(list.get(i))){
					list.remove(j);
				}
			}
		}
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void removeDuplicateByHashSet( List<?> list) {    
		HashSet h = new HashSet(list);    
	      list.clear();    
	      list.addAll(h);    
	}  
	
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public void removeDuplicateWithOrder(List list) {
		Set set = new HashSet();
		List newList = new ArrayList();
		for (Iterator iter = list.iterator(); iter.hasNext();) {
			Object element = iter.next();
			if (set.add(element))
				newList.add(element);
		}
		list.clear();
		list.addAll(newList);
	}
	
}
