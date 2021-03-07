
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import model.paint.Color;
import model.shape.Circle;
import model.shape.Rectangle;
import model.shape.Triangle;
import model.shape.Shape;

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
        shapes[0] = new Circle(15);
        shapes[0].setColor(new Color(35,700,-3));
        shapes[1] = new Rectangle(15,3);
        shapes[1].setColor(new Color(0,255,0));
        shapes[2] = new Triangle(3,4,5);
        
        for(int i=0;i<3;i++){
            System.out.println(shapes[i].toString());
        }

        double totalArea=0;
        for(int i=0;i<3;i++){
            totalArea+=shapes[i].getArea();
        }
        System.out.println("Tital area of shape in array ="+totalArea);
        
                
        System.out.println("array list");
        ArrayList<Shape> shapeList = new ArrayList<>();
        shapeList.add(new Circle(15));
        shapeList.get(0).setColor(new Color(35,700,-3));
        shapeList.add(new Rectangle(15,3));
        shapeList.get(1).setColor(new Color(0,255,0));
        shapeList.add(new Triangle(3,4,5));
        Collections.sort(shapeList);
        System.out.println(shapeList);
        Collections.sort(shapeList,Shape.getPerimeterComparator());
        System.out.println(shapeList);
    }
}
