package T_2_Graphs;
import java.util.*;

public class Q_22_Shortest_Path_in_Directed_Acyclic_Graph
{
    /* Given a Directed Acyclic Graph of N vertices from 0 to N-1
    and a 2D Integer array(or vector) edges[ ][ ] of length M,
    where there is a directed edge from edge[i][0] to edge[i][1] with a
    distance of edge[i][2] for all i.

    Find the shortest path from src(0) vertex to all the vertices and if it
    is impossible to reach any vertex, then return -1 for that vertex.

    input => 7 8 => 0 1 2  1 3 1  2 3 3  4 0 3  4 2 1  5 4 1  6 4 2  6 5 3
    output =>
    */
    public static class Pair
    {
        int node;
        int weight;
        public Pair(int n,int w)
        {
            this.node=n;
            this.weight=w;
        }
    }
    public static void dfs(int[] vis,Stack<Integer> st,int node,ArrayList<ArrayList<Pair>> adj)
    {
        vis[node]=1;
        for(int i=0;i<adj.get(node).size();i++)
        {
            int v=adj.get(node).get(i).node;
            if(vis[node]==0)
            {
                dfs(vis,st,v,adj);
            }
        }
        st.add(node);

    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();
        int[][] edges = new int[m][3];
        for(int i=0;i<m;i++)
        {
            edges[i][0]=scn.nextInt();
            edges[i][1]=scn.nextInt();
            edges[i][2]=scn.nextInt();
        }
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            ArrayList<Pair> temp=new ArrayList<Pair>();
            adj.add(temp);
        }
        for(int i=0;i<m;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            adj.get(u).add(new Pair(v,wt));
        }
        int[] vis=new int[n];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0) dfs(vis,st,i,adj);
        }
        int[] dist=new int[n];
        for(int i=0;i<n;i++) dist[i]=(int)(1e9);
        dist[0]=0;
        while(!st.isEmpty())
        {
            int node=st.pop();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int v=adj.get(node).get(i).node;
                int wt=adj.get(node).get(i).weight;
                if(dist[node]+wt<dist[v])
                {
                    dist[v]=dist[node]+wt;
                }
            }
        }
        for(int val:dist) System.out.print(val+" , ");


    }
}
