package com.jshen;

import java.util.HashMap;

public class Solution {

    //O(2n)
//    public int firstUniqChar(String s){
//        if(s.length() == 0 || s == null) return -1;
//
//        HashMap<Character, Integer> visited = new HashMap<>();
//        for(int i = 0; i < s.length(); i++){
//            visited.put(s.charAt(i), visited.getOrDefault(s.charAt(i), 0) + 1);
//        }
//
//        for(int j = 0; j < s.length(); j++){
//            if(visited.get(s.charAt(j)) == 1 ){
//                return j;
//            }
//        }
//        return -1;
//    }

    public int firstUniqChar(String s){
        int res = Integer.MAX_VALUE;

        for(int c = 'a'; c <= 'z'; c++){
            int first = s.indexOf(c);
            if(first != -1 && s.lastIndexOf(c) == first){
                if (first < res)
                    res = first;
            }
        }

        return res == Integer.MAX_VALUE ? -1 : res;
    }
}
