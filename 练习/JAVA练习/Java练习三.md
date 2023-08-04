## 输出直角三角形

```java
package exer;

/*
 * @author:Lwj;
 * @data: 3/8/2023;
 */

public class ForFor {
    public static void main(String[] args) {
for(int i = 1;i <= 6;i++){
            for(int n = 1;n <= i; n++ ) {
                System.out.print("* ");
            };
            System.out.println();
        };
        };
    }
```



![image-20230803191418355](https://liwenj-typ-img.oss-cn-beijing.aliyuncs.com/oss/image-20230803191418355.png)

##  输出九九乘法表

```java
package exer;

/*
 * @author:Lwj;
 * @data: 3/8/2023;
 */

public class ForFor {
    public static void main(String[] args) {
for (int i = 1; i <= 9; i++) {

            for (int j = 1; j <= i; j++) {
                System.out.print(  i + "x" + j + "=" + i * j  + '\t');
            }
            System.out.println();
    };
   };
}
```



![image-20230803191001086](https://liwenj-typ-img.oss-cn-beijing.aliyuncs.com/oss/image-20230803191001086.png)



## 输出正三角形

```java
package exer;

/*
 * @author:Lwj;
 * @data: 3/8/2023;
 */

public class Graph {
    public static void main(String [] args){
         // Scanner sc = new Scanner(System.in);
        int n = 7;
        for(int row = 1; row <= n; row++ ){
            for(int blank = 1; blank <= n - row ; blank++){
                System.out.print("  ");
            }
            for(int s = 1; s <= 2 * row - 1;s++){
                System.out.print("* ");
            }
            System.out.println();
        }
    }
}

```

![image-20230803201302129](https://liwenj-typ-img.oss-cn-beijing.aliyuncs.com/oss/image-20230803201302129.png)



## 输出菱形

```java
package exer;

/*
 * @author:Lwj;
 * @data: 3/8/2023;
 */

public class Graph {
    public static void main(String[] args) {
        // Scanner sc = new Scanner(System.in);
        int n = 7;

        for (int row = 1; row <= n; row++) {
            for (int j = 1; j <= n - row; j++) {
                System.out.print("  ");
            }
            for (int s = 1; s <= 2 * row - 1; s++) {
                System.out.print("* ");
            }
            System.out.println();
        }
             for (int row = n - 1; row >= 1; row--) {
                 for (int j = 1; j <= n - row; j++){
                       System.out.print("  ");
            }
                 for (int s = 1; s <= 2 * row - 1; s++) {
                       System.out.print("* ");
                }
                System.out.println();
            }
        };
    }

```

![image-20230803203820242](https://liwenj-typ-img.oss-cn-beijing.aliyuncs.com/oss/image-20230803203820242.png)



## 圣诞树

```java
package exer;

/*
 * @author:Lwj;
 * @data: 3/8/2023;
 */

public class GraphSDS {
    public static void main(String [] args){
        int n = 3;
        int m = 4;
        int z = 5;

        for(int row = 1;row <=3;row++ ){
            for(int j = 1;j <= n - row + 3;j++ ){
                System.out.print("  ");
            }
            for(int i = 1;i <= 2 * row - 1 ; i++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int row = 1;row <= 4;row++){
            for(int j = 1;j <= m - row + 1;j++){
                System.out.print("  ");
            }
            for(int i = 1 ;i <= 2 * row + 1 ; i++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int row = 1;row <= 5;row++){
            for(int j = 1;j <= z - row;j++){
                System.out.print("  ");
            }
            for(int i = 1 ;i <= 2 * row + 1 ; i++){
                System.out.print("* ");
            }
            System.out.println();
        }

        for(int row = 1;row <= 4;row++){
            for(int j = 1;j <= 4;j++){
                System.out.print("  ");
            }
            for(int i = 1 ;i <= 3 ; i++){
                System.out.print("# ");
            }
            System.out.println();
        }

    }
}

```



![image-20230803210130502](https://liwenj-typ-img.oss-cn-beijing.aliyuncs.com/oss/image-20230803210130502.png)

























