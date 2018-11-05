package Array.DeckofCards_914;

import java.util.HashMap;
import java.util.Map;

/**
 * @author evan_qb
 * @date 2018/10/12
 * 914.卡牌分组
 * 给定一副牌，每张牌上都写着一个整数。
 * 此时，你需要选定一个数字 X，使我们可以将整副牌按下述规则分成 1 组或更多组：
 * 每组都有 X 张牌。
 * 组内所有的牌上都写着相同的整数。
 * 仅当你可选的 X >= 2 时返回 true。
 * 示例 1：
 * 输入：[1,2,3,4,4,3,2,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[3,3]，[4,4]
 *
 * 示例 2：
 * 输入：[1,1,1,2,2,2,3,3]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 3：
 * 输入：[1]
 * 输出：false
 * 解释：没有满足要求的分组。
 *
 * 示例 4：
 * 输入：[1,1]
 * 输出：true
 * 解释：可行的分组是 [1,1]
 *
 * 示例 5：
 * 输入：[1,1,2,2,2,2]
 * 输出：true
 * 解释：可行的分组是 [1,1]，[2,2]，[2,2]
 * 提示：
 * 1. 1 <= deck.length <= 10000
 * 2. 0 <= deck[i] < 10000
 */
public class DeckofCards {
    public static void main(String[] args) {
        /*int[] deck = {1,2,3,4,4,3,2,3};
        boolean result = hasGroupsSizeX(deck);
        System.out.println(result);*/

        System.out.println(8%10);
    }

    /**
     * 思路:
     * 利用map统计每个数字的个数，
     * 然后判断卡牌的个数和卡片的数值是否相等,从卡牌数值为0开始判断,
     * 当卡牌的数值和卡片的分组中卡片的个数相等且(通过countNum)统计数值大于等于2时，返回true
     * 否则，返回false
     * @param deck
     * @return
     */
    public static boolean hasGroupsSizeX(int[] deck) {
        Map<Integer,Integer> map = new HashMap<>();
        int res = 0;
        for (int i : deck) map.put(i,map.getOrDefault(i,0) + 1);
        for (int i :map.values()) res = countNum(i,res);
        return res > 1;
    }

    private static int countNum(int a,int b){
        return b > 0 ? countNum(b,a % b) : a;
    }
}
