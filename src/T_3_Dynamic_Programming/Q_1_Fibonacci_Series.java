package T_3_Dynamic_Programming;
import java.util.*;

public class Q_1_Fibonacci_Series {
    /* Fibonacci Number - 0 1 1 2 3 5 8 13 21 => f(n) = f(n-1) + f(n-2) */
    public static int fibonacciRecursion(int n)
    {
        if(n<=1) return n;
        return fibonacciRecursion(n-1)+fibonacciRecursion(n-2);
    }
    public static int fibonacciDPMemoization(int n,int[] dp)
    {
        if(n<=1) return n;
        if(dp[n]!=-1) return dp[n];
        return dp[n]=fibonacciDPMemoization(n-1,dp)+fibonacciDPMemoization(n-2,dp);
    }
    public static int fibonacciDPTabulation(int n)
    {
        int prev = 0;
        int prev2 =1;
        for(int i=2;i<=n;i++)
        {
            int cur=prev+prev2;
            prev2=prev;
            prev=cur;
        }
        return prev;
    }
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        // using simple recursion
        int ans1 = fibonacciRecursion(n);
        System.out.println(ans1);

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans2=fibonacciDPMemoization(n,dp);
        System.out.println(ans2);


        int ans3=fibonacciDPTabulation(n);
        System.out.println(ans3);
    }
}
