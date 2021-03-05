package model.shape;

import model.paint.Color;
import model.paint.Paint;

public abstract class Shape {
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shape ");
        sb.append("fill color=").append(this.bgPaint);
        sb.append(", line color=").append(this.linePaint);
        return sb.toString();
    }
}
