package com.wsn.restful.util;

import sun.misc.BASE64Decoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;

/**
 * 将二维码二进制数据转化为图片
 * Created by songyangguang on 2018/1/15.
 */
public class QRCodeToImage {
    public String imageUrl="D://QRCode.jpg";

    public String base64StringToImage(String base64String) {
        BASE64Decoder decoder = new BASE64Decoder();
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File file = new File("D://QRCode.jpg");// 指定图片存储路径、图片名称和格式
            ImageIO.write(bi1, "jpg", file);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imageUrl;
    }

}
