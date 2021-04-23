package Sort;

import java.util.Arrays;

/**
 * 快速排序:
 * 从数列中挑出一个元素作为基准。
 * 重新排列数列，把所有的比基准小的放在基准前面，反之放在后面
 * 完成后基准处在分区的中间位置。
 * 通过递归调用把小于基准元素和大于基准元素的子序列进行排序。
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/19 15:53
 */
public class QuickSort {

    public void quickSort(int[] arr, int left,int right){
        if (left >= right){
            return;
        }
        int key = arr[left];
        int i = left;
        int j = right;
        while (i < j){
            //j向左移，直到遇到比key小的值
            while (arr[j] >= key && i < j){
                j--;
            }
            //i向右移，直到遇到比key大的值
            while (arr[i] <= key && i < j){
                i++;
            }

            //i和j指定的元素交换
            if (i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        arr[left] = arr[i];
        arr[i] = key;
        quickSort(arr,left,i - 1);
        quickSort(arr,i + 1,right);
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] arr = new int[]{5,6,1,3,8,9};
        int left = 0;
        int right = arr.length - 1;
        quickSort.quickSort(arr,left,right);
        System.out.println(Arrays.toString(arr));
    }

}
