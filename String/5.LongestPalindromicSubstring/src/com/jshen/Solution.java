package com.jshen;

public class Solution {
    private String res = "";

    public String longestPalindrome(String s){
        if(s == null || s.length() == 0) return s;

        for(int i = 0; i < s.length(); i++){
            //treat every charAt(i) or charAt(i) && charAt(i + 1) as the center of palindrome
            helper(s, i, i); //if palindrome length is odd, so center is a single char
            helper(s, i, i + 1); //if palindrome length is even, so center is two
        }
        return res;
    }

    private void helper(String s, int left, int right){
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            left--;
            right++;
        }

        String cur = s.substring(left + 1, right);
        if(cur.length() > res.length()){
            res = cur;
        }
    }
}
