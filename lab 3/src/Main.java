public class Main {
    public static void main(String[] args) throws Exception {
        
        Controller control = new Controller();
        
        Shape[] shapes = new Shape[10]; // масив з 10 фігур
        ShapeGenerator shapeGen = new ShapeGenerator(); // генератор фігур
        shapeGen.generateShapes(shapes); // генерація фігур

        control.processMenu(shapes);
    }
}
