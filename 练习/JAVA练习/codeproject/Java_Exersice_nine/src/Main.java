

public class Main {
    public static void main(String[] args) {

// 调用showSalary方法，给可变参数传入散列值
        showSalary("开发部", 1987, 2001, 2005);
// 调用showSalary方法，给可变参数传入数组
        showSalary("测试部", new double[]{2009, 1888});
    }

    // salary定义为可变参数
    public static void showSalary(String dname, double... salary) {
        double sum = 0;
        if (salary != null && salary.length > 0) {
            for (int i = 0; i < salary.length; i++) {
                sum += salary[i];
            }
        }
        System.out.printf("%s部门的平均薪资是%.2f", dname, sum /
                salary.length);
    }
}