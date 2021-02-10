
public class Test {

    public static void main(String[] args) {
        Circle shape01 = new Circle(10);
        System.out.println(shape01.toString());
        
        Rectangle shape02 = new Rectangle(10,20);
        System.out.println(shape02.toString());
        
        Triangle shape03=new Triangle(10,10,10);
        System.out.println(shape03.toString());
        
        System.out.println("array");

        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(15,new int[]{35,700,-3});
        shapes[1] = new Rectangle(15,3,new int[]{-10,25,600});
        shapes[2] = new Triangle(3,4,5,new int[]{-10,10,20});
        
        for(int i=0;i<3;i++){
            System.out.println(shapes[i].toString());
        }

        double totalArea=0;
        for(int i=0;i<3;i++){
            totalArea+=shapes[i].getArea();
        }
        System.out.println("Tital area of shape in array ="+totalArea);
    }
}
