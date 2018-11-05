package Array.ArrayKdiffPairs_532;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @author evan_qb
 * @date 2018/9/4
 * 532.数组中的K-diff数对
 * 给定一个整数数组和一个整数 k, 你需要在数组里找到不同的 k-diff 数对。这里将 k-diff 数对定义为一个整数对 (i, j), 其中 i 和 j 都是数组中的数字，且两数之差的绝对值是 k.
 * 示例 1:
 * 输入: [3, 1, 4, 1, 5], k = 2
 * 输出: 2
 * 解释: 数组中有两个 2-diff 数对, (1, 3) 和 (3, 5)。
 * 尽管数组中有两个1，但我们只应返回不同的数对的数量。
 *
 * 示例 2:
 * 输入:[1, 2, 3, 4, 5], k = 1
 * 输出: 4
 * 解释: 数组中有四个 1-diff 数对, (1, 2), (2, 3), (3, 4) 和 (4, 5)。
 *
 * 示例 3:
 * 输入: [1, 3, 1, 5, 4], k = 0
 * 输出: 1
 * 解释: 数组中只有一个 0-diff 数对，(1, 1)。
 * 注意:
 * 数对 (i, j) 和数对 (j, i) 被算作同一数对。
 * 数组的长度不超过10,000。
 * 所有输入的整数的范围在 [-1e7, 1e7]。
 */
public class ArrayKdiffPairs {
    public static void main(String[] args) {
        int[] nums = {3, 1, 4, 1, 5};
        int result = findPairs2(nums,2);
        System.out.println(result);

    }

    /**
     * 方法一：使用map集合
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs1(int[] nums, int k) {
        if (nums == null || nums.length < 0 || k < 0)
            return 0;
        Map<Integer,Integer> map = new HashMap<>();
        for (int i : nums){
            //将数组的数统计存入map中，并统计个数
            map.put(i,map.getOrDefault(i,0) + 1);
        }
        int count = 0;
        for (Map.Entry<Integer,Integer> entry: map.entrySet()){
            //当k = 0时，只需获取数组中相同对的个数即可
            if (k == 0){
                if (entry.getValue() >= 2){
                    count++;
                }
            }else{
                //判断map中是否存在两个数满足num1 - num2 = k
                if (map.containsKey(entry.getKey() + k)){
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 方法二：使用两个Set集合,一个用于判断是否满足，一个用于存储满足的值
     * @param nums
     * @param k
     * @return
     */
    public static int findPairs2(int[] nums, int k) {
        //用于判断是否存在
        Set<Integer> numbers = new HashSet<>();
        //用于存储k-diff的值
        Set<Integer> diff = new HashSet<>();
        for (int num : nums){
            //判断是否满足条件:正负进行判断
            if (numbers.contains(num + k))
                diff.add(num);
            if (numbers.contains(num - k))
                diff.add(num);
            numbers.add(num);
        }
        return diff.size();
    }



    /**
     * 统计数组每个数字的个数
     * @param nums
     * @return
     */
    public static Map<Integer,Integer> countNum(int[] nums){
        Map<Integer,Integer> map = new HashMap<>();
        for (int num : nums){
            map.put(num,map.getOrDefault(num,0) + 1);
        }
        return map;
    }
}
