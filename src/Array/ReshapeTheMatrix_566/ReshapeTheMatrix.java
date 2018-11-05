package Array.ReshapeTheMatrix_566;

/**
 * @author evan_qb
 * @date 2018/9/5
 * 566.重塑矩阵
 * 在MATLAB中，有一个非常有用的函数 reshape，它可以将一个矩阵重塑为另一个大小不同的新矩阵，但保留其原始数据。
 * 给出一个由二维数组表示的矩阵，以及两个正整数r和c，分别表示想要的重构的矩阵的行数和列数。
 * 重构后的矩阵需要将原始矩阵的所有元素以相同的行遍历顺序填充。
 * 如果具有给定参数的reshape操作是可行且合理的，则输出新的重塑矩阵；否则，输出原始矩阵。
 *
 * 示例 1:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 1, c = 4
 * 输出:
 * [[1,2,3,4]]
 * 解释:
 * 行遍历nums的结果是 [1,2,3,4]。新的矩阵是 1 * 4 矩阵, 用之前的元素值一行一行填充新矩阵。
 *
 * 示例 2:
 * 输入:
 * nums =
 * [[1,2],
 *  [3,4]]
 * r = 2, c = 4
 * 输出:
 * [[1,2],
 *  [3,4]]
 * 解释:
 * 没有办法将 2 * 2 矩阵转化为 2 * 4 矩阵。 所以输出原矩阵。
 */
public class ReshapeTheMatrix {
    public static void main(String[] args) {
        int[][] nums = {{1,2},{3,4,5},{5,6},{7,8}};
        int r = 4,c = 2;
        int[][] results = matrixReshape(nums, r, c);
        for (int i = 0; i < results.length; i++) {
            for (int j = 0; j < results[i].length; j++) {
                System.out.print(results[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 思路:
     * 问题：变换数组时，存在一个问题，就是变换前和变换后的数组索引不一致，
     * 这就会导致下标越界等情况的发生
     * 解决：我们可以通过以下公式来解决这个问题:
     * 假设原数组的的长度nums[0].length = m
     * i从0到 r*c
     * i / c  的结果在i <= c之前一直会是0
     * i % c  的结果在不会超过c,当大于c时，继续按超出的值算:即|i - c|
     * 以此类推：
     * 原数组也可以这样
     * i / m 作为第一层索引
     * i % m 作为第二层索引
     * @param nums
     * @param r
     * @param c
     * @return
     */
    public static int[][] matrixReshape(int[][] nums, int r, int c) {
        int n = nums.length,m = nums[0].length;
        if (r * c != n*m){
            return nums;
        }
        int[][] res = new int[r][c];
        for (int i = 0; i < r * c; i++) {
            res[i/c][i%c] = nums[i/m][i%m];
        }
        return res;
    }


}
