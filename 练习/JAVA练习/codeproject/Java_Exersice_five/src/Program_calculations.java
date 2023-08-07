/**
 * @title:Program_calculations
 * @author:nanzhou
 * @date:2023.08.07
 */
public class Program_calculations {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 5, 6};
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i] *Math.pow(10,(arr.length-i-1));
        }
        System.out.println(sum);
    }
}
