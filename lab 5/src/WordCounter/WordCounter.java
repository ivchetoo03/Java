package WordCounter;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Scanner;

public class WordCounter {

    public static void initializeWordsCounting(Scanner sc){

        System.out.println("\n\t--- Word Counter ---");
        System.out.print("Введіть шлях до файлу: ");
        String filePath = sc.nextLine();

        try(BufferedReader reader = new BufferedReader(new FileReader(filePath))){

            String biggestLine = "";
            
            String line = reader.readLine();
            while(line != null){
                if(Arrays.asList(line.split(" ")).size() > Arrays.asList(biggestLine.split(" ")).size()){
                    biggestLine = line;
                }
                line = reader.readLine();
            }

            System.out.println("\nРядок з найбільшою кількістю слів:\n" + biggestLine);

        } catch (FileNotFoundException e) {
            System.out.println("\nФайл '" + filePath + "' не знайдений або не був створений :<\n");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}