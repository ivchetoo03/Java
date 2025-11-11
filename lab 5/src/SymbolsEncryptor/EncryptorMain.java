package SymbolsEncryptor;

import java.util.Scanner;

public class EncryptorMain {
    public static void initializeEncryptor(Scanner sc) {

        int choice;
        while(true){
            
            System.out.println("\n\t--- Encryptor ---");
            System.out.println("Виберіть дію: ");
            System.out.println("1. Зашифрувати символи в файл");
            System.out.println("2. Розшифрувати символи з файлу");
            System.out.println("0. Вихід");
            System.out.print(" - ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice){
                case 1:
                Encryptor.inputEncryptParams(sc);
                    break;
                case 2: 
                Encryptor.inputDecryptParams(sc);
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
