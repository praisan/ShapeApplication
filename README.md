# ShapeApplication

ปิติ ต้องการออกแบบโปรแกรมสำหรับไว้ใช้ในการวาดรูปทรงต่าง ๆ
แต่ละรูปทรงสามารถเติมสีได้ รวมถึงสามารถคำนวณพื้นที่ และเส้นรอบรูปได้
และอาจมีการคำนาณคุณสมบัติอื่นของรูปทรงนั้น ๆ

ปิติเริ่มจากออกแบบคลาส Circle ที่สามารถจดสีและรัศมีของวงกลมได้ และสามารถเปลี่ยนแปลงได้ในภายหลังหากต้องการ
นอกจากเส้นรอบวงและพื้นที่แลัวคลาสนี้ยังออกแบบให้สามารถคำนวณหาเส้นผ่านศูนย์กลางของวงกลมได้ด้วย


|                                                                               Circle                                                                             |
|:-----------------------------------------------------------------------------------------------------------------------------------------------------------------:|
| -radius: double<br>-bgColor: int[] |
| +Circle(radius:double)<br>+Circle(radius:double,bgColor: int[<br>+getRadius():double<br>+getDiameter():double<br>+getPerimeter():double<br>+getArea():double<br>+toString():String |  


<table>
<thead>
  <tr>
    <th >Circle</th>
  </tr>
</thead>
<tbody>
  <tr>
    <td>-radius: double<br>-bgColor: int[]</td>
  </tr>
  <tr>
    <td>+Circle(radius:double)<br>+Circle(radius:double,bgColor: int[])<br>+getRadius():double<br>+getDiameter():double<br>+getPerimeter():double<br>+getArea():double<br>+toString():String</td>
  </tr>
</tbody>
</table>
