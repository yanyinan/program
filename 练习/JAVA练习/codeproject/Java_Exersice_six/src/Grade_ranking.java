

/**
 * @title:Grade_ranking
 * @author:nanzhou
 * @date:2023.8.8
 */
//##  成绩排名
//一个班级有若干学生，每个学生的成绩以整数表示。
//请实现一个程序，根据学生的成绩对 他们进行排名并输出。
public class Grade_ranking {
    public static void main(String[] args) {

        int[] arr = {1, 6, 7, 8,2, 3, 4, 5, 9, 10};

        for (int i = 1; i < arr.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr[j]) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = temp;
        }
        for (int i = -1;i <arr.length ;i++){
            if (i < 0 ){System.out.println("排名\t成绩");}
            else {
                System.out.println(i+1 +"\t" + arr[i]);
            }
        }
    }
}
