package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;

public class Parser {
    ArrayList<String> textContent;
    ArrayList<String> links;
    Document document;

    public Parser(String url) throws IOException {
        this.document = Jsoup.connect(url).get();
        links = new ArrayList<>();
        textContent = new ArrayList<>();
    }

    public void parse() throws IOException {
        parseLinks();
        parseText();
    }

    private void parseLinks() {
        Elements urls = document.select("a[href]");
        for (Element link : urls) {
            String current = link.attr("abs:href");
            links.add(current);
        }
    }

    public ArrayList<String> getTextContent() {
        return textContent;
    }

    public ArrayList<String> getLinks() {
        return links;
    }

    private void parseText() {
        Elements elements = document.select("a");
        for (Element element : elements)
            if (element != null) {
                textContent.add(element.text());
            }
    }
}

