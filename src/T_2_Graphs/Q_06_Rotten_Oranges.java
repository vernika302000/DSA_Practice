package T_2_Graphs;

import java.util.*;

public class Q_06_Rotten_Oranges
{
    /*
       Given a grid of dimension nxm where each cell in the grid can have values 0, 1 or 2 which has the following meaning:
       0 : Empty cell
       1 : Cells have fresh oranges
       2 : Cells have rotten oranges
       We have to determine what is the earliest time after which all the oranges are rotten. A rotten orange at index [i,j] can rot other fresh orange at indexes [i-1,j], [i+1,j], [i,j-1], [i,j+1] (up, down, left and right) in unit time.
    */
    public static class Pair
    {
        int row;
        int col;
        int tm;
        public Pair(int Row,int Col,int Tm)
        {
            this.row=Row;
            this.col=Col;
            this.tm=Tm;
        }
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
        Queue<Pair> q=new LinkedList<>();
        int[][] vis=new int[n][m];
        int cntFresh=0;
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==2)
                {
                    q.add(new Pair(i,j,0));
                    vis[i][j]=2;
                }
                else vis[i][j]=0;
                if(mat[i][j]==1) cntFresh++;
            }
        }

        int tm=0;
        int dRow[]={-1,0,1,0};
        int dCol[]={0,1,0,-1};
        int cnt=0;
        while(!q.isEmpty())
        {
            int r=q.peek().row;
            int c=q.peek().col;
            int t=q.peek().tm;
            tm=Math.max(t,tm);
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=r+dRow[i];
                int ncol=c+dCol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==1)
                {
                    q.add(new Pair(nrow,ncol,t+1));
                    vis[nrow][ncol]=2;
                    cnt++;
                }
            }

        }
        if(cnt!=cntFresh) System.out.println("-1");
        else System.out.println("Unit time taken to rot all fresh oranges -> "+tm);;


    }
}
