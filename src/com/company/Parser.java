package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    String html;
    ArrayList<String> links;
    Document document;

    public Parser(String url) throws IOException {
        this.document = Jsoup.connect(url).get();
        links = new ArrayList<>();
    }

    public void parse() throws IOException { //html cody pahum a stringi mej
        parseLinks();
        parseText();
    }

    public void parseLinks() {
        Elements urls = document.select("a[href]");
        for (Element link : urls) {
            String current = link.attr("abs:href");
            links.add(current);
        }
    }

//    public void parseText() {
//
//        Element element = document.select("a").first();
//
//        if (element != null) {
//            html = element.text();
//        }
//    }

    public String getHtml() {
        return html;
    }

    public ArrayList<String> getLinks() {
        return links;
    }
/*public static Set<String> fff(String Links) throws IOException { //html cody pahum a stringi mej

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


}

