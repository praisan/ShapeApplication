
public class Test {

    public static void main(String[] args) {
        Circle shape01 = new Circle(10);
        System.out.println(shape01.toString());

        Object[] shapes = new Object[5];
        shapes[0] = new Circle(8);
        shapes[1] = new Circle(10);
        shapes[2] = new Circle(15);
        
        for(int i=0;i<3;i++){
            System.out.println(shapes[i].toString());
        }
    }

}
