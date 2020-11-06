package com.jshen;

import java.util.HashMap;

public class Solution {
    //HashMap
//    public boolean isAnagram(String s, String t){
//        if(s.length() != t.length()) return false;
//
//        HashMap<Character, Integer> count = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            char c = s.charAt(i);
//            count.put(c, count.getOrDefault(c, 0) + 1);
//        }
//
//        for(int i = 0; i < t.length(); i++){
//            char c = t.charAt(i);
//            if(count.containsKey(c)){
//                count.put(c, count.get(c) - 1);
//                if(count.get(c) == 0){
//                    count.remove(c);
//                }
//            } else {
//                return false;
//            }
//        }
//        if(count.size() > 0){
//            return false;
//        }
//        return true;
//    }


    public boolean isAnagram(String s, String t){
        if(s.length() != t.length()) return false;

        int[] count = new int[26];

        for(int i = 0; i < s.length(); i++){
            count[s.charAt(i) - 'a']++;
            count[t.charAt(i) - 'a']--;
        }

        for(int num : count){
            if(num != 0){
                return false;
            }
        }
        return true;
    }
}
