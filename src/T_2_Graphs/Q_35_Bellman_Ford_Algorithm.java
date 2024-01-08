package T_2_Graphs;

import java.util.ArrayList;
import java.util.Scanner;

public class Q_35_Bellman_Ford_Algorithm
{
    /* Used to find the shortest path to each node ->
    -> unlike dijikstra's algorithm it doesn't fail with negative edges also.
    -> only applicable on directed graphs
    -> if any undirected graph is given, convert it into directed graph, then only bellman ford can be applied.
    -> Relax all the edges (n-1) times sequentially.
    E = [[0,1,5],[1,0,3],[1,2,-1],[2,0,1]]
    S = 2
    Output: 1 6 0
    */
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int V= scn.nextInt();
        int n= scn.nextInt();
        int[][] edges=new int[n][3];
        for(int i=0;i<n;i++)
        {
            edges[i][0]=scn.nextInt();
            edges[i][1]=scn.nextInt();
            edges[i][2]=scn.nextInt();
        }
        int S = scn.nextInt();
        int[] dist=new int[V];
        for(int i=0;i<V;i++) dist[i]=(int)(1e8);
        dist[S]=0;
        for(int i=0;i<V-1;i++)
        {
            for(int j=0;j<n;j++)
            {
                int u=edges[j][0];
                int v=edges[j][1];
                int wt=edges[j][2];
                if(dist[u]!=(int)(1e8) && wt+dist[u]<dist[v])
                {
                    dist[v]=dist[u]+wt;
                }
            }
        }
        for(int j=0;j<n;j++)
        {
            int u=edges[j][0];
            int v=edges[j][1];
            int wt=edges[j][2];
            if(dist[u]!=(int)(1e8) && wt+dist[u]<dist[v])
            {
                System.out.println(-1);
                return;
            }
        }
        for(int val:dist) System.out.print(val+" ");

    }
}
