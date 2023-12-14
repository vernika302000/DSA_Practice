package T_3_Dynamic_Programming;
import java.util.*;

public class Q_2_Climbing_Stairs
{
    /* You are given n stairs, and currently you are at the 0th stair.
    *  You can take 1 or 2 steps at a time.
    *  Return the number of ways in which you can climb from 0th to nth stair.
    *  e.g. => for N=3 => a) 1 1 1 b) 2 1 c) 1 2 => number of ways - 3
    */
    public static int climbStairsRecursion(int n)
    {
        if(n==0) return 1;
        if(n==1) return 1;

        return climbStairsRecursion(n-1)+climbStairsRecursion(n-2);
    }
    public static int climbStairsDPMemoization(int n, int[] dp)
    {
        if(n==0) return 1;
        if(n==1) return 1;
        if(dp[n]!=-1) return dp[n];
        return climbStairsDPMemoization(n-1,dp)+ climbStairsDPMemoization(n-2,dp);

    }
    public static int climbStairsDP(int n,int[] dp)
    {
        dp[0]=1;
        dp[1]=1;
        for(int i=2;i<=n;i++)
        {
            dp[i]=dp[i-1]+dp[i-2];
        }
        return dp[n];
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        int ans=climbStairsRecursion(n);
        System.out.println("ways to reach "+n+" -> "+ans);

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        int ans1= climbStairsDPMemoization(n,dp);
        System.out.println("ways to reach "+n+" -> "+ans1);

        int[] dp1=new int[n+1];
        Arrays.fill(dp1,-1);
        int ans2= climbStairsDP(n,dp);
        System.out.println("ways to reach "+n+" -> "+ans2);

    }
}
