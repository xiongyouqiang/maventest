package com.xyq.maventest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.google.gson.Gson;
import com.xyq.maventest.bean.Person;

/**
 * Hello world!
 *
 */
public class App 
{
	private static Gson gson = new Gson();
	
	private static List<Person> persons = new ArrayList<Person>();
    public static void main( String[] args )
    {
        
        Person p1 = new Person(10, "Lee");
        Person p2 = new Person(50, "Xiong");
        Person p3 = new Person(60, "Zhao");
        Person p4 = new Person(40, "Qian");
        
        persons.add(p1);
        persons.add(p2);
        persons.add(p3);
        persons.add(p4);
        
        System.out.println("排序�?...");
        System.out.println(gson.toJson(persons));
        
        Collections.sort(persons, new PersonComp());
 
        
        System.out.println("排序�?...");
        System.out.println(gson.toJson(persons));
    }
    
     private static class PersonComp implements Comparator<Person>{

		public int compare(Person o1, Person o2) {
		    if(o1.getAge() >= o2.getAge())
		    	return 1;
		    else 
		    	return -1;
		}
    	 
     }
     
   
    
    
}
