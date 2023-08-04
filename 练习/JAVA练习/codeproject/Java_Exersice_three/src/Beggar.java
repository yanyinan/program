/**
 * @title:beggar
 * @author:nanzhou
 * @date:2023.8.4
 */
/*## 洪乞丐干10天，收入是多少？
     天朝有一个乞丐姓洪，去天桥要钱
     第一天要了1块钱
     第二天要了2块钱
     第三天要了4块钱
     第四天要了8块钱
     以此类推*/
public class Beggar {
    public static void main(String[] args) {
        int money = 1,
                total_money = 0;
        int days = 10;
        for (int i = 1;i <= days;i++){
            total_money = total_money + money;
            money *=2;
        }
        System.out.println(total_money);
    }
}
