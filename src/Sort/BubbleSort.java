package Sort;

import java.util.Arrays;

/**
 * 冒泡排序
 * 一个个上浮
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/19 15:16
 */
public class BubbleSort {

    public void bubbleSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }

    public static void main(String[] args) {
        BubbleSort bubbleSort = new BubbleSort();
        int[] arr = new int[]{5,6,1,3,8,9};
        bubbleSort.bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
