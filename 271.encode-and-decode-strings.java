/*
 * @lc app=leetcode id=271 lang=java
 *
 * [271] Encode and Decode Strings
 */

// @lc code=start
public class Codec {

    // Encodes a list of strings to a single string.
    public String encode(List<String> strs) {
      StringBuilder sb = new StringBuilder();
      for(String s : strs){
        sb.append(s.length()).append('#').append(s);
      }
      return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        // 5#Hello5#World"
        int i = 0;
        while(i < s.length()){
          int sym = s.indexOf('#', i);
          int len = Integer.parseInt(s.substring(i, sym));
          i = sym + 1;
          res.add(s.substring(i, i + len));
          i += len;
        }
        return res;
    }
}

// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.decode(codec.encode(strs));
// @lc code=end

