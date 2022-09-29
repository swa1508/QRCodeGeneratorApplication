package com.app.home.util;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

public class QRCodeGeneratorUtils {


  public void generateQRCodeImage(String qrCodeContent,Integer width, Integer height,String filePath) {
    try {
      QRCodeWriter qrCodeWriter = new QRCodeWriter();
      BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, width, height);
      Path path = FileSystems.getDefault().getPath(filePath);
      MatrixToImageWriter.writeToPath(bitMatrix, "PNG", path);
    } catch (WriterException | IOException e) {
      e.printStackTrace();
    }
  }

  public byte[] getQRCodeByteArrary(String qrCodeContent,int width, int height) {
    try {
      QRCodeWriter qrCodeWriter = new QRCodeWriter();
      BitMatrix bitMatrix = qrCodeWriter.encode(qrCodeContent, BarcodeFormat.QR_CODE, width, height);
      ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
      MatrixToImageWriter.writeToStream(bitMatrix, "PNG", outputStream);
      return outputStream.toByteArray();
    } catch (WriterException | IOException e) {
      e.printStackTrace();
    }
    return new byte[] {};
  }
  
}
