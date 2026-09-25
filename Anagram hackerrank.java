    static boolean isAnagram(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }       
        a = a.toLowerCase();
        b = b.toLowerCase();
        int[] frequencies = new int[26];
        for (int i = 0; i < a.length(); i++) {
            frequencies[a.charAt(i) - 'a']++;
            frequencies[b.charAt(i) - 'a']--;
        }
        for (int count : frequencies) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }


