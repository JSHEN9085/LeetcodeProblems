package com.jshen;

import java.util.*;

public class Solution {

    //Time: O(N * KlogK) where N is the length of strs, and K is the maximum length of a string in strs.
    //Space: O(N), the total information content stored in map
//    public List<List<String>> groupAnagrams(String[] strs) {
//        if(strs.length == 0) return new ArrayList<>();
//
//        List<List<String>> res = new ArrayList<>();
//        HashMap<String, Integer> map = new HashMap<>();
//
//        for(String s : strs){
//            char[] c = s.toCharArray();
//            Arrays.sort(c);
//            String key = new String(c);
//
//            if(map.containsKey(key)){
//                res.get(map.get(key)).add(s);
//            } else {
//                List<String> list = new ArrayList<>();
//                list.add(s);
//                res.add(list);
//                map.put(key, res.size() - 1);
//            }
//        }
//        return res;
//    }

    //Time: O(NK), where N is the length of strs, and K is the maximum length of a string
    //Space: O(N), actually O(NK), it is all info stored in the HashMap
    public List<List<String>> groupAnagrams(String[] strs){
        if(strs.length == 0) return new ArrayList<>();

        HashMap<String, List<String>> map = new HashMap<>();
        for(String s : strs){
            int[] count = new int[128];
            for(char c : s.toCharArray()){
                count[c]++;
            }

            StringBuilder sb = new StringBuilder();
            for(int i = 97; i < 128; i++){
                if(count[i] != 0){
                    sb.append((char) i);
                    sb.append(count[i]);
                }
            }
            String key = sb.toString();
            if(map.containsKey(key)){
                map.get(key).add(s);
            } else {
                List<String> list = new ArrayList<>();
                list.add(s);
                map.put(key, list);
            }
        }
        return new ArrayList<>(map.values());
    }
}