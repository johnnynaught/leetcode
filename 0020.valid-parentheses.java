/*
 * @lc app=leetcode id=20 lang=java
 *
 * [20] Valid Parentheses
 */

// @lc code=start
class Solution {
    public boolean isValid(String s) {
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put('}', '{');
        map.put(']', '[');

        Deque<Character> stack = new ArrayDeque<>();
        for(int i = 0; i < s.length(); i++){
            Character c = s.charAt(i);
            if(map.containsKey(c)){
                Character top = stack.isEmpty()? '!' : stack.pop();
                if(top != map.get(c)){
                    return false;
                }
            }else{
                stack.push(c);           
            }
        }
        return stack.isEmpty();
    }
}
// @lc code=end

