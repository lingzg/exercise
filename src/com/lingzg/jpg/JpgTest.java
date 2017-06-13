package com.lingzg.jpg;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

/**
 * Java鍘嬬缉鍥剧墖涓簀pg缂╃暐鍥�
 * 杩囩▼寰堢畝鍗曪紝浠庢湰鍦扮鐩樿鍙栨枃浠禣rder005-0001.jpg(2032*1524)锛屽彉鎴怚mage瀵硅薄src,鎺ョ潃鏋勯�鐩爣鏂囦欢tag,
 * 璁剧疆tag鐨勯暱瀹戒负婧愬浘鐨勪竴鍗婏紝瀵箃ag杩涜缂栫爜锛岃緭鍑哄埌鏂囦欢娴乷ut,鏈�悗鍏抽棴鏂囦欢娴併�
 * 
 * @author lingzg
 *
 */
public class JpgTest {

	public void JpgTset() throws Exception {
		File _file = new File("/Order005-0001.jpg"); // 璇诲叆鏂囦欢
		Image src = ImageIO.read(_file); // 鏋勯�Image瀵硅薄
		int wideth = src.getWidth(null); // 寰楀埌婧愬浘瀹�
		int height = src.getHeight(null); // 寰楀埌婧愬浘闀�
		BufferedImage tag = new BufferedImage(wideth / 2, height / 2, BufferedImage.TYPE_INT_RGB);
		tag.getGraphics().drawImage(src, 0, 0, wideth / 2, height / 2, null); // 缁樺埗缂╁皬鍚庣殑鍥�
		String dstName = "newfile.jpg";
//		FileOutputStream out = new FileOutputStream(dstName); // 杈撳嚭鍒版枃浠舵祦
//		JPEGImageEncoder encoder = JPEGCodec.createJPEGEncoder(out);
//		encoder.encode(tag); // 杩慗PEG缂栫爜
//		out.close();
		String formatName = dstName.substring(dstName.lastIndexOf(".") + 1);
		ImageIO.write(tag, formatName, new File(dstName));
		System.out.print(wideth + "*" + height);

	}
}
