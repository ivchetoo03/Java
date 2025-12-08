import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        // cat elephant sky innovation tree jump synchronize book universe fly algorithm dream code imagination river strength whisper galaxy

        String[] wordsArray;
        byte choiceNum;
        try(Scanner sc = new Scanner(System.in)){

            while (true) {
                System.out.println("Введіть масив слів для обчислення через пробіл, вкінці тисніть enter:");

                String line = sc.nextLine();
                wordsArray = line.trim().split("\\s+");

                if (wordsArray.length == 0 || wordsArray[0].isEmpty()) {
                    System.out.println("Введи хоч якісь слова cuh!\n");
                    continue;
                }
                break;
            }

            System.out.print("\nЯкий масив слів повернути? \n1. Більше за середню кількість літер\n2. Менше за середню кількість літер\n |\n\\|/\n ");
            String input = sc.nextLine();
            choiceNum = Byte.parseByte(input);
        }

        int avgNumOfChars = calculateAverageNumOfLetters(wordsArray);
        System.out.println("\u001B[33m" + "\nСередня довжина слова в масиві: " + avgNumOfChars + "\u001B[0m");

        List<String> resultArray = calculateResult(wordsArray, avgNumOfChars, choiceNum);

        printResult(resultArray, choiceNum);
    }

    static int calculateAverageNumOfLetters(String[] strings) {
        return (int) Arrays.stream(strings)
                .mapToInt(String::length)
                .average()
                .orElse(0);
    }

    static List<String> calculateResult(String[] words, int avgNumOfChars, byte choiceNum) {
        return Arrays.stream(words)
                .filter(word -> {
                    if (choiceNum == 1) {
                        return word.length() > avgNumOfChars;
                    } else {
                        return word.length() < avgNumOfChars;
                    }
                })
                .collect(Collectors.toList());
    }

    static void printResult(List<String> resultArray, byte choiceNum) {
        if (choiceNum == 1) {
            System.out.println("\u001B[32m" + "\nСлова, довше за середню довжину:");
        } else {
            System.out.println("\u001B[34m" + "\nСлова, коротше за середню довжину:");
        }

        resultArray.forEach(System.out::println);
        
        System.out.println("\u001B[0m");
    }
}