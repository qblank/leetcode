package Array.TransposeMatrix_867;

import java.util.Arrays;
import java.util.List;

/**
 * @author evan_qb
 * @date 2018/10/12
 * 867. 转置矩阵
 * 给定一个矩阵 A， 返回 A 的转置矩阵。
 * 矩阵的转置是指将矩阵的主对角线翻转，交换矩阵的行索引与列索引。
 * 示例 1：
 * 输入：[[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[[1,4,7],[2,5,8],[3,6,9]]
 *
 * 示例 2：
 * 输入：[[1,2,3],[4,5,6]]
 * 输出：[[1,4],[2,5],[3,6]]
 */
public class TransposeMatrix {
    public static void main(String[] args) {
        int[][] A = {{1,2,3},{4,5,6},{7,8,9}};
        int[][] res = transpose(A);
        for (int i = 0; i < res.length; i++) {
            System.out.println(Arrays.toString(res[i]));
        }
    }

    /**
     * 思路
     * 创建一个新的数组，将反向复制即可
     * @param A
     * @return
     */
    public static int[][] transpose(int[][] A) {
        int m = A.length,n = A[0].length;
        int[][] B = new int[n][m];
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m; i++) {
                B[j][i] = A[i][j];
            }
        }
        return B;
    }
}
