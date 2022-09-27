package com.learn.rpcdemo.utils;

import org.apache.http.HttpEntity;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;

import java.io.*;

/**
 * <p>
 * HttpUtils
 * </p>
 *
 * @author Yuhaoran
 * @since 2022/9/2
 */
public class HttpUtils {

    public static String getRequest(String uri) throws IOException {
        CloseableHttpClient httpClient = HttpClientBuilder.create().build();
        HttpGet httpGet = new HttpGet(uri);
        CloseableHttpResponse execute = httpClient.execute(httpGet);
        if (execute.getStatusLine().getStatusCode() == 200){
            HttpEntity entity = execute.getEntity();
            InputStream content = entity.getContent();
            byte[]  bytes= new byte[1024];
            ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
            int count = 0;
            while ((count = content.read(bytes))!=-1){
                outputStream.write(bytes,0,count);
            }
            return outputStream.toString();
        }else {
            return null;
        }
    }

    public static String convertParams(String uri,Object ... params){
        StringBuilder builder = new StringBuilder();
        builder.append(uri).append("?");
        for (int i = 0; i < params.length; i++) {
            builder.append(params[i]);
            if (i!= params.length-1){
                builder.append("&");
            }
        }
        return builder.toString();
    }
}
