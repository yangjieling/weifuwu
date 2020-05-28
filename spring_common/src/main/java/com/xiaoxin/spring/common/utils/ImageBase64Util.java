package com.xiaoxin.spring.common.utils;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;

public class ImageBase64Util {

    static BASE64Encoder encoder = new sun.misc.BASE64Encoder();
    static BASE64Decoder decoder = new sun.misc.BASE64Decoder();

    public static void main(String[] args) {
//        System.out.println(getImageBinary()); // image to base64
        base64StringToImage("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"); // base64 to image
    }

    static String getImageBinary() {
        File f = new File("d://time.jpg");
        try {
            BufferedImage bi = ImageIO.read(f);
            ByteArrayOutputStream baos = new ByteArrayOutputStream();
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();

            return encoder.encodeBuffer(bytes).trim();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    static void base64StringToImage(String base64String) {
        try {
            byte[] bytes1 = decoder.decodeBuffer(base64String);
            ByteArrayInputStream bais = new ByteArrayInputStream(bytes1);
            BufferedImage bi1 = ImageIO.read(bais);
            File f1 = new File("d://"+LocalDate.now()+".jpg");
            ImageIO.write(bi1, "jpg", f1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
