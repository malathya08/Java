import java.util.*;
public class Solution {
    public static int sherlockAndAnagrams(String text) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        int len = text.length();
        for (int start = 0; start < len; start++) {
            for (int end = start + 1; end <= len; end++) {
                char[] tempArray = text.substring(start, end).toCharArray();
                Arrays.sort(tempArray);
                String key = new String(tempArray);               
                Integer val = map.get(key);
                if (val == null) {
                    map.put(key, 1);
                } else {
                    map.put(key, val + 1);
                }
            }
        }
        int result = 0;
        for (Integer freq : map.values()) {
            if (freq > 1) {
                result += (freq * (freq - 1)) / 2;
            }
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        if (input.hasNextInt()) {
            int queries = input.nextInt();
            for (int k = 0; k < queries; k++) {
                String str = input.next();
                System.out.println(sherlockAndAnagrams(str));
            }
        }
        input.close();
    }
}


