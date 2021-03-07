package model.shape;

import java.util.Comparator;
import java.util.Objects;
import model.paint.Color;
import model.paint.Paint;

public abstract class Shape implements Comparable<Shape>{
    private Paint bgPaint;
    private Paint linePaint;

    public Shape() {
        this.bgPaint=new Color(255,255,255);
        this.linePaint=new Color(0,0,0);
    }
    
    public Paint getBgColor() {return this.bgPaint;}
    public Paint getLineColor() {return this.linePaint;}
    
    public final void setColor(Paint paint) {
        if(paint==null) return;
        this.bgPaint = paint;
        this.linePaint=paint;
    }
    
    public final void setBgColor(Paint bgPaint) {
        if(bgPaint==null) return;
        this.bgPaint = bgPaint;
    }
    
    public final void setLineColor(Paint linePaint) {
        if(bgPaint==null) return;
        this.linePaint = linePaint;
    }
    public abstract double getArea();
    public abstract double getPerimeter();

    @Override
    public int compareTo(Shape obj) {
        Objects.requireNonNull(obj);
        return Double.compare(this.getArea(), obj.getArea());
    }
    
    public static Comparator<Shape> getPerimeterComparator(){
        return new Comparator<Shape>(){
            @Override
            public int compare(Shape o1, Shape o2) {
               return Double.compare(o1.getPerimeter(), o2.getPerimeter());
            }
        };
    }

    @Override
    public int hashCode() {
        return (int)((this.getArea()+this.getPerimeter()/2));
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Shape other = (Shape) obj;
        if (!((Double)this.getArea()).equals(other.getArea())) {
            return false;
        }
        if (!((Double)this.getPerimeter()).equals(other.getPerimeter())) {
            return false;
        }
        return true;
    }
    
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shape ");
        sb.append("fill color=").append(this.bgPaint);
        sb.append(", line color=").append(this.linePaint);
        return sb.toString();
    }
}
