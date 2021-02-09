
public class Circle {

    private double radius;
    private int[] bgColor;

    public Circle(double radius) {
        this.radius = radius;
        this.bgColor=new int[]{0,0,0};
    }

    public Circle(double radius, int[] bgColor) {
        this.radius = radius;
        this.bgColor = bgColor;
    }

    public double getRadius() {return this.radius;}

    public int[] getBgColor() {return this.bgColor;}

    public void setRadius(double radius) {this.radius = radius;}

    public void setBgColor(int[] bgColor) {this.bgColor = bgColor;}

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
        sb.append("Shape ");
        sb.append("Color=[").append(this.bgColor[0]).append(", ").append(this.bgColor[1]).append( ", ").append(this.bgColor[2]).append("]");
        sb.append(": Circle , Radius=").append(this.radius);
        sb.append(", Diameter=").append(this.getDiameter());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
