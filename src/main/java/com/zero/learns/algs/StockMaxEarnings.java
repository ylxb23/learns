package com.zero.learns.algs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StockMaxEarnings {

    public static void main(String[] args) {
        List<int[]> pricesList = new ArrayList<>();
        pricesList.add(new int[]{7,1,5,3,6,4}); // 5
        pricesList.add(new int[]{7,6,4,3,1});   // 0
        pricesList.add(new int[]{3,1,2});       // 1
        pricesList.add(new int[]{3,1,2,4});     // 3

        for(int[] prices : pricesList) {
            System.out.println("max earning of " + Arrays.toString(prices) + " is: " + maxEarnings(prices));
        }
    }

    /**
     * 121. 买卖股票的最佳时机
     * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
     * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
     * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
     * 示例 1：
     * 输入：[7,1,5,3,6,4]
     * 输出：5
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
     *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
     * @param prices 股票价格
     * @return 最大收益额
     */
    public static int maxEarnings(int[] prices) {
        if(prices.length < 2) {
            return 0;
        }
        int minBefore = prices[0];
        int maxEarning = 0;
        for(int i=1; i<prices.length; i++) {
            maxEarning = Math.max(maxEarning, prices[i] - minBefore);
            if(prices[i] < minBefore) {
                minBefore = prices[i];
            }
        }
        return maxEarning;
    }

    /**
     * 122. 买卖股票的最佳时机 II
     * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
     * 在每一天，你可以决定是否购买和/或出售股票。
     * 返回 你能获得的 最大 利润 。
     * 示例 1：
     * 输入：prices = [7,1,5,3,6,4]
     * 输出：7
     * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 3 天（股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      随后，在第 4 天（股票价格 = 3）的时候买入，在第 5 天（股票价格 = 6）的时候卖出, 这笔交易所能获得利润 = 6 - 3 = 3 。
     *      总利润为 4 + 3 = 7 。
     * 示例 2：
     * 输入：prices = [1,2,3,4,5]
     * 输出：4
     * 解释：在第 1 天（股票价格 = 1）的时候买入，在第 5 天 （股票价格 = 5）的时候卖出, 这笔交易所能获得利润 = 5 - 1 = 4 。
     *      总利润为 4 。
     * @param prices 每天的股票价格
     * @return 最大收益额
     */
    public static int maxEarningsV2(int[] prices) {

        return 0;
    }
}
