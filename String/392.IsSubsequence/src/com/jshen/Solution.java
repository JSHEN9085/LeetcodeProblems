package com.jshen;

public class Solution {
    public boolean isSubsequence(String s, String t){
        if(s.length() == 0) return true;

        int sl = s.length() - 1;
        int tl = t.length() - 1;

        while(sl >= 0 && tl >= 0){

            if(s.charAt(sl) == t.charAt(tl)){
                sl--;
                tl--;
            } else {
                tl--;
            }

            if(sl < 0){
                return true;
            }
            if(tl < 0){
                return false;
            }
        }
        return false;
    }
}
