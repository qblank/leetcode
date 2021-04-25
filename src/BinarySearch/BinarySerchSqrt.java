package BinarySearch;

/**
 * 二分查找获取平方根
 * @author evan_qb
 * @version 1.0
 * @date 2021/1/20 14:41
 */
public class BinarySerchSqrt {

    public static void main(String[] args) {
        double result = sqrt(3,0.000001);
        System.out.println(result);
    }

    public static double sqrt(double x , double precision){
        if (x < 0){
            return Double.NaN;
        }
        double low = 0;
        double high = x;
        if (x < 1 && x > 0){
            low = x;
            high = 1;
        }
        double mid = low + (high - low) / 2;
        while (high - low > precision){
            if (mid * mid > x){
                high = mid;
            }else if (mid * mid < x){
                low = mid;
            }else {
                return mid;
            }
            mid = low + (high - low) / 2;
        }
        return mid;
    }
}
