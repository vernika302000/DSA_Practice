package T_3_Dynamic_Programming;

import java.util.*;

public class Q_12_Triangle_Path
{
    // n=4 -> 1  2 3   3 6 7   8 9 6 10 => output - 14
    public static int solve(int i,int j,int n,int[][] mat)
    {
        if(i==n-1) return mat[n-1][j];
        int d=mat[i][j]+solve(i+1,j,n,mat);
        int dg=mat[i][j]+solve(i+1,j+1,n,mat);
        return Math.min(d,dg);
    }
    public static int solve_DP(int i,int j,int[][] dp,int n,int[][] mat)
    {
        if(i==n-1) return mat[n-1][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int d=mat[i][j]+solve_DP(i+1,j,dp,n,mat);
        int dg=mat[i][j]+solve_DP(i+1,j+1,dp,n,mat);
        return dp[i][j]=Math.min(d,dg);
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int[][] mat=new int[n][n];
        int size=1;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<size;j++)
            {
                mat[i][j]=scn.nextInt();
            }
            size++;
        }

        System.out.println(solve(0,0,n,mat)); // simple recursive approach

        int[][] dp=new int[n][n];
        for(int[] row:dp) Arrays.fill(row,-1);
        System.out.println(solve_DP(0,0,dp,n,mat)); // memoization DP technique


    }
}
