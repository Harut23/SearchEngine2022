package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

public class Parser{


    public static Set<String> getHTML(String Links) throws IOException { //html cody pahum a stringi mej

        // Set<String>allLinks = findLinks(Links);
        // HTML = null;
        Set<String>HTML = new HashSet<>();

        // for(String st:allLinks) {
        //Document document = Jsoup.connect(String.valueOf(Links)).get();
        Document document = Jsoup.connect(Links).get();

        //System.out.println(document.toString());
        HTML = Collections.singleton(document.toString());
        //}
        return  HTML;
    }











    /*public static Set<String> parse(String Links) throws IOException { //html cody pahum a stringi mej

        // Set<String>allLinks = findLinks(Links);
        // HTML = null;
        Set<String>HTML = new HashSet<>();

        // for(String st:allLinks) {
        Document document = Jsoup.connect(String.valueOf(Links)).get();
        //System.out.println(document.toString());
        HTML = Collections.singleton(document.toString());
        //}
        return  HTML;
    }
*/


        //Set<String> newList = parse(list);
/*Document document = Jsoup.parse(String.valueOf(newList));
    Element link = document.select("a").first();

        System.out.println("Text: " + ((Element) link).text());
     */




  /*Document document = Jsoup.parse(String.valueOf(newList));
    Element link = document.select("a").first();
    System.out.println("Text: " + link.text());
*/

        /*
public static void ParseTitlesAndLinks(String list) throws IOException {

    Document document = Jsoup.connect(String.valueOf("https://4pda.to/")).get();
    Elements titleElements = document.getElementsByAttributeValue("itemprop","url");
    titleElements.forEach(titleElement -> System.out.println(titleElement.attr("title")+"|" +titleElement.attr("href")));

    }*/



}

