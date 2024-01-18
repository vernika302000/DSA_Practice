package T_3_Dynamic_Programming;
import java.util.*;

public class Q_16_Partition_subset_equal_sum
{
    // n=4 => 1 5 11 5 - possible
    public static boolean solve_DP(int ind,int[] arr,int[][] dp,int sum)
    {
        if(sum==0) return true;
        if(ind==0) return (arr[ind]==sum);
        if(dp[ind][sum]!=-1) return dp[ind][sum]!=0;
        boolean notTake=solve_DP(ind-1,arr,dp,sum);
        boolean Take=false;
        if(sum>=arr[ind]) Take=solve_DP(ind-1,arr,dp,sum-arr[ind]);
        dp[ind][sum]=Take||notTake?1:0;
        return Take||notTake;

    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=scn.nextInt();
        int totSum=0;
        for(int val:arr) totSum+=val;
        if(totSum%2!=0)
        {
            System.out.println("Not possible");
        }
        else
        {
            int k=totSum/2;
            int[][] dp=new int[n][k+1];
            for(int[] row:dp) Arrays.fill(row,-1);
            boolean ans=solve_DP(n-1,arr,dp,k);
            if(ans) System.out.println("Possible");
            else System.out.println("Not possible");
        }

    }
}
