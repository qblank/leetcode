package Sort;

import java.util.Arrays;

/**
 * 插入排序:取未排序的元素，在已排序区间找到
 * 合适的位置，并进行插入，保证已排序的区间数据一直有序
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/19 15:20
 */
public class InsertionSort {

    public void insertionSort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int value = arr[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (arr[j] > value){
                    arr[j + 1] = arr[j];    //移位
                }else {
                    break;
                }
            }
            arr[j + 1] = value;
        }
    }


    public static void main(String[] args) {
        InsertionSort insertionSort = new InsertionSort();
        int[] arr = new int[]{5,6,1,3,8,9};
        insertionSort.insertionSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
