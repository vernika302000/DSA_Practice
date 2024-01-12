package T_3_Dynamic_Programming;
import java.util.*;

public class Q_4_Climbing_n_stairs
{
    public static int nStairs_Recursion(int ind)
    {
        if(ind==0) return 1;
        if(ind==1) return 1;
        int left=nStairs_Recursion(ind-1);
        int right=nStairs_Recursion(ind-2);
        return left+right;
    }
    public static int nStairs_memoization_DP(int ind,int[] dp)
    {
        if(ind==0) return dp[0];
        if(ind==1) return dp[1];
        if(dp[ind]!=-1) return dp[ind];
        return nStairs_memoization_DP(ind-1,dp)+nStairs_memoization_DP(ind-2,dp);
    }
    public static int nStairs_tabulation(int ind,int prev1,int prev2)
    {
        for(int i=2;i<=ind;i++)
        {
            int curr=prev1+prev2;
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();

        System.out.println(nStairs_Recursion(n)); // simple recursive function

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=1;
        dp[1]=1;
        System.out.println(nStairs_memoization_DP(n,dp)); // using memoization technique

        int prev1=1;
        int prev2=1;
        System.out.println(nStairs_tabulation(n,prev1,prev2)); //using tabulation method

    }
}
