package model.paint;

public final class Color extends Paint {
    
    private int red;
    private int green;
    private int blue;

    public Color(int red, int green, int blue) {
        this.setColor(red,green,blue);
    }

    public double getBrightness() {
        return 0.2126 * red + 0.7152 * green + 0.0722 * blue;
    }

    public int getRed() {return red;}
    public int getGreen() {return green;}
    public int getBlue() {return blue;}

    public int[] getColor(){ return new int[]{red,green,blue}; }

    private int checkColor(int color) {
        color = (color >= 0) ? color : 0;
        color = (color <= 255) ? color : 255;
        return color;
    }
    
    public void setColor(int red, int green, int blue) {
        red = checkColor(red);
        green = checkColor(green);
        blue = checkColor(blue);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("Color [R,G,B]=[").append(red);
        sb.append(",").append(green);
        sb.append(",").append(blue);
        sb.append("]");
        return sb.toString();
    }
}
