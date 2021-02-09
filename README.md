# ShapeApplication

## สารบัญ 
* ก้าวที่ 1 Class-Object <br>
https://github.com/praisan/ShapeApplication/tree/1fcdcefc1eefb93f56cf293d3c1b8b0565b3c7a3

* ก้าวที่ 2 การตรวจสอบเพื่อป้องกันความผิดพลาดจากการใช้งาน <br>
https://github.com/praisan/ShapeApplication/tree/dc0df02dcc6b6a1ff95e99dc2c0878f8f68e2e33

# เรื่องราวการออกแบบ
## ก้าวที่ 1 Class-Object

https://github.com/praisan/ShapeApplication/tree/1fcdcefc1eefb93f56cf293d3c1b8b0565b3c7a3

ปิติ ต้องการออกแบบโปรแกรมสำหรับไว้ใช้ในการวาดรูปทรงต่าง ๆ
แต่ละรูปทรงสามารถเติมสีได้ รวมถึงสามารถคำนวณพื้นที่ และเส้นรอบรูปได้
และอาจมีการคำนาณคุณสมบัติอื่นของรูปทรงนั้น ๆ

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
      -> เอาไว้สร้าง object วงกลมตามรัศมีที่กำหนด และจะใส่สีดำที่พื้นหลังเป็นสีดำ [0,0,0] <br>
      -> เอาไว้สร้าง object วงกลมตามรัศมีที่กำหนด และจะใส่สีดำที่พื้นหลังตามที่ระบุ <br>
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

## ก้าวที่ 2 การตรวจสอบเพื่อป้องกันความผิดพลาดจากการใช้งาน

https://github.com/praisan/ShapeApplication/tree/dc0df02dcc6b6a1ff95e99dc2c0878f8f68e2e33

เนื่องจากรัศมีของวงกลมควรมีค่ามากกว่าและเท่ากับ 0 และค่าสีควรมี 3 ค่าเพื่อแทนความสว่างของช่องสัญญาณสีทั้งสาม [Red,Green,Blue] และมีค่าความเข้มสีอยู่ในช่วง 0-255 

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
