package com.lingzg.test;

public class Test1 {

	 public void testExit() {  
	        try {  
	        	System.out.println("testExit1");  
	            System.exit(0);  
	        } finally {  
	            System.out.println("testExit");  
	        }  
	    }  
	      
	    public void testReturn() {  
	        try {  
	            return;  
	        } finally {  
	            System.out.println("testReturn");  
	        }  
	    }  
	  
	    /** 
	     * @param args 
	     */  
	    public static void main(String[] args) {  
	        Test1 t = new Test1();  
	        t.testReturn();  
	        t.testExit();  
	    }  
}
