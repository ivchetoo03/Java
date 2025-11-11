package URLTagsCounter;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.Map;
import java.util.Scanner;

public class TagsCounterMain {

    public static void initializeTagsCounter(Scanner sc){

        System.out.println("\n\t--- URL Tag Counter ---");
        System.out.print("Введіть URL сторінки для підрахунку тегів: ");
        // https://docs.oracle.com/javase/8/docs/api/java/io/package-tree.html
        String url = sc.next();

        String html = null;
        try {
            html = HTMLFetcher.fetchHTMLFromURL(url);
        } catch (MalformedURLException e) {
            System.out.println("Не вдалося знайти сторінку по цій URL: " + url);
            return;
        } catch (IOException e) {
            e.printStackTrace();
            return;
        }

        try(BufferedWriter writer = new BufferedWriter(new FileWriter("html.txt"))){
            writer.write(html);
        } catch (IOException e) {
            e.printStackTrace();
        }

        Map<String, Integer> tags = TagsCounter.countTags(html);
        System.out.println("\nТеги підраховано!");

        int choice;
        while(true){
            
            System.out.println("Вивести і сортувати теги: ");
            System.out.println("1. Зростаючий алфавітний порядок");
            System.out.println("2. Зростання кількості");
            System.out.println("0. Вихід");
            System.out.print(" - ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    TagsCounter.printTagsAlphabetical(tags);
                    break;
                case 2: 
                    TagsCounter.printTagsByCount(tags);
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Такої опції не представлено, спробуйте ще раз");
                    break;
            }
        }


    }
   
}
