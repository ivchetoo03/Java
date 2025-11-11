package MVCShapes;

public class Circle extends Shape {
    
    private String type = "Circle";
    private float radius;

    public Circle(String name, String color, float radius) {
        super(name, color);
        this.radius = radius;
    }

    public String getType(){
        return type;
    }

    public double calcArea() {
        return Math.PI * radius * radius;
    }

    public String draw() {
        return "   **** \n *      *\n*        *\n *      *\n   **** ";
    }

    @Override
    public String toString() {
        return  "Назва: " + super.getName() + 
                "\n\tТип: "  + type + 
                "\n\tКолір: "  + super.getColor() + 
                "\n\tРадіус: "  + radius + 
                "\n\tПлоща: "  + calcArea();
    }
}
