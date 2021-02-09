
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height, int[] bgColor) {
        super(bgColor);
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public Rectangle(double width, double height) {
        this(width,height,new int[]{0,0,0});
    }

    public double getWidth() {return width;}

    public double getHeight() {return height;}
   
    public void setWidth(double width) {if(width<0) return; this.width = width;}

    public void setHeight(double height) {if(height<0) return; this.height = height;}
    
    public double getDiagonal() {
        return Math.sqrt(this.width*this.width+this.height*this.height);
    }
    
    public double getArea() {
        return this.width*this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width+this.height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": Rectangle , width=").append(this.width).append(",height=").append(this.height);
        sb.append(", Diagonal=").append(this.getDiagonal());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
