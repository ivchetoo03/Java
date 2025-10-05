public class Input {

    public static String[] inputRecordInfo() {

        System.out.println("\nВведіть інформацію про запис");

        System.out.print("\nПрізвище: ");
        String name = Main.scanner.nextLine();

        System.out.print("\nІм'я: ");
        String surname = Main.scanner.nextLine();

        System.out.print("\nДата народження (ДД.ММ.РРРР) : ");
        String dateOfBith = Main.scanner.nextLine();

        System.out.print("\nНомер телефону (+380XXXXXXXXX, де X - цифра.): ");
        String phoneNumber = Main.scanner.nextLine();

        System.out.print("\nДомашня адреса: ");
        String homeAddress = Main.scanner.nextLine();

        return new String[]{name, surname, dateOfBith, phoneNumber, homeAddress};
    }
}
