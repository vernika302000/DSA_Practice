package T_3_Dynamic_Programming;
import java.util.*;

public class Q_11_Maximum_sum_path
{
    // 2 3 -> 5 9 6  11 5 2 -> output - 21
    public static int solve(int i,int j,int[][] mat)
    {
        if(i==0 && j==0) return mat[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        int up=solve(i-1,j,mat)+mat[i][j];
        int left=solve(i,j-1,mat)+mat[i][j];
        return Math.min(left,up);
    }
    public static int solve_DP(int i,int j,int[][] mat,int[][] dp)
    {
        if(i==0 && j==0) return mat[0][0];
        if(i<0 || j<0) return Integer.MAX_VALUE;
        if(dp[i][j]!=-1) return dp[i][j];
        int up=solve_DP(i-1,j,mat,dp)+mat[i][j];
        int left=solve_DP(i,j-1,mat,dp)+mat[i][j];
        return dp[i][j]=Math.min(left,up);
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=scn.nextInt();
            }
        }

        System.out.println(solve(n-1,m-1,mat)); // simple recursive approach

        int[][] dp=new int[n][m];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(solve_DP(n-1,m-1,mat,dp));


    }
}
