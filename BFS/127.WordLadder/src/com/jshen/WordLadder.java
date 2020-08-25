package com.jshen;

import java.util.*;

public class WordLadder {
    //version 1 BFS
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> reached = new HashSet<>(wordList); // put all words into a HashSet
//        Queue<String> queue = new LinkedList<>();
//        queue.add(beginWord);
//        int step = 0;
//
//        while(!queue.isEmpty()){
//            int size = queue.size();
//            for(int i = 0; i < size; i++){
//                String current = queue.remove();
//                if(current.equals(endWord)) return step + 1; // can't use current == endWord
//
//                char[] wordUnit = current.toCharArray();
//                for(int j = 0; j < current.length(); j++){
//                    char temp = wordUnit[j];
//                    for(char c = 'a'; c <= 'z'; c++){
//                        wordUnit[j] = c;
//                        String s = new String(wordUnit);
//                        if(reached.contains(s)){
//                            queue.add(s);
//                            reached.remove(s);
//                        }
//                    }
//                    wordUnit[j] = temp;
//                }
//            }
//            step++;
//        }
//        return 0;
//    }

    //version 2 Bidirectional BFS
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<>(wordList);
        if(!reached.contains(endWord)) return 0;

        Set<String> q1 = new HashSet<>();
        Set<String> q2 = new HashSet<>();
        q1.add(beginWord);
        q2.add(endWord);

        int l = beginWord.length();
        int step = 0;

        while(!q1.isEmpty() && !q2.isEmpty()){
            ++step;

            if(q1.size() > q1.size()){
                Set<String> tem = q1;
                q1 = q2;
                q2 = tem;
            }

            Set<String> q = new HashSet<>();

            for(String w : q1){
                char[] chs = w.toCharArray();
                for(int i = 0; i < l; ++i){
                    char ch = chs[i];
                    for(char c = 'a'; c <= 'z'; ++c){
                        chs[i] = c;
                        String t = new String(chs);
                        if(q2.contains(t)) return step + 1;
                        if(!reached.contains(t)) continue;
                        reached.remove(t);
                        q.add(t);
                    }
                    chs[i] = ch;
                }
            }
            q1 = q;
        }
        return 0;
    }


    // solution beat 96%
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//        Set<String> dict = new HashSet<>(wordList);
//        if(!dict.contains(endWord)) return 0;
//        return search(beginSet,endSet,dict,1);
//    }
//    private int search(Set<String> beginSet, Set<String> endSet, Set<String> dict, int cnt){
//        if(beginSet.isEmpty() || endSet.isEmpty())
//            return 0;
//        cnt++;
//        dict.removeAll(beginSet);
//        Set<String> nextSet = new HashSet<>();
//        for(String str: beginSet){
//            char[] chs = str.toCharArray();
//            for(int i = 0; i< chs.length; i++){
//                char c = chs[i];
//
//                for(char j = 'a'; j<= 'z'; j++){
//                    if(c == j)continue;
//                    chs[i] = j;
//                    String temp = new String(chs);
//                    if(!dict.contains(temp)) continue;
//                    if(endSet.contains(temp)) return cnt;
//                    nextSet.add(temp);
//                }
//                chs[i] = c;
//            }
//        }
//        if(nextSet.size() > endSet.size())
//            return search(endSet,nextSet, dict, cnt);
//        return  search(nextSet, endSet, dict, cnt);
//    }

      //without helper 12ms
//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//
//        Set<String> wordDict = new HashSet<>(wordList);
//        if(!wordDict.contains(endWord))
//            return 0;
//        Set<String> beginSet = new HashSet<>();
//        Set<String> endSet = new HashSet<>();
//        beginSet.add(beginWord);
//        endSet.add(endWord);
//        int level = 2;
//
//        while(!beginSet.isEmpty() && !endSet.isEmpty()) {
//            if(beginSet.size() > endSet.size()) {
//                Set<String> tmp = beginSet;
//                beginSet = endSet;
//                endSet = tmp;
//            }
//            Set<String> tmpSet = new HashSet<>();
//            for(String word : beginSet) {
//                for(int i = 0; i < word.length(); i++) {
//                    char[] chs = word.toCharArray();
//                    for(char k = 'a'; k <= 'z'; k++) {
//                        chs[i] = k;
//                        String cur = new String(chs);
//                        if(endSet.contains(cur))
//                            return level;
//                        if(wordDict.contains(cur)) {
//                            tmpSet.add(cur);
//                            wordDict.remove(cur);
//                        }
//
//                    }
//                }
//            }
//            beginSet = tmpSet;
//            level++;
//        }
//        return 0;
//
//    }
}
