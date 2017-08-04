package com.lingzg.qrcode;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import javax.imageio.ImageIO;

import com.swetake.util.Qrcode;

import jp.sourceforge.qrcode.QRCodeDecoder;

/**
 * 使用qrcode读写二维码
 * @author lingzg
 *
 */
public class QRcodeUtil {

	public static File createQRcode(String qrData,String outputPath) throws IOException {
		Qrcode qrcode = new Qrcode();
		qrcode.setQrcodeErrorCorrect('M'); // 纠错等级L M Q H
		qrcode.setQrcodeEncodeMode('B'); // N:数字，A:a-Z ,B:其他字符
		int version = 7;
		qrcode.setQrcodeVersion(version);
		byte data[] = qrData.getBytes("utf-8");
		int width = 67 + 12 * (version - 1);
		int hight = 67 + 12 * (version - 1);
		BufferedImage bufferedImage = new BufferedImage(width, hight, BufferedImage.TYPE_INT_RGB);
		Graphics2D graphics2d = bufferedImage.createGraphics();
		graphics2d.setBackground(Color.white);
		graphics2d.setColor(Color.black);
		graphics2d.clearRect(0, 0, width, hight);
		int pixoff = 2; // 偏移量
		if (data.length > 0 && data.length < 120) {
			boolean[][] s = qrcode.calQrcode(data);
			for (int i = 0; i < s.length; i++) {
				for (int j = 0; j < s.length; j++) {
					if (s[j][i]) {
						graphics2d.fillRect(j * 3 + pixoff, i * 3 + pixoff, 3, 3);
					}
				}
			}
		}
		graphics2d.dispose();
		bufferedImage.flush();
		File output = new File(outputPath);
		ImageIO.write(bufferedImage, "png", output);
		return output;
	}

	public static String readQRcode(String filePath) throws IOException {
		File file = new File(filePath);
		return readQRcode(file);
	}

	public static String readQRcode(File file) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(file);
		return readQRcode(bufferedImage);
	}

	public static String readQRcode(InputStream in) throws IOException {
		BufferedImage bufferedImage = ImageIO.read(in);
		return readQRcode(bufferedImage);
	}

	public static String readQRcode(BufferedImage bufferedImage) throws IOException {
		QRCodeDecoder codeDecoder = new QRCodeDecoder();
		String res = new String(codeDecoder.decode(new MyQRCodeImage(bufferedImage)), "utf-8");
		System.out.println(res);
		return res;
	}

	public static void main(String[] args) {
		try {
//			createQRcode("http://172.16.1.15:8080/gongdi/app/login","C:\\Users\\lingzg\\Pictures\\image.png");
			readQRcode("C:\\Users\\lingzg\\Pictures\\image.jpg");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
