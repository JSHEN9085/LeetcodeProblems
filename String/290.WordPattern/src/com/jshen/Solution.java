package com.jshen;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class Solution {
    //Time: O(n), Space: O(n)
//    public boolean wordPattern(String pattern, String s) {
//        List<String> words = stringToWords(s);
//        if(pattern.length() != words.size()) return false;
//
//        HashMap<Character, String> ps = new HashMap<>();
//        HashMap<String, Character> sp = new HashMap<>();
//
//        for(int i = 0; i < pattern.length(); i++){
//            char c = pattern.charAt(i);
//            String word = words.get(i);
//
//            if(ps.containsKey(c) && !ps.get(c).equals(word)){
//                return false;
//            } else if(sp.containsKey(word) && sp.get(word) != c){
//                return false;
//            }
//
//            if(!ps.containsKey(c) && !sp.containsKey(word)){
//                ps.put(c, word);
//                sp.put(word, c);
//            }
//        }
//        return true;
//    }
//
//    public List<String> stringToWords(String s){
//        ArrayList<String> words = new ArrayList<>();
//        StringBuilder word = new StringBuilder();
//
//        int start = 0;
//        int end = s.length() - 1;
//        int p = 0;
//
//        while(start <= end){
//            while(s.charAt(start) == ' '){
//                start++;
//            }
//            p = start;
//
//            while(p <= end && s.charAt(p) != ' '){
//                word.append(s.charAt(p));
//                p++;
//            }
//            words.add(word.toString());
//            word.setLength(0);
//            start = p;
//        }
//        return words;
//    }

    public boolean wordPattern(String pattern, String s){
        String[] words = s.split(" ");
        if(words.length != pattern.length()) return false;

        HashMap<Character, String> match = new HashMap<>();
        HashSet<String> seen = new HashSet<>();

        for(int i = 0; i < pattern.length(); i++){
            char c = pattern.charAt(i);
            String word = words[i];

            if(!match.containsKey(c)){
                if(seen.contains(word)){
                    return false;
                }
                match.put(c, word);
                seen.add(word);
            } else {
                if(!match.get(c).equals(word)){
                    return false;
                }
            }
        }
        return true;
    }

}
