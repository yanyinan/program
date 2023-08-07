import java.util.Scanner;

/**
 * @title:The_judges_score
 * @author:nanzhou
 * @date:2023.8.7
 */
//在唱歌比赛中，有6名评委给选手打分，分数范围是[0 - 100]之间的整数。
//        选手的 最后得分为：去掉最高分、最低分后的4个评委的平均分，
//        请完成上述过程并计算 出选手的得分。
public class The_judges_score {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] arr = new int[5];
        int max = 0,min = 0,sum = 0;
        for (int i = 0; i < arr.length; i++){
            arr[i] = input.nextInt();
            if (max < arr[i]){
                max = arr[i];
            } else if (min > arr[i]) {
                min = arr[i];
            }
            sum += arr[i];
        }
        System.out.println((sum-max-min)/4);
    }
}
