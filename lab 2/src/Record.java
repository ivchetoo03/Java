public class Record {

    private String name;
    private String surname;
    private String dateOfBirth;
    private String phoneNumber;
    private String homeAddress;

    public Record(String name, String surname, String dateOfBirth, String phoneNumber, String homeAddress) {
        this.name = name;
        this.surname = surname;
        this.dateOfBirth = dateOfBirth;
        this.phoneNumber = phoneNumber;
        this.homeAddress = homeAddress;
    }

    @Override
    public String toString() {
        return  "\n Ім'я: " + name + 
                "\n Прізвище: " + surname +
                "\n Дата народження: " + dateOfBirth +
                "\n Номер телефона: " + phoneNumber +
                "\n Домашя адреса: " + homeAddress;
    }
}
