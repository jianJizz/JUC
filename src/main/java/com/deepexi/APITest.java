package com.deepexi;

import com.sun.org.apache.xerces.internal.impl.dv.util.Base64;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * @author jianjianDuan
 * @date 2022/2/23 10:46 AM
 */
public class APITest {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException, InvalidKeyException {
        String url = "http://10.201.0.165/deepexi-daas-data-service/openapi/ee5f9dfa3c0a4196ae877816f55de46f/test_3";
        String uri = "/deepexi-daas-data-service/openapi/ee5f9dfa3c0a4196ae877816f55de46f/test_3";
        String queryString = "";  //queryString为空
        String appSecret = "771a3a493faf4afcb5b820e956d14202";
        String token = "Ygg5NsDNqmkwzT0pGhlLwfYhnl39almqY7ZyfWIGSsPT8N5v25A61QXS3OZQANmXtJnVrFha7xqmeavognAiyDRd181CCYyFqiWNAOKv8OkAKsLeo/DXPmAhw1MgR0KguoUTQaSC9n3eK4iegQaQ8w==";
        // 拼接stringToSign
        String stringToSign = uri + '\n' + queryString;
        // 对stringToSign进行签名
        SecretKeySpec secretKeySpec = new SecretKeySpec(appSecret.getBytes(StandardCharsets.UTF_8), "HmacSHA1");
        Mac mac = Mac.getInstance("HmacSHA1");
        mac.init(secretKeySpec);
        byte[] rawHmac = mac.doFinal(stringToSign.getBytes());
        String sign = Base64.encode(rawHmac);
        System.out.println("sign: " + sign);
        // 包装请求
        CloseableHttpClient client = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        httpGet.addHeader("X-DP-TOKEN", token);
        httpGet.addHeader("X-DP-SIGN", sign);
        httpGet.addHeader("X-DP-VERSION-NUMBER", "1");
        // 执行请求
        CloseableHttpResponse httpResponse = null;
        try {
            httpResponse = client.execute(httpGet);
            String responese = EntityUtils.toString(httpResponse.getEntity());
            System.out.println(responese);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpResponse != null) {
                httpResponse.close();
            }
        }

    }
}
