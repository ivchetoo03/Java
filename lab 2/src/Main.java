import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        ArrayList<Record> records = new ArrayList<>();
        
        while (true) {
            System.out.println("\n--------- МЕНЮ ---------");
            System.out.println("1. Додати запис");
            System.out.println("2. Переглянути записи");
            System.out.println("3. Вихід");
            System.out.print("Ваш вибір: ");
            
            String choice = scanner.nextLine();
            
            switch (choice) {
                case "1":
                    addRecord(records);
                    break;
                case "2":
                    showRecords(records);
                    break;
                case "3":
                    scanner.close();
                    return;
                default:
                    System.out.println("\nНекоректний вибір");
            }
        }
    }

    public static void addRecord(ArrayList<Record> records) {
        String[] recordInfo = new String[5];
        boolean validationSuccessful = false;

        while(!validationSuccessful){
            recordInfo = Input.inputRecordInfo();
    
            validationSuccessful = Validation.validateRecordInfo(recordInfo);
            
            if (!validationSuccessful) {
                System.out.println("\nХочете спробувати ще раз?\n1. Так\n2. Ні");
                String retryChoice = scanner.nextLine();
                switch (retryChoice) {
                    case "1":
                        break;
                    case "2":
                        return;
                    default:
                        return;
                }
            }
        }
        if (validationSuccessful) {
            Record record = new Record(recordInfo[0], recordInfo[1], recordInfo[2], recordInfo[3], recordInfo[4]);
            records.add(record);
        }
    }

    public static void showRecords(ArrayList<Record> records) {
        
        if (records.isEmpty()) {
            System.out.println("\nЗаписи відсутні.");
            return;
        }

        System.out.println("\n--------- СПИСОК ЗАПИСІВ ---------");
        int i = 1;
        for (Record record : records) {
            System.out.println("Запис " + i + record.toString());
        }
    }
}
