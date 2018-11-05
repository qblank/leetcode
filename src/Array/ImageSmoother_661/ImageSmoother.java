package Array.ImageSmoother_661;

import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/9/6
 * 661.图片平滑器
 * 包含整数的二维矩阵 M 表示一个图片的灰度。
 * 你需要设计一个平滑器来让每一个单元的灰度成为平均灰度 (向下舍入) ，
 * 平均灰度的计算是周围的8个单元和它本身的值求平均，如果周围的单元格不足八个，则尽可能多的利用它们。
 * 示例 1:
 * 输入:
 * [[1,1,1],
 *  [1,0,1],
 *  [1,1,1]]
 * 输出:
 * [[0, 0, 0],
 *  [0, 0, 0],
 *  [0, 0, 0]]
 * 解释:
 * 对于点 (0,0), (0,2), (2,0), (2,2): 平均(3/4) = 平均(0.75) = 0
 * 对于点 (0,1), (1,0), (1,2), (2,1): 平均(5/6) = 平均(0.83333333) = 0
 * 对于点 (1,1): 平均(8/9) = 平均(0.88888889) = 0
 * 注意:
 * 1.给定矩阵中的整数范围为 [0, 255]。
 * 2.矩阵的长和宽的范围均为 [1, 150]。
 */
public class ImageSmoother {
    public static void main(String[] args) {
        int[][] M = {{1,2,1},{3,2,1},{1,3,1}};
        int[][] result = imageSmoother(M);
        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int[][] imageSmoother(int[][] M) {
        if (M == null) return null;
        int rows = M.length;
        if (rows == 0) return new int[0][];
        int cols = M[0].length;

        int result[][] = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int count = 0;
                int sum = 0;
                for (int incR : new int[]{-1, 0, 1}) {
                    for (int incC : new int[]{-1, 0, 1}) {
                        if (isValid(row + incR, col + incC, rows, cols)) {
                            count++;
                            sum += M[row + incR][col + incC];
                        }
                    }
                }
                result[row][col] = sum / count;
            }
        }
        return result;

    }

    private static boolean isValid(int x, int y, int rows, int cols) {
        return x >= 0 && x < rows && y >= 0 && y < cols;
    }

}
