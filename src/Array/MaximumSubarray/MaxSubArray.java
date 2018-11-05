package Array.MaximumSubarray;

/**
 * @author evan_qb
 * @date 2018/8/7 10:47
 * 最大子序和
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 输入: [-2,1,-3,4,-1,2,1,-5,4],
 * 输出: 6
 * 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 *
 * 如果你已经实现复杂度为 O(n) 的解法，尝试使用更为精妙的分治法求解。
 */
public class MaxSubArray {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,-4};
        int result = maxSubArray(nums);
        System.out.println(result);
    }
    /**
     * 方法二
     * @param nums
     * @return
     */
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = nums[0];
        for (int i :nums){
            //判断加上这个值和加之前的大小，变小了则只取本身,否则就取其之和
            sum += i;
            max = Math.max(max,sum);
            if (sum < 0){
                sum = 0;
            }
        }
        return max;
    }
}
