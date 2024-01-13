package com.assistai.backend;

import java.io.IOException;
import java.net.URLEncoder;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import com.assistai.backend.core.*;
public class SimpleHttpRequest {

    final static String apiUrl = "https://detect.roboflow.com/bus-number-detection-0fiy2/1";
    final static String apiKey = "D9haFqLfycHCrtNgVZE8";

    public static String sendPostRequest(String image) throws IOException {
        String url = createUrl(image);

        try (CloseableHttpClient httpClient = HttpClients.createDefault()) {
            HttpPost httpPost = new HttpPost(url);

            httpPost.setHeader("Content-Type", "application/x-www-form-urlencoded");

            try (CloseableHttpResponse response = httpClient.execute(httpPost)) {
                int statusCode = response.getStatusLine().getStatusCode();
                HttpEntity entity = response.getEntity();
                String responseBody = entity != null ? EntityUtils.toString(entity) : "";

                return responseBody;
            }
        }
    }

    public static String createUrl(String image) throws IOException {
        StringBuilder url = new StringBuilder();
        url.append(apiUrl);
        url.append("?api_key=");
        url.append(apiKey);
        url.append("&image=");
        url.append(URLEncoder.encode(image, "UTF-8"));

        return url.toString();
    }
}
