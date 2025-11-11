package MVCShapes;

public class Triangle extends Shape {
    
    private String type = "Triangle";
    private float base;
    private float height;

    public Triangle(String name, String color, float base, float height) {
        super(name, color);
        this.base = base;
        this.height = height;
    }

    public String getType(){
        return type;
    }

    public double calcArea() {
        return 0.5 * base * height;
    }

    public String draw() {
        return "    /\\\n   /  \\\n  /    \\\n /______\\";
    }

    @Override
    public String toString() {
        return  "Назва: " + super.getName() + 
                "\n\tТип: "  + type + 
                "\n\tКолір: "  + super.getColor() + 
                "\n\tОснова: "  + base + 
                "\n\tВисота: " + height + 
                "\n\tПлоща: "  + calcArea();
    }
}
