package com.jshen;

public class Solution {

    public String toLowerCase(String s){
        if(s == null || s.length() == 0) return s;

        char[] c = s.toCharArray();
        for(int i = 0; i < s.length(); i++){
            if(c[i] >= 'A' && c[i] <= 'Z'){
                c[i] += 32;
            }
        }
        return String.valueOf(c);
        //return the content of char[] into a String //
    }
}
