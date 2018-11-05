package Array.BestTimetoBuyandSellStock_121;

import java.util.Arrays;

/**
 * @author evan_qb
 * @date 2018/8/28 16:57
 * 121. 买卖股票的最佳时机
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票），设计一个算法来计算你所能获取的最大利润。
 * 注意你不能在买入股票前卖出股票。
 * 示例 1:
 *
 * 输入: [7,1,5,3,6,4]
 * 输出: 5
 * 解释: 在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格。
 * 示例 2:
 *
 * 输入: [7,6,4,3,1]
 * 输出: 0
 * 解释: 在这种情况下, 没有交易完成, 所以最大利润为 0。
 */
public class BestTimetoBuyAndSellStock {
    public static void main(String[] args) {
        int[] nums = {7,2,5,3,1,2};
        int profit = maxProfit(nums);
        System.out.println(profit);

    }

    /**
     * 思路:设置一个索引值，遍历数组中的数依次去减去这个索引值对应的数
     * 如果相减结果小于0，说明后面的数小于改索引值对应的数，
     * 那么将索引值移动到该数对应的索引值继续判断
     *
     * 如果相减结果大于0，说明后面的数大于索引值对应的数，
     * 那么索引值的位置不变，继续让下一个值与索引值对应的数相减
     * 当相减结果大于0时，比较profit(盈利值)和差值，谁大取谁
     *
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        //计算盈利值
        int profit = 0;
        int index = 0;
        for (int i = 1; i < prices.length; i++) {
            int temp = prices[i] - prices[index];
            if (temp < 0){
                index = i;
            }else{
                //差值和profit谁大取谁
                profit = profit > temp ? profit : temp;
            }
        }
        return profit;
    }
}
