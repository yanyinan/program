package MerchandiseManagement;

import java.util.Scanner;
import java.util.Stack;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */

/**
 * 商品管理
 * 创建一个List集合,添加多个商品名称。实现根据输入查询某个商品是否存在,如果存在则输
 * 出信息。
 */
public class Merchandise {
    public static void main(String[] args) {
        Stack<String> shop = new Stack<>();
        shop.add("苹果");
        shop.add("香蕉");
        shop.add("哈密瓜");
        shop.add("甜橙");
        shop.add("西瓜");
        System.out.println(shop);
        MerchandiSearch(shop);
    }
    static Scanner input  = new Scanner(System.in);
    private static void MerchandiSearch(Stack<String> shop) {
        System.out.println("请输入要查询的商品");
        int flag = shop.indexOf(input.next());
        if ( flag!=-1) {

            System.out.println(shop.get(flag));
        }
    }
}
