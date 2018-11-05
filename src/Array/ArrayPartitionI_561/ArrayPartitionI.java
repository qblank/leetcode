package Array.ArrayPartitionI_561;

import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/9/5
 * 561.数组拆分I
 * 给定长度为 2n 的数组, 你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ...,
 * (an, bn) ，使得从1 到 n 的 min(ai, bi) 总和最大。
 * 示例 1:
 * 输入: [1,4,3,2]
 *
 * 输出: 4
 * 解释: n 等于 2, 最大总和为 4 = min(1, 2) + min(3, 4).
 *
 * 提示:
 * 1.n是正整数,范围在 [1, 10000].
 * 2.数组中的元素范围在 [-10000, 10000].
 *
 */
public class ArrayPartitionI {
    public static void main(String[] args) {
        int[] nums = {2,4,5,3};
        int result = arrayPairSum(nums);
        System.out.println(result);
    }

    /**
     * 思路:
     * 先找规律，发现升序排列的时候，下标为偶数的相加可以满足条件
     * 先对其进行排序，然后将所有下标为偶数的进行相加
     * @param nums
     * @return
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
