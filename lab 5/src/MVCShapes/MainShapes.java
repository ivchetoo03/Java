package MVCShapes;

import java.util.Scanner;

public class MainShapes {
    public static void initializeShapesProgram(Scanner sc){
        
        Controller control = new Controller(sc);
        control.processProgram();
    }
}
