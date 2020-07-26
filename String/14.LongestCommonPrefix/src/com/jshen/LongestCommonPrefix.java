package com.jshen;


public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";

        String prefix = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(prefix) != 0){ //based on the testing, the question actually want common prefix starting from the beginning, that is why we set != 0 here instead of < 0
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        return prefix;
    }
}
