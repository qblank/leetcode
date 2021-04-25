package BinarySearch;

/**
 * @author evan_qb
 * @version 1.0
 * @date 2021/4/23 21:20
 */
public class BinarySearch {

    public static int binarySearch(int[] arr,int num){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            //防止两者之后导致类型值溢出
            int mid = left +  ((right - left) >> 1);
            if (arr[mid] == num){
                return mid;
            }else if (arr[mid] > num){
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static int binarySearch1(int[] arr, int value){
        return binarySearchInternally(arr,0,arr.length - 1,value);
    }

    private static int binarySearchInternally(int[] arr,int low,int high,int value){
        if (low > high) return -1;
        //防止类型值溢出
        int mid = low + ((high - low) >> 1);
        if (arr[mid] == value){
            return mid;
        }else if (arr[mid] > value){
            return binarySearchInternally(arr,low, mid - 1,value);
        }else {
            return binarySearchInternally(arr,mid + 1,high,value);
        }
    }


    /**
     * 查找最后一个值为num的
     * @param arr
     * @param num
     * @return
     */
    public static int binarySearch2(int[] arr,int num){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            //防止两者之后导致类型值溢出
            int mid = left +  ((right - left) >> 1);
            if (arr[mid] > num){
                right = mid - 1;
            }else if (arr[mid] < num){
                left = mid + 1;
            }else {
                if ((mid == arr.length - 1) || (arr[mid + 1] != num)){
                    return mid;
                }else {
                    left = mid + 1;
                }
            }
        }
        return -1;
    }


    public static int binarySearch3(int[] arr,int num){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            //防止两者之后导致类型值溢出
            int mid = left +  ((right - left) >> 1);
            if (arr[mid] >= num){
                if (mid == 0 || arr[mid - 1] < num){
                    return mid;
                }
                right = mid - 1;
            }else {
                left = mid + 1;
            }
        }
        return -1;
    }


    public static int binarySearch4(int[] arr,int num){
        int left = 0;
        int right = arr.length - 1;
        while (left <= right){
            //防止两者之后导致类型值溢出
            int mid = left +  ((right - left) >> 1);
            if (arr[mid] > num){
                right = mid - 1;
            }else {
                if (mid == arr.length - 1 || arr[mid + 1] > num){
                    return mid;
                }
                left = mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,5,5,6,7,8,8,8};
        int result = binarySearch4(arr,4);
        System.out.println(result);

    }
}
