package com.zjx.util;

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import static com.sun.org.apache.xml.internal.serialize.OutputFormat.Defaults.Encoding;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2019/05/28 15:07
 */
public class HttpUtil2 {

    public static String doPostBodyData(String url, String bodyData) throws Exception {
        String result = "";
        CloseableHttpClient httpClient = null;
        CloseableHttpResponse response = null;
        try {
            // 获取默认的请求客户端
            httpClient = HttpClients.createDefault();
            // 通过HttpPost来发送post请求
            HttpPost httpPost = new HttpPost(url);
            httpPost.setEntity(new StringEntity(bodyData, Encoding));
            // 得到返回的response.
            response = httpClient.execute(httpPost);
            HttpEntity entity = response.getEntity();
            result = EntityUtils.toString(entity, "UTF-8");
        } catch (Exception e) {
            throw e;
        } finally {
            // 关闭httpClient
            if (null != httpClient) {
                httpClient.close();
            }
            // 关闭response
            if (null != response) {
                EntityUtils.consume(response.getEntity()); // 会自动释放连接
                response.close();
            }
        }
        return result;
    }


}
