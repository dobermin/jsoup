package ru.mail.dobermin;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

public class Jsoup {

    private static Document document;

    public static Element getFromUri(String uri) {
        try {
            document = org.jsoup.Jsoup.connect(uri)
                    .userAgent("Mozilla")
                    .timeout(5000)
                    .referrer("https://google.com")
                    .get();
        } catch (Exception e) {
            return null;
        }
        return document.body();
    }

    public static Element getFromFile(String fileName) {
        File file = new File(fileName);

        try {
            return org.jsoup.Jsoup.parse(file, "windows-1251", "https://example.com/");

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Document getDocument() {
        return document;
    }
}
