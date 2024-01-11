package T_3_Dynamic_Programming;

import java.util.*;

public class Q_2_Finbonacci_Number {
    public static int fib_recursive(int n) {
        if (n <= 1) return n;
        return fib_recursive(n - 1) + fib_recursive(n - 2);
    }

    public static int fib_memoization(int[] dp, int n) {
        if (n <= 1) return n;
        if (dp[n] != -1) return dp[n];
        return dp[n] = fib_memoization(dp, n - 1)+fib_memoization(dp, n - 2);

    }
    public static int fib_tabulation(int n)
    {
        int prev=0;
        int prev1=1;
        for(int i=2;i<=n;i++)
        {
            int curr=prev+prev1;
            prev1=prev;
            prev=curr;
        }
        return prev;
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        System.out.println(fib_recursive(n)); // fibonacci by simple recursive method

        int[] dp = new int[n + 1];
        Arrays.fill(dp, -1);
        System.out.println(fib_memoization(dp,n)); // fibonacci by memoization dp

        System.out.println(fib_tabulation(n)); // fibonacci by tabulation dp

    }
}
