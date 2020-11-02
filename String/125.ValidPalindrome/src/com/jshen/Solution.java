package com.jshen;

public class Solution {
    public boolean isPalindrome(String s){
        if(s.length() == 0 || s == null) return true;

        char[] cArr = s.toLowerCase().toCharArray();

        int len = s.length();
        int i = 0, j = len - 1;

        while(i < j){
            while(i < len && !Character.isLetterOrDigit(cArr[i])){
                i++;
            }

            while(j >= 0 && !Character.isLetterOrDigit(cArr[j])){
                j--;
            }

            if( i < j && cArr[i++] != cArr[j--]){
                return false;
            }
        }
        return true;
    }
}
