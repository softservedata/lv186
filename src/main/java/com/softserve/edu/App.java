package com.softserve.edu;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * Hello world!
 */
public class App {
    public final static String AUTHORIZATION_TOKEN = "d6roho235i79qlphwk8iqmm2giftbt32";

    public String getJson() throws IOException {
        String postal = "http://localhost/magento2/index.php/rest/V1/customers/search/";
        String resultString;
        URL url = new URL(postal);
        URLConnection connection = url.openConnection();
        HttpURLConnection httpConnection = (HttpURLConnection) connection;
        httpConnection.setRequestMethod("GET");
        httpConnection.setRequestProperty("Authorization", "Bearer " + AUTHORIZATION_TOKEN);
        connection.setReadTimeout(15000);
        httpConnection.setDoOutput(true);
        httpConnection.setDoInput(true);
        httpConnection.connect();
        int responseCode = httpConnection.getResponseCode();
        if (responseCode == HttpURLConnection.HTTP_OK) {
            InputStream in = httpConnection.getInputStream();
            InputStreamReader isr = new InputStreamReader(in, "UTF-8");
            StringBuffer data = new StringBuffer();
            int c;
            while ((c = isr.read()) != -1) {
                data.append((char) c);
            }
            resultString = new String(data.toString());
        } else {
            resultString = "Server does not respond";
        }
        httpConnection.disconnect();
        return resultString;
    }

    public static void main(String[] args) {
        App appl = new App();
        try {
            String json = appl.getJson();
            System.out.println(json);
            GsonBuilder builder = new GsonBuilder();
            Gson gson = builder.create();
            CustomerUser customerUser = gson.fromJson(json, CustomerUser.class);
            System.out.println(customerUser.toString());
        } catch (MalformedURLException ex) {
            System.out.println("\nMalformedURLException:" + ex.getMessage());
        } catch (IOException ex) {
            System.out.println("\nIOException:" + ex.getMessage());
        }
        System.out.println("\nThe End");
    }
}
    

