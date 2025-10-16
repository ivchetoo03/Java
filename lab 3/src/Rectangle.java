public class Rectangle extends Shape {
    
    private String type = "Rectangle";
    private float width;
    private float height;

    public Rectangle(String name, String color, float width, float height) {
        super(name, color);
        this.width = width;
        this.height = height;
    }

    public String getType(){
        return type;
    }

    public double calcArea() {
        return width * height;
    }

    public String draw() {
        return " ----------\n|          |\n|          |\n ----------";
    }

    @Override
    public String toString() {
        return  "Назва: " + super.getName() + 
                "\n\tТип: "  + type + 
                "\n\tКолір: "  + super.getColor() + 
                "\n\tШирина: "  + width + 
                "\n\tВисота: " + height + 
                "\n\tПлоща: "  + calcArea();
    }
}
