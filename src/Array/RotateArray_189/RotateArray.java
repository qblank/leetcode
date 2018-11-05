package Array.RotateArray_189;

import java.util.Arrays;
import java.util.Stack;

/**
 * @author evan_qb
 * @date 2018/8/31 10:35
 * 189. 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5,6,7] 和 k = 3
 * 输出: [5,6,7,1,2,3,4]
 * 解释:
 * 向右旋转 1 步: [7,1,2,3,4,5,6]
 * 向右旋转 2 步: [6,7,1,2,3,4,5]
 * 向右旋转 3 步: [5,6,7,1,2,3,4]
 *
 * 示例 2:
 * 输入: [-1,-100,3,99] 和 k = 2
 * 输出: [3,99,-1,-100]
 * 解释:
 * 向右旋转 1 步: [99,-1,-100,3]
 * 向右旋转 2 步: [3,99,-1,-100]
 * 说明:
 *
 * 尽可能想出更多的解决方案，至少有三种不同的方法可以解决这个问题。
 * 要求使用空间复杂度为 O(1) 的原地算法。
 */
public class RotateArray {
    public static void main(String[] args) {
        int[] nums = {1};
        new RotateArray().rotate(nums,0);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 思路：写一个交换并将索引移位的方法
     * @param nums
     * @param k
     */
    public void rotate(int[] nums, int k) {
        //当num.length < k时，只需移动k % nums.length即可
        // 例如:k = 5,nums.length = 4, 5 % 4 = 1
        //则 只需移动1位即可

        //当num.length > k时， k % nums.length 等于k,
        //例如 5 % 9 = 5
        //仍然需要移动5位
        k %= nums.length;
        //例如: 1 2 3 4 5 6 7  k = 3
        //第一次将整体全部反转 例如: 7 6 5 4 3 2 1
        reverse(nums,0,nums.length - 1);
        //第二次反转0~k-1的位置  5 6 7 4 3 2 1
        reverse(nums,0,k - 1);
        //第三次反转k ~ 最后一位  5 6 7 1 2 3 4
        reverse(nums,k,nums.length - 1);
    }

    /**
     * 反转
     */
    public void reverse(int[] nums,int start,int end){
        while (start < end){
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            end--;
            start++;
        }
    }
}
