package T_2_Graphs;

import java.util.*;

public class Q_9_Distance_of_nearest_cell_having_1
{   // 3 3 -> 1 0 1 1 1 0 1 0 0
    public static class Pair
    {
        int first;
        int second;
        int third;
        public Pair(int f, int s, int t)
        {
            this.first=f;
            this.second=s;
            this.third=t;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=scn.nextInt();
            }
        }
        int[][] vis=new int[n][m];
        int[][] dis=new int[n][m];
        Queue<Pair> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==1)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=1;
                }
                else
                    vis[i][j]=0;
            }
        }
        int[] drow = {-1,0,+1,0}; // top right bottom left
        int[] dcol = {0,+1,0,-1};

        while(!q.isEmpty())
        {
            int row=q.peek().first;
            int col=q.peek().second;
            int steps=q.peek().third;
            q.remove();
            dis[row][col]=steps;
            for(int i=0;i<4;i++)
            {
                int nrow=row+drow[i];
                int ncol=col+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0)
                {
                    q.add(new Pair(nrow,ncol,steps+1));
                    vis[nrow][ncol]=1;
                }
            }

        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                System.out.print(dis[i][j]+" ");
            }
            System.out.println();
        }




    }
}
