package org.example;

import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        HttpStatusChecker checker = new HttpStatusChecker();

        try {
            String imageUrl = checker.getStatusImage(102);
            if (imageUrl != null) {
                System.out.println("Посилання на зображення: " + imageUrl);
            }
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }

        HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
        try {
            downloader.downloadStatusImage(102);
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
        }
        HttpImageStatusCli cli = new HttpImageStatusCli();
        cli.askStatus();

    }
}