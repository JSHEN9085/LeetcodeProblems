package com.jshen;

import java.util.HashMap;

public class Solution {

    //Time: O(r + m), space: O(1) max 26 letters
//    public boolean canConstruct(String ransomNote, String magazine) {
//
//        HashMap<Character, Integer> m = new HashMap<>();
//        for(int i = 0; i < magazine.length(); i++){
//            char c = magazine.charAt(i);
//
//            if(m.get(c) != null){
//                m.put(c, m.get(c) + 1);
//            } else {
//                m. put(c, 1);
//            }
//        }
//
//        for(int j = 0; j < ransomNote.length(); j++){
//            char c = ransomNote.charAt(i);
//            if(m.get(c) == null){
//                return false;
//            } else {
//                m.put(c, m.get(c) - 1);
//                if(m.get(c) == 0){
//                    m.remove(c);
//                }
//            }
//        }
//        return true;
//    }



    public boolean canConstruct(String ransomNote, String magazine) {
        int[] bucket = new int[26];
        //首先将magazine中各元素分配到桶中
        for (int i = 0;i < magazine.length(); i++){
            char ch = magazine.charAt(i);
            bucket[ch-'a']++;
        }
        //从桶中取出元素，与ransomNote中的元素匹配
        for (int i = 0; i < ransomNote.length(); i++){
            char ch = ransomNote.charAt(i);
            if (--bucket[ch-'a'] < 0)
                return false;
        }
        return true;
    }
}
