package lico;


import java.util.Arrays;

/**
 * @title:
 * @author:nanzhou
 * @date:
 */
public class Demo02 {
    public static void main(String[] args) {
        int[] n ={1,3};
        int [] m= {2,4};
        findMedianSortedArrays(m,n);


    }
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {

            int[] temp = new int[nums1.length+nums2.length];
            System.arraycopy(nums1,0,temp,0,nums1.length);
            System.arraycopy(nums2,0,temp,nums1.length,nums2.length);
            temp= Arrays.stream(temp).sorted().toArray();
            double n;
            if (temp.length%2==0){
                n =((double)temp[temp.length / 2] + (double)(temp[temp.length / 2 - 1]))/2;
            }else {
                n = (double)temp[temp.length / 2];
            }

            return n;
        }
}
