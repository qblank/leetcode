package Array.SortArrayByParity_905;

import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/10/12
 * 905. 按奇偶校验排序数组
 * 给定一个非负整数数组 A，返回一个由 A 的所有偶数元素组成的数组，后面跟 A 的所有奇数元素。
 *
 * 你可以返回满足此条件的任何数组作为答案。
 * 示例：
 * 输入：[3,1,2,4]
 * 输出：[2,4,3,1]
 * 输出 [4,2,3,1]，[2,4,1,3] 和 [4,2,1,3] 也会被接受。
 * 提示：
 * 1. 1 <= A.length <= 5000
 * 2. 0 <= A[i] <= 5000
 */
public class SortArrayByPaity {
    public static void main(String[] args) {
        int[] A = {3,1,2,4};
        int[] result = sortArrayByParity3(A);
        System.out.println(Arrays.toString(result));
    }

    /**
     * 方法一:
     * 思路:
     * 需要创建一个新数组B,当为偶数时，添加进去，并把原来的值清零
     * 接着遍历数组A,将A中不为0的值添加到B数组中
     * 优点: 可以保证原来的顺序
     * 缺点： 需要两次遍历
     * @param A
     * @return
     */
    public static int[] sortArrayByParity1(int[] A) {
        int[] B = new int[A.length];
        int index = 0;
        for (int i = 0; i < A.length; i++) {
            if (A[i] % 2 == 0){
                B[index] = A[i];
                index++;
                A[i] = 0;
            }
        }
        for (int i = 0;i < A.length;i++){
            if (A[i] != 0){
                B[index] = A[i];
                index++;
            }
        }
        return B;
    }

    /**
     * 方法二:
     * 思路:
     * 创建新数组B
     * 给定两个索引，一个向左遍历，一个向右遍历
     * 当为偶数时在B的左边添加，否则在B的右边添加
     * 缺点: 不能保证原来的顺序
     * 优点： 只需一次遍历
     * @param A
     * @return
     */
    public static int[] sortArrayByParity2(int[] A) {
        int len = A.length;
        int[] B = new int[len];
        int left = 0,right = len - 1;
        for (int num: A){
            if (num %2 == 0) B[left++] = num;
            else B[right--] = num;
        }
        return B;
    }

    /**
     * 方法三:
     * 不使用新数组
     * 思路:
     * 如果为偶数，则直接和前面值进行交换
     * @param A
     * @return
     */
    public static int[] sortArrayByParity3(int[] A) {
        for (int i = 0,j = 0; j < A.length; j++) {
            if (A[j] % 2 == 0){
                int temp = A[i];
                A[i++] = A[j];
                A[j] = temp;
            }
        }
        return A;
    }

}
