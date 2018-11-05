package Array.MonotonicArray_896;

/**
 * @author evan_qb
 * @date 2018/10/12
 * 896.单调数列
 *
 * 如果数组是单调递增或单调递减的，那么它是单调的。
 * 如果对于所有 i <= j，A[i] <= A[j]，那么数组 A 是单调递增的。
 * 如果对于所有 i <= j，A[i]> = A[j]，那么数组 A 是单调递减的。
 * 当给定的数组 A 是单调数组时返回 true，否则返回 false。
 * 示例 1：
 * 输入：[1,2,2,3]
 * 输出：true
 *
 * 示例 2：
 * 输入：[6,5,4,4]
 * 输出：true
 *
 * 示例 3：
 * 输入：[1,3,2]
 * 输出：false
 *
 * 示例 4：
 * 输入：[1,2,4,5]
 * 输出：true
 * 示例 5：
 * 输入：[1,1,1]
 * 输出：true
 */
public class MonotonicArray {
    public static void main(String[] args) {
        int[] A = {-1,-2,2};
        boolean result = isMonotonic(A);
        System.out.println(result);
    }

    /**
     * 思路:遍历统计每次递增的个数，如果递增/递减的次数等于数组长度-1
     * @param A
     * @return
     */
    public static boolean isMonotonic(int[] A) {
        int inc = 0,dec = 0,len = A.length - 1;
        for (int i = 0; i < len; i++) {
            if (A[i] >= A[i + 1]) inc++;
            if (A[i] <= A[i + 1]) dec++;
        }
        return inc == len || dec == len;
    }
}
