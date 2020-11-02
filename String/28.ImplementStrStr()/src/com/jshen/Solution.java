package com.jshen;

public class Solution {

    public int strStr(String t, String p){
        int n = t.length();
        int m = p.length();
        if(m == 0) return 0;

        int[] pt = new int[m];
        computePrefix(p, pt);

        int k = -1;
        for(int i = 0; i < n; i++){
            while(k >= 0 && p.charAt(k + 1) != t.charAt(i) ){
                k = pt[k];
            }

            if(p.charAt(k + 1) == t.charAt(i)){
                k++;
            }

            if(k == m - 1){
                return i - m + 1;
            }
        }
        return -1;
    }

    private void computePrefix(String p, int[] pt){
        pt[0] = -1;
        int k = -1;
        int m = p.length();

        for(int i = 1; i < m; i++){
            while(k >= 0 && p.charAt(k + 1) != p.charAt(i) ){
                k = pt[k];
            }

            if(p.charAt(k + 1) == p.charAt(i)){
                k++;
            }
            pt[i] = k;
        }
    }


    //O(n^2)
//    public int strStr(String haystack, String needle){
//        if(needle.length() == 0 || needle == null) return 0;
//
//        int hl = haystack.length();
//        int nl = needle.length();
//
//        for(int i = 0; i < hl - nl; i++){
//            if(haystack.substring(i, i + nl).equals(needle)){
//                return i;
//            }
//        }
//        return -1;
//    }

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
