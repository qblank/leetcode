package Array.ShortestUnsortedContinuousSubarray_581;

/**
 * @author evan_qb
 * @date 2018/9/5
 * 581.最短无序连续子数组
 * 给定一个整数数组，你需要寻找一个连续的子数组，如果对这个子数组进行升序排序，那么整个数组都会变为升序排序。
 * 你找到的子数组应是最短的，请输出它的长度。
 *
 * 示例 1:
 * 输入: [2, 6, 4, 8, 10, 9, 15]
 * 输出: 5
 * 解释: 你只需要对 [6, 4, 8, 10, 9] 进行升序排序，那么整个表都会变为升序排序。
 *
 * 说明 :
 * 1.输入的数组长度范围在 [1, 10,000]。
 * 2.输入的数组可能包含重复元素 ，所以升序的意思是<=。
 *
 */
public class ShortestUnsortedContinuousSubarray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 3};
        int result = findUnsortedSubarray(nums);
        System.out.println(result);
    }

    /**
     * 思路:
     * 给定min和max,min右边两两取最小，max左边两两取最大，
     * end从左往右走，start从右往左走
     * 当num[i] < max时，索引赋值给end,
     * 当num[len - i -1] > min时，索引赋值给start
     * @param nums
     * @return
     */
    public static int findUnsortedSubarray(int[] nums) {
        int len = nums.length;
        int start = -1,end = -2,min = nums[len - 1],max = nums[0];
        for (int i = 0; i < len; i++) {
            max = Math.max(max,nums[i]);
            min = Math.min(min,nums[len - i -1]);
            if (nums[i] < max){
                end = i;
            }
            if (nums[len - 1 - i] > min){
                start = len - i - 1;
            }
        }
        return end - start + 1;
    }


}
