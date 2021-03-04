package model.paint;

public final class ImagePattern extends Paint{
    private String imagePath;

    public ImagePattern(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getImagePath() { return imagePath;  }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append("ImagePattern{imagePath=").append(imagePath);
        sb.append("} ");
        return sb.toString();
    }  
}
