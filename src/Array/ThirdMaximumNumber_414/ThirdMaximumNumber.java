package Array.ThirdMaximumNumber_414;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/9/4
 * 414.第三大的数
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。
 * 示例 1:
 * 输入: [3, 2, 1]
 * 输出: 1
 * 解释: 第三大的数是 1.
 *
 * 示例 2:
 * 输入: [1, 2]
 * 输出: 2
 * 解释: 第三大的数不存在, 所以返回最大的数 2 .
 *
 * 示例 3:
 * 输入: [2, 2, 3, 1]
 * 输出: 1
 * 解释: 注意，要求返回第三大的数，是指第三大且唯一出现的数。
 * 存在两个值为2的数，它们都排第二。
 *
 */
public class ThirdMaximumNumber {
    public static void main(String[] args) {
        int[] nums = {9,-1};
        int result = thirdMax(nums);
        System.out.println(result);
    }

    /**
     * 思路:本题的关键在于先初始化一个数组中不存在的值，当没有第三大数，就直接取最大的值
     * @param nums
     * @return
     */
    public static int thirdMax(int[] nums) {
        long max = Long.MIN_VALUE,secondMax = Long.MIN_VALUE,thirdMax = Long.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max){
                thirdMax = secondMax;
                secondMax = max;
                max = nums[i];
            }else if (nums[i] > secondMax && nums[i] < max){
                thirdMax = secondMax;
                secondMax = nums[i];
            }else if (nums[i] > thirdMax && nums[i] < secondMax){
                thirdMax = nums[i];
            }
        }
        return (int) (thirdMax ==  Long.MIN_VALUE ? max : thirdMax);
    }
}
