package com.lingzg.zxing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
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

public class ZxingUtil {

	private static void createZxing() throws WriterException, IOException {
		int width = 300;
		int hight = 300;
		String format = "png";
		String content = "http://172.16.1.14:8080/fxCloud/app/login";
		HashMap<EncodeHintType, Object> hints = new HashMap<EncodeHintType, Object>();
		hints.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hints.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);// 纠错等级L,M,Q,H
		hints.put(EncodeHintType.MARGIN, 2); // 边距
		BitMatrix bitMatrix = new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE, width, hight, hints);
		Path file = new File("F:/image.png").toPath();
		MatrixToImageWriter.writeToPath(bitMatrix, format, file);
	}

	private static void readZxing() throws IOException, NotFoundException {
		MultiFormatReader read = new MultiFormatReader();
		File file = new File("F:/image.png");
		BufferedImage image = ImageIO.read(file);
		Binarizer binarizer = new HybridBinarizer(new BufferedImageLuminanceSource(image));
		BinaryBitmap binaryBitmap = new BinaryBitmap(binarizer);
		Result res = read.decode(binaryBitmap);
		System.out.println(res.toString());
		System.out.println(res.getBarcodeFormat());
		System.out.println(res.getText());
	}

	public static void main(String[] args) {
		try {
			createZxing();
			readZxing();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
