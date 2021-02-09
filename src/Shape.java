
public class Shape {
    private int[] bgColor;
    private int[] lineColor;

    public Shape(int[] color) {
        this.setBgColor(color);
        this.setLineColor(color);
    }
    
    public int[] getBgColor() {return this.bgColor;}
    public int[] getLineColor() {return this.lineColor;}
    
    private int[] checkColor(int[] color) {
        for(int i=0;i<3;i++){
            color[i]=(color[i]>=0)?color[i]:0;
            color[i]=(color[i]<=255)?color[i]:255;
        }
        return color;
    }
    
    public final void setBgColor(int[] bgColor) {
        if(bgColor.length!=3) return;
        this.bgColor = this.checkColor(bgColor);
    }
    
    public final void setLineColor(int[] lineColor) {
        if(lineColor.length!=3) return;
        this.lineColor = this.checkColor(lineColor);
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shape ");
        sb.append("fill color=[").append(this.bgColor[0]).append(", ").append(this.bgColor[1]).append( ", ").append(this.bgColor[2]).append("]");
        sb.append("line color=[").append(this.lineColor[0]).append(", ").append(this.lineColor[1]).append( ", ").append(this.lineColor[2]).append("]");
        return sb.toString();
    }
}
