package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 桶排序
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/22 9:28
 */
public class BucketSort {

public static void bucketSort2(int[] arr){
    int max = arr[0];
    int min = arr[0];
    for (int i = 0; i < arr.length; i++) {
        max = Math.max(max,arr[i]);
        min = Math.min(min,arr[i]);
    }
    //计算桶的数量
    int bucketNum = (max - min) / arr.length + 1;
    List<List<Integer>> bucketArr = new ArrayList<>(bucketNum);
    for (int i = 0; i < bucketNum; i++) {
        bucketArr.add(new ArrayList<>());
    }
    //将每个元素放入桶内
    for (int i = 0; i < arr.length; i++) {
        int index = (arr[i] - min) / arr.length;
        bucketArr.get(index).add(arr[i]);
    }
    //对每个桶进行排序
    for (int i = 0; i < bucketArr.size(); i++) {
        Collections.sort(bucketArr.get(i));
    }

    //取出数据存入数组中
    int index = 0;
    for (int i = 0; i < bucketArr.size(); i++) {
        for (int j = 0; j < bucketArr.get(i).size(); j++) {
            arr[index] = bucketArr.get(i).get(j);
            index++;
        }
    }
}


    public static void bucketSort(int[] arr,int bucketSize){
        if (arr.length < 2){
            return;
        }
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > maxValue){
                maxValue = arr[i];
            }
            if (arr[i] < minValue){
                minValue = arr[i];
            }
        }
        //桶数量
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        int[][] buckets = new int[bucketCount][bucketSize];
        int[] indexArr = new int[bucketCount];
        //将数值分配到各个桶中
        for (int i = 0; i < arr.length; i++) {
            int bucketIndex = (arr[i] - minValue) / bucketSize;
            if (indexArr[bucketIndex] == buckets[bucketIndex].length){
                //扩容
                ensureCapacity(buckets,bucketIndex);
            }
            buckets[bucketIndex][indexArr[bucketIndex]++] = arr[i];
        }

        //对每个桶进行排序，使用快速排序
        int k = 0;
        for (int i = 0; i < buckets.length; i++) {
            if (indexArr[i] == 0){
                continue;
            }
            //快速排序
            quickSort(buckets[i],0,indexArr[i] - 1);

            //赋值到原数组
            for (int j = 0; j < indexArr[i]; j++) {
                arr[k++] = buckets[i][j];
            }
        }
    }


    /**
     * 数组扩容
     * @param buckets 数组
     * @param bucketIndex 下标
     */
    private static void ensureCapacity(int[][] buckets,int bucketIndex){
        int[] tempArr = buckets[bucketIndex];
        int[] newArr = new int[tempArr.length * 2];
        for (int i = 0; i < tempArr.length; i++) {
            newArr[i] = tempArr[i];
        }
        buckets[bucketIndex] = newArr;
    }

    /**
     * 快速排序
     * @param arr 数组
     * @param p 分区点左边
     * @param r 分区点右边
     */
    private static void quickSort(int[] arr,int p,int r){
        if (p >= r){
            return;
        }
        //分区点
        int q = partition(arr,p,r);
        //往左边继续分区
        quickSort(arr,p,q - 1);
        //往右遍继续分区
        quickSort(arr,q + 1,r);
    }

    private static int partition(int[] arr, int p,int r){
        //分区点
        int pivot = arr[r];
        int i = p;
        for (int j = p; j < r; j++) {
            //小于分区点的放左边
            if (arr[j] <= pivot){
                swap(arr,i,j);
                i++;
            }
        }
        swap(arr,i,r);
        return i;
    }


    private static void swap(int[] arr,int i,int j){
        if (i == j){
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    public static void main(String[] args) {
        int[] arr = {2,3,5,4,3,2,-2};
        bucketSort(arr,5);
        System.out.println(Arrays.toString(arr));
    }

}
