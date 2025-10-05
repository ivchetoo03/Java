import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // cat elephant sky innovation tree jump synchronize book universe fly algorithm dream code imagination river strength whisper galaxy
        Scanner sc = new Scanner(System.in);
        String[] wordsArray;
        byte choiceNum;

        while (true) {

            System.out.println("Введіть масив слів для обчислення через пробіл, вкінці тисніть enter:");

            String line = sc.nextLine();
            wordsArray = line.trim().split("\\s+");

            if (wordsArray[0].isEmpty()) {
                System.out.println("Введи хоч якісь слова cuh!\n");
                continue;
            }
            break;
        }
        while (true) {
            System.out.println("Який масив слів повернути? (Введіть 1 чи 2)\n1. Більше за середню кількість літер\n2. Менше за середню кількість літер\n\\|/");
            choiceNum = sc.nextByte();
            if(choiceNum != 1 && choiceNum != 2){
                System.out.println("\nПотрібно ввести 1 чи 2 :є\n");
                continue;
            }
            break;
        }

        sc.close();

        int avgNumOfChars = calculateAverageNumOfLetters(wordsArray);
        System.out.println("\u001B[33m" + "\nСередня довжина слова в масиві: " + avgNumOfChars + "\u001B[0m");

        ArrayList<String> resultArray = calculateResult(wordsArray, avgNumOfChars, choiceNum);
        printResult(resultArray, choiceNum);
        System.exit(0);
    }

    static int calculateAverageNumOfLetters(String[] strings) {
        int numberOfWords = strings.length;
        int numberOfChars = 0;

        for (String string:strings){
            numberOfChars += string.length();
        }
        return numberOfChars / numberOfWords;
    }

    static ArrayList<String> calculateResult(String[] words, int avgNumOfChars, byte choiceNum){

        ArrayList<String> MoreThanAvgWords = new ArrayList<>();
        ArrayList<String> LessThanAvgWords = new ArrayList<>();

        for (String word:words){
            if(word.length() > avgNumOfChars){
                MoreThanAvgWords.add(word);
            }
            else if(word.length() < avgNumOfChars){
                LessThanAvgWords.add(word);
            }
        }
        if (choiceNum == 1){
            return MoreThanAvgWords;
        }
        else {
            return LessThanAvgWords;
        }
    }

    static void printResult(ArrayList<String> resultArray, byte choiceNum) {
        if(choiceNum == 1){
            System.out.println("\u001B[32m" + "\nСлова, довше за середню довжину:");
            for (String word:resultArray){
                System.out.println(word);
            }
        }
        else{
            System.out.println("\u001B[34m" + "\nСлова, коротше за середню довжину:");
            for (String word:resultArray){
                System.out.println(word);
            }
        }
        System.out.println("\u001B[0m");
    }
}