package com.company;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

public class Crawler11 extends Parser{

    private static final int Max_Depth = 2;

    private HashSet<String> links;

    public Crawler11(){
        links = new HashSet<>();
    }

    //we get all URLs from a web page
    public static Set<String> findLinks(String url) throws IOException {

        Set<String> links = new HashSet<>();

        Document doc = Jsoup.connect(url)
                .data("query", "Java")
                .userAgent("Mozilla")
                .cookie("auth","token")
                .timeout(2000)
                . get();

        Elements elements = doc.select("a[href]");
        for (Element element : elements) {
            links.add(element.attr("href"));
        }

        return links;


        // Set<String>set=parse(links.toString());

        //System.out.println(set);


    /*Set<String> result = parse(links.toString());
        Document docc = Jsoup.parse(String.valueOf(result));
        Elements paragraphs = docc.select("p");
        for(Element paragraph : paragraphs) {
            System.out.println(paragraph.text());
        }*/
    }
}






/*public void getPageLinks(String URL, int Depth) {                  //URL i meji sax linkery talis a
//    HashSet<String> LinksOfUrl=new HashSet<>() ;

       if ((!links.contains(URL) && (Depth < Max_Depth))) {
           System.out.println(">>Depth:: " + Depth +"["+ URL +"]");


           try {
               links.add(URL);

               Document document = Jsoup.connect(URL).get();
               Elements linksOnPage = document.select("a[href]");

               Depth++;
               for (Element page : linksOnPage) {
                   getPageLinks(page.attr("abs:href"), Depth);
               }
           } catch (IOException e) {
               System.err.println("For '" + URL + "': " + e.getMessage());
           }


       }


}

*/



