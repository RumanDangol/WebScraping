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
public class KaymuScrapper extends Scrapper {

    @Override
    public void scrap() throws IOException {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Keywords:");
        String param =input.next();//gets what to post
        String link = "http://www.kaymu.com.np/catalog/?q=";

        Grabber grabber = new Grabber();
        
        String regEx = "<a(.*?) href=\"(.*?)data-track-name=\"(.*?)\"(.*?)data-track-price_local=\"(.*?)\"(.*?)</a>";

        String content = grabber.post(link,"q=".concat(param));
        
      
        Pattern pattern1 = Pattern.compile(regEx);
        Matcher matcher1 = pattern1.matcher(content);

        while (matcher1.find()) {
            System.out.println("Title:" + matcher1.group(3));
            System.out.println("Price:" + matcher1.group(5).trim());
            System.out.println("================================");
        }
    }

}


