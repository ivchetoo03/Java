public abstract class Shape implements Drawable {
    
    private String name;
    private String shapeColor;

    public Shape(String name, String color) {
        this.name = name;
        this.shapeColor = color;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return shapeColor;
    }
    
    public abstract double calcArea();
    public abstract String draw();
    public abstract String getType();

    @Override
    public String toString() {
        return  "Фігура: " + name + 
                "\n\tКолір: "  + shapeColor;
    } 
}
