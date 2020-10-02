package com.jshen;

public class Profit {
    public int maxProfit(int[] prices){
        if(prices.length < 2 || prices == null) return 0;

        int[] record = new int[2];
        int profit = 0;
        int buy = prices[0];

        for(int i = 1; i < prices.length; i++){
            if(prices[i - 1] >= prices[i]){
                buy = prices[i];
            }
            if(prices[i - 1] < prices[i] && prices[i] > prices[i + 1]){

            }

        }
    }
}
