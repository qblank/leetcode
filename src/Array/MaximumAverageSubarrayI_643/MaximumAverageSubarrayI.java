package Array.MaximumAverageSubarrayI_643;

/**
 * @author evan_qb
 * @date 2018/9/6
 * 643.子数组最大平均数I
 * 给定 n 个整数，找出平均数最大且长度为 k 的连续子数组，并输出该最大平均数。
 * 示例 1:
 * 输入: [1,12,-5,-6,50,3], k = 4
 * 输出: 12.75
 * 解释: 最大平均数 (12-5-6+50)/4 = 51/4 = 12.75
 * 注意:
 * 1. 1 <= k <= n <= 30,000。
 * 2. 所给数据范围 [-10,000，10,000]。
 */
public class MaximumAverageSubarrayI {
    public static void main(String[] args) {
        int[] nums = {1,12,-5,-6,50,3};
        double result = findMaxAverage(nums, 4);
        System.out.println(result);
    }

    /**
     * 思路:
     * 索引从0开始，依次加k个数，如果大于，就减去之前第一个数
     * 关键点： 一直开始加的话，当个数大于k时，注意减去第一个数
     * @param nums
     * @param k
     * @return
     */
    public static double findMaxAverage(int[] nums, int k) {
        double sum = 0,maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            //如果i > k，将直接相加的减去
            if (i - k >= 0) sum -= nums[i - k];
            if (i >= k - 1){
                maxSum = Math.max(sum,maxSum);
            }
        }
        return maxSum / k;
    }
}
