import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)){
            
            WordDictionary dict = new WordDictionary();

            String pathToFile = "words.txt";
            String content = null;
            content = Files.readString(Paths.get(pathToFile));
            dict.addWordList(content);
    
            int choice;
            while(true){
                
                System.out.println("\n\t--- ПЕРЕКЛАДАЧ ---");
                System.out.println("Виберіть дію: ");
                System.out.println("1. Перекласти введене слово");
                System.out.println("2. Додати слово та переклад");
                System.out.println("3. Додати список слів та перекладів");
                System.out.println("4. Видалити слово та переклад");
                System.out.println("5. Видалити список слів та перекладів");
                System.out.println("6. Вивести вміст словника");
                System.out.println("0. Вихід");
                System.out.print(" - ");
                choice = sc.nextInt();
                sc.nextLine();
    
                switch (choice){
                    case 1:
                        translateWord(dict, sc);
                        break;
                    case 2: 
                        addToDict(dict, sc);
                        break;
                    case 3:
                        addToDictList(dict, sc);
                        break;
                    case 4:
                        removeFromDict(dict, sc);
                        break;
                    case 5:
                        removeFromDictList(dict, sc);
                        break;
                    case 6:
                        dict.list();
                        break;                    
                    case 0:
                        return;
                    default:
                        System.out.println("Такої опції не представлено, спробуйте ще раз");
                        break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void translateWord(WordDictionary dict, Scanner sc){
        System.out.print("\nВведіть слово для перекладу - ");
        String word = sc.nextLine();
        dict.translate(word);
    }

    private static void addToDict(WordDictionary dict, Scanner sc){
        System.out.print("\nВведіть запис у формі 'оригінал - переклад'\n");
        String entry = sc.nextLine();
        dict.addWord(entry);
        System.out.print("\nЗапис успішно додано!\n");
    }

    private static void addToDictList(WordDictionary dict, Scanner sc){
        System.out.print("\nВведіть записи у формі 'оригінал - переклад'\nКожен запис має починатись з нового рядка\nЩоб завершити ввід, введіть символ 0 та натисніть Enter\n");
        sc.useDelimiter("0");
        String entry = sc.next();
        sc.useDelimiter("\\p{javaWhitespace}+");
        if (sc.hasNextLine()) {
            sc.nextLine();
        }
        dict.addWordList(entry);
        System.out.print("\nЗаписи успішно додано!\n");
    }

    private static void removeFromDict(WordDictionary dict, Scanner sc){
        System.out.print("\nВведіть оригінал слова для видалення запису про нього\n - ");
        String entry = sc.nextLine();
        if(dict.removeWord(entry) != null){
            System.out.print("\nЗапис успішно видалено!\n");
        }
        else{
            System.out.println("\nЦього запису в словнику вже не існує");
        }
    }

    private static void removeFromDictList(WordDictionary dict, Scanner sc){
        System.out.print("\nВведіть оригінали слів через пробіл для видалення записів про них\n - ");
        String entry = sc.nextLine();
        dict.removeWordList(entry);
        System.out.println("\nЗаписи успішно видалено!\n");
    }
}
