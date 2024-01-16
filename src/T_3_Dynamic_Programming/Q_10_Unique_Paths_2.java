package T_3_Dynamic_Programming;
import java.util.*;

public class Q_10_Unique_Paths_2
{
    //3 3 -> 0 0 0  0 -1 0  0 0 0
    public static int unique_paths(int i,int j,int[][] mat)
    {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        if(i>=0 && j>=0 && mat[i][j]==-1) return 0;
        int up=unique_paths(i-1,j,mat);
        int left=unique_paths(i,j-1,mat);
        return up+left;
    }
    public static int unique_paths_dp(int i, int j, int[][] maze, int[][] dp)
    {
        if (i >= 0 && j >= 0 && maze[i][j] == -1)
            return 0;
        if (i == 0 && j == 0)
            return 1;
        if (i < 0 || j < 0)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int up = unique_paths_dp(i - 1, j, maze, dp);
        int left = unique_paths_dp(i, j - 1, maze, dp);
        return dp[i][j] = up + left;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int m= scn.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) mat[i][j]=scn.nextInt();
        }

        System.out.println(unique_paths(n-1,m-1,mat)); // simple recursive approach

        int dp[][] = new int[n][m];
        for (int row[] : dp)
            Arrays.fill(row, -1);
        System.out.println(unique_paths_dp(n-1,m-1,mat,dp)); // Memoization DP approach

    }
}
