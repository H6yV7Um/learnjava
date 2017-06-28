package com.net;

import org.apache.http.HttpEntity;
import org.apache.http.HttpRequest;
import org.apache.http.NameValuePair;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.entity.ContentType;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by dongchunxu on 2017/6/27.
 */
public class Main {

    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(13000)
            .setConnectTimeout(13000)
            .setConnectionRequestTimeout(15000)
            .build();

    private static AtomicLong successCounter = new AtomicLong(0);
    private static AtomicLong failedCounter = new AtomicLong(0);


    public static void main(String[] args) throws InterruptedException {
//        String result = new Main().sendHttpGet("http://47.90.63.0:81");
//        System.out.println(result);

        ExecutorService es = Executors.newCachedThreadPool();
        for (int i = 0; i < 30; i++) {
            es.execute(new Main.MyRunnable());
        }

        try {
            TimeUnit.SECONDS.sleep(8);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("success:" + successCounter.get());
        System.out.println("failed:" + failedCounter.get());
    }

    static class MyRunnable implements Runnable {

        public void run() {
            Map<String, String> maps = new HashMap<String, String>();
            maps.put("type", "all");
            maps.put("currentPage", "2");
            maps.put("totalCount", "28916");
            maps.put("placeId", "175649");
            maps.put("placeIdType", "PLACE");
            maps.put("isPOI", "Y");
            maps.put("isELong", "N");
            maps.put("isPicture", "");
            maps.put("isBest", "");
            String result =
//                    //sendHttpPost("http://www.lvmama.com", maps);
                    sendHttpPost("http://ticket.lvmama.com/vst_front/comment/newPaginationOfComments", maps);
                   // sendHttpPost("http://ticket.lvmama.com/scenic_front/scenic/asynLoadingComment.do", maps);


//           result = sendHttpGet("http://47.90.63.0:81/");
//            String result = sendHttpGet("http://www.lvmama.com");
            System.out.println(result + "--------------------------------");
        }
    }


    /**
     * 发送 post请求
     * @param httpUrl 地址
     * @param maps 参数
     */
    public static String sendHttpPost(String httpUrl, Map<String, String> maps) {
        HttpPost httpPost = new HttpPost(httpUrl);// 创建httpPost
        // 创建参数队列
        List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>();
        for (String key : maps.keySet()) {
            nameValuePairs.add(new BasicNameValuePair(key, maps.get(key)));
        }
        try {
            httpPost.setEntity(new UrlEncodedFormEntity(nameValuePairs, "UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sendHttpPost(httpPost);
    }



    public static  String sendHttpGet(String httpUrl) {
        HttpGet httpGet = new HttpGet(httpUrl);// 创建get请求
        return sendHttpGet(httpGet);
    }

    private static String sendHttpGet(HttpGet httpGet) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpGet.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpGet);

            if (response.getStatusLine().getStatusCode() == 200) {
                successCounter.getAndAdd(1);
            } else {
                failedCounter.getAndAdd(1);
            }
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }

    /**
     * 发送Post请求
     * @param httpPost
     * @return
     */
    private static  String sendHttpPost(HttpPost httpPost) {
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        HttpEntity entity = null;
        String responseContent = null;
        try {
            // 创建默认的httpClient实例.
            httpClient = HttpClients.createDefault();
            httpPost.setConfig(requestConfig);
            // 执行请求
            response = httpClient.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == 200) {
                successCounter.getAndAdd(1);
            } else {
                failedCounter.getAndAdd(1);
            }
            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
            failedCounter.getAndAdd(1);
        } finally {
            try {
                // 关闭连接,释放资源
                if (response != null) {
                    response.close();
                }
                if (httpClient != null) {
                    httpClient.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return responseContent;
    }
}
