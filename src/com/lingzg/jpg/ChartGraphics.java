package com.lingzg.jpg;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Java鐢熸垚jpg鏍煎紡鍥剧墖
 * Created by IntelliJ IDEA. 
 * User: Administrator 
 * Date: 2005-6-10 Time: 11:19:49
 * This class can create jpg picture. 
 * To change this template use File | Settings | File Templates.
 */
public class ChartGraphics {
	BufferedImage image;

	void createImage(String fileLocation) {
		try {
//			FileOutputStream fos = new FileOutputStream(fileLocation);
//			BufferedOutputStream bos = new BufferedOutputStream(fos);
//			JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(bos);
//			encoder.encode(image);
//			bos.close();
			File file = new File(fileLocation);
			if(!file.exists()){
				file.mkdirs();
			}
			String formatName = fileLocation.substring(fileLocation.lastIndexOf(".") + 1);
			ImageIO.write(image, formatName, file);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void graphicsGeneration(int h1, int h2, int h3, int h4, int h5) {

		final int X = 10;
		int imageWidth = 300;// 鍥剧墖鐨勫搴�
		int imageHeight = 300;// 鍥剧墖鐨勯珮搴�
		int columnWidth = 30;// 鏌辩殑瀹藉害
		int columnHeight = 200;// 鏌辩殑鏈�ぇ楂樺害

		// ChartGraphics chartGraphics = new ChartGraphics();
		image = new BufferedImage(imageWidth, imageHeight, BufferedImage.TYPE_INT_RGB);
		Graphics graphics = image.getGraphics();
		graphics.setColor(Color.white);
		graphics.fillRect(0, 0, imageWidth, imageHeight);
		graphics.setColor(Color.red);
		graphics.drawRect(X + 1 * columnWidth, columnHeight - h1, columnWidth, h1);
		graphics.drawRect(X + 2 * columnWidth, columnHeight - h2, columnWidth, h2);
		graphics.drawRect(X + 3 * columnWidth, columnHeight - h3, columnWidth, h3);
		graphics.drawRect(X + 4 * columnWidth, columnHeight - h4, columnWidth, h4);
		graphics.drawRect(X + 5 * columnWidth, columnHeight - h5, columnWidth, h5);
		createImage("F://chart.jpg");
	}

	public static void main(String[] args) {
		int[] height = { 40, 50, 16, 22, 85 };
		ChartGraphics cg = new ChartGraphics();
		try {
			cg.graphicsGeneration(height[0], height[1], height[2], height[3], height[4]);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
