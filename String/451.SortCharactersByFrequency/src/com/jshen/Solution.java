package com.jshen;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution {
    public String frequencySort(String s){
        if(s.length() == 0 || s == null) return "";

        //start with bucket sort
        Map<Character, Integer> count = new HashMap<>();
        for(char c : s.toCharArray()){
            count.put(c, count.getOrDefault(c, 0) + 1);
        }

        List<Character> [] bucket = new List[s.length() + 1];

        for(char key : count.keySet()){
            int frequency = count.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        //iterate bucket
        StringBuilder res = new StringBuilder();
        for(int i = bucket.length - 1; i >= 0; i--){
            if(bucket[i] != null){
                for(char c : bucket[i]){
                    for(int j = 0; j < i; j++){
                        res.append(c);
                    }
                }
            }
        }
        return res.toString();
    }
}

        for (int pos = bucket.length - 1; pos >= 0; pos--){
                if (bucket[pos] != null){
                for (char c : bucket[pos]){
                for (int i = 0; i < pos; i++){
        sb.append(c);
        }
        }
        }
        }