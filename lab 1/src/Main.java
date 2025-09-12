import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String[] wordsArray;

        while (true){

            System.out.println("Введіть масив слів для обчислення через пробіл, вкінці тисніть enter:");

            String line = sc.nextLine();
            wordsArray = line.trim().split("\\s+");

            if (wordsArray[0] == ""){
                System.out.println("Введи хоч якісь слова cuh!\n");
                continue;
            }
            sc.close();

            int avgNumOfChars = calculateAverageNumOfLetters(wordsArray);
            calculateAndPrintResult(wordsArray, avgNumOfChars);

            System.exit(0);
        }

    }

    static int calculateAverageNumOfLetters(String[] strings) {
        int numberOfWords = strings.length;
        int numberOfChars = 0;

        for (String string:strings){
            numberOfChars += string.length();
        }
        return numberOfChars / numberOfWords;
    }

    static void calculateAndPrintResult(String[] words, int avgNumOfChars){

        System.out.println("\u001B[33m" + "\nСередня довжина слова в масиві: " + avgNumOfChars + "\u001B[0m");
        System.out.println("\u001B[32m" + "\nСлова, довше за середню довжину:");
        for (String word:words){
            if(word.length() > avgNumOfChars){
                System.out.println(word);
            }
        }

        System.out.println("\u001B[34m" + "\nСлова, коротше за середню довжину:");
        for (String word:words){
            if(word.length() < avgNumOfChars){
                System.out.println(word);
            }
        }
        System.out.println("\u001B[0m");
    }
}