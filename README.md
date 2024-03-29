ชื่อโปรแกรม ManVSFood

ความเป็นมา ManVSFood เป็นแอพพลิเคชั่นที่สร้างขึ้นเพื่อให้ผู้ใช้มีประสบการณ์ในการบันทึกข้อมูล และรีวิวเกี่ยวกับอาหารและเครื่องดื่มต่าง ๆ ที่พบได้ในท้องถิ่นหรือทั่วโลก 
โดยผู้ใช้สามารถเข้าถึงข้อมูลเหล่านี้ได้ทั้งตลอดเวลาและสามารถแบ่งปันประสบการณ์ของตนเองกับผู้ใช้งานคนอื่นได้อีกด้วย

ผู้พัฒนาระบบ  นายวิญญู พรมภิภักดิ์ 643450084-0

แนวคิด ค้นหาและแสดงข้อมูล ผู้ใช้สามารถค้นหาข้อมูลเกี่ยวกับอาหารและเครื่องดื่มต่าง ๆ ได้โดยใช้ระบบค้นหาภายในแอพพลิเคชั่น โดยมีรายการอาหารและเครื่องดื่มทั้งหมดที่มีอยู่ในฐานข้อมูล(ยังทำค้าหาไม่ได้)

เพิ่มข้อมูลใหม่ ผู้ใช้สามารถเพิ่มข้อมูลเกี่ยวกับอาหารและเครื่องดื่มใหม่ลงในระบบได้ โดยระบุชื่อของอาหารหรือเครื่องดื่ม รายละเอียดเกี่ยวกับมัน สถานที่ที่พบได้ และลิงก์ URL สำหรับรูปภาพ

แก้ไขข้อมูล ผู้ใช้สามารถแก้ไขข้อมูลที่มีอยู่แล้วในระบบได้ โดยเปลี่ยนแปลงหรือปรับปรุงข้อมูลชื่อ รายละเอียด สถานที่พบ และลิงก์ URL สำหรับรูปภาพ

ลบข้อมูล ผู้ใช้สามารถลบข้อมูลที่ไม่ต้องการในระบบได้ โดยลบออกจากรายการอาหารและเครื่องดื่ม

คุณสมบัติหลัก
1.ระบบค้นหาและแสดงข้อมูล(ยังทำค้าหาไม่ได้)
2.เพิ่มข้อมูลใหม่
3.แก้ไขข้อมูลที่มีอยู่
4.ลบข้อมูลที่ไม่ต้องการ

การใช้งาน Firebase Realtime Database เก็บข้อมูลเกี่ยวกับอาหารและเครื่องดื่มทั้งหมดในฐานข้อมูลใช้ Firebase Authentication เพื่อรับรองความปลอดภัยและการเข้าถึงข้อมูล

![image](https://github.com/Winyu64/My_Project/assets/96216528/16f866d2-1076-4930-9fff-a256d61da726)

การออกแบบ UI/UX ที่ใช้งานง่าย
การใช้ภาพและไอคอนที่สร้างสีสันและดึงดูดความ

หน้า Login 
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/MainActivity.kt
รหัส Username คือ 1
รหัส Password คือ 1
![image](https://github.com/Winyu64/My_Project/assets/96216528/0d51dd6d-9e05-4dac-a9db-9ab7c1d7af8a)


หน้า HomePage 
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/HomePageActivity.kt

![image](https://github.com/Winyu64/My_Project/assets/96216528/dfbb67c1-45d0-4046-8ff4-6250998afc9b)


หน้า ManVSFood 
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/ManVSFoodActivity.kt

![image](https://github.com/Winyu64/My_Project/assets/96216528/aeb681f6-b636-44f5-b5b4-c9fb5d811e28)


หน้า AddFood 
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/AdapterFood.java

![image](https://github.com/Winyu64/My_Project/assets/96216528/83bcd307-c26f-4573-a8fc-7c289abcfb98)


หน้า EditFood 
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/MainFoodModel.java

![image](https://github.com/Winyu64/My_Project/assets/96216528/1d73974c-a46f-45bc-8067-9ff2d3345def)


หน้า DeleteFood 
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/MainFoodModel.java

![image](https://github.com/Winyu64/My_Project/assets/96216528/4014f2fb-f671-45d3-9e56-f2738411e03c)


หน้า ManVSDrink
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/ManVSDrinkActivity.kt

![image](https://github.com/Winyu64/My_Project/assets/96216528/d7285177-c0c6-47b2-bb1c-4557d8500679)


หน้า AddDrink
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/Adapter.java

![image](https://github.com/Winyu64/My_Project/assets/96216528/9fea1029-8c83-4adc-a370-a63fd103b50a)


หน้า EditDrink
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/MainModel.java

![image](https://github.com/Winyu64/My_Project/assets/96216528/14b867f7-d879-4224-8575-5cc6fc7a2f43)


หน้า DeleteDrink
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/MainModel.java

![image](https://github.com/Winyu64/My_Project/assets/96216528/f24e9184-d10c-497d-b23a-0dd88923e78f)


หน้า Settings
https://github.com/Winyu64/My_Project/blob/main/app/src/main/java/th/ac/kku/cis/my_project/SettingsActivity.kt

![image](https://github.com/Winyu64/My_Project/assets/96216528/5705dc0a-a321-4065-a936-49d9bf376ef1)


หน้า LogOut

![image](https://github.com/Winyu64/My_Project/assets/96216528/f5f1d3a6-a6c1-4bb3-95b9-5e07575294fd)

