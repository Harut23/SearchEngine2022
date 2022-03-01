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
//        parseText();
    }

    private void parseLinks() {
        Elements urls = document.select("a[href]");
        for (Element link : urls) {
            String current = link.attr("abs:href");
            links.add(current);
        }
    }

    public String getHtml() {
        return html;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    private void parseText() {

        Element element = document.select("a").first();

        if (element != null) {
            html = element.text();
        }
    }
}

