# Java递归

## 定义

递归是指一个方法或函数在执行过程中调用自身的过程。

## 使用

递归函数通常分为两部分：基础情况和递归情况。

### 基本情况

基本情况是指问题可以直接解决的情况，通常是递归函数的终止条件，避免无线递归。

### 递归情况

递归情况是指问题需要进一步分解才能解决的情况，通常是递归函数中调用自身的部分。

## 注意事项

- 递归一定要有条件限定，保证递归能够停止下来，否则会形成死循环并发生栈内存溢出（`StackOverflowError`）。
- 递归中虽然限定了停止下来的条件，但是递归次数不能太多，否则也会发生栈内存溢出。
- 禁止构造方法递归。

## 实例

```java
/**
 * 递归练习：使用递归计算1-100的累加和
 *
 * @author zhuhuix
 * @date 2020-05-31
 */
public class AddRecursion {
    public static void main(String[] args) {
        System.out.println(sum(100));
    }

    public static int sum(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n + sum(n - 1);
        }
    }
}

```

