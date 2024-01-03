package T_2_Graphs;

import java.util.*;

public class Q_30_Shortest_Path_in_binary_maze
{
    /* grid[][] = {{1, 1, 1, 1},
                   {1, 1, 0, 1},
                   {1, 1, 1, 1},
                   {1, 1, 0, 0},
                   {1, 0, 0, 1}}
      source = {0, 1}
      destination = {2, 2} => output - 3 */
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
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] mat = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) mat[i][j] = scn.nextInt();
        }
        int[] src = new int[2];
        src[0] = scn.nextInt();
        src[1] = scn.nextInt();
        int[] dest = new int[2];
        dest[0] = scn.nextInt();
        dest[1] = scn.nextInt();

        Queue<tuple> q=new LinkedList<>();
        int[][] dist=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) dist[i][j]=(int)(1e9);
        }
        dist[src[0]][src[1]]=0;
        q.add(new tuple(0,src[0],src[1]));
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        while(!q.isEmpty())
        {
            tuple it=q.peek();
            int dis=it.first;
            int r=it.second;
            int c=it.third;
            q.remove();
            for(int i=0;i<4;i++)
            {
                int nrow=r+drow[i];
                int ncol=c+dcol[i];
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && mat[nrow][ncol]==1 && dis+1<dist[nrow][ncol])
                {
                    dist[nrow][ncol]=dis+1;
                    if(dest[0]==nrow && dest[1]==ncol)
                    {
                        System.out.println(dis+1);
                        return;
                    }
                    q.add(new tuple(dis+1,nrow,ncol));
                }
            }
        }


    }
}
