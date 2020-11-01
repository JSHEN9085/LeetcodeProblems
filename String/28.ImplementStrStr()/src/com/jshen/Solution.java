package com.jshen;

public class Solution {

    public int strStr(String haystack, String needle){
        if(haystack.length() == 0 || haystack == null) return 0;

        int hl = haystack.length();
        int nl = needle.length();

        for(int i = 0; i < hl - nl; i++){
            if(haystack.substring(i, i + nl).equals(needle)){
                return i;
            }
        }
        return -1;
    }

    //O(n^2)
//    public int strStr(String haystack, String needle){
//        if(needle.length() == 0 || needle == null) return 0;
//
//        for(int i = 0; i < haystack.length(); i++){
//            if(haystack.charAt(i) == needle.charAt(0)){
//                int len = 0;
//
//                while(i + len < haystack.length() && len < needle.length() &&
//                        haystack.charAt(i + len) == needle.charAt(len)){
//                    len++;
//                }
//
//                if(len == needle.length()){
//                    return i;
//                }
//            }
//        }
//        return -1;
//    }
}
