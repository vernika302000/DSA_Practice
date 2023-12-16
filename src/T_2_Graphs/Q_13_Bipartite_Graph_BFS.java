package T_2_Graphs;
import java.util.*;

public class Q_13_Bipartite_Graph_BFS
{
    // Color the graph with two colours such that no two adjacent nodes have same colour.
    // Linear graphs with no cycles in it -> always bipartite
    //    6 6 -> 1 2 2 3 3 4 4 6 4 5 2 5 -> Bipartite Graph
    public static boolean check(int i,List<List<Integer>> adj,int[] vis,int n)
    {
        Queue<Integer> q=new LinkedList<>();
        q.add(i);
        vis[i]=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            for(int it:adj.get(node))
            {
                if(vis[it]==-1)
                {
                    vis[it] = 1-vis[node];
                    q.add(it);
                }
                else if(vis[it] == vis[node]) return false;
            }
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int m= scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        Q_02_Representation_of_graphs_adjacency_list.buildGraphAdjacencyList(adj,n,m);
        int[] vis=new int[n+1];
        Arrays.fill(vis,-1);
        for(int i=0;i<n;i++)
        {
            if(vis[i]==-1)
            {
               if(!check(i,adj,vis,n))
               {
                   System.out.println("Not Bipartite");
                   return;
               }
            }
        }
        System.out.println("Bipartite Graph");


    }
}
