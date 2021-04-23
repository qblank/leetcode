package Sort;

import java.util.Arrays;

/**
 * 归并排序
 * @author evan_qb
 * @version 1.0
 * @date 2021/1/20 14:39
 */
public class MergeSort {

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,1,8,5,3,5,1};
        sort(arr,0,arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(int[] arr, int L, int R) {
        if(L == R) {
            return;
        }
        int mid = L + ((R - L) >> 1);
        sort(arr, L, mid);
        sort(arr, mid + 1, R);
        merge(arr, L, mid, R);
    }

    public static void merge(int[] arr, int L, int mid, int R) {
        int[] temp = new int[R - L + 1];
        int i = 0;
        int left = L;
        int right = mid + 1;
        // 比较左右两部分的元素，哪个小，把那个元素填入temp中
        while(left <= mid && right <= R) {
            temp[i++] = arr[left] < arr[right] ? arr[left++] : arr[right++];
        }
        // 上面的循环退出后，把剩余的元素依次填入到temp中
        // 以下两个while只有一个会执行
        while(left <= mid) {
            temp[i++] = arr[left++];
        }
        while(right <= R) {
            temp[i++] = arr[right++];
        }
        // 把最终的排序的结果复制给原数组
        for(i = 0; i < temp.length; i++) {
            arr[L + i] = temp[i];
        }
    }
}
