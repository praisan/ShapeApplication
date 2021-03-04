package model.paint;

public abstract class Paint {
    private double opacity;

    public double getOpacity() {
        return opacity;
    }

    public void setOpacity(double opacity) {
        this.opacity = opacity;
    }
    
    public boolean isOpaque(){return opacity>0;};

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Paint{opacity=").append(opacity);
        sb.append("} ");
        return sb.toString();
    } 
}
