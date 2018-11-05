package Array.MoveZeroes_283;

/**
 * @author evan_qb
 * @date 2018/9/3 13:10
 * 283. 移动零
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * 示例:
 * 输入: [0,1,0,3,12]
 * 输出: [1,3,12,0,0]
 * 说明:
 * 必须在原数组上操作，不能拷贝额外的数组。
 * 尽量减少操作次数。
 */
public class MoveZeroes_283 {
    public static void main(String[] args) {
        int[] nums = {0,1,0,3,12};
        moveZeroes2(nums);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
    }

    /**
     * 方法一：一边移动，一边赋值
     * 思路:给定一个索引index用于纪录移动后0的位置
     * 首先从前面遍历，如果为0，整个数组前移
     * @param nums
     */
    public static void moveZeroes1(int[] nums) {
        int index = nums.length - 1;
        for (int i = 0; i < index; i++) {
            if (nums[i] == 0){
                move(nums,i);
                nums[index] = 0;
                index--;
                i--;
            }
        }
    }

    /**
     * 前移
     * @param nums
     * @param index
     */
    public static void move(int[] nums,int index){
        for (int i = index + 1; i < nums.length; i++) {
            nums[i - 1] = nums[i];
        }
    }

    /**
     * 方法二:先移动，再赋值
     * @param nums
     */
    public static void moveZeroes2(int[] nums) {
        int start = 0;
        int index = 0;
        int len = nums.length;
        //先将不为0的全部移动到前面
        while (index < len){
            if (nums[index] != 0){
                nums[start] = nums[index];
                start++;
            }
            index++;
        }
        //然后将后面的值全部赋值为0
        while (start < len){
            nums[start] = 0;
            start++;
        }
    }


}
