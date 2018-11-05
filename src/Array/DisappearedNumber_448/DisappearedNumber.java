package Array.DisappearedNumber_448;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author evan_qb
 * @date 2018/9/4
 * 448.找到所有数组中消失的数字
 * 给定一个范围在  1 ≤ a[i] ≤ n ( n = 数组大小 ) 的 整型数组，数组中的元素一些出现了两次，另一些只出现一次。
 * 找到所有在 [1, n] 范围之间没有出现在数组中的数字。
 * 您能在不使用额外空间且时间复杂度为O(n)的情况下完成这个任务吗? 你可以假定返回的数组不算在额外空间内。
 * 示例:
 * 输入:
 * [4,3,2,7,8,2,3,1]
 * 输出:
 * [5,6]
 */
public class DisappearedNumber {
    public static void main(String[] args) {
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> numList = findDisappearedNumbers2(nums);
        for (int i = 0; i < numList.size(); i++) {
            System.out.print(numList.get(i) + " ");
        }
    }

    /**
     * 方法一(超出时间限制):将1~n的值添加到list集合中，
     * 然后判断集合中是否包含数组里面的值，包含就移除掉
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> numList = new LinkedList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(i + 1);
        }
        for (int i = 0; i < nums.length; i++) {
            if (numList.contains(nums[i])){
                numList.remove((Integer) nums[i]);
            }
        }
        return numList;
    }


    /**
     * 思路:
     * |数组的值| - 1 = 索引，然后给每个索引对应的值标记为负数
     * 当数组中的值有相同的时候，那么就会有一些数组的值没有标记到，
     * 刚好这些数组的值的索引就是数组中缺少的数字
     *
     * 第一步:1,1,2
     * 第二步:-1,1,2
     * 第三步:-1,-1,2
     * 最后确定索引3
     *
     * 第一步:3,3,2
     * 第二步:3,-3,2
     * 第三步:3,-3,-2
     * 最后确定索引1
     * @param nums
     * @return
     */
    public static List<Integer> findDisappearedNumbers2(int[] nums) {
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            //确定索引
            int val = Math.abs(nums[i]) - 1;
            if (nums[val] > 0){
                nums[val] = -nums[val];
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0){
                nums[i] = -nums[i];
            }else {
                numList.add(i + 1);
            }
        }
        return numList;
    }
}
