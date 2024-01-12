package T_3_Dynamic_Programming;
import java.util.*;

public class Q_3_Frog_Jump
{
    public static int Cost_Recursion(int ind,int[] arr)
    {
        if(ind==0) return 0;
        int left= Cost_Recursion(ind-1,arr) + Math.abs(arr[ind]-arr[ind-1]);
        int right=Integer.MAX_VALUE;
        if(ind>1)
        {
            right=Cost_Recursion(ind-2,arr) + Math.abs(arr[ind]-arr[ind-2]);
        }
        return Math.min(left,right);

    }
    public static int Cost_DP(int ind,int[] dp,int[] arr)
    {
        if(ind==0) return 0;
        if(dp[ind]!=-1) return dp[ind];
        int left=Cost_DP(ind-1,dp,arr)+Math.abs(arr[ind-1]-arr[ind]);
        int right=Integer.MAX_VALUE;
        if(ind>1)
        {
            right=Cost_DP(ind-2,dp,arr)+Math.abs(arr[ind-2]-arr[ind]);
        }
        return dp[ind]=Math.min(left,right);

    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=scn.nextInt();

        System.out.println(Cost_Recursion(n-1,arr)); // Simple recursive approach

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        System.out.println(Cost_DP(n-1,dp,arr)); // DP memoization

        

    }
}
