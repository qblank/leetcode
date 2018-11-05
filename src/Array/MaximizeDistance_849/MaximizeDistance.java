package Array.MaximizeDistance_849;

/**
 * @author evan_qb
 * @date 2018/10/12
 * 849.到最近的人的最大距离
 * 在一排座位（ seats）中，1 代表有人坐在座位上，0 代表座位上是空的。
 * 至少有一个空座位，且至少有一人坐在座位上。
 * 亚历克斯希望坐在一个能够使他与离他最近的人之间的距离达到最大化的座位上。
 * 返回他到离他最近的人的最大距离。
 * 示例 1：
 * 输入：[1,0,0,0,1,0,1]
 * 输出：2
 * 解释：
 * 如果亚历克斯坐在第二个空位（seats[2]）上，他到离他最近的人的距离为 2 。
 * 如果亚历克斯坐在其它任何一个空位上，他到离他最近的人的距离为 1 。
 * 因此，他到离他最近的人的最大距离是 2 。
 * 示例 2：
 * 输入：[1,0,0,0]
 * 输出：3
 * 解释：
 * 如果亚历克斯坐在最后一个座位上，他离最近的人有 3 个座位远。
 * 这是可能的最大距离，所以答案是 3 。
 * 提示：
 * 1. 1 <= seats.length <= 20000
 * 2. seats 中只含有 0 和 1，至少有一个 0，且至少有一个 1。
 *
 */
public class MaximizeDistance {
    public static void main(String[] args) {
        int[] seats = {1,0,0,0,1,0,1};
        int result = maxDistToClosest(seats);
        System.out.println(result);
    }

    /**
     * 思路:
     * 两个1之间0最多的区间，然后通过除以2，算出其中间部分与两边的距离
     * @param seats
     * @return
     */
    public static int maxDistToClosest(int[] seats) {
        int i = 0,j = 0,result = 0;
        for (; i < seats.length; i++) {
            if (seats[i] == 1){
                if (j == 0) result = Math.max(result,i - j);
                else result = Math.max(result,(i - j + 1) / 2);
                j = i + 1;
            }
        }
        return Math.max(result,seats.length - j);
    }

}
