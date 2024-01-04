package T_2_Graphs;
import java.util.*;

public class Q_31_Path_with_minimum_efforts
{
    /*
    You are a hiker preparing for an upcoming hike.
    You are given heights, a 2D array of size rows x columns,
    where heights[row][col] represents the height of cell (row, col).
    You are situated in the top-left cell, (0, 0),
    and you hope to travel to the bottom-right cell, (rows-1, columns-1) (i.e., 0-indexed).
    You can move up, down, left, or right, and you wish to find a route that
    requires the minimum effort.
    A route's effort is the maximum absolute difference in heights between two consecutive
    cells of the route.
    */
    public static class tuple
    {
        int first;
        int second;
        int third;
        public tuple(int a,int b,int c)
        {
            this.first=a;
            this.second=b;
            this.third=c;
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
            for(int j=0;j<m;j++) mat[i][j]= scn.nextInt();
        }
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) dist[i][j]=(int)(1e9);
        }
        dist[0][0]=0;
        PriorityQueue<tuple> pq=new PriorityQueue<tuple>((x,y)->x.first-y.first);
        pq.add(new tuple(0,0,0));
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!pq.isEmpty())
        {
            int diff=pq.peek().first;
            int r=pq.peek().second;
            int c=pq.peek().third;
            pq.remove();
            if(r==n-1 && c==m-1)
            {
                System.out.println(diff);
                return;
            }
            for(int i=0;i<4;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m)
                {
                    int newEffort=Math.max(Math.abs(mat[r][c]-mat[nrow][ncol]),diff);
                    if(newEffort<dist[nrow][ncol])
                    {
                        dist[nrow][ncol]=newEffort;
                        pq.add(new tuple(newEffort,nrow,ncol));
                    }
                }

            }
        }
        System.out.println();
    }
}
