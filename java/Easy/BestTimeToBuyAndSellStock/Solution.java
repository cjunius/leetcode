// https://leetcode.com/problems/best-time-to-buy-and-sell-stock
class Solution {
    public int maxProfit(int[] prices) {
        //return maxProfitUsingMax(prices);
        return maxProfitUsingMin(prices);
    }

    public int maxProfitUsingMax(int[] prices) {
        int profit = 0;
        int max = prices[prices.length-1];

        for(int i=prices.length-2; i>=0; i--) {
            if(max>prices[i])
                profit = Math.max(max-prices[i], profit);
            else
                max = prices[i];
        }

        return profit;
    }

    public int maxProfitUsingMin(int[] prices) {
        int profit = 0;
        int min = prices[0];

        for(int i : prices) {
            if(min<i)
                profit = Math.max(i-min, profit);
            else
                min = i;
        }

        return profit;
    }
}
