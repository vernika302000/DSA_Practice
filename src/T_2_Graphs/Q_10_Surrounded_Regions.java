package T_2_Graphs;
import java.util.*;

public class Q_10_Surrounded_Regions
{
    // Algorithm -> DFS
    // Visit the boundary of the matrix and convert all the 0's and 0's connected to it and mark them as-
    // -1 in visited array.
    // Now then traverse the inner part of matrix and for every 0 check -
    // - if the boundary of it in visited array is marked 1 or not if not then convert it into X else not.
    // Input -> 5 4 -> X X X X | X 0 X X | X 0 0 X | X 0 X X | X X 0 0
    // Output -> X X X X | X X X X | X X X X | X X X X | X X 0 0
    public static void dfs(char[][] mat,int n,int m,int i,int j,int[][] vis)
    {
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        vis[i][j]=1;
        for(int k=0;k<4;k++)
        {
            int nrow=i+drow[k];
            int ncol=i+dcol[k];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]=='O')
            {
                dfs(mat,n,m,nrow,ncol,vis);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        char[][] mat=new char[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=scn.next().charAt(0);
            }
        }
        int[][] vis=new int[n][m];
        Arrays.fill(vis,0);
        //first row
        for(int j=0;j<m;j++)
        {
            if(vis[0][j]==0 && mat[0][j]=='O')
                dfs(mat,n,m,0,j,vis);
            if(vis[n-1][j]==0 && mat[n-1][j]=='O')
                dfs(mat,n,m,n-1,j,vis);
        }
        for(int i=0;i<n;i++)
        {
            if(vis[i][0]==0 && mat[i][0]=='O')
                dfs(mat,n,m,i,0,vis);
            if(vis[i][m-1]==0 && mat[i][m-1]=='O')
                dfs(mat,n,m,i,m-1,vis);
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && mat[i][j]=='O')
                {
                    mat[i][j]='X';
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) System.out.print(mat[i][j]);
            System.out.println();
        }



    }
}
