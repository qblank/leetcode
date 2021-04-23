package Sort;

import java.util.Arrays;

/**
 * 选择排序
 * 每次从中选出最小的放到前面
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/19 15:40
 */
public class SelectSort {

    public void selectSort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            for (int j = i + 1; j < arr.length - i; j++) {
                if (arr[j] < min){
                    int tmp = arr[j];
                    arr[j] = min;
                    min = tmp;
                }
            }
            arr[i] = min;
        }

    }


    public static void main(String[] args) {
        SelectSort selectSort = new SelectSort();
        int[] arr = new int[]{5,6,1,3,8,9};
        selectSort.selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
