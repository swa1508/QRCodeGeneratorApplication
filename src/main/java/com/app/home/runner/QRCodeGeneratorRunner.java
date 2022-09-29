package com.app.home.runner;

import com.app.home.util.QRCodeGeneratorUtils;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class QRCodeGeneratorRunner implements CommandLineRunner {

private static final String QR_CODE_IMAGE_PATH = "./src/main/resources/QRCode_Image.png";
  
  @Override
  public void run(String... args) throws Exception {
    System.out.println("Hello From CommandLine Runner");
    QRCodeGeneratorUtils util = new QRCodeGeneratorUtils();
    util.generateQRCodeImage("Swatantra Namdeo Final", 300, 300, QR_CODE_IMAGE_PATH);
    System.out.println(util.getQRCodeByteArrary("Swatantra Namdeo Final", 300, 300));
  } 

}
