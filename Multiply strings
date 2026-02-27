class Solution {
    public String multiply(String s1, String s2) {
        if (s1.equals("0") || s2.equals("0")) return "0";
        int n1 = s1.length(), n2 = s2.length();
        int[] res = new int[n1 + n2];
        for (int i = n1 - 1; i >= 0; i--) {
            for (int j = n2 - 1; j >= 0; j--) {
                int p = (s1.charAt(i) - '0') * (s2.charAt(j) - '0');
                int s = p + res[i + j + 1];
                res[i + j + 1] = s % 10;
                res[i + j] += s / 10;
            }
        }
        int k = 0;
        while (k < res.length && res[k] == 0) k++;
        char[] c = new char[res.length - k];
        for (int i = 0; i < c.length; i++) {
            c[i] = (char) (res[k++] + '0');
        }
        return new String(c);
    }
}
