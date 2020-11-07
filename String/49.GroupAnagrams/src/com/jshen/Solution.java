package com.jshen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Solution {

    //Time: O(N * KlogK) where N is the length of strs, and KK is the maximum length of a string in strs.
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

    public List<List<String>> groupAnagrams(String[] strs){
        
    }
}
