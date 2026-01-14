/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 */

// @lc code=start

import java.util.*;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<String>(wordList);
        if (!wordSet.contains(endWord)) return 0;

        wordSet.remove(beginWord);
        wordSet.remove(endWord);

        Set<String> forwardQueue = new HashSet<String>();;
        Set<String> backwardQueue = new HashSet<String>();;

        forwardQueue.add(beginWord);
        backwardQueue.add(endWord);

        int step = 1;

        while(!forwardQueue.isEmpty() && !backwardQueue.isEmpty()){
            if(forwardQueue.size() > backwardQueue.size()){
                Set<String> temp = forwardQueue;
                forwardQueue = backwardQueue;
                backwardQueue = temp;
            }
            
            step++;

            Set<String> validMutation = new HashSet<>();
            for(String word : forwardQueue){
                char[] arr = word.toCharArray();
                for(int i = 0; i < arr.length; i++){
                    char tempC = arr[i];
                    for(char c = 'a'; c <= 'z'; c++){
                        if(c == tempC) continue;
                        arr[i] = c;
                        String newString = new String(arr);
                        if(backwardQueue.contains(newString)){
                            return step;
                        }
                        if(wordSet.contains(newString)){
                            validMutation.add(newString);
                            wordSet.remove(newString);
                        }
                    }
                    arr[i] = tempC;
                }
            }
            forwardQueue = validMutation;
        }
        return 0;
    }
}
// @lc code=end

