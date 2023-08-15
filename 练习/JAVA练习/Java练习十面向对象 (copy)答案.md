# 面向对象练习

## 找对象

以下名词中哪些是对象？

- [ ] 猫
- [ ] 狗
- [x] Tom
- [x] Jerry
- [ ] 人
- [ ] 帅哥
- [ ] 美女
- [x] 迪丽热巴
- [x] 胡歌
- [ ] Phone
- [x] iPhone 14 Pro Max
- [x] 《Java面向对象》



## 编程

**1、**编写一个Student类，包含name、gender、age、id、score属性，分别为String、String、int、int、double类型。类中声明一个say方法，返回String类型，方法返回信息中包含所有属性值。在另一个`StudentTest`类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用结果打印输出

~~~java
/**
 * @title:编程
 * @author:nanzhou
 * @date:2023.8.15
 */

/***1、**编写一个Student类，包含name、gender、age、id、score属性，
 * 分别为String、String、int、int、double类型。类中声明一个say方法，
 * 返回String类型，方法返回信息中包含所有属性值。在另一个`StudentTest`
 * 类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用
 * 结果打印输出*/
public class Student {
    String name;
    String gender;
    int age;
    int id;
    double score;

    public String say() {
        return "名字"+name +"\t性别"+gender +"\t年龄"+ age +"\t编号"+ id +"\t分数"+ score;
    }
}

~~~

```java
/**
 * @title:编程
 * @author:nanzhou
 * @date:2023.8.15
 */

/***1、**编写一个Student类，包含name、gender、age、id、score属性，
 * 分别为String、String、int、int、double类型。类中声明一个say方法，
 * 返回String类型，方法返回信息中包含所有属性值。在另一个`StudentTest`
 * 类中的main方法中，创建Student对象，并访问say方法和所有属性，并将调用
 * 结果打印输出*/
public class Student_test {
    public static void main(String[] args) {
        Student studentTest = new Student();
        System.out.println(studentTest.say());
    }
}

```

**2、**定义一个女朋友类（`GirlFriend`）女朋友的属性包含：姓名，身高，体重。行为包含：洗衣服wash()，做饭cook()。另外定义一个用于展示三个属性值的show()方法。请在测试类中通过有参构造方法创建对象并赋值，然后分别调用展示方法、洗衣服方法和做饭方法。打印效果如下：

	我女朋友叫凤姐,身高155.0厘米,体重130.0斤
	
	女朋友帮我洗衣服
	
	女朋友给我做饭



~~~java
/**
 * @title:编程
 * @author:nanzhou
 * @date:2023.8.15
 */
/*定义一个女朋友类（`GirlFriend`）女朋友的属性包含：姓名，身高，体重。行为包含：
洗衣服wash()，做饭cook()。另外定义一个用于展示三个属性值的show()方法。
请在测试类中通过有参构造方法创建对象并赋值，然后分别调用展示方法、
洗衣服方法和做饭方法。打印效果如下：

 我女朋友叫凤姐,身高155.0厘米,体重130.0斤

 女朋友帮我洗衣服

 女朋友给我做饭*/
    
 public class GirlFriend {
    String name;
    double high;
    double wight;
    public GirlFriend(String name,double high, double wight){
        this.name = name;
        this.high = high;
        this.wight = wight;
    }
    public void wash(){
        System.out.println("女朋友帮我洗衣服");
    }
    public void cook(){
        System.out.println("女朋友帮我洗衣服");
    }
    public void show(){
        System.out.printf("我女朋友叫%s,身高%.1f厘米,体重%.1f斤\n\n",name,high,wight);
    }

}

~~~

```java
/**
 * @title:编程
 * @author:nanzhou
 * @date:2023.8.15
 */
/***2、**定义一个女朋友类（`GirlFriend`）女朋友的属性包含：姓名，身高，体重。行为包含：洗衣服wash()，做饭cook()。另外定义一个用于展示三个属性值的show()方法。请在测试类中通过有参构造方法创建对象并赋值，然后分别调用展示方法、洗衣服方法和做饭方法。打印效果如下：

 我女朋友叫凤姐,身高155.0厘米,体重130.0斤

 女朋友帮我洗衣服

 女朋友给我做饭

 * */
public class GirlFriend_test {
    public static void main(String[] args) {
        GirlFriend girlFriend = new GirlFriend("凤姐",155,130);
        girlFriend.show();
        girlFriend.wash();
        girlFriend.cook();
    }
}

```

**3、**定义猫类Cat。属性:毛的颜色color，品种breed。行为:吃饭eat()，抓老鼠catchMouse()

定义狗类Dog。属性:毛的颜色color，品种breed。行为:吃饭()，看家()

要求：

    1.按照以上要求定义Cat类和Dog类,属性要私有,生成无参、有参构造 
    
    2.定义测试类,在main方法中创建该类的对象并给属性赋值
    
    3.调用成员方法,打印格式如下:
    
    花色的波斯猫正在吃鱼.....
    
    花色的波斯猫正在逮老鼠....
    
    黑色的藏獒正在啃骨头.....
    
    黑色的藏獒正在看家.....



~~~java
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

public class Cat {
    private String color;
    private String breed;

    public Cat() {
        this.color = null;
        this.breed = null;
    }

    public Cat(String color, String breed) {
        this.color = color;
        this.breed = breed;
    }

    public String eat(){
        return color+"的"+breed+"正在吃鱼.....";
    }
    public String catchMouse(){
        return color+"的"+breed+"正在逮老鼠....";
    }
}

~~~

```java
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

```

```java
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

public class Cat_Dog_test {
    public static void main(String[] args) {
        Cat cat = new Cat("花色","波斯猫");
        Dog dog = new Dog("黑色","藏獒");
        System.out.println(cat.eat());
        System.out.println(cat.catchMouse());
        System.out.println(dog.eat());
        System.out.println(dog.watchHome());
    }
}

```

