package Array.LongestContinuousIncreasingSubsequence_674;

import java.util.Map;

/**
 * @author evan_qb
 * @date 2018/9/18'
 * 674.最长连续递增序列
 *
 * 给定一个未经排序的整数数组，找到最长且连续的的递增序列。
 * 示例 1:
 * 输入: [1,3,5,4,7]
 * 输出: 3
 * 解释: 最长连续递增序列是 [1,3,5], 长度为3。
 * 尽管 [1,3,5,7] 也是升序的子序列, 但它不是连续的，因为5和7在原数组里被4隔开。
 *
 * 示例 2:
 * 输入: [2,2,2,2,2]
 * 输出: 1
 * 解释: 最长连续递增序列是 [2], 长度为1。
 * 注意：数组长度不会超过10000。
 */
public class LongestContinuousIncreasingSubsequence {
    public static void main(String[] args) {
        int[] nums = {2,2,2};
        int result = findLengthOfLCIS(nums);
        System.out.println(result);
    }

    /**
     * 思路:
     * 先遍历数组,判断是否递增，如果没有递增，计数为1
     * 反之递增，count+1,将count与result（统计长度最大值）比较取大值
     * @param nums
     * @return
     */
    public static int findLengthOfLCIS(int[] nums) {
        int count = 0,result = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] > nums[i - 1] ){
                result = Math.max(result,++count);
            }else{
                count = 1;
            }
        }
        return result;
    }


}
