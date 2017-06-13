package com.lingzg.pdf;

import java.io.File;
import java.io.IOException;

public class ConvertPdf {
	private static String INPUT_PATH;
	private static String PROJECT_PATH;

	public static void convertToHtml(String file, String project) {
		INPUT_PATH = file;
		PROJECT_PATH = project;
		if (checkContentType() == 0) {
			toHtml();
		}
	}

	private static int checkContentType() {
		String type = INPUT_PATH.substring(INPUT_PATH.lastIndexOf(".") + 1, INPUT_PATH.length()).toLowerCase();
		if (type.equals("pdf"))
			return 0;
		else
			return 9;
	}

	private static void toHtml()     
	    {     
	        if(new File(INPUT_PATH).isFile())     
	        {     
	            try    
	            {     
	                String cmd = "cmd /c start E://PDFBox//xpdf//pdftohtml.bat /" + PROJECT_PATH + "/ /" + INPUT_PATH + "/";     
	                Runtime.getRuntime().exec(cmd);     
	            }     
	            catch (IOException e)     
	            {     
	                e.printStackTrace();     
	            }     
	        }     
	    }
	
	public static void main(String[] args) {
		ConvertPdf.convertToHtml("F://Documents//电子发票.pdf", "E:/PDFBox/xpdf");
	}
}
