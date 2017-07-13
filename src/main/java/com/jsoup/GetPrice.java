package com.jsoup;

import org.apache.http.HttpEntity;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by dongchunxu on 2017/7/13.
 */
public class GetPrice {
    private static RequestConfig requestConfig = RequestConfig.custom()
            .setSocketTimeout(13000)
            .setConnectTimeout(13000)
            .setConnectionRequestTimeout(15000)
            .build();


    public static void main(String[] args) {
        String url = "http://www.lvmama.com/tuangou/deal-1506948?losc=119606&ict=i";
        String html = sendHttpGet(url);
        Document document = Jsoup.parse(html);
        Elements select = document.select(".nchline-count-down-explain b:last-child");
        if (select != null && select.size() > 0) {
            Element element = select.get(0);
            System.out.println(element.text());
        }
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

            entity = response.getEntity();
            responseContent = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
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
