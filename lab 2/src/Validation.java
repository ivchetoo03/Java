public class Validation {
    
    public static boolean validateRecordInfo(String[] recordInfo) {
        
        boolean success = true;

        String name = recordInfo[0];
        String surname = recordInfo[1];
        String dateOfBirth = recordInfo[2];
        String phoneNumber = recordInfo[3];
        String homeAddress = recordInfo[4];

        if (!validateName(name)) success = false;
        if (!validateSurname(surname)) success = false;
        if (!validateDateOfBirth(dateOfBirth)) success = false;
        if (!validatePhoneNumber(phoneNumber)) success = false;
        if (!validateHomeAddress(homeAddress)) success = false;
        
        if (success){
            System.out.println("\nЗапис успішно додано:");
            System.out.println("Прізвище: " + name);
            System.out.println("Ім'я: " + surname);
            System.out.println("Дата народження: " + dateOfBirth);
            System.out.println("Номер телефону: " + phoneNumber);
            System.out.println("Домашня адреса: " + homeAddress);
        }

        return success;
    }

    public static boolean validateName(String name) {
        if (name == null || name.trim().isEmpty()) { 
            System.out.println("ПОМИЛКА: ІМ'Я не може бути порожнім.");
            return false;
        }

        if (!name.matches("[a-zA-Zа-яА-ЯёЁїЇіІєЄ'\\-]+")) { 
            System.out.println("ПОМИЛКА: ІМ'Я може містити лише літери, апострофи та дефіси.");
            return false;
        }
        return true;
    }

    public static boolean validateSurname(String surname) {
        if (surname == null || surname.trim().isEmpty()) { 
            System.out.println("ПОМИЛКА: ПРІЗВИЩЕ не може бути порожнім.");
            return false;
        }

        if (!surname.matches("[a-zA-Zа-яА-ЯёЁїЇіІєЄ'\\-]+")) { 
            System.out.println("ПОМИЛКА: ПРІЗВИЩЕ може містити лише літери, апострофи та дефіси.");
            return false;
        }
        return true;
    }

    public static boolean validateDateOfBirth(String dateOfBirth) {
        if (dateOfBirth == null || dateOfBirth.trim().isEmpty()) { 
            System.out.println("ПОМИЛКА: ДАТА НАРОДЖЕННЯ не може бути порожньою.");
            return false;
        }

        if (!dateOfBirth.matches("\\d{2}\\.\\d{2}\\.\\d{4}")) { 
            System.out.println("ПОМИЛКА: ДАТА НАРОДЖЕННЯ має некоректний формат. Формат має бути ДД.ММ.РРРР.");
            return false;
        }
        return true;
    }

    public static boolean validatePhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.trim().isEmpty()) { 
            System.out.println("ПОМИЛКА: НОМЕР ТЕЛЕФОНУ не може бути порожнім.");
            return false;
        }

        if (!phoneNumber.matches("^\\+380(39|50|63|66|67|68|73|89|91|92|93|94|95|96|97|98|99)\\d{7}$")) { 
            System.out.println("ПОМИЛКА: НОМЕР ТЕЛЕФОНУ має некоректний формат. Формат має бути +380XXXXXXXXX, де X - цифра.");
            return false;
        }
        return true;
    }

    public static boolean validateHomeAddress(String homeAddress) {
        if (homeAddress == null || homeAddress.trim().isEmpty()) { 
            System.out.println("ПОМИЛКА: ДОМАШНЯ АДРЕСА не може бути порожньою.");
            return false;
        }

        if (!homeAddress.matches("^(вул|проспект|пр|бульвар|пров|пл)\\.?\\s+[А-Яа-яїЇіІєЄ\\s\\d-]+,\\s*\\d+[А-Яа-я]?(,\\s*(кв|квартира)\\.?\\s*\\d+)?$")) {
            System.out.println("ПОМИЛКА: ДОМАШНЯ АДРЕСА має некоректний формат. Формат має бути (вул|проспект|пр|бульвар|пров|пл. Назва, номер)");
            return false;
        }
        return true;
    }
}
