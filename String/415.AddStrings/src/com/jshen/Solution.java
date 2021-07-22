package com.jshen;

public class Solution {
    public String addStrings(String num1, String num2){

        StringBuilder res = new StringBuilder();
        int carry = 0;

        for(int i = num1.length() - 1, j = num2.length() - 1;
        i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = 0, y = 0;
            if(i >= 0){
                x = num1.charAt(i) - '0';
            }
            if(j >= 0){
                y = num2.charAt(j) - '0';
            }

            res.append( (x + y + carry) % 10 );
            carry = (x + y + carry) / 10;
        }
        return res.reverse().toString();
    }
}
