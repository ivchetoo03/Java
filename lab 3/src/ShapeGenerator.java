import java.util.Random;

public class ShapeGenerator {

    private Random rand = new Random();
    private int randShapeValue;
    private int randColorIndex;
    
    public static final String[] colors = {"Red", "Yellow", "Green", "Blue", "Black", "White"};
    private String color;

    public Shape[] generateShapes(Shape[] shapes) {
        
        for (int i = 0; i < shapes.length; i++) {
            
            randShapeValue = rand.nextInt(3);
            randColorIndex = rand.nextInt(colors.length);
            color = colors[randColorIndex];
            
            if (randShapeValue == 0) {

                shapes[i] = new Circle( "Circle" + (i + 1), // ім'я кола
                                        color, // колір
                                        rand.nextFloat() * 10); // радіус
            } 
            
            else if (randShapeValue == 1) {
                shapes[i] = new Rectangle("Rectangle" + (i + 1), // ім'я прямокутника
                                          color, // колір
                                          rand.nextFloat() * 10, // ширина
                                          rand.nextFloat() * 10); // висота
            } 
            
            else {
                shapes[i] = new Triangle(  "Triangle" + (i + 1), // ім'я трикутника
                                           color, // колір
                                           rand.nextFloat() * 10, // довжина основи
                                           rand.nextFloat() * 10); // висота
            }
        }
        return shapes;
    }
}