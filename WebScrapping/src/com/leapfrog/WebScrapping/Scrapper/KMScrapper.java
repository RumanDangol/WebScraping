/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapping.Scrapper;

import com.leapfrog.WebScrapping.Grabber.Grabber;
import java.io.IOException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author ruman dangol
 */
public class KMScrapper extends Scrapper {

    @Override
    public void scrap() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Keywords:");
        String param = input.next();//gets what to post
        String link = "http://kathmandumart.com/index.php?route=product/search";

        Grabber grabber = new Grabber();

        String titleregEx = "<h4><a href=\"(.*?)\">(.*?)</a></h4>";
        String priceregEx = "<p class=\"price\">\\n(.*?)</p>";
        String content = grabber.post(link, "route=product/search&search=".concat(param));
        Pattern pattern1 = Pattern.compile(titleregEx);
        Matcher matcher1 = pattern1.matcher(content);

        Pattern pattern2 = Pattern.compile(priceregEx);
        Matcher matcher2 = pattern2.matcher(content);

        while (matcher1.find() && matcher2.find()) {
            System.out.println("Title:" + matcher1.group(2));
            System.out.println("Price:" + matcher2.group(1).trim());
            System.out.println("================================");
        }
    }

}
