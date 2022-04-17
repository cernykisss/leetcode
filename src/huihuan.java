public class huihuan {

    public static void main(String[] args) {
        int i = GetSteps(4, 10);
        System.out.println(i);
    }

    public static int GetSteps(int k, int n) {
        int[][] dp = new int[k + 1][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < k + 1; i++) {
            for (int j = 0; j < n; j++) {
                dp[i][j] = dp[i - 1][(j - 1 + n) % n] + dp[i - 1][(j + 1) % n];
            }
        }
        return dp[k][0];
    }
}
