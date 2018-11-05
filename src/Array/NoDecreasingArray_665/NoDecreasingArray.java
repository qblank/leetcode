package Array.NoDecreasingArray_665;

/**
 * @author evan_qb
 * @date 2018/9/6
 * 665.非递减数列
 * 给定一个长度为 n 的整数数组，你的任务是判断在最多改变 1 个元素的情况下，该数组能否变成一个非递减数列。
 * 我们是这样定义一个非递减数列的： 对于数组中所有的 i (1 <= i < n)，满足 array[i] <= array[i + 1]。
 * 示例 1:
 * 输入: [4,2,3]
 * 输出: True
 * 解释: 你可以通过把第一个4变成1来使得它成为一个非递减数列。
 *
 * 示例 2:
 * 输入: [4,2,1]
 * 输出: False
 * 解释: 你不能在只改变一个元素的情况下将其变为非递减数列。
 * 说明:  n 的范围为 [1, 10,000]。
 */
public class NoDecreasingArray {
    public static void main(String[] args) {
        int[] nums = {4,2,1,5};
        boolean flag = checkPossibility(nums);
        System.out.println(flag);
    }

    /**
     * 思路
     *  判断前一个数是否大于后一个数
     *  如果大于给(修改次数)count+1,判断需要改前面的值，还是需要改
     *  后面的值:
     *  i - 2 < 0肯定改前面的值，后面的改不了
     *  当i - 2 > 0 && nums[i - 2] <= nums[i]当前面一位数大于后面一位数，
     *  但前面第二位数小于这个数，这时候需要修改前面那一位数，
     *  即 4 2 5，当4 > 2且4 <= 5时，此时就应该修改2的值（前面的值）
     *
     * 当不满足前面两个条件，则修改后面的值
     * 4 5 3: i = 2 时，nums[i - 1] > nums[i]且 num[i - 2] > nums[i] ：4 > 3
     *  修改3,即nums[i] = nums[i - 1]
     *
     *  最后判断count（修改次数）是否小于等于1,满足返回true，否则返回false
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length && count <= 1; i++) {
            if (nums[i - 1] > nums[i]){
                count++;
                if (i - 2 < 0 || nums[i - 2] <= nums[i]){
                    nums[i - 1] = nums[i];
                }else{
                    nums[i] = nums[i - 1];
                }
            }
        }
        return count <= 1;
    }


}
