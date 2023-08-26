package org.example;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class HttpStatusChecker {
    private static final String BASE_URL = "https://http.cat/";
    public String getStatusImage(int code) {
        OkHttpClient client = new OkHttpClient();
        String url = BASE_URL + code + ".jpg";
        Request request = new Request.Builder()
                .url(url)
                .build();
        try {
            Response response = client.newCall(request).execute();
            if (!response.isSuccessful()) {
                throw new Exception("HTTP request failed with code: " + response.code());
            }
            return url;
        } catch (Exception e) {
            System.err.println("Помилка: " + e.getMessage());
            return null;
        }
    }
}

