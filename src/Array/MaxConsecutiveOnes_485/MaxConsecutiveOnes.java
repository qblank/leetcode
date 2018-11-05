package Array.MaxConsecutiveOnes_485;

/**
 * @author evan_qb
 * @date 2018/9/4
 * 485. 最大连续1的个数
 * 给定一个二进制数组， 计算其中最大连续1的个数。
 *
 * 示例 1:
 * 输入: [1,1,0,1,1,1]
 * 输出: 3
 * 解释: 开头的两位和最后的三位都是连续1，所以最大连续1的个数是 3.
 * 注意：
 * 输入的数组只包含 0 和1。
 * 输入数组的长度是正整数，且不超过 10,000。
 */
public class MaxConsecutiveOnes {
    public static void main(String[] args) {
        int[] nums = {1,1,0,1,1,1};
        int result = findMaxConsecutiveOnes2(nums);
        System.out.println(result);
    }

    /**
     * 思路:
     * for循环遍历，判断是否为1，如果为1，count++
     * 否则令count = 0,重新计数
     * 判断count是否大于max,如果大于将其赋值给max
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes1(int[] nums) {
        int count = 0,max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1){
                count++;
            }else{
                count = 0;
            }
            max = Math.max(count,max);
        }
        return max;
    }

    /**
     * 方法二:
     * @param nums
     * @return
     */
    public static int findMaxConsecutiveOnes2(int[] nums){
        int maxHere = 0, max = 0;
        for (int num : nums)
            max = Math.max(max, maxHere = num == 0 ? 0 : maxHere + 1);
        return max;
    }
}
