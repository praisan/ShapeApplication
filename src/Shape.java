
public class Shape {
    private int[] bgColor;

    public Shape(int[] bgColor) {
        this.setBgColor(bgColor);
    }
    
    public int[] getBgColor() {return this.bgColor;}
    
    public void setBgColor(int[] bgColor) {
        if(bgColor.length!=3) return;
        for(int i=0;i<3;i++){
            bgColor[i]=(bgColor[i]>=0)?bgColor[i]:0;
            bgColor[i]=(bgColor[i]<=255)?bgColor[i]:255;
        }
        this.bgColor = bgColor;
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shape ");
        sb.append("Color=[").append(this.bgColor[0]).append(", ").append(this.bgColor[1]).append( ", ").append(this.bgColor[2]).append("]");
        return sb.toString();
    }
}
