package model.shape;

public class Triangle extends Shape {
    private double side1,side2,side3;

    public Triangle(double side1, double side2, double side3) {
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }

    public double getSide1() {return side1;}
    public double getSide2() {return side2;}
    public double getSide3() {return side3;}

    public void setSide1(double side1) {
        if(side1<0) return;
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        if(side2<0) return;
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        if(side3<0) return;
        this.side3 = side3;
    }
    
    public double getPerimeter() {
        return this.side1+this.side2+this.side3;
    }
    
    public double getArea() {
        double p=this.getPerimeter()/2;
        return Math.sqrt(p*(p-this.side1)*(p-this.side2)*(p-this.side3));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": Triangle , side1=").append(this.side1).append(",side2=").append(this.side2).append(",side3=").append(this.side3);
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
