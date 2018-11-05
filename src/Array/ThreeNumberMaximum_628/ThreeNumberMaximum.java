package Array.ThreeNumberMaximum_628;

import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/9/6
 * 628.三个数的最大乘积
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: 6
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: 24
 *
 * 注意:
 * 1.给定的整型数组长度范围是[3,104]，数组中所有的元素范围是[-1000, 1000]。
 * 2.输入的数组中任意三个数的乘积不会超出32位有符号整数的范围。
 */
public class ThreeNumberMaximum {
    public static void main(String[] args) {
        int[] nums = {-4,5,1,7,2,3};
        int result = maximumProduct2(nums);
        System.out.println(result);
    }

    /**
     * 方法一
     * 思路:
     * 先排序再乘
     * @param nums
     * @return
     */
    public static int maximumProduct1(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        int t = Math.max(nums[0] * nums[1],nums[len - 2] * nums[len - 3]);
        return nums[len - 1] * t;
    }

    /**
     * 方法二:类似于题目:414求第三大数
     * 依次找出第一~三大的数字和第一第二小的数字
     * 判断第一大的数字 * 最小的两个数字之积  和 第一大数字 * 第二大和第三大数字之积
     * 谁大取谁
     * @param nums
     * @return
     */
    public static int maximumProduct2(int[] nums) {
        int max1 = Integer.MIN_VALUE,max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE,
                min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
        for (int num : nums){
            //求最大的三个数
            if (num > max1){
                max3 = max2;
                max2 = max1;
                max1 = num;
            }else if (num > max2){
                max3 = max2;
                max2 = num;
            }else if (num > max3){
                max3 = num;
            }
            //求最小的两个数
            if (num < min1){
                min2 = min1;
                min1 = num;
            }else if (num < min2){
                min2 = num;
            }
        }
        return max1 * Math.max(max2 * max3,min1 * min2);
    }
}
