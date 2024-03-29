package com.jshen;


import java.util.HashSet;
import java.util.Set;

public class Solution {
    //time and space complexity is both O(n)
//    public int longestPalindorme(String s){
//        int res = 0;
//        if(s.length() == 0 || s == null) return res;
//
//        Set<Character> count = new HashSet<>();
//
//        for(int i = 0; i < s.length(); i++){
//            if(count.contains(s.charAt(i))){
//                res+=2;
//                count.remove(s.charAt(i));
//            } else {
//                count.add(s.charAt(i));
//            }
//        }
//
//        if(count.isEmpty()){
//            return res;
//        }
//        return res + 1;
//    }

    //constant space complexity
    public int longestPalindrome(String s){
        int res = 0;
        if(s.length() == 0 || s == null) return res;

        int[] lowerCase = new int[26];
        int[] upperCase = new int[26];

        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);

            if(c > 96){
                lowerCase[c - 'a']++;
            } else {
                upperCase[c - 'A']++;
            }
        }

        for(int j = 0; j < 26; j++){
            res += lowerCase[j] / 2 * 2;
            res += upperCase[j] / 2 * 2;
        }

        return res == s.length() ? res : res + 1;
    }
}
