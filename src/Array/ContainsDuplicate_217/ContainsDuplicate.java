package Array.ContainsDuplicate_217;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author evan_qb
 * @date 2018/8/30 21:16
 * 217. 存在重复元素
 * 给定一个整数数组，判断是否存在重复元素。
 * 如果任何值在数组中出现至少两次，函数返回 true。如果数组中每个元素都不相同，则返回 false。
 * 示例 1:
 * 输入: [1,2,3,1]
 * 输出: true
 *
 * 示例 2:
 * 输入: [1,2,3,4]
 * 输出: false
 *
 * 示例 3:
 * 输入: [1,1,1,3,3,4,3,2,4,2]
 * 输出: true
 */
public class ContainsDuplicate {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,4};
        boolean result = containsDuplicate3(nums);
        System.out.println(result);
    }

    /**
     * 使用Set集合
     * @param nums
     * @return
     */
    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        return set.size() == nums.length ? false:true;
    }

    /**
     * 先排序判断前一个和后一个数是否相同，相同则放回true
     * 都不相同返回false
     * @param nums
     * @return
     */
    public static boolean containsDuplicate2(int[] nums){
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]){
                return true;
            }
        }
        return false;
    }

    /**
     * 双层for循环
     * 前一个数大于后一个数时，直接跳出内层for循环
     * 否则判断相邻两个数是否相等，如果相等，那么直接返回，
     * 否则，让内层循环的j进行回溯（j - 1），判断前一个值和这个值是否相等
     * @param nums
     * @return
     */
    public static boolean containsDuplicate3(int[] nums){
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    break;
                }else if (nums[i] == nums[j]){
                    return true;
                }
            }
        }
        return false;
    }

}
