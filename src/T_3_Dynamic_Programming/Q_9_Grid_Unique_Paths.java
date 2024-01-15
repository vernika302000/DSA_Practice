package T_3_Dynamic_Programming;
import java.util.*;

public class Q_9_Grid_Unique_Paths
{
    public static int solve(int i,int j,int m,int n)
    {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        int up=solve(i-1,j,m,n);
        int left=solve(i,j-1,m,n);
        return up+left;
    }
    public static int solve_DP(int i,int j,int[][] dp)
    {
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = solve_DP(i - 1, j, dp);
        int left = solve_DP(i, j - 1, dp);
        return dp[i][j] = up + left;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int m=scn.nextInt();
        int n=scn.nextInt();

        System.out.println(solve(m-1,n-1,m,n)); // Simple Recursion Technique

        int[][] dp=new int[m+1][n+1];
        for (int[] row : dp)
            Arrays.fill(row, -1);
        System.out.println(solve_DP(m-1,n-1,dp));// DP Memoization Technique
    }

}
