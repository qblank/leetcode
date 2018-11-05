package Array.MissingNumber_268;

import java.util.ArrayList;

/**
 * @author evan_qb
 * @date 2018/8/31 11:48
 * 268.缺少数字
 * 给定一个包含 0, 1, 2, ..., n 中 n 个数的序列，找出 0 .. n 中没有出现在序列中的那个数。
 *
 * 示例 1:
 * 输入: [3,0,1]
 * 输出: 2
 *
 * 示例 2:
 * 输入: [9,6,4,2,3,5,7,0,1]
 * 输出: 8
 */
public class MissingNumber {
    public static void main(String[] args) {
        int[] nums = {3,2,1};
        int result = new MissingNumber().missingNumber(nums);
        System.out.println(result);
    }

    /**
     *
     * @param nums
     * @return
     */
    public int missingNumber(int[] nums) {
        //利用数组的特性，再进行抑或运算 a ^ b ^ = a
        //数组的特性:下标从0开始,长度比索引要大一位，所以一定会有一个缺失的数字
        //抑或运算:
        //例子: {0,2,1} ：
        // (0 ^ res ^ 0) ^ (1 ^ 2) ^ (2 ^ 1)
        // res ^ 0 ^ 0 ^ 1 ^ 1 ^ 2 ^ 2
        // 索引  结果(默认为长度)  索引值  结果
        // 0   ^    3          ^   0    3
        // 1   ^    3          ^   2    0
        // 2   ^    0          ^   1    3

        //{2,1,3}
        // 索引  结果(默认为长度)  索引值  结果
        // 0   ^    3          ^   2    1
        // 1   ^    1          ^   1    1
        // 2   ^    1          ^   3    0
        //解释:
        //在完全没有缺失的情况,索引和索引值是一一对应的: nums[index] = index
        //当缺失一个数字后，索引和索引值就会有一对不会对应:
        //{2,1,3} 3(长度) ^ 0 ^ 3 ^ 1 ^ 1 ^ 2 ^ 2 = 0
        //{0,2,1} 3(长度) ^ 0 ^ 0 ^ 1 ^ 1 ^ 2 ^ 2 = 3
        //{0,1,3} 3(长度) ^ 0 ^ 0 ^ 1 ^ 1 ^ 2 ^ 3 = 2
        int result = nums.length;
        for (int i = 0; i < nums.length; i++) {
            result =i ^ result ^ nums[i];  //a ^ b ^ b = a
        }
        return result;
    }
}
