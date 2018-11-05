package Array.MagicSquaresInGrid_840;

/**
 * @author evan_qb
 * @date 2018/10/11
 * 840.矩阵中的幻方
 *
 * 3 x 3 的幻方是一个填充有从 1 到 9 的不同数字的 3 x 3 矩阵，其中每行，每列以及两条对角线上的各数之和都相等。
 * 给定一个由整数组成的 N × N 矩阵，其中有多少个 3 × 3 的 “幻方” 子矩阵？（每个子矩阵都是连续的）。
 * 示例 1:
 * 输入: [[4,3,8,4],
 *       [9,5,1,9],
 *       [2,7,6,2]]
 * 输出: 1
 * 解释:
 * 下面的子矩阵是一个 3 x 3 的幻方：
 * 438
 * 951
 * 276
 * 而这一个不是：
 * 384
 * 519
 * 762
 * 总的来说，在本示例所给定的矩阵中只有一个 3 x 3 的幻方子矩阵。
 * 提示:
 * 1. 1 <= grid.length = grid[0].length <= 10
 * 2. 0 <= grid[i][j] <= 15
 */
public class MagisSquaresInGrid {
    public static void main(String[] args) {
        int[][] grid = {{4,3,8,4}, {9,5,1,9},{2,7,6,2}};
        int result = numMagicSquaresInside(grid);
        System.out.println(result);
    }

    /**
     * 题目大意：找出给定矩阵中存在多少个3x3的矩阵满足每行每列以及两条对角线之和都相等
     * 思路: 先判断是否是幻方，再判断个数
     * 判断
     * @param grid
     * @return
     */
    public static int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) return 0;
        for (int i = 0; i < grid.length - 2; i++) {
            for (int j = 0; j < grid[0].length - 2; j++) {
                if(isMagic(i,j,grid)){

                }
            }
        }
        return 0;
    }

    private static int sum(int num1,int num2,int num3){
        return num1 + num2 + num3;
    }

    public static boolean isMagic(int i,int j,int[][] grid){
        if (sum(grid[i][j],grid[i + 1][j],grid[i + 2][j]) == 15
                && sum(grid[i + 1][j],grid[i + 1][j+1],grid[i + 1][j + 2]) == 15
                && sum(grid[i + 2][j],grid[i + 2][j + 1],grid[i + 2][j + 2]) == 15){

        }
        return false;
    }
}
