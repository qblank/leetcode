package Sort;

import java.util.Arrays;

/**
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/22 16:43
 */
public class CountingSort {

    public static void countingSort(int[] arr){
        int min = arr[0];
        int max = arr[0];
        for (int i = 0; i < arr.length; i++) {
            max = Math.max(max,arr[i]);
            min = Math.min(min,arr[i]);
        }
        int[] bucket = new int[max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            //减去min是为了防止array[i]小于0，
            // 数组索引不能小于0，相当于做了个偏移。++是为了记录次数
            bucket[arr[i] - min]++;
        }
        int index = 0;
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i]-- > 0){
                arr[index++] = i + min;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = {2,3,5,4,3,2,-2};
        countingSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
