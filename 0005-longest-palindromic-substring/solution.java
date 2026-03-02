class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";

        // Transform s: insert '#' between characters to handle even-length palindromes
        StringBuilder sb = new StringBuilder();
        sb.append("^#");  // Starting sentinel
        for (char c : s.toCharArray()) {
            sb.append(c).append("#");
        }
        sb.append("$");  // Ending sentinel

        char[] T = sb.toString().toCharArray();
        int n = T.length;
        int[] P = new int[n];  // palindrome radius array
        int C = 0, R = 0;      // current center and right boundary

        for (int i = 1; i < n - 1; i++) {
            int mirror = 2 * C - i;

            if (i < R) {
                P[i] = Math.min(R - i, P[mirror]);
            }

            // Expand palindrome around i
            while (T[i + 1 + P[i]] == T[i - 1 - P[i]]) {
                P[i]++;
            }

            // Update center and right boundary
            if (i + P[i] > R) {
                C = i;
                R = i + P[i];
            }
        }

        // Find the longest palindrome
        int maxLen = 0, centerIndex = 0;
        for (int i = 1; i < n - 1; i++) {
            if (P[i] > maxLen) {
                maxLen = P[i];
                centerIndex = i;
            }
        }

        // Map back to original string indices
        int start = (centerIndex - maxLen) / 2;
        return s.substring(start, start + maxLen);
    }
}
