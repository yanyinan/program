import java.util.Arrays;

/**
 * @title:根据科目降序排名
 * @author:nanzhou
 * @date:2023.8.14
 */
public class Examtest4 {
    public static void arr(String[] names,int[][] scores,int n){
        for (int i = 0; i < scores.length; i++) {
            String temp_names = names[i];
            int temp_scores = scores[i][n];
            int[] temp = scores[i];
            int preIndex = i-1;
            while (preIndex >=0&& scores[preIndex][n] < temp_scores ){
                scores[preIndex+1] = scores[preIndex];
                names[preIndex+1] = names[preIndex];
                preIndex--;
            }
            scores[preIndex+1] = temp;
            names[preIndex+1] = temp_names;
        }
//        System.out.println(Arrays.toString(scores));
    }
    public static void main(String[] args) {
        String[] names = {"1","2","3"};
        int[][] scores = {
                {1,2,3},
                {1,3,2},
                {3,1,1}
        };
        arr(names,scores,1);
        for (int i = 0; i < names.length; i++) {
            System.out.print(names[i]+"\t");
            for (int j = 0; j < scores[i].length; j++) {
                System.out.printf(scores[i][j]+"\t");
            }
            System.out.println();
        }
    }
}
