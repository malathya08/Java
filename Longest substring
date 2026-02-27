import java.util.Arrays;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] index = new int[128];
        Arrays.fill(index, -1);
        
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char current = s.charAt(end);
            if (index[current] >= start) {
                start = index[current] + 1;
            }
            index[current] = end;
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
