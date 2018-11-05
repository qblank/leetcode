package Array.SearchInsertPosition;

/**
 * @author evan_qb
 * @date 2018/8/6 9:51
 * 搜索插入位置
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。
 * 如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 *
 * 输入: [1,3,5,6], 5
 * 输出: 2
 *
 * 输入: [1,3,5,6], 2
 * 输出: 1
 *
 * 输入: [1,3,5,6], 7
 * 输出: 4
 *
 * 输入: [1,3,5,6], 0
 * 输出: 0
 */
public class SearchInsert {
    public static void main(String[] args) {
        int[] nums = {1,3,5,6};
        int target = 1;
        int result = searchInsert2(nums, target);
        System.out.println(result);
    }

    /**
     * 方法一：普通搜索
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert1(int[] nums, int target) {
        int len = nums.length;
        //找出位置
        for (int i = 0; i < len; i++) {
            if (nums[i] >= target){
                return i;
            }
        }
        return len;
    }

    /**
     * 方法二：二分搜索
     * @param nums
     * @param target
     * @return
     */
    public static int searchInsert2(int[] nums, int target) {
        int len = nums.length;
        int index = 0;
        //找出位置
        while (index < len){
            int mid = (index + len) / 2;
            if (nums[mid] == target){
                return mid;
            }else if (nums[mid] > target){
                len = mid;
            }else{
                index = mid + 1;
            }
        }
        return len;
    }

}
