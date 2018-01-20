package com.lingzg.test;

public class Test1 {

	 public void testExit() {  
	        try {  
//	        	System.out.println("testExit1");  
	        	long l=1001101L;
	        	System.out.println(l);
	        	System.out.println(Long.toBinaryString(l));
	        	l=Long.highestOneBit(l);
	        	System.out.println(l); 
	        	System.out.println(Long.toBinaryString(l));
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
