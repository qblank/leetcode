package Array.MergeSortedArray;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/8/22 17:20
 * 合并两个有序数组
 * 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 * 说明：
 *      初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 *      你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 *
 */
public class MergeSortedArray {
    public static void main(String[] args) {

        int[] nums1 = {0};
        int[] nums2 = {1};
        int m = 0;
        int n = 1;
        new MergeSortedArray().merge2(nums1,m,nums2,n);
        for (int i = 0; i < nums1.length; i++) {
            System.out.print(nums1[i]+" ");
        }
    }

    /**
     * 方法一：对num1从后面进行插入值，谁大谁先进
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int index = m + n -1;
        int i = m - 1;
        int j = n - 1;
        while (i >= 0 && j >= 0){
            nums1[index] = nums1[i] > nums2[j] ? nums1[i--]: nums2[j--];
            index++;
        }
        //当m > n的情况
        while (j >= 0){
            nums1[index] = nums2[j--];
        }
    }

    /**
     * 方法二：先插入后排序
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge2(int[] nums1, int m, int[] nums2, int n) {
        if (n <= 0){
            return;
        }
        for (int i = m; i < m + n; i++) {
            nums1[i] = nums2[i - m];
        }
        Arrays.sort(nums1);
    }

}
