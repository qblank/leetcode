package Array.TwoSum;

import java.util.HashMap;
import java.util.Map;

/**
 * 两数之和
 * 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。
 * 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用。
 * 给定 nums = [2, 7, 11, 15], target = 9
 * 因为 nums[0] + nums[1] = 2 + 7 = 9
 * 所以返回 [0, 1]
 */
public class SumNum {
    public static void main(String[] args) {
        int[] arr = {1,3,4,5,6,7,8,11,15};
//        int[] result = twoSum1(arr, 12);
        int[] result = twoSum2(arr, 13);

        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }


    /**
     * 暴力法
     * 时间复杂度 O(n^2)
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] nums,int target){
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length - i; j++) {
                if (nums[j] == target - nums[i]){
                    return new int[]{i,j};
                }
            }

        }
        throw new IllegalArgumentException("没有满足条件的数");
    }

    /**
     * 一遍哈希表:将数据放入HashMap中
     * @param nums
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] nums,int target){
        Map<Integer,Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (map.containsKey(complement)){
                return new int[]{map.get(complement),i};
            }
            map.put(nums[i],i);
        }
        throw new IllegalArgumentException("没有满足条件的数");
    }
}
