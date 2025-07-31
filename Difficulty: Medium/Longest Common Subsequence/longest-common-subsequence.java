// class Solution {
//     // Define dp array
//     int[][] dp = new int[1001][1001];

//     // Recursive function with memoization
//     int LCS(int i, int j, String s1, String s2) {
//         // Base case
//         if (i == s1.length() || j == s2.length()) return 0;

//         // If already computed
//         if (dp[i][j] != -1) return dp[i][j];

//         // If characters match
//         if (s1.charAt(i) == s2.charAt(j)) {
//             dp[i][j] = 1 + LCS(i + 1, j + 1, s1, s2);
//         } else {
//             dp[i][j] = Math.max(LCS(i + 1, j, s1, s2), LCS(i, j + 1, s1, s2));
//         }

//         return dp[i][j];
//     }

//     // Main function
//     int lcs(String s1, String s2) {
//         // Initialize dp array with -1
//         for (int i = 0; i < 1001; i++) {
//             for (int j = 0; j < 1001; j++) {
//                 dp[i][j] = -1;
//             }
//         }

//         return LCS(0, 0, s1, s2);
//     }
// }
class Solution {
    public int lcs(String s1, String s2) {
        int n = s1.length();
        int m = s2.length();

        int[][] dp = new int[n + 1][m + 1];

        // Bottom-up filling
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[n][m];
    }
}
