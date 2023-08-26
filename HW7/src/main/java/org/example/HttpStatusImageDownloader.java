package org.example;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;


public class HttpStatusImageDownloader {
        public void downloadStatusImage(int code) throws IOException, Exception {
            HttpStatusChecker checker = new HttpStatusChecker();
            String imageUrl = checker.getStatusImage(code);

            if (imageUrl != null) {
                String[] parts = imageUrl.split("/");
                String fileName = parts[parts.length - 1];

                OkHttpClient client = new OkHttpClient();
                Request request = new Request.Builder().url(imageUrl).build();

                try (Response response = client.newCall(request).execute()) {
                    if (!response.isSuccessful()) {
                        throw new Exception("HTTP request failed with code: " + response.code());
                    }
                    try (InputStream is = response.body().byteStream();
                         FileOutputStream fos = new FileOutputStream(fileName)) {
                        byte[] buffer = new byte[8192];
                        int bytesRead;
                        while ((bytesRead = is.read(buffer)) != -1) {
                            fos.write(buffer, 0, bytesRead);
                        }
                    }

                    System.out.println("Зображення для статусу " + code + " було завантажено як " + fileName);
                }
            } else {
                throw new Exception("Для статусу " + code + " картинки не існує.");
            }
        }
}


