package Array.MajorityElement_169;

/**
 * @author evan_qb
 * @date 2018/8/30 8:56
 * 169. 求众数
 * 给定一个大小为 n的数组，找到其中的众数。众数是指在数组中出现次数大于 ⌊ n/2 ⌋ 的元素。
 * 你可以假设数组是非空的，并且给定的数组总是存在众数。
 *  * 示例 1:
 * 输入: [3,2,3]
 * 输出: 3
 * 示例 2:
 *
 * 输入: [2,2,1,1,1,2,2]
 * 输出: 2
 */
public class MajorityElement {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,1};
        int result = majorityElement(nums);
        System.out.println(result);
    }

    /**
     * 思路:先令count = 0
     * 将第一个数赋值给majority,每次遇到和第一个数相同的，则然count+1，否则count-1
     * 若其他数的数量大于第一个数，则当count被减为0时，将该数赋值给majority,
     * 这样就能算出众数，不需要求出该数的总数量
     * @param nums
     * @return
     */
    public static int majorityElement(int[] nums) {
        int count = 0,majority = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0){
                majority = nums[i];
                count++;
            }else if (nums[i] == majority){
                count++;
            }else{
                count--;
            }
        }
        return majority;
    }
}
