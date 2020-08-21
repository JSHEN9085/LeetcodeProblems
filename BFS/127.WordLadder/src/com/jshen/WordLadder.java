package com.jshen;

import java.util.*;

public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> reached = new HashSet<>(wordList); // put all words into a HashSet
        Queue<String> queue = new LinkedList<>();
        queue.add(beginWord);
        int step = 0;

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                String current = queue.remove();
                if(current.equals(endWord)) return step + 1; // can't use current == endWord

                char[] wordUnit = current.toCharArray();
                for(int j = 0; j < current.length(); j++){
                    char temp = wordUnit[j];
                    for(char c = 'a'; c <= 'z'; c++){
                        wordUnit[j] = c;
                        String s = new String(wordUnit);
                        if(reached.contains(s)){
                            queue.add(s);
                            reached.remove(s);
                        }
                    }
                    wordUnit[j] = temp;
                }
            }
            step++;
        }
        return 0;
    }
}
