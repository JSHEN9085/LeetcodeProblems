package com.jshen;

public class Solution {
    //with O(1) extra memory.
    public void reverseString(char[] s){
        if(s.length < 2) return;

        int len = s.length;
        for(int i = 0; i < len / 2; i++){
            char temp = s[i];
            s[i] = s[len - 1 - i];
            s[len - 1 - i] = temp;
        }
    }
}
