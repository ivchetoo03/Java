import java.util.Scanner;

import MVCShapes.MainShapes;
import WordCounter.WordCounter;
import SymbolsEncryptor.EncryptorMain;
import URLTagsCounter.TagsCounterMain;

public class Main {
    private static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {

        int choice;
        while(true){
            
            System.out.println("\n\t--- MAIN MENU ---");
            System.out.println("Виберіть програму: ");
            System.out.println("1. Рядок, де найбільше слів");
            System.out.println("2. MVC Shapes");
            System.out.println("3. Шифрування символів");
            System.out.println("4. Підрахування тегів на сторінці");
            System.out.println("0. Вихід");
            System.out.print(" - ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                    WordCounter.initializeWordsCounting(sc);
                    break;
                case 2: 
                    MainShapes.initializeShapesProgram(sc);
                    break;
                case 3:
                    EncryptorMain.initializeEncryptor(sc);
                    break;
                case 4:
                    TagsCounterMain.initializeTagsCounter(sc);
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