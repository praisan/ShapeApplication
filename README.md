# เรื่องราวการออกแบบ ShapeApplication

ปิติ ต้องการออกแบบโปรแกรมสำหรับไว้ใช้ในการวาดรูปทรงต่าง ๆ
แต่ละรูปทรงสามารถเติมสีได้ รวมถึงสามารถคำนวณพื้นที่ และเส้นรอบรูปได้
และอาจมีการคำนาณคุณสมบัติอื่นของรูปทรงนั้น ๆ

<a name="toc"></a>
## สารบัญ 
* <a href="#move01">ก้าวที่ 1 Class-object และการใช้งาน</a> <br>
กลับไปดู code ณ เวลานั้นได้ที่นี่
https://github.com/praisan/ShapeApplication/tree/3ec7b1959f99adc484c6c0e25ed9461061f39b9c

* <a href="#move02">ก้าวที่ 2 การตรวจสอบเพื่อป้องกันความผิดพลาดจากการใช้งาน </a><br>
กลับไปดู code ณ เวลานั้นได้ที่นี่
https://github.com/praisan/ShapeApplication/tree/161a52b491e815b75b466a4fc9bd883bad259acc

* <a href="#move03">ก้าวที่ 3 เพิ่ม class Rectangle </a><br>
กลับไปดู code ณ เวลานั้นได้ที่นี่
https://github.com/praisan/ShapeApplication/tree/06a16d6fb453f608e66089ff5606d0394280e80f

* <a href="#move04">ก้าวที่ 4 สืบทอด(Inheritance) ลดความซ้ำซ้อน </a><br>
กลับไปดู code ณ เวลานั้นได้ที่นี่
https://github.com/praisan/ShapeApplication/tree/792cb9846adb08df8b803ded9ef2681b7e0b1dec

* <a href="#move05">ก้าวที่ 5 เพิ่ม Triangle </a><br>
กลับไปดู code ณ เวลานั้นได้ที่นี่
https://github.com/praisan/ShapeApplication/tree/5eee303c25b119d3c625c8c7bcafad4078195714

* <a href="#move06">ก้าวที่ 6 เพิ่มความสามารถ และป้องกันการแก้ไข </a><br>
กลับไปดู code ณ เวลานั้นได้ที่นี่
https://github.com/praisan/ShapeApplication/tree/0ad14eb1fddcb81ecb3347c1dc4ebba4c86ffc39

* <a href="#move07">ก้าวที่ 7 Abstract class เติมเต็มส่วนที่ขาดและติดปีก Polymorphism </a><br>
กลับไปดู code ณ เวลานั้นได้ที่นี่
https://github.com/praisan/ShapeApplication/tree/0f3a25e2241b1a9d3cca4453c5f7e205c278f921

* <a href="#move08">ก้าวที่ 8 "composition over inheritance" and "responsibility"</a><br>
code ปัจจุบันเป็นก้าวที่ 8 แล้ว

<a name="move01"></a>
## ก้าวที่ 1 Class-object และการใช้งาน

https://github.com/praisan/ShapeApplication/tree/3ec7b1959f99adc484c6c0e25ed9461061f39b9c

ปิติเริ่มจากออกแบบคลาส Circle ที่สามารถจดจำสีและรัศมีของวงกลมได้ สามารถเปลี่ยนแปลงได้ในภายหลังหากต้องการ
นอกจากการคำนวณเส้นรอบวงและพื้นที่แลัว คลาสนี้ยังออกแบบให้สามารถคำนวณหาเส้นผ่านศูนย์กลางของวงกลมได้ด้วยดังนี้


### การออกแบบ
<table>
<thead>
  <tr>
    <th >Circle</th><th ></th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>-radius: double<br>-bgColor: int[]</td>
    <td>
      -> บันทึกตัวเลขจำนวณจริง เอาไว้จำรัศมี<br>
      -> บันทึก array ของตัวเลขจำนวนเต็มเอาไว้จำค่าสี
    </td>
  </tr>
  <tr>
    <td>
      +Circle(radius:double)<br>
      +Circle(radius:double,bgColor: int[])<br>
      +getRadius():double<br>
      +getBgColor():int[]<br>
      +setRadius(radius:double):void<br>
      +setBgColor(bgColor: int[]):void<br>
      +getDiameter():double<br>
      +getPerimeter():double<br>
      +getArea():double<br>
      +toString():String
    </td>
    <td>
      -> เอาไว้สร้าง object วงกลมตามรัศมีที่กำหนด และจะใส่สีที่พื้นหลังเป็นสีดำ [0,0,0] <br>
      -> เอาไว้สร้าง object วงกลมตามรัศมีที่กำหนด และจะใส่สีที่พื้นหลังตามที่ระบุ <br>
      -> เอาไว้คืนค่ารัศมีของวงกลมหากผู้ใช้ต้องการ <br>
      -> เอาไว้คืนค่าสีของวงกลมหากผู้ใช้ต้องการ <br>
      -> เอาไว้แก้ไขค่ารัศมีของวงกลมใหม่หากผู้ใช้ต้องการ <br>
      -> เอาไว้แก้ไขค่าสีของวงกลมใหม่หากผู้ใช้ต้องการ <br>
      -> เอาไว้คำนวณและคืนค่าเส้นผ่านศูนย์กลางของวงกลมหากผู้ใช้ต้องการ <br>
      -> เอาไว้คำนวณและคืนค่าเส้นรอบวงกลมหากผู้ใช้ต้องการ<br>
      -> เอาไว้คำนวณและคืนค่าพื้นที่วงกลมหากผู้ใช้ต้องการ<br>
      -> เอาไว้คืนค่าข้อความรายละเอียดของวงกลม
    </td>
  </tr>
</tbody>
</table>

### Code
```java
public class Circle {

    private double radius;
    private int[] bgColor;

    public Circle(double radius) {
        this.radius = radius;
        this.bgColor=new int[]{0,0,0};
    }

    public Circle(double radius, int[] bgColor) {
        this.radius = radius;
        this.bgColor = bgColor;
    }

    public double getRadius() {return this.radius;}

    public int[] getBgColor() {return this.bgColor;}

    public void setRadius(double radius) {this.radius = radius;}

    public void setBgColor(int[] bgColor) {this.bgColor = bgColor;}

    public double getDiameter() {
        return this.radius * 2;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shape ");
        sb.append("Color=[").append(this.bgColor[0]).append(", ").append(this.bgColor[1]).append( ", ").append(this.bgColor[2]).append("]");
        sb.append(": Circle , Radius=").append(this.radius);
        sb.append(", Diameter=").append(this.getDiameter());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
```


```java
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
```
### Output
```
Shape Color=[0, 0, 0]: Circle , Radius=10.0, Diameter=20.0, Area=314.1592653589793, Perimeter=62.83185307179586
Shape Color=[0, 0, 0]: Circle , Radius=8.0, Diameter=16.0, Area=201.06192982974676, Perimeter=50.26548245743669
Shape Color=[0, 0, 0]: Circle , Radius=10.0, Diameter=20.0, Area=314.1592653589793, Perimeter=62.83185307179586
Shape Color=[0, 0, 0]: Circle , Radius=15.0, Diameter=30.0, Area=706.8583470577034, Perimeter=94.24777960769379
```
<a name="move02"></a>
<a href="#toc">[กลับสารบัญ]</a>
## ก้าวที่ 2 การตรวจสอบเพื่อป้องกันความผิดพลาดจากการใช้งาน

https://github.com/praisan/ShapeApplication/tree/161a52b491e815b75b466a4fc9bd883bad259acc

เนื่องจากรัศมีของวงกลมควรมีค่ามากกว่าหรือเท่ากับ 0 และค่าสีควรมี 3 ค่าเพื่อแทนความสว่างของช่องสัญญาณสีทั้งสาม [Red,Green,Blue] และมีค่าความเข้มสีอยู่ในช่วง 0-255 

ปิติจึงแก้ไข code เพื่อให้สามารถตรวจสอบค่าให้เหมาะสมก่อนการกำหนดค่าต่าง ๆ ทำให้มีการเปลี่ยนแปลงดังนี้

### Code
```java

    public Circle(double radius) {
        this.setRadius(radius);
        this.bgColor=new int[]{0,0,0};
    }

    public Circle(double radius, int[] bgColor) {
        this.setRadius(radius);
        this.setBgColor(bgColor);
    }

    public void setRadius(double radius) {
        if(radius<0) return;
        this.radius = radius;
    }

    public void setBgColor(int[] bgColor) {
        if(bgColor.length!=3) return;
        for(int i=0;i<3;i++){
            bgColor[i]=(bgColor[i]>=0)?bgColor[i]:0;
            bgColor[i]=(bgColor[i]<=255)?bgColor[i]:255;
        }
        this.bgColor = bgColor;
    }

```

<a name="move03"></a>
<a href="#toc">[กลับสารบัญ]</a>
## ก้าวที่ 3 เพิ่ม class Rectangle

https://github.com/praisan/ShapeApplication/tree/06a16d6fb453f608e66089ff5606d0394280e80f

ปิติเริ่มออกแบบคลาสถัดไปซึ่งคือ Rectangle โดยใช้แนวทางออกแบบเดียวกับ class Circle และได้ทดสอบการเรียกใช้งานดังนี้
### การออกแบบ
<table>
<thead>
  <tr>
    <th >Rectangle</th><th ></th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>
      -width: double<br>
      -height: double<br>
      -bgColor: int[]</td>
    <td>
      -> บันทึกตัวเลขจำนวณจริง เอาไว้จำความกว้าง<br>
      -> บันทึกตัวเลขจำนวณจริง เอาไว้จำความสูง<br>
      -> บันทึก array ของตัวเลขจำนวนเต็มเอาไว้จำค่าสี
    </td>
  </tr>
  <tr>
    <td>
      +Rectangle(width: double,height: double)<br>
      +Rectangle(width: double,height: double,bgColor: int[])<br>
      +getWidth():double<br>
      +getHeight():double<br>
      +getBgColor():int[]<br>
      +setWidth(width: double):void<br>
      +setHeight(height: double):void<br>
      +setBgColor(bgColor: int[]):void<br>
      +getDiagonal():double<br>
      +getPerimeter():double<br>
      +getArea():double<br>
      +toString():String
    </td>
    <td>
      -> เอาไว้สร้าง object สี่เหลี่ยมตามความกว้างและความสูงที่กำหนด และจะใส่พื้นหลังเป็นสีดำ [0,0,0] <br>
      -> เอาไว้สร้าง object สี่เหลี่ยมตามความกว้างและความสูงที่กำหนด และจะใส่สีพื้นหลังตามที่ระบุ <br>
      -> เอาไว้คืนค่าความกว้างของสี่เหลี่ยมหากผู้ใช้ต้องการ <br>
      -> เอาไว้คืนค่าความสูงของสี่เหลี่ยมหากผู้ใช้ต้องการ <br>
      -> เอาไว้คืนค่าสีของสี่เหลี่ยมหากผู้ใช้ต้องการ <br>
      -> เอาไว้แก้ไขค่าความกว้างของสี่เหลี่ยมใหม่หากผู้ใช้ต้องการ <br>
      -> เอาไว้แก้ไขค่าความสูงของสี่เหลี่ยมใหม่หากผู้ใช้ต้องการ <br>
      -> เอาไว้แก้ไขค่าสีของสี่เหลี่ยมใหม่หากผู้ใช้ต้องการ <br>
      -> เอาไว้คำนวณและคืนค่าเส้นทะแยงมุมของสี่เหลี่ยมหากผู้ใช้ต้องการ <br>
      -> เอาไว้คำนวณและคืนค่าเส้นรอบสี่เหลี่ยมหากผู้ใช้ต้องการ<br>
      -> เอาไว้คำนวณและคืนค่าพื้นที่สี่เหลี่ยมหากผู้ใช้ต้องการ<br>
      -> เอาไว้คืนค่าข้อความรายละเอียดของสี่เหลี่ยม
    </td>
  </tr>
</tbody>
</table>

### Code
```java
public class Rectangle {

    private double width;
    private double height;
    private int[] bgColor;

    public Rectangle(double width, double height) {
        this.setWidth(width);
        this.setHeight(height);
        this.bgColor = new int[]{0, 0, 0};
    }

    public Rectangle(double width, double height, int[] bgColor) {
        this.setWidth(width);
        this.setHeight(height);
        this.setBgColor(bgColor);
    }

    public double getWidth() {return width;}

    public double getHeight() {return height;}

    public int[] getBgColor() {return bgColor;}

    public void setWidth(double width) {if(width<0) return; this.width = width;}

    public void setHeight(double height) {if(height<0) return; this.height = height;}

    public void setBgColor(int[] bgColor) {
        if(bgColor.length!=3) return;
        for(int i=0;i<3;i++){
            bgColor[i]=(bgColor[i]>=0)?bgColor[i]:0;
            bgColor[i]=(bgColor[i]<=255)?bgColor[i]:255;
        }
        this.bgColor = bgColor;
    }
    
    public double getDiagonal() {
        return Math.sqrt(this.width*this.width+this.height*this.height);
    }
    
    public double getArea() {
        return this.width*this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width+this.height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Shape ");
        sb.append("Color=[").append(this.bgColor[0]).append(", ").append(this.bgColor[1]).append( ", ").append(this.bgColor[2]).append("]");
        sb.append(": Rectangle , width=").append(this.width).append(",height=").append(this.height);
        sb.append(", Diagonal=").append(this.getDiagonal());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
```

```java
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
```
### Output

```
Shape Color=[0, 0, 0]: Circle , Radius=10.0, Diameter=20.0, Area=314.1592653589793, Perimeter=62.83185307179586
Shape Color=[0, 0, 0]: Circle , Radius=10.0, Diameter=20.0, Area=314.1592653589793, Perimeter=62.83185307179586
array
Shape Color=[0, 0, 0]: Circle , Radius=8.0, Diameter=16.0, Area=201.06192982974676, Perimeter=50.26548245743669
Shape Color=[0, 0, 0]: Circle , Radius=10.0, Diameter=20.0, Area=314.1592653589793, Perimeter=62.83185307179586
Shape Color=[35, 255, 0]: Circle , Radius=15.0, Diameter=30.0, Area=706.8583470577034, Perimeter=94.24777960769379
Shape Color=[0, 25, 255]: Rectangle , width=15.0,height=3.0, Diagonal=15.297058540778355, Area=45.0, Perimeter=36.0
Shape Color=[0, 0, 0]: Rectangle , width=3.0,height=4.0, Diagonal=5.0, Area=12.0, Perimeter=14.0 
```

<a name="move04"></a>
<a href="#toc">[กลับสารบัญ]</a>
## ก้าวที่ 4 สืบทอด(Inheritance) ลดความซ้ำซ้อน

https://github.com/praisan/ShapeApplication/tree/792cb9846adb08df8b803ded9ef2681b7e0b1dec

หลังจากเพิ่ม Rectangle ปิติพบว่ามี Code หลายส่วนซ้ำซ้อนกับ Circle คือการกำหนดสีของรูปทรงและหากเพิ่มคลาสรูปทรงอื่น ๆ อีกต่อไป Code ส่วนนี้ก็ยังคงเหมือนเดิมจึงตัดสินใจสร้าง Parent class เพื่อให้ Circle และ Rectangle ได้สืบทอดคุณสมบัติที่เหมือนกันนั้นมาใช้งาน 

ปิติสร้างคลาส Shape เพื่อการกำหนดค่าสีของรูปทรงและรายละเอียดอื่นที่รูปทรงจะใช้ร่วมกันได้ และให้ Circle และ Rectangle สืบทอดและขยายความสามารถซึ่งต้องได้แก้ไข Constructor และ toString() เล็กน้อยซึ่งช่วยลดความซ้ำซ้อนได้ดีขึ้น

การออกแบบใหม่นี้ยังช่วยให้ Code ในการเรียกใช้งานสื่อความหมายเข้าใจง่ายขึ้นด้วยจากการใช้คุณสมบัติ การมีได้หลายรูป (Polymorphism) จากที่เคยใช้แล้วคือ ```Object[] shapes = new Object[5];``` สามมารถเปลี่ยนมาใช้เป็น ```Shape[] shapes = new Shape[5];```

### การออกแบบ

```
Shape<-Circle 
Shape<-Rectangle 
```
<table>
<thead>
  <tr>
    <th >Shape</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>
      -bgColor: int[]</td>
  </tr>
  <tr>
    <td>
      +Shape(bgColor: int[])<br>
      +getBgColor():int[]<br>
      +setBgColor(bgColor: int[]):void<br>
      +toString():String
    </td>
</tbody>
</table>

<table>
<thead>
  <tr>
    <th >Circle</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>-radius: double</td>
  </tr>
  <tr>
    <td>
      +Circle(radius:double)<br>
      +Circle(radius:double,bgColor: int[])<br>
      +getRadius():double<br>
      +setRadius(radius:double):void<br>
      +getDiameter():double<br>
      +getPerimeter():double<br>
      +getArea():double<br>
      +toString():String
    </td>
  </tr>
</tbody>
</table>

<table>
<thead>
  <tr>
    <th >Rectangle</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>
      -width: double<br>
      -height: double</td>
  </tr>
  <tr>
    <td>
      +Rectangle(width: double,height: double)<br>
      +Rectangle(width: double,height: double,bgColor: int[])<br>
      +getWidth():double<br>
      +getHeight():double<br>
      +setWidth(width: double):void<br>
      +setHeight(height: double):void<br>
      +getDiagonal():double<br>
      +getPerimeter():double<br>
      +getArea():double<br>
      +toString():String
    </td>
</tbody>
</table>

### Code

```java
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
```

```java
public class Circle extends Shape{

    private double radius;

    public Circle(double radius, int[] bgColor) {
        super(bgColor);
        this.setRadius(radius);
    }
    
    public Circle(double radius) {
        this(radius,new int[]{0,0,0});
    }

    public double getRadius() {return this.radius;}

    public void setRadius(double radius) {
        if(radius<0) return;
        this.radius = radius;
    }

    public double getDiameter() {
        return this.radius * 2;
    }

    public double getArea() {
        return Math.PI * this.radius * this.radius;
    }

    public double getPerimeter() {
        return 2 * Math.PI * this.radius;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": Circle , Radius=").append(this.radius);
        sb.append(", Diameter=").append(this.getDiameter());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
```

```java
public class Rectangle extends Shape {

    private double width;
    private double height;

    public Rectangle(double width, double height, int[] bgColor) {
        super(bgColor);
        this.setWidth(width);
        this.setHeight(height);
    }
    
    public Rectangle(double width, double height) {
        this(width,height,new int[]{0,0,0});
    }

    public double getWidth() {return width;}

    public double getHeight() {return height;}
   
    public void setWidth(double width) {if(width<0) return; this.width = width;}

    public void setHeight(double height) {if(height<0) return; this.height = height;}
    
    public double getDiagonal() {
        return Math.sqrt(this.width*this.width+this.height*this.height);
    }
    
    public double getArea() {
        return this.width*this.height;
    }

    public double getPerimeter() {
        return 2 * (this.width+this.height);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": Rectangle , width=").append(this.width).append(",height=").append(this.height);
        sb.append(", Diagonal=").append(this.getDiagonal());
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
```

```java
public class Test {

    public static void main(String[] args) {
        Circle shape01 = new Circle(10);
        System.out.println(shape01.toString());
        
        Rectangle shape02 = new Rectangle(10,20);
        System.out.println(shape01.toString());
        
        System.out.println("array");

        Shape[] shapes = new Shape[5];
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
```

<a name="move05"></a>
<a href="#toc">[กลับสารบัญ]</a>
## ก้าวที่ 5 เพิ่ม Triangle

https://github.com/praisan/ShapeApplication/tree/5eee303c25b119d3c625c8c7bcafad4078195714

ปิติเพิ่มคลาส Triangle ที่รับความยาวของด้านทั้งสามของสามเหลี่ยมและเตรียม code สำหรับคำนวณความยาวรอบสามเหลี่ยมและพื้นที่ไว้ให้ด้วย ซึ่งการสืบทอดมาจากคลาส Shape ทำให้ไม่ต้องเขียน code ในส่วนที่ใช้ร่วมกันอีก

### Code
```java
public class Triangle extends Shape {
    private double side1,side2,side3;

    public Triangle(double side1, double side2, double side3, int[] bgColor) {
        super(bgColor);
        this.side1 = side1;
        this.side2 = side2;
        this.side3 = side3;
    }
    public Triangle(double side1, double side2, double side3) {
        this(side1,  side2,  side3,new int[]{0,0,0});
    }  

    public double getSide1() {return side1;}
    public double getSide2() {return side2;}
    public double getSide3() {return side3;}

    public void setSide1(double side1) {
        if(side1<0) return;
        this.side1 = side1;
    }

    public void setSide2(double side2) {
        if(side2<0) return;
        this.side2 = side2;
    }

    public void setSide3(double side3) {
        if(side3<0) return;
        this.side3 = side3;
    }
    
    public double getPerimeter() {
        return this.side1+this.side2+this.side3;
    }
    
    public double getArea() {
        double p=this.getPerimeter()/2;
        return Math.sqrt(p*(p-this.side1)*(p-this.side2)*(p-this.side3));
    }
    
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(super.toString());
        sb.append(": Triangle , side1=").append(this.side1).append(",side2=").append(this.side2).append(",side3=").append(this.side3);
        sb.append(", Area=").append(this.getArea());
        sb.append(", Perimeter=").append(this.getPerimeter());
        return sb.toString();
    }
}
```

```java
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
```

### Output
```
Shape Color=[0, 0, 0]: Circle , Radius=10.0, Diameter=20.0, Area=314.1592653589793, Perimeter=62.83185307179586
Shape Color=[0, 0, 0]: Rectangle , width=10.0,height=20.0, Diagonal=22.360679774997898, Area=200.0, Perimeter=60.0
Shape Color=[0, 0, 0]: Triangle , side1=10.0,side2=10.0,side3=10.0, Area=43.30127018922193, Perimeter=30.0
array
Shape Color=[0, 0, 0]: Circle , Radius=8.0, Diameter=16.0, Area=201.06192982974676, Perimeter=50.26548245743669
Shape Color=[35, 255, 0]: Circle , Radius=15.0, Diameter=30.0, Area=706.8583470577034, Perimeter=94.24777960769379
Shape Color=[0, 25, 255]: Rectangle , width=15.0,height=3.0, Diagonal=15.297058540778355, Area=45.0, Perimeter=36.0
Shape Color=[0, 0, 0]: Rectangle , width=3.0,height=4.0, Diagonal=5.0, Area=12.0, Perimeter=14.0
Shape Color=[0, 10, 20]: Triangle , side1=3.0,side2=4.0,side3=5.0, Area=6.0, Perimeter=12.0
Shape Color=[0, 0, 0]: Triangle , side1=15.0,side2=10.0,side3=5.0, Area=0.0, Perimeter=30.0
```

<a name="move06"></a>
<a href="#toc">[กลับสารบัญ]</a>
## ก้าวที่ 6 เพิ่มความสามารถ และป้องกันการแก้ไข 

https://github.com/praisan/ShapeApplication/tree/0ad14eb1fddcb81ecb3347c1dc4ebba4c86ffc39

ปิติอยากให้รูปร่างทุกแบบที่เขาสร้างขึ้นสามารถกำหนดสีของเส้นขอบได้จึงได้เพิ่มความสามารถในการจำสีเส้นขอบ ซึ่งกำหนดให้เป็นสีเดียวกันกับสีพื้นหลังแต่สามารถเปลี่ยนใหม่ได้หากผู้ใช้ต้องการ ซึ่งมีการตรวจสอบช่วงค่าที่ถูกต้องก่อนเปลี่ยนแปลงด้วยและเพื่อป้องกันความผิดพลาดจึงป้องกันไม่ให้คลาสที่สืบทอดแก้ไขเปลี่ยนแปลงโดยการเขียนทับ(Override) ได้ ทั้งหมดนี้ปิติสามารถปรับที่คลาส Shape ได้ทั้งหมดโดยไม่ต้องแก้ไขคลาสอื่นเลยดังนี้

### Code
```java
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
```

<a name="move07"></a>
<a href="#toc">[กลับสารบัญ]</a>
## ก้าวที่ 7 Abstract class เติมเต็มส่วนที่ขาดและติดปีก Polymorphism 

https://github.com/praisan/ShapeApplication/tree/0f3a25e2241b1a9d3cca4453c5f7e205c278f921

ปิติพบว่าหากใช้คุณสมบัติ Polymorphism เก็บรูปร่างต่าง ๆ ไว้ด้วยกันโดยใช้ array ชนิด Shape ทำให้การทำงานค่อนข้างสะดวก แต่หากต้องการทราบพื้นที่หรือเส้นรอบรูปของรูปร่างต่าง ๆ จะต้องแปลง (cast) กลับเป็นชนิดที่ถูกต้องของ object นั้น ๆ ก่อน เช่น 

```java
Shape[] shapes = new Shape[3];
shapes[0] = new Circle(15,new int[]{35,700,-3});
double area = ((Circle)shapes[0]).getArea();
```

การทำแบบนี้ก็ไม่ค่อยสะดวกเท่าที่ควรเนื่องจากการประกาศตัวแปรเป็นชนิด Shape ที่ไม่มีเมดธอด getArea() จึงไม่สามารถเรียกใช้ได้โดยตรง 

ปิติจึงเพิ่มเมดธอด getArea() และ getPerimeter() ซึ่งทุกรูปทรงในโปรแกรมนี้จะต้องมีเมดธอดเหล่านี้เหมือนกันแต่เนื่องจากแต่ละรูปทรงจะมีการคำนวณต่างกัน ปิติจึงให้เมดธอดเหล่านี้เป็น abstract เมดธอด ซึ่งจะไม่มีการเขียน code ใด ๆ และเปลี่ยนคลาส Shape เป็น abstract คลาสด้วย

การออกแบบนี้ทำให้ object ที่ประกาศเป็นชนิด Shape สามารถเรียกใช้งานเมดธอด getArea() ได้ และด้วยภาษา Java มีความสามารถในการผูกแบบไดนามิก (Dynamic binding) จะทำการผูกการทำงานของเมดธอดตอนรัน (runtime binding หรือ late binding) การทำงานของเมดธอดจะเป็นได้หลายรูปแบบเป็นไปตามชนิดของ object จริง ๆ ที่สร้างขึ้น (คุณสมบัติ Polymorphism)ไม่เช่นนั้นแล้วหากผูกการทำงานตอน compile (compile time binding) การทำงานของเมดธอดต่างจะทำงานด้วย code เดียวกันเสมอ

### Code
```java
 public abstract class Shape {
  //... code อื่นเหมือนเดิมไม่มีการเปลี่ยนแปลง
    public abstract double getArea();
    public abstract double getPerimeter();
    
  //... code อื่นเหมือนเดิมไม่มีการเปลี่ยนแปลง
```
```java
public class Test {

    public static void main(String[] args) {

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
```
### Output
```
Shape fill color=[0, 0, 0]line color=[0, 0, 0]: Circle , Radius=10.0, Diameter=20.0, Area=314.1592653589793, Perimeter=62.83185307179586
Shape fill color=[0, 0, 0]line color=[0, 0, 0]: Rectangle , width=10.0,height=20.0, Diagonal=22.360679774997898, Area=200.0, Perimeter=60.0
Shape fill color=[0, 0, 0]line color=[0, 0, 0]: Triangle , side1=10.0,side2=10.0,side3=10.0, Area=43.30127018922193, Perimeter=30.0
array
Shape fill color=[35, 255, 0]line color=[35, 255, 0]: Circle , Radius=15.0, Diameter=30.0, Area=706.8583470577034, Perimeter=94.24777960769379
Shape fill color=[0, 25, 255]line color=[0, 25, 255]: Rectangle , width=15.0,height=3.0, Diagonal=15.297058540778355, Area=45.0, Perimeter=36.0
Shape fill color=[0, 10, 20]line color=[0, 10, 20]: Triangle , side1=3.0,side2=4.0,side3=5.0, Area=6.0, Perimeter=12.0
Tital area of shape in array =757.8583470577034
```

<a name="move08"></a>
<a href="#toc">[กลับสารบัญ]</a>
## <a href="#move07">ก้าวที่ 8 "composition over inheritance" and "responsibility"</a><br>

ปิติอยากเพิ่มความยืดหยุ่นให้การกำหนดสีให้สามารถเป็นไปได้ทั้งใส่สีและใช้ภาพเป็นลวดลายได้ด้วยทั้งพื้นหลังและเส้นขอบ จึงตัดสินใจแยกการระบายสีออกมาเป็นคลาสใหม่ 

* composition over inheritance <br>
สร้าง Paint เป็นคลาสแบบ abstract จัดการเรื่องความโปร่งใสของการระบาย มีคลาสลูก Color สำหรับการจดจำและจัดการการระบายสีแบบ RGB และคลาสลูก ImagePattern สำหรับการจดจำและจัดการภาพที่จะใช้แทนการระบายสี การออกแบบนี้ยังช่วยให้เกิดความสะดวกในการประกาศชนิด attribute ที่มีความสามารถเป็นได้หลายรูป (Polymorphism) ในการระบายสีโดยประกาศเป็นชนิด Paint และกลายเป็นองค์ประกอบ (composition) หนึ่งของ Shape ที่รับผิดชอบในการระบายสีโดยเฉพาะแทนที่แบบเดิมที่การจัดการด้วยตัวเองแล้วให้คลาสลูกสืบทอด (inherit) การจัดการนี้ ตามแนวคิดของการออกแบบ "composition over inheritance"

* responsibility <br>
การเปลี่ยนแปลงนี้ทำให้ต้องแก้ไขคลาสลูกของ Shape ทุกคลาสเนื่องจากในคลาสเหล่านั้นมีเมดธอดหรือการดำเนินการบางอย่างเกี่ยวข้องกับการระบายสีด้วยซึ่งพบใน constructor ของแต่ละคลาส จึงทำให้ปิติต้องไต่ตรองการออกแบบใหม่โดยคำนึงถึงความรับผิดชอบ (responsibility) ของแต่ละคลาส หากแต่ละคลาสมีการจัดการกับ attribute ของคลาสอื่นด้วยเมื่อไหร่ก็ตามที่มีการเปลี่ยนแปลงในคลาสที่ประกาศ attribute เหล่านั้นก็จะมีผลกระทบต่อเนื่องโยงกันไปหมด ปิติออกแบบ Shape, Circle, Rectangle, และ Triangle ใหม่เพื่อหลีกเลี่ยงปัญหานี้โดยพยายามให้แต่ละคลาสมีเมดธอดที่จัดการกับ attribute ของด้วเองเท่านั้น

* การจัดการอื่น ๆ 
  * เพิ่มสีที่ใช้งานบ่อยในคลาส Color เพื่อให้สะดวกในการใช้งานโดยไม่ต้องจำค่าสีเหล่านั้นโดยใช้ชื่อและรหัสสีจาก https://en.wikipedia.org/wiki/Web_colors สีเหล่านี้ถูกกำหนดไว้เป็นค่าคงที่แบบ static ในคลาส Color และสามารถเรียกใช้ได้ง่ายเช่น ```Color.BLUE``` จะมีค่าเท่ากับ ```new Color(0,0,255)``` เป็นต้น
  * แยก Package ออกเป็นสองส่วน model.paint และ model.shape เพื่อการแบ่งแยกคลาสที่ทำงานเกี่ยวข้องกันไว้ด้วยด้วยกันจะได้ปรับปรุงและแก้ไขง่ายจึ้นเมื่อคลาสมีจำนวนมากขึ้นในอนาคต
```bash
├── ShapeApplication
│   ├── <default package>
│   │   ├── Test.java
│   ├── model.paint
│   │   ├── Paint.java
│   │   ├── Color.java
│   │   ├── ImagePattern.java
│   ├── model.shape
│   │   ├── Shape.java
│   │   ├── Circle.java
│   │   ├── Rectangle.java
│   │   ├── Triangle.java
```

คลาสใหม่

```
Paint<-Color 
Paint<-ImagePattern 
```
<table>
<thead>
  <tr>
    <th >Paint</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>
      -opacity: double</td>
  </tr>
  <tr>
    <td>
      +getOpacity():double<br>
      +setOpacity(opacity: double):void<br>
      +isOpaque(): boolean
      +toString():String
    </td>
</tbody>
</table>

<table>
<thead>
  <tr>
    <th >Color</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>-red:int<br>
        -green:int<br>
        -blue:int<br>
        +static WHITE: Color<br>
        +static BLACK: Color
    </td>
  </tr>
  <tr>
    <td>
      +Color(red: int, green: int, blue: int)<br>
      +getBrightness():double<br>
      -checkColor(color int):int<br> 
      +setColor(red: int, green: int, blue: int)<br>
      +getRed():int<br>
      +getGreen():int<br>
      +getBlue():int<br>
      +getColor():int[]<br>
      +toString():String
    </td>
  </tr>
</tbody>
</table>

<table>
<thead>
  <tr>
    <th >ImagePattern</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>
      -imagePath:String
    </td>
  </tr>
  <tr>
    <td>
      +ImagePattern(imagePath:String)<br>
      +getImagePath():String<br>
      +getHeight():double<br>
      +setImagePath(imagePath:String):void<br>
      +toString():String
    </td>
</tbody>
</table>


เปลี่ยนแปลงที่คลาส Shape ยกหน้าที่ในการจัดการสีให้ Paint แล้วเอา Paint มาเป็นองค์ประกอบของตัวเองเหมือน attribute ทั่วไป 
```java
public abstract class Shape {
    private Paint bgPaint;
    private Paint linePaint;

    public Shape() {
        this.bgPaint=Color.WHITE;
        this.linePaint=Color.BLACK;
    }
    
```
เปลี่ยนแปลงที่คลาสลูกของ Shape ไม่ให้มีส่วนเกี่ยวข้องกับสี

```public Circle(double radius```~~, int[] color~~```){```<br>
```  ```~~super(color);~~<br>```  this.setRadius(radius);```<br>```}```

การเปลี่ยนแปลงการใชงานที่ Test.java จะต้องกำหนดสีใหม่หากไม่เป็นไปตามค่าเริ่มต้น

```java
        Shape[] shapes = new Shape[3];
        shapes[0] = new Circle(15);
        shapes[0].setColor(new Color(35,700,-3));
        shapes[1] = new Rectangle(15,3);
        shapes[1].setColor(Color.GREEN);
        shapes[2] = new Triangle(3,4,5);
```