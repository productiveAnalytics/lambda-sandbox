package com.productive_analytics;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import com.productive_analytics.model.Person;
import com.productive_analytics.model.PersonNameComparator;

public class LambdaMain {
    public static void main(String args[]) {
        Person[] personList = new Person[] {
        		new Person(23, "Rajshree"),
                new Person(29, "Anand"),
                new Person(32, "Satoshi"),
                new Person(21, "Xiobao"),
                new Person(25, "Misha"),
                new Person(35, "Uma"),
                new Person(22, "Bentir")
        };
        
        
        System.out.println("UnSorted List is ::" + Arrays.asList(personList));
        
        {
	        List <Person> pList1 = Arrays.asList(personList);
	        
	        // SCENERIO 1: Use customized Comparator Class
	        Collections.sort(pList1, new PersonNameComparator());
	        
	        System.out.println("\n\nSCENARIO 1\n\t Sorted List is ::" + pList1);
        }
        
        {
	        List <Person> pList2 = Arrays.asList(personList);
	        
	        // SCENERIO 2:: Use Comparator Anonymous Inner class .. Functional Interface
	        Collections.sort(pList2, new Comparator<Person>() {
								        @Override
								        public int compare(Person p1, Person p2) {
								        	return p1.getName().compareTo(p2.getName());
								        }
	        						}
	        				);
	        
	        System.out.println("\n\nSCENARIO 2\n\t Sorted List is ::" + pList2);
        }
        
        {
	        List <Person> pList3 = Arrays.asList(personList);
	        
	        // SCENERIO 3: Using lambda expressions..using default methods 
	        pList3.sort((p1,p2) -> p1.getName().compareTo(p2.getName()));
	        
	        System.out.println("\n\nSCENARIO 3\n\t Sorted List is ::" + pList3);
        }
        
        {
	        List <Person> pList4 = Arrays.asList(personList);
	        
	        // SCENERIO 4: Using lambda expressions..using higher order functions 
	        pList4.sort(Comparator.comparing(p -> p.getName()));
	        
	        System.out.println("\n\nSCENARIO 4\n\t Sorted List is ::" + pList4);
        }
        
        {
	        List <Person> pList5 = Arrays.asList(personList);
	        
	        // SCENERIO 5: Using lambda expressions..using method references 
	        pList5.sort(Comparator.comparing(Person::getName));
	        
	        System.out.println("\n\nSCENARIO 5\n\t Sorted List is ::" + pList5);
        }
    }
}
