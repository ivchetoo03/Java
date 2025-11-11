package MVCShapes;

import java.util.Scanner;

public class View {    
    
    public Scanner sc;

    public View(Scanner sc){
        this.sc = sc;
    }
    
    public int viewMenu(){

        System.out.println("\n\t--- MVC Shapes ---");
        System.out.println("Виберіть дію: ");
        System.out.println("1. Відобразити фігури (ascii art)");
        System.out.println("2. Відобразити інформацію про фігури");
        System.out.println("3. Обчислити площу всіх фігур");
        System.out.println("4. Обчислити площу фігур конкретного типу");
        System.out.println("5. Сортувати фігури по збільшенню їх площі");
        System.out.println("6. Сортувати фігури по кольору");
        System.out.println("7. Імпортувати фігури з файлу");
        System.out.println("8. Експортувати фігури у файл");
        System.out.println("0. Вихід");
        System.out.print(" - ");
        return sc.nextInt();
    }

    public void printShapes(String shapeName, String shapeForm) {
        System.out.println(shapeName);
        System.out.println(shapeForm);
        System.out.println("--------------------");
    }

    public void printShapesInfo(String shapeInfo) {
        System.out.println(shapeInfo);
        System.out.println("--------------------");
    }

    public void printShapesArea(float area) {
        System.out.println("\nСума площ всіх фігур: " + area);
    }

    public void printShapesAreaType(float area, String type) {
        System.out.println("\nСума площ всіх фігур типу " + type + ": " + area);
    }
    
    public int typeChoice(){
        System.out.println("\nВиберіть тип фігур, суму фігур яких хочете обчислити: ");
        System.out.println("1. Прямокутник");
        System.out.println("2. Трикутник");
        System.out.println("3. Коло");
        System.out.print(" - ");
        return sc.nextInt();
    }
    
    public void printChoiceError() {
        System.out.println("\nПомилка вводу (можливі варіанти вводу: 0, 1, 2, 3, 4, 5, 6)");
    }

    public void printChoiceTypeError() {
        System.out.println("\nПомилка вводу (можливі варіанти вводу: 1, 2, 3)");
    }

    public void printSortAreaSuccess() {
        System.out.println("\nСортування по площі було виконано успішно!");
    }

    public void printSortColorSuccess() {
        System.out.println("\nСортування по кольору було виконано успішно!");
    }

    public String printAndReadPathToFile() {
        System.out.print("\nВведіть шлях до файлу: ");
        return sc.next();
    }

    public void printSuccessfulImport(String pathToFile) {
        System.out.println("Імпорт фігур з файлу '" + pathToFile + "' відбувся успішно!");
        
    }
    public void printSuccessfulExport(String pathToFile) {
        System.out.println("Експорт фігур у файл '" + pathToFile + "' відбувся успішно!");
    }
}
