package Array.ContainsDuplicateII_219;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author evan_qb
 * @date 2018/8/31 9:16
 * 219. 存在重复元素 II
 * 给定一个整数数组和一个整数 k，判断数组中是否存在两个不同的索引 i 和 j，
 * 使得 nums [i] = nums [j]，并且 i 和 j 的差的绝对值最大为 k。
 * 示例 1:
 * 输入: nums = [1,2,3,1], k = 3
 * 输出: true
 *
 * 示例 2:
 * 输入: nums = [1,0,1,1], k = 1
 * 输出: true
 *
 * 示例 3:
 * 输入: nums = [1,2,3,1,2,3], k = 2
 * 输出: false
 *
 */
public class ContainsDuplicateII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1,2,3};
        int k = 2;
        boolean result = containsNearbyDuplicate3(nums, k);
        System.out.println(result);
        Map<Integer,Integer> map = new HashMap<>();
        Integer lastIndex = map.put(1, 2);
        Integer index = map.put(1, 3);
        System.out.println(index);

    }

    /**
     * 回溯:先两两对比，然后如果后一个大于前一个，则跳出内层循环，继续比较，
     * 相等的话就判断i - j <= k，移除与k对应的之前的数
     * 小于的话，就将j的索引往前移,继续判断
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate1(int[] nums, int k) {
        for (int i = 1; i < nums.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (nums[i] > nums[j]){
                    break;
                }else if (nums[i] == nums[j]){
                    if (i - j <= k){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 使用Set集合
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate2(int[] nums, int k){
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            //移除距离比k远的元素
            if (i > k){
                set.remove(nums[i - k - 1]);
            }
            //因为所有仍存在的元素的距离都满足最大距离为k,
            // 如果这时存在相同元素则返回true，反之为false
            if (!set.add(nums[i])){
                return true;
            }
        }
        return false;
    }

    /**
     * 使用Map集合
     * @param nums
     * @param k
     * @return
     */
    public static boolean containsNearbyDuplicate3(int[] nums, int k) {
        Map<Integer, Integer> indices = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            //利用map的特性，如果put已经存在的key,则会返回上一个key的值
            //如果不存在，则返回null
            Integer lastIndex = indices.put(nums[i], i);
            if (lastIndex != null && (i - lastIndex) <= k)
                return true;
        }
        return false;
    }
}
