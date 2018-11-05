package Array.PascalTriangle_118;

import java.util.ArrayList;
import java.util.List;

/**
 * @author evan_qb
 * @date 2018/8/23 22:04
 * 杨辉三角
 * 输入: 5
 * 输出:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 */
public class PascalTriangle {
    public static void main(String[] args) {
        int numRows = 10;
        List<List<Integer>> generate = new PascalTriangle().generate(numRows);
        for (List<Integer> integerList : generate){
            for (int i = 0; i < numRows - integerList.size(); i++) {
                System.out.print(" ");
            }

            for (int i = 0; i < integerList.size(); i++) {
                System.out.print(integerList.get(i) + " ");
            }
            System.out.println();
        }
    }
    /**
     * 小的集合用于存储每一行的数据
     * 大的集合用于存储小的集合
     * @param numRows
     * @return
     */
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> integerList = new ArrayList<>();
        //循环遍历numRows
        for (int i = 0; i < numRows; i++) {
            //将每次的数进行初始化为1
            integerList.add(0,1);
            //当集合大于2时，进入该循环，将除了第一个数和尾数的值通通经过上一个数的相邻的和加起来，并修改值
            for (int j = 1; j < integerList.size() - 1; j++) {
                integerList.set(j,integerList.get(j+1) + integerList.get(j));
            }
            //重新创建一个新集合，将数据添加到总集合中
            lists.add(new ArrayList<>(integerList));
        }
        return lists;
    }
}
