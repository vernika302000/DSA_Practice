package T_3_Dynamic_Programming;
import java.util.*;

public class Q_13_Maximum_Minimum_Falling_path
{
    /*
       4 4
       1   2 10 4
       100 3 2  1
       1   1 20 2
       1   2 2  1
       -> output - 105
     */
    public static int solve(int n,int m,int[][] mat,int i,int j)
    {
        if(j<0 || j>=m) return (int)(-1e8);
        if(i==0) return mat[0][j];
        int s=mat[i][j]+solve(n,m,mat,i-1,j);
        int ld=mat[i][j]+solve(n,m,mat,i-1,j-1);
        int rd=mat[i][j]+solve(n,m,mat,i-1,j+1);

        return Math.max(s,Math.max(ld,rd));
    }
    public static int solve_DP(int i,int j,int[][] dp,int[][] mat)
    {
        if(j<0 || j>=mat[0].length) return (int)(-1e8);
        if(i==0) return mat[0][j];
        if(dp[i][j]!=-1) return dp[i][j];
        int s=mat[i][j]+solve_DP(i-1,j,dp,mat);
        int ld=mat[i][j]+solve_DP(i-1,j-1,dp,mat);
        int rd=mat[i][j]+solve_DP(i-1,j+1,dp,mat);

        return dp[i][j]=Math.max(s,Math.max(ld,rd));
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
                mat[i][j]=scn.nextInt();
        }

        System.out.println(solve(n,m,mat,n-1,m-1));
    }
}
