import java.util.Scanner;
public class MaximumPalindromes {
    private static final int MOD = 1000000007;
    private int[][] prefixSum;
    private long[] fact, invFact;
    public void initialize(String s) {
        int n = s.length();
        prefixSum = new int[n + 1][26];
        fact = new long[n + 1];
        invFact = new long[n + 1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 26; j++) {
                prefixSum[i + 1][j] = prefixSum[i][j];
            }
            prefixSum[i + 1][s.charAt(i) - 'a']++;
        }
        fact[0] = 1;
        invFact[0] = 1;
        for (int i = 1; i <= n; i++) {
            fact[i] = (fact[i - 1] * i) % MOD;
            invFact[i] = power(fact[i], MOD - 2);
        }
    }
    private long power(long base, int exp) {
        long res = 1;
        base %= MOD;
        while (exp > 0) {
            if (exp % 2 == 1) res = (res * base) % MOD;
            base = (base * base) % MOD;
            exp /= 2;
        }
        return res;
    }
    public int answerQuery(int l, int r) {
        int totalPairs = 0;
        int oddCount = 0;
        long denominatorInv = 1;
        for (int i = 0; i < 26; i++) {
            int count = prefixSum[r][i] - prefixSum[l - 1][i];
            int p = count / 2;
            totalPairs += p;
            if (count % 2 != 0) oddCount++;
            denominatorInv = (denominatorInv * invFact[p]) % MOD;
        }
        long result = (fact[totalPairs] * denominatorInv) % MOD;
        if (oddCount > 0) {
            result = (result * oddCount) % MOD;
        }
        return (int) result;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        if (!scanner.hasNext()) return;
        String s = scanner.next();
        MaximumPalindromes mp = new MaximumPalindromes();
        mp.initialize(s);
        if (scanner.hasNextInt()) {
            int q = scanner.nextInt();
            while (q-- > 0) {
                int l = scanner.nextInt();
                int r = scanner.nextInt();
                System.out.println(mp.answerQuery(l, r));
            }
        }
        scanner.close();
    }
}
