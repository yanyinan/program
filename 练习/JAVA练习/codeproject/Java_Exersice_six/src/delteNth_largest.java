import java.util.Arrays;
import java.util.Scanner;

/**
 * @title:delteNth_largest
 * @author:nanzhou
 * @date:2023.8.8
 */
public class delteNth_largest {
    public static void main(String[] args) {
        int[] arr = {2, 3, 1, 8, 3, 9, 6};
        System.out.println(Arrays.toString(arr));
        int[] arr2 = Arrays.copyOfRange(arr,0,arr.length-1);
        for (int i = 1; i < arr2.length; i++) {
            int temp = arr[i];
            int j = i - 1;
            while (j >= 0 && temp > arr2[j]) {
                arr2[j + 1] = arr2[j];
                j--;
            }
            arr2[j + 1] = temp;
        }
        Scanner input = new Scanner(System.in);
        int i =0,index =input.nextInt() - 1;
        while (i < arr.length){
            if (arr[i]==arr2[index]){
                arr[i] = 0;
            }
            i++;
        }
        System.out.println(Arrays.toString(arr));
        input.close();
    }
}
