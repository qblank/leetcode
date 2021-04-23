package Sort;

import java.util.Arrays;

/**
 * 基数排序
 * 基数排序是按照低位先排序，然后收集；再按照高位排序，然后再收集；依次类推，直到最高位。
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/22 18:29
 */
public class RadixSort {

    public static void randixSort(int[] arr){
        int max = arr[0];
        //找到最大值
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max){
                max = arr[i];
            }
        }
        // 从个位开始，对数组arr按“指数”进行排序
        for (int exp = 1;max / exp > 0;exp *= 10){
            countingSort(arr,exp);
        }
    }


    private static void countingSort(int[] arr,int exp){
        if (arr.length <= 1){
            return;
        }
        //计算每个元素的个数
        int[] c = new int[10];
        for (int i = 0; i < arr.length; i++) {
            c[(arr[i] / exp) % 10]++;
        }
        //计算排序后的位置
        for (int i = 1; i < c.length; i++) {
            c[i] += c[i - 1];
        }
        //临时数组temp，存储排序之后的结果
        int[] temp = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            temp[c[(arr[i] / exp) % 10] - 1] = arr[i];
            c[(arr[i] / exp) % 10]--;
        }
        //将临时数组的值赋值到原数组中
        for (int i = 0; i < arr.length; i++) {
            arr[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        int[] arr = {1,8,9,3,5,6,8,5,3,2,5};
        randixSort(arr);
        System.out.println(Arrays.toString(arr));
    }

}
