package URLTagsCounter;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Scanner;

public class HTMLFetcher {

    public static String fetchHTMLFromURL(String url) throws MalformedURLException, IOException{

        String html = null;

        try (Scanner scanner = new Scanner(new URL(url).openConnection().getInputStream());){
            scanner.useDelimiter("\\Z"); // кінець потоку
            html = scanner.next();
        }
        return html;
    }
}
