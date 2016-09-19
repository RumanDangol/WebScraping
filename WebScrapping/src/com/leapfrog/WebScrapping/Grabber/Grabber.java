/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapping.Grabber;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;

/**
 *
 * @author ruman dangol
 */
public class Grabber {
    public String get(String link) throws IOException{
            URL url = new URL(link);//gives link to url
        URLConnection conn = url.openConnection();//connects url
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
        //reads the content
        String line = "";
        StringBuilder content = new StringBuilder();

        while ((line = reader.readLine()) != null) {

            content.append(line).append("\n");

        }
        reader.close();
        return content.toString();
    }
        public String post(String link,String param) throws IOException{
            URL url = new URL(link);
            HttpURLConnection conn =(HttpURLConnection)url.openConnection();
            //http is used for posting
            conn.setDoOutput(true);//for posting to search
            OutputStream os = conn.getOutputStream();//for writing
        
            os.write(param.getBytes());//post the param
       
            
            
        BufferedReader reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));

        String line = "";
        StringBuilder content = new StringBuilder();
            

        while ((line = reader.readLine()) != null) {

            content.append(line).append("\n");

        }
        reader.close();
        return content.toString();
    }
    
}
