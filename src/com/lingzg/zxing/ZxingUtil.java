package com.lingzg.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.util.HashMap;

import javax.imageio.ImageIO;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.Binarizer;
import com.google.zxing.BinaryBitmap;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.common.HybridBinarizer;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

/**
 * 使用zxing读写二维码
 * @author lingzg
 *
 */
public class ZxingUtil {

	public static File createZxing(String content,String outputPath) throws WriterException, IOException {
		int width = 300;
		int hight = 300;
		String format = "png";
		HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 纠错等级L,M,Q,H
		hints.put(EncodeHintType.MARGIN, 2); // 边距
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, hight, hints);
		File output = new File(outputPath);
		Path file = output.toPath();
		MatrixToImageWriter.writeToPath(bitMatrix, format, file);
		return output;
	}

	public static String readZxing(String filePath) throws IOException, NotFoundException {
		File file = new File(filePath);
		return readZxing(file);
	}

	public static String readZxing(File file) throws IOException, NotFoundException {
		BufferedImage image = ImageIO.read(file);
		return readZxing(image);
	}

	public static String readZxing(InputStream in) throws IOException, NotFoundException {
		BufferedImage image = ImageIO.read(in);
		return readZxing(image);
	}

	public static String readZxing(BufferedImage image) throws IOException, NotFoundException {
		MultiFormatReader read = new MultiFormatReader();
		Binarizer binarizer = new HybridBinarizer(new BufferedImageLuminanceSource(image));
		BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
		Result res = read.decode(binaryBitmap);
		System.out.println(res.getBarcodeFormat());
		System.out.println(res.getText());
		return res.getText();
	}

	public static void main(String[] args) {
		try {
			createZxing("http://172.16.1.15:8080/gongdi/app/login","F:/image.png");
			readZxing("F:/image.png");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
