/**
 * ### 题目3
 *
 * 给你一个整数数组 `nums` 和一个整数 `k` ，判断数组中是否存在两个 **不同的索引** `i` 和 `j` ，满足 `nums[i] == nums[j]` 且 `abs(i - j) <= k` 。如果存在，返回 `true` ；否则，返回 `false` 。
 *
 * **示例 1：**
 *
 * ```
 * 输入：nums = [1,2,3,1], k = 3
 * 输出：true
 * ```
 *
 * **示例 2：**
 *
 * ```
 * 输入：nums = [1,0,1,1], k = 1
 * 输出：true
 * ```
 *
 * **示例 3：**
 *
 * ```
 * 输入：nums = [1,2,3,1,2,3], k = 2
 * 输出：false
 * ```
 *
 *
 * @author:nanzhou
 * @date:
 */
public class Demo3 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        System.out.println(jude(nums, k));

    }

    private static Boolean jude(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                int temp = i - j;
                temp = Math.abs(temp);
                if (nums[i] == nums[j] && temp <= k) {
                    return true;
                }
            }
        }
        return false;
    }
}
