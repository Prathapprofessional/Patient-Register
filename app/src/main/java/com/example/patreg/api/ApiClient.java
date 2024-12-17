package com.example.patreg.api;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import java.io.IOException;

public class ApiClient {

    private static final String BASE_URL = "https://api.mockapi.com/api/prat"; // Your API URL
    private static final String API_KEY = "2b068516f55046dba83125e9bd4fa07b"; // Replace with actual API Key
    private static final OkHttpClient client = new OkHttpClient();

    // Method to send GET request
    public static String sendGetRequest() throws IOException {
        Request request = new Request.Builder()
                .url(BASE_URL)
                .header("x-api-key", API_KEY)
                .build();

        try (Response response = client.newCall(request).execute()) {
            if (response.isSuccessful()) {
                return response.body().string();
            } else {
                throw new IOException("Unexpected code " + response);
            }
        }
    }

}
