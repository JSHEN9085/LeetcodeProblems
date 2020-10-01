package com.jshen;

public class Profit {
    public int maxProfit(int[] prices){
        if(prices.length == 0 || prices == null) return 0;

        int profit = 0;
        int buy = prices[0];
        for(int i = 1; i < prices.length; i++){
            profit = Math.max(profit, prices[i] - buy);
            buy = Math.min(buy, prices[i]);
        }
        return profit;
    }
}
