package com.jshen;

public class Solution {

    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

    public String numberToWords(int num) {
        if (num == 0) return "Zero";

        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num > 0){
            if(num % 1000 != 0){
                StringBuilder temp = new StringBuilder();
                helper(num % 1000, temp);
                sb.insert(0, temp.append(THOUSANDS[index]).append(" "));
            }
            index++;
            num /= 1000;
        }
        return sb.toString().trim();
    }

    private void helper(int num, StringBuilder temp) {
        if(num == 0) return;

        if(num < 20){
            temp.append(LESS_THAN_20[num]).append(" ");
        } else if (num < 100){
            temp.append(TENS[num / 10]).append(" ");
            helper(num % 10, temp);
        } else {
            temp.append(LESS_THAN_20[num / 100]).append(" Hundred").append(" ");
            helper(num % 100, temp);
        }
    }
}
