package Array.PascalTriangleII_119;

import java.util.ArrayList;
import java.util.List;

/**
 * @author evan_qb
 * @date 2018/8/24 9:33
 * 杨辉三角II
 * 输入: 3
 * 输出: [1,3,3,1]
 */
public class PascalTriangleII {
    public static void main(String[] args) {
        List<Integer> rows = new PascalTriangleII().getRow(20);
        for (int i = 0; i < rows.size(); i++) {
            System.out.print(rows.get(i) + " ");
        }
    }
    /**
     * 方法一:先初始化，再修改
     * @param rowIndex
     * @return
     */
    public List<Integer> getRow(int rowIndex) {
        List<Integer> rows = new ArrayList<>();
        for (int i = 0; i <= rowIndex; i++) {
            rows.add(0,1);
            for (int j = 1; j < i; j++) {
                rows.set(j,rows.get(j) + rows.get(j+1));
            }
        }
        return rows;
    }
}
