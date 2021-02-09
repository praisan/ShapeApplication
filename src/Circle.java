
public class Circle extends Shape{

    private double radius;

    public Circle(double radius, int[] bgColor) {
        super(bgColor);
        this.setRadius(radius);
    }
    
    public Circle(double radius) {
        this(radius,new int[]{0,0,0});
    }

    public double getRadius() {return this.radius;}

    public void setRadius(double radius) {
        if(radius<0) return;
        this.radius = radius;
    }

    public double getDiameter() {
        return this.radius * 2;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": Circle , Radius=").append(this.radius);
        sb.append(", Diameter=").append(this.getDiameter());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
