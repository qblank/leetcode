package Array.RemoveDuplicates;

import java.util.Set;
import java.util.TreeSet;

/**
 * @author evan_qb
 * @date 2018/8/5 20:46
 * 删除排序数组中的重复项
 * 给定数组 nums = [1,1,2],
 * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
 * 你不需要考虑数组中超出新长度后面的元素。
 *
 */
public class Duplicate {
    public static void main(String[] args) {
        int[] nums = {1,1,2};
        int count = removeDuplicates1(nums);
        System.out.println(count);
    }

    /**
     * 方法一：使用set集合
     * @param nums
     * @return
     */
    public static int removeDuplicates1(int[] nums) {
        Set<Integer> sets = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            sets.add(nums[i]);
        }
        //用于计数
        int index = 0;
        for (int s:sets){
            nums[index] = s;
            index++;
        }
        return index;
    }

    /**
     * 方法二：对比赋值法
     * @param nums
     * @return
     */
    public static int removeDuplicates2(int[] nums) {
        if (nums == null || nums.length == 0){
            return 0;
        }
        int index = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] != nums[i-1]){
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

}
