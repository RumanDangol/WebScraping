/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.WebScrapping;

import com.leapfrog.WebScrapping.Scrapper.KaymuScrapper;
import com.leapfrog.WebScrapping.Scrapper.Scrapper;

import java.io.IOException;




/**
 *
 * @author ruman dangol
 */
public class Program {

        
    
    public static void main(String[] args) {
       
        Scrapper scrapper=new KaymuScrapper();
        try{
            scrapper.scrap();
        }catch(IOException ioe){
            
        }
    }
    
}
