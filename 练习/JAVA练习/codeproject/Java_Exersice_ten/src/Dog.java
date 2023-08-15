/**
 * @title:编程
 * @author:nanzhou
 * @date:2023.8.15
 */
//**3、**定义猫类Cat。属性:毛的颜色color，品种breed。行为:吃饭eat()，抓老鼠catchMouse()
//
//        定义狗类Dog。属性:毛的颜色color，品种breed。行为:吃饭()，看家()
//
//        要求：
//
//        1.按照以上要求定义Cat类和Dog类,属性要私有,生成无参、有参构造
//
//        2.定义测试类,在main方法中创建该类的对象并给属性赋值
//
//        3.调用成员方法,打印格式如下:
//
//        花色的波斯猫正在吃鱼.....
//
//        花色的波斯猫正在逮老鼠....
//
//        黑色的藏獒正在啃骨头.....
//
//        黑色的藏獒正在看家.....

public class Dog {
    private String color;
    private String breed;

    public Dog() {
        this.color = null;
        this.breed = null;
    }

    public Dog(String color, String breed) {
        this.color = color;
        this.breed = breed;
    }

    public String eat(){
        return color+"的"+breed+"正在啃骨头.....";
    }
    public String watchHome(){
        return color+"的"+breed+"正在看家.....";
    }
}
