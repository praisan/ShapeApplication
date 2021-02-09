
public class Rectangle {

    private double width;
    private double height;
    private int[] bgColor;

    public Rectangle(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        this.bgColor = new int[]{0, 0, 0};
    }

    public Rectangle(double width, double height, int[] bgColor) {
        this.setWidth(width);
        this.setHeight(height);
        this.setBgColor(bgColor);
    }

    public double getWidth() {return width;}

    public double getHeight() {return height;}

    public int[] getBgColor() {return bgColor;}

    public void setWidth(double width) {if(width<0) return; this.width = width;}

    public void setHeight(double height) {if(height<0) return; this.height = height;}

    public void setBgColor(int[] bgColor) {
        if(bgColor.length!=3) return;
        for(int i=0;i<3;i++){
            bgColor[i]=(bgColor[i]>=0)?bgColor[i]:0;
            bgColor[i]=(bgColor[i]<=255)?bgColor[i]:255;
        }
        this.bgColor = bgColor;
    }
    
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
        sb.append("Shape ");
        sb.append("Color=[").append(this.bgColor[0]).append(", ").append(this.bgColor[1]).append( ", ").append(this.bgColor[2]).append("]");
        sb.append(": Rectangle , width=").append(this.width).append(",height=").append(this.height);
        sb.append(", Diagonal=").append(this.getDiagonal());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
