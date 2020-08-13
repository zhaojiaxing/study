package com.zjx.csdn;

import org.apache.http.client.methods.HttpGet;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhaojiaxing
 * @version 1.0
 * @Date 2020/01/20 13:46
 */
public class Test {
    public static void main(String[] args) throws IOException {

        for (int number = 0; number < 100; number++) {
            //i为文章总页数-1
            for (int i = 0; i <= 1; i++) {
                int page = i + 1;
                String name = "weixin_44397777";
                String url = "https://blog.csdn.net/" + name + "/article/list/" + page;
                System.out.println(url);
                try {
                    // 添加时间间隔 3s  解决 403问题。
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("睡眠结束，爬取第" + page + "页");
                //创建httpget实例
                HttpGet httpGet = new HttpGet(url);
                httpGet.addHeader(":authority", "https://blog.csdn.net");
                httpGet.addHeader("user-agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36");
                Document doc = Jsoup.connect(url)
                        .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.6 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36").get();
                Elements listDiv = doc.getElementsByAttributeValue("class", "article-item-box csdn-tracking-statistics");
                System.out.println(listDiv.size());
                List temp = new ArrayList();
                listDiv.get(1);

                for (int num = 1; num < listDiv.size(); num++) {
                    Element text = listDiv.get(num);
                    System.out.println(num);
                    Elements a = text.getElementsByTag("a");
                    String href = a.get(0).attr("href");
                    Document d = Jsoup.connect(href)
                            .userAgent("Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.6 (KHTML, like Gecko) Chrome/75.0.3770.90 Safari/537.36").get();
                }
            }
        }
    }
}

