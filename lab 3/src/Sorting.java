import java.util.Comparator;
import java.util.Arrays;
import java.util.List;

public class Sorting {
    
    private static final List<String> COLOR_ORDER = Arrays.asList(ShapeGenerator.colors);

    static Comparator<Shape> sortByArea = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            if (s1.calcArea() < s2.calcArea()) {
                return -1;
            }
            if (s1.calcArea() > s2.calcArea()) {
                return 1;
            }
            return 0;
        }
    };

    static Comparator<Shape> sortByColor = new Comparator<Shape>() {
        @Override
        public int compare(Shape s1, Shape s2) {
            int index1 = COLOR_ORDER.indexOf(s1.getColor());
            int index2 = COLOR_ORDER.indexOf(s2.getColor());

            if (index1 < index2) {
                return -1;
            }
            if (index1 > index2) {
                return 1;
            }
            
            return 0;
        }
    };

    public static void sortByArea(Shape[] shapes){
        Arrays.sort(shapes, sortByArea);
    }

    public static void sortByColor(Shape[] shapes){
        Arrays.sort(shapes, sortByColor);
    }

}
