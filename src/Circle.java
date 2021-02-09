
public class Circle {

    private double radius;
    private int[] bgColor;

    public Circle(double radius) {
        this.radius = radius;
        bgColor=new int[]{0,0,0};
    }

    public Circle(double radius, int[] bgColor) {
        this.radius = radius;
        this.bgColor = bgColor;
    }

    public double getRadius() {
        return radius;
    }

    public int[] getBgColor() {
        return bgColor;
    }

    public void setRadius(double radius) {
        this.radius = radius;
    }

    public void setBgColor(int[] bgColor) {
        this.bgColor = bgColor;
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
        sb.append("Shape ");
        sb.append("Color=[").append(getBgColor()[0]).append(", ").append(getBgColor()[1]).append( ", ").append(getBgColor()[2]).append("]");
        sb.append(": Circle , Radius=").append(radius);
        sb.append(", Diameter=").append(getDiameter());
        sb.append(", Area=").append(getArea());
        sb.append(", Perimeter=").append(getPerimeter());
        return sb.toString();
    }

        

}
