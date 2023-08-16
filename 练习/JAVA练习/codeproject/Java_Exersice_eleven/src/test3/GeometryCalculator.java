package test3;

/**
 * @title:几何图形计算器
 * @author:nanzhou
 * @date:2023.8.16
 */
/*## 几何图形计算器 设计一个几何图形计算器，可以计算圆的面积和矩形的面积。

创建名为 GeometryCalculator 的类，

包含以下实例方法：

calculateCircleArea(double radius) ：计算并返回圆的面积

calculateRectangleArea(double width, double height) ：计算并返回矩形的面积

完成计算圆的面积以及计算矩形的面积等功能。*/
public class GeometryCalculator {
    public double calculateCircleArea(double radius) {
        return Math.PI * Math.pow(radius, 2);
    }

    public double calculateRectangleArea(double width, double height) {
        return width * height;
    }

}
