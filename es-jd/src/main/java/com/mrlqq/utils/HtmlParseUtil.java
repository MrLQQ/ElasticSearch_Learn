package com.mrlqq.utils;

import com.mrlqq.pojo.Content;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/**
 * @Classname HtmlParseUtil
 * @Description TODO
 * @Date 2022/1/21 19:23
 * @Created by LQQ
 */

@Component
public class HtmlParseUtil {
    public static void main(String[] args) throws IOException {
      new HtmlParseUtil().parseJD("毛泽东").forEach(System.out::println);
    }
    public List<Content> parseJD(String keywords) throws IOException {
        String url = "https://search.jd.com/Search?keyword="+keywords;
        Document document = Jsoup.parse(new URL(url), 30000);
        Element element = document.getElementById("J_goodsList");
        Elements elements = element.getElementsByTag("li");

        ArrayList<Content> goodsList = new ArrayList<>();

        // 获取元素中的内容 这里的el，就是每个li标签了
        for (Element el : elements) {
            // 关于这种图片特别多的网站，所有的图片都是延迟加载的
            String img = el.getElementsByTag("img").eq(0).attr("data-lazy-img");
            String price = el.getElementsByClass("p-price").eq(0).text();
            String title = el.getElementsByClass("p-name").eq(0).text();

            Content content = new Content();
            content.setImg(img);
            content.setPrice(price);
            content.setTitle(title);
            goodsList.add(content);
        }
        return goodsList;

    }
}
