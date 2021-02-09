
public class Test {

    public static void main(String[] args) {
        Circle shape01 = new Circle(10);
        System.out.println(shape01.toString());
        
        Rectangle shape02 = new Rectangle(10,20);
        System.out.println(shape01.toString());
        
        System.out.println("array");

        Object[] shapes = new Object[5];
        shapes[0] = new Circle(8);
        shapes[1] = new Circle(10);
        shapes[2] = new Circle(15,new int[]{35,700,-3});
        shapes[3] = new Rectangle(15,3,new int[]{-10,25,600});
        shapes[4] = new Rectangle(3,4);
        
        for(int i=0;i<5;i++){
            System.out.println(shapes[i].toString());
        }
    }
}
