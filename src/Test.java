
public class Test {

    public static void main(String[] args) {
        Circle shape01 = new Circle(10);
        System.out.println(shape01.toString());
        
        Rectangle shape02 = new Rectangle(10,20);
        System.out.println(shape02.toString());
        
        Triangle shape03=new Triangle(10,10,10);
        System.out.println(shape03.toString());
        
        System.out.println("array");

        Shape[] shapes = new Shape[6];
        shapes[0] = new Circle(8);
        shapes[1] = new Circle(15,new int[]{35,700,-3});
        shapes[2] = new Rectangle(15,3,new int[]{-10,25,600});
        shapes[3] = new Rectangle(3,4);
        shapes[4] = new Triangle(3,4,5,new int[]{-10,10,20});
        shapes[5] = new Triangle(15,10,5);
        
        
        for(int i=0;i<6;i++){
            System.out.println(shapes[i].toString());
        }
    }
}
