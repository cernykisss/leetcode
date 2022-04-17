public class Change {

    public static void main(String[] args) {
        change(5, new int[] {3,2,5});
    }

    public static int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        // Arrays.fill(dp, amount + 1);
        dp[0] = 1;
        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                dp[i] += dp[i - coin];
            }
        }
        return dp[amount];
    }
}
