class Solution {
    public boolean isPalindrome(int x) {
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reversedNum = 0;
        int original = x;
        while (x > 0) {
            int lastDigit = x % 10;          
            if (reversedNum > (Integer.MAX_VALUE - lastDigit) / 10) {
                return false; 
            }
            reversedNum = (reversedNum * 10) + lastDigit;
            x = x / 10;
        }
        return original == reversedNum;
    }
}
