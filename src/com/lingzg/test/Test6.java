package com.lingzg.test;

import java.util.ArrayList;
import java.util.List;

public class Test6 {

	public void testInt(int n) {  
        n++;  
    }  
  
    public void testIntger(Integer n) {  
        int m = n;  
        m++;  
        n = new Integer(m);  
    }  
      
    public void testList(List<Integer> list) {  
        int n = list.get(0);  
        n++;  
        list = new ArrayList<Integer>();  
        list.add(n);  
    }  
      
    public void testIntger2(Integer n) {  
        n++;  
    }  
      
    public void testList2(List<Integer> list) {  
        int n = list.get(0);  
        n++;  
        list.set(0, n);  
    }  
  
    /** 
     * @param args 
     */  
    public static void main(String[] args) {  
        Test6 t = new Test6();  
        int n = 1;  
        t.testInt(n);  
        System.out.println(n);  
          
        t.testInt(Integer.valueOf(n));  
        Integer m = new Integer(1);  
        t.testIntger(m);  
        System.out.println(m);  
          
        List<Integer> list = new ArrayList<Integer>();  
        list.add(1);  
        t.testList(list);  
        System.out.println(list.get(0));  
          
        t.testIntger2(m);  
        System.out.println(m);  
          
        t.testList2(list);  
        System.out.println(list.get(0));  
    }  
}
