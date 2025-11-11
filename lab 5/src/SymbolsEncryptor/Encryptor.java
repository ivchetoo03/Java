package SymbolsEncryptor;

import java.io.IOException;
import java.util.Scanner;

public class Encryptor{

    static IOHandler handler = new IOHandler('a');

    public static void inputEncryptParams(Scanner sc){

        System.out.print("\nВведіть символи на зашифрування: ");
        String symbolsString = sc.nextLine();

        System.out.print("\nВведіть шлях до вихідного файлу: ");
        String pathToFile = sc.nextLine();
        
        try{
            handler.encryptSymbols(symbolsString, pathToFile);
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }

        System.out.println("Символи були успішно зашифровані у файл '" + pathToFile + "' !");
    }

    public static void inputDecryptParams(Scanner sc){        

        String decryptedCharacters;

        System.out.print("\nВведіть шлях до файлу: ");
        String pathToFile = sc.nextLine();
        
        try{
            decryptedCharacters = handler.decryptSymbols(pathToFile);
        }
        catch (IOException e) {
            e.printStackTrace();
            return;
        }
        System.out.println("Символи були успішно розшифорвані!\nРезультат: " + decryptedCharacters);
    }
}
