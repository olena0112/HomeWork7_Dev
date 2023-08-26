package org.example;

import java.util.Scanner;

public class HttpImageStatusCli {

    public void askStatus() {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.print("Enter HTTP status code (or 'q' to quit): ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("q")) {
                System.out.println("Goodbye!");
                break;
            }

            try {
                int statusCode = Integer.parseInt(input);

                HttpStatusImageDownloader downloader = new HttpStatusImageDownloader();
                try {
                    downloader.downloadStatusImage(statusCode);
                } catch (Exception e) {
                    System.err.println("Error: " + e.getMessage());
                }
            } catch (NumberFormatException e) {
                System.err.println("Please enter a valid number.");
            }
        }

        scanner.close();
    }
}

