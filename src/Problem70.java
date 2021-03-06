/**
 * Created by snow on 2018/7/5.
 */
public class Problem70 {
    public int climbStairs(int n) {

        /* Time Limit Exceeded */

//        if (n <= 0) return -1;
//
//        if (n == 1) return 1;
//
//        if (n == 2) return 2;
//
//        return climbStairs(n - 2) + climbStairs(n - 1);

        if (n == 1) {
            return 1;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
