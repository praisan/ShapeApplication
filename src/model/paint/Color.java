package model.paint;

public final class Color extends Paint {
    
    // https://en.wikipedia.org/wiki/Web_colors
    public static final Color WHITE=new Color(255,255,255);
    public static final Color SILVER=new Color(192,192,192);
    public static final Color GRAY=new Color(128,128,128);
    public static final Color BLACK=new Color(0,0,0);
    public static final Color RED=new Color(255,0,0);
    public static final Color MAROON=new Color(128,0,0);
    public static final Color YELLOW=new Color(255,255,0);
    public static final Color OLIVE=new Color(128,128,0);
    public static final Color LIME=new Color(0,255,0);
    public static final Color GREEN=new Color(0,128,0);
    public static final Color AQUA=new Color(0,255,255);
    public static final Color TEAL=new Color(0,128,128);
    public static final Color BLUE=new Color(0,0,255);
    public static final Color NAVY=new Color(0,0,128);
    public static final Color FUCHSIA=new Color(255,0,255);
    public static final Color PURPLE=new Color(128,0,128);

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
