package org.test;

import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.X509Certificate;

import javax.net.ssl.*;

public class ServiceTest {

    private static final TrustManager[] MOCK_TRUST_MANAGER = new TrustManager[]{
            new X509TrustManager() {
                public X509Certificate[] getAcceptedIssuers() {

                    return new X509Certificate[0];
                }

                public void checkClientTrusted(X509Certificate[] certs, String authType) {

                }

                public void checkServerTrusted(X509Certificate[] certs, String authType) {

                }
            }
    };

    @Test
    public void testVersionAPI() {

        try {
            SSLContext sslContext = SSLContext.getInstance("TLS");
            sslContext.init(null, MOCK_TRUST_MANAGER, new SecureRandom());

            // Build HttpClient with the custom SSLContext
            HttpClient httpClient = HttpClient.newBuilder()
                    .sslContext(sslContext)
                    .build();
            // Build HTTP GET Request
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://localhost:9443/services/Version"))
                    .GET()
                    .build();

            // Send Request and get Response
            HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());

            // Assert the response status code
            Assert.assertEquals(200, response.statusCode());

        } catch (IOException | InterruptedException | NoSuchAlgorithmException | KeyManagementException e) {
            // Handle exceptions
            e.printStackTrace();
            Assert.fail("Exception occurred in version API test : " + e.getMessage());
        }
    }
}
