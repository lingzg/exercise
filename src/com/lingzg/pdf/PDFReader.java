package com.lingzg.pdf;

import java.io.IOException;

import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.parser.PdfReaderContentParser;
import com.itextpdf.text.pdf.parser.SimpleTextExtractionStrategy;
import com.itextpdf.text.pdf.parser.TextExtractionStrategy;

public class PDFReader {
	public static void main(String[] args) throws IOException {
		String s=getPdfFileText("E:\\中国电建\\绩溪抽水蓄能电站技术条款.pdf");
		System.out.print(s);
	}

	public static String getPdfFileText(String fileName) throws IOException {
		PdfReader reader = new PdfReader(fileName);
		PdfReaderContentParser parser = new PdfReaderContentParser(reader);
		StringBuffer buff = new StringBuffer();
		TextExtractionStrategy strategy;
		for (int i = 1; i <= reader.getNumberOfPages(); i++) {
			strategy = parser.processContent(i, new SimpleTextExtractionStrategy());
			buff.append(strategy.getResultantText());
		}
		return buff.toString();
	}

}
