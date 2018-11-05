package Array.LargestNumberAtLeastTwice_747;

import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/10/9
 * 747.至少是其他数字两倍的最大数
 * 在一个给定的数组nums中，总是存在一个最大元素 。
 * 查找数组中的最大元素是否至少是数组中每个其他数字的两倍。
 * 如果是，则返回最大元素的索引，否则返回-1。
 * 示例 1:
 * 输入: nums = [3, 6, 1, 0]
 * 输出: 1
 * 解释: 6是最大的整数, 对于数组中的其他整数,
 * 6大于数组中其他元素的两倍。6的索引是1, 所以我们返回1.
 *
 * 示例 2:
 * 输入: nums = [1, 2, 3, 4]
 * 输出: -1
 * 解释: 4没有超过3的两倍大, 所以我们返回 -1.
 * 提示:
 * nums 的长度范围在[1, 50].
 * 每个 nums[i] 的整数范围在 [0, 99].
 */
public class LargestNumberAtLeastTwice {
    public static void main(String[] args) {
        int[] nums = {1};
        int result = dominantIndex(nums);
        System.out.println(result);
    }

    /**
     * 思路:
     * 边比较边找出最大值
     * 找出最大值max和第二大的值temp
     * @param nums
     * @return
     */
    public static int dominantIndex(int[] nums) {
        int max = nums[0],index = 0,temp = -1;
        //先找出第一大和第二大的值
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] > max){
                temp = max;
                max = nums[i];
                index = i;
            }else if (nums[i] > temp){
                temp = nums[i];
            }
        }
        return max >= 2 * temp ? index:-1;
    }
}
