package Array.TwoSumIIInputarraySorted_167;

/**
 * @author evan_qb
 * @date 2018/8/29 17:24
 * 167.两数之和II
 * 给定一个已按照升序排列 的有序数组，找到两个数使得它们相加之和等于目标数。
 * 函数应该返回这两个下标值 index1 和 index2，其中 index1 必须小于 index2。
 * 说明:
 * 返回的下标值（index1 和 index2）不是从零开始的。
 * 你可以假设每个输入只对应唯一的答案，而且你不可以重复使用相同的元素。
 * 示例:
 * 输入: numbers = [2, 7, 11, 15], target = 9
 * 输出: [1,2]
 * 解释: 2 与 7 之和等于目标数 9 。因此 index1 = 1, index2 = 2 。
 */
public class TwoSumII {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 10, 5};
        int target = 9;
        int[] results = twoSum2(numbers, target);
        for (int i = 0; i < results.length; i++) {
            System.out.print(results[i] + " ");
        }
    }

    /**
     * 双for循环:从左至右，循环判断(效率低)
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum1(int[] numbers, int target) {
        for (int j = 0; j < numbers.length; j++) {
            for (int i = j + 1; i < numbers.length; i++) {
                if (target - numbers[j] == numbers[i]){
                    return new int[]{j + 1,i + 1};
                }
            }
        }
        return new int[]{0,0};
    }

    /**
     * 两边向中间搜:类似二分法查找（效率高）
     * @param numbers
     * @param target
     * @return
     */
    public static int[] twoSum2(int[] numbers,int target){
        int left = 0;
        int right = numbers.length - 1;
        int results[] = new int[2];
        while (left < right){
            if (numbers[left] + numbers[right] == target){
                results[0] = left + 1;
                results[1] = right + 1;
                return results;
            }else if (numbers[left] + numbers[right] > target){
                right--;
            }else{
                left++;
            }
        }
        return results;
    }
}
