# ShapeApplication

ปิติ ต้องการออกแบบโปรแกรมสำหรับไว้ใช้ในการวาดรูปทรงต่าง ๆ
แต่ละรูปทรงสามารถเติมสีได้ รวมถึงสามารถคำนวณพื้นที่ และเส้นรอบรูปได้
และอาจมีการคำนาณคุณสมบัติอื่นของรูปทรงนั้น ๆ

ปิติเริ่มจากออกแบบคลาส Circle ที่สามารถจดสีและรัศมีของวงกลมได้ และสามารถเปลี่ยนแปลงได้ในภายหลังหากต้องการ
นอกจากเส้นรอบวงและพื้นที่แลัวคลาสนี้ยังออกแบบให้สามารถคำนวณหาเส้นผ่านศูนย์กลางของวงกลมได้ด้วย

```mermaid
classDiagram
  class Circle
   Circle : +String owner
   Circle : +BigDecimal balance
   Circle : +deposit(amount)
   Circle : +withdrawal(amount)
   
```mermaid
graph LR

A(Start)

A --> B[Look for an item]

B --> C{Did you find it?}
C -->|Yes| D(Stop looking)
C -->|No| E{Do you need it?}
E -->|Yes| B
E -->|No| D
