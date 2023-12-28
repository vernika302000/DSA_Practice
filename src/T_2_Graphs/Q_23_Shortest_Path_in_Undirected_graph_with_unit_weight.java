package T_2_Graphs;
import java.util.*;

public class Q_23_Shortest_Path_in_Undirected_graph_with_unit_weight
{
    /*
    You are given an Undirected Graph having unit weight, Find the shortest path from src to all the vertex
    and if it is unreachable to reach any vertex, then return -1 for that vertex.
    Input:
    For Input:
    9 10 =>  0 1  0 3  3 4  4 5  5 6  1 2  2 6  6 7  7 8  6 8
    src => 0
    Your Output:
    0 1 2 1 2 3 3 4 4
     */
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] edges=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                edges[i][j]=scn.nextInt();
            }
        }
        int src= scn.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(edges[i][1]);
            adj.get(edges[i][1]).add(edges[i][0]);
        }
        int[] dist =new int[n];
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++) dist[i]=(int)(1e9);
        dist[src]=0;
        q.add(src);
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            for(int it:adj.get(node))
            {
                if(dist[node]+1<dist[it])
                {
                    dist[it]=dist[node]+1;
                    q.add(it);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            if(dist[i]==1e9)
            {
                dist[i]=-1;
            }
        }
        for(int val:dist) System.out.println(val);



    }
}
