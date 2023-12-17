package T_2_Graphs;
import java.util.*;

public class Q_11_Number_Of_Enclaves
{
    // Algorithm -> The remaining 1's not connected to the boundary ones is the answer.
    public static class Pair
    {
        int first;
        int second;
        public Pair(int f,int s)
        {
            this.first=f;
            this.second=s;
        }
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
            {
                mat[i][j]=scn.nextInt();
            }
        }
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if( i==0||j==0||i==n-1||j==m-1)
                {
                    if(mat[i][j]==1)
                    {
                        q.add(new Pair(i,j));
                        vis[i][j]=1;
                    }
                }
            }
        }
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 &&mat[nrow][ncol]==1)
                {
                    vis[nrow][ncol]=1;
                    q.add(new Pair(nrow,ncol));
                }
            }

        }
        int cnt=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && mat[i][j]==1)
                    cnt++;
            }
        }
        System.out.println(cnt);
    }
}
