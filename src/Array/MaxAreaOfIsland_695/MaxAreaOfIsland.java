package Array.MaxAreaOfIsland_695;

/**
 * @author evan_qb
 * @date 2018/9/18
 * 695.岛屿的最大面积
 * 给定一个包含了一些 0 和 1的非空二维数组 grid , 一个 岛屿 是由四个方向 (水平或垂直) 的 1 (代表土地) 构成的组合。
 * 你可以假设二维矩阵的四个边缘都被水包围着。
 * 找到给定的二维数组中最大的岛屿面积。(如果没有岛屿，则返回面积为0。)
 *
 * 示例 1:
 *
 * [[0,0,1,0,0,0,0,1,0,0,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,1,1,0,1,0,0,0,0,0,0,0,0],
 *  [0,1,0,0,1,1,0,0,1,0,1,0,0],
 *  [0,1,0,0,1,1,0,0,1,1,1,0,0],
 *  [0,0,0,0,0,0,0,0,0,0,1,0,0],
 *  [0,0,0,0,0,0,0,1,1,1,0,0,0],
 *  [0,0,0,0,0,0,0,1,1,0,0,0,0]]
 * 对于上面这个给定矩阵应返回 6。注意答案不应该是11，因为岛屿只能包含水平或垂直的四个方向的‘1’。
 */
public class MaxAreaOfIsland {
    public static void main(String[] args) {
        int[][] grid = {
           {0,0,1,0,0,0,0,1,0,0,0,0,0},
           {0,0,0,0,0,0,0,1,1,1,0,0,0},
           {0,1,1,0,1,0,0,0,0,0,0,0,0},
           {0,1,0,0,1,1,0,0,1,0,1,0,0},
           {0,1,0,0,1,1,0,0,1,1,1,0,0},
           {0,0,0,0,0,0,0,0,0,0,1,0,0},
           {0,0,0,0,0,0,0,1,1,1,0,0,0},
           {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        int result = maxAreaOfIsland(grid);
        System.out.println(result);
    }

    /**
     * 思路:
     * 通过areaOfIsland方法获取岛屿面积，然后对该面积进行最大值的筛选
     *
     * @param grid
     * @return
     */
    public static int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1){
                    maxArea = Math.max(areaOfIsland(grid,i,j),maxArea);
                }
            }
        }
        return maxArea;
    }

    /**
     * 递归计算计算面积
     * 将计算过的值赋值为0
     * @param grid
     * @param i
     * @param j
     * @return
     */
    public static int areaOfIsland(int[][] grid,int i,int j){
        if (i >= 0 && i < grid.length && j>= 0 && j < grid[0].length && grid[i][j] == 1){
            grid[i][j] = 0;
            return 1 + areaOfIsland(grid,i+1,j) + areaOfIsland(grid,i - 1,j)
                    + areaOfIsland(grid,i,j + 1) + areaOfIsland(grid,i,j - 1);

        }
        return 0;
    }
}
