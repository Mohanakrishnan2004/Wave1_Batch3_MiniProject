package com.asset.service;

import java.nio.file.*;
import com.google.zxing.*;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;

public class QRCodeGenerator {

    public static void generateQRCode(String data, String fileName) throws Exception {

        BitMatrix matrix = new MultiFormatWriter()
                .encode(data, BarcodeFormat.QR_CODE, 300, 300);

        Path path = FileSystems.getDefault().getPath(fileName);

        MatrixToImageWriter.writeToPath(matrix, "PNG", path);

        System.out.println("QR Created: " + path.toAbsolutePath());
    }
}
