package Array.RemoveElement;

/**
 * @author evan_qb
 * @date 2018/8/5 21:47
 * 移除元素
 * 给定一个数组 nums 和一个值 val，你需要原地移除所有数值等于 val 的元素，返回移除后数组的新长度。
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveEle {
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,3,0,4,2};
        int index = removeElement2(nums, 2);
        System.out.println(index);
    }

    /**
     * 使用for循环
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement1(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val){
                nums[index] = nums[i];
            }else{
                nums[index] = nums[i];
                index++;
            }
        }
        return index;
    }

    /**
     * 使用while循环
     * @param nums
     * @param val
     * @return
     */
    public static int removeElement2(int[] nums, int val) {
        int i = 0;
        int n = nums.length;
        while (i < n) {
            if (nums[i] == val) {
                nums[i] = nums[n - 1];
                n--;
            } else {
                i++;
            }
        }
        return n;
    }
}
