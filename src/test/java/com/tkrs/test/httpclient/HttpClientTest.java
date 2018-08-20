package com.tkrs.test.httpclient;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName HttpClientTest
 * @Description TODO
 * @Author wangchenge
 * @Date 2018/8/18  12:58
 * @Version 1.0
 **/

public class HttpClientTest {

    @Test
    public void httpTest() throws Exception {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet("https://dl.reg.163.com/gt?un=wcg9301%40163.com&pkid=CvViHzl&pd=mail163&rtid=1kiKHEOT3oRBsc3kva5iQOq0KkTqbIND&topURL=https%3A%2F%2Fmail.163.com%2F&nocache=1534568610393");
        CloseableHttpResponse response1 = httpclient.execute(httpGet);
// The underlying HTTP connection is still held by the response object
// to allow the response content to be streamed directly from the network socket.
// In order to ensure correct deallocation of system resources
// the user MUST call CloseableHttpResponse#close() from a finally clause.
// Please note that if response content is not fully consumed the underlying
// connection cannot be safely re-used and will be shut down and discarded
// by the connection manager.
        try {
            System.out.println(response1.getStatusLine());
            HttpEntity entity1 = response1.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
//            EntityUtils.consume(entity1);
            String str = EntityUtils.toString(entity1);
            System.out.println(str);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                response1.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        /*HttpPost httpPost = new HttpPost("http://targethost/login");
        List<NameValuePair> nvps = new ArrayList<NameValuePair>();
        nvps.add(new BasicNameValuePair("username", "vip"));
        nvps.add(new BasicNameValuePair("password", "secret"));
        httpPost.setEntity(new UrlEncodedFormEntity(nvps));
        CloseableHttpResponse response2 = httpclient.execute(httpPost);
        try {
            System.out.println(response2.getStatusLine());
            HttpEntity entity2 = response2.getEntity();
            // do something useful with the response body
            // and ensure it is fully consumed
            EntityUtils.consume(entity2);
        } finally {
            response2.close();
        }*/
    }
}
