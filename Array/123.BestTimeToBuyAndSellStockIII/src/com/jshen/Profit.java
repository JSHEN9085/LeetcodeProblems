package com.jshen;

public class Profit {
    public int maxProfit(int[] prices){
        if(prices.length < 2 || prices == null) return 0;

        int buyOne = Integer.MAX_VALUE;
        int sellOne = 0;

        int buyTwo = Integer.MAX_VALUE;
        int sellTwo = 0;

        for(int i = 0; i < prices.length; i++){
            buyOne = Math.min(buyOne, prices[i]);
            sellOne = Math.max(sellOne, prices[i] - buyOne);

            buyTwo = Math.min(buyTwo, prices[i] - sellOne);
            sellTwo = Math.max(sellTwo, prices[i] - buyTwo);
        }
        return sellTwo;
    }
}
