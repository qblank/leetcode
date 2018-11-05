package Array.DegreeOfArray_697;

        import org.omg.CORBA.INTERNAL;

        import java.util.HashMap;
        import java.util.Map;

/**
 * @author evan_qb
 * @date 2018/10/7
 * 697.数组的度
 * 给定一个非空且只包含非负数的整数数组 nums, 数组的度的定义是指数组里任一元素出现频数的最大值。
 * 你的任务是找到与 nums 拥有相同大小的度的最短连续子数组，返回其长度。
 * 示例 1:
 * 输入: [1, 2, 2, 3, 1]
 * 输出: 2
 * 解释:
 * 输入数组的度是2，因为元素1和2的出现频数最大，均为2.
 * 连续子数组里面拥有相同度的有如下所示:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * 最短连续子数组[2, 2]的长度为2，所以返回2.
 *
 * 示例 2:
 * 输入: [1,2,2,3,1,4,2]
 * 输出: 6
 *
 * 注意
 * nums.length 在1到50,000区间范围内。
 * nums[i] 是一个在0到49,999范围内的整数。
 */
public class DegreeOfArray {
    public static void main(String[] args) {
        int[] nums = {1, 2, 2, 3, 2};
        int result = findShortestSubArray(nums);
        System.out.println(result);
    }

    /**
     * 找出数组的度
     * 思路:
     * 首先将所有值存储到Map<Integer,int[]>中
     * map的key为数组中的每个数
     * map的value存储一个数组，数组的第一个值存储数组的度、第二个值存储key值的原索引，第三个值存储key值(重复值)的最后一个索引
     * @param nums
     * @return
     */
    public static int findShortestSubArray(int[] nums) {
        Map<Integer,int[]> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])){
                //第一个值为数组的度，第二个值为nums[i]的原来索引，第三个值为最后一个该值(重复值)的索引
                map.put(nums[i],new int[]{1,i,i});
            }else{
                int[] temp = map.get(nums[i]);
                temp[0]++;
                temp[2] = i;
            }
        }
        int degree = Integer.MIN_VALUE,result = Integer.MAX_VALUE;
        for (int[] value: map.values()){
            if (value[0] > degree){
                degree = value[0];
                result = value[2] - value[1] + 1;
            }else if (value[0] == degree){
                result = Math.min(value[2] - value[1] + 1,result);
            }
        }
        return result;
    }
}
