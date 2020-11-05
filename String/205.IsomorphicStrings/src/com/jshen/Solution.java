package com.jshen;

import java.util.HashMap;

public class Solution {

    //time: O(2n), space: O(2n)
//    public boolean isIsomorphic(String s, String t){
//        if(s.length() != t.length()) return false;
//
//        return helper(s, t) && helper(t, s);
//    }
//
//    private boolean helper(String s, String t){
//        HashMap<Character, Character> match = new HashMap<>();
//
//        for(int i = 0; i < s.length(); i++){
//            char charS = s.charAt(i);
//            char charT = t.charAt(i);
//
//            if(match.containsKey(charS)){
//                if(match.get(charS) != charT){
//                    return false;
//                }
//            } else {
//                match.put(charS, charT);
//            }
//        }
//        return true;
//    }

    //ASCII, Time: O(n), space: O(1)
    public boolean isIsomorphic(String s, String t){
        if(s.length() != t.length()) return false;

        int[] mapS = new int[128];
        int[] mapT = new int[128];

        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);

            if(mapS[cs] != mapT[ct]){
                return false;
            } else {
                if(mapS[cs] == 0){
                    mapS[cs] = i + 1;
                    mapT[ct] = i + 1;
                }
            }
        }
        return true;
    }
}
