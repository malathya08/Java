import java.util.HashSet;
class Solution {
    public int[] intersection(int[] a, int[] b) {
        HashSet<Integer> s = new HashSet<>();
        for (int x : a) s.add(x);
        HashSet<Integer> i = new HashSet<>();
        for (int x : b) {
            if (s.contains(x)) i.add(x);
        }
        int[] res = new int[i.size()];
        int k = 0;
        for (int x : i) res[k++] = x;    
        return res;
    }
}
