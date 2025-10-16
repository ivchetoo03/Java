public class AreaCalculator {

    public static float calculateAllAreas(Shape[] shapes){
        float areaSum = 0;

        for (Shape shape : shapes) {
            areaSum += shape.calcArea();
        }

        return areaSum;
    }

    public static float calculateAreasByType(Shape[] shapes, String type){
        
        float areaSum = 0;
        for (Shape shape : shapes) {
            if(shape.getType() == type){
                areaSum += shape.calcArea();
            }
        }

        return areaSum;
    }
}
