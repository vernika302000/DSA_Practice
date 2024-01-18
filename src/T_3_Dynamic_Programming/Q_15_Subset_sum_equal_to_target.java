package T_3_Dynamic_Programming;
import java.util.*;

public class Q_15_Subset_sum_equal_to_target
{
    public static boolean solve_recursion(int ind,int target,int[] arr)
    {
        if(target==0) return true;
        if(ind == 0) return (arr[0]==target);
        boolean notTake=solve_recursion(ind-1,target,arr);
        boolean Take=false;
        if(target>=arr[ind])
            Take=solve_recursion(ind-1,target-arr[ind],arr);
        return Take|notTake;
    }
    public static boolean solve_DP(int ind,int target,int[] arr,int[][] dp)
    {
        if(target==0) return true;
        if(ind == 0) return (arr[0]==target);
        if(dp[ind][target]!=-1) return dp[ind][target]!=0;
        boolean notTake=solve_DP(ind-1,target,arr,dp);
        boolean Take=false;
        if(target>=arr[ind])
            Take=solve_DP(ind-1,target-arr[ind],arr,dp);
        dp[ind][target]=notTake||Take?1:0;
        return Take||notTake;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=scn.nextInt();
        int target=scn.nextInt();

        System.out.println(solve_recursion(n-1,target,arr)); // simple recursive technique

        int[][] dp=new int[n][target+1];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(solve_DP(n-1,target,arr,dp));


    }
}
