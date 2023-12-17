package T_2_Graphs;
import java.util.*;

public class Q_14_Detect_Cycle_In_directed_graph_using_DFS
{
    // The simple visited technique fails -> In this on that path the node needs to be occurring again to from a cycle.
    // So in order to solve this one, one visited array and one path visited array needs to be initialized.
    public static boolean dfs(int i, List<List<Integer>> adj,int[] vis,int[] pathVis)
    {
        vis[i]=1;
        pathVis[i]=1;
        for(int it:adj.get(i))
        {
            if(vis[it]==0)
            {
                if(dfs(it,adj,vis,pathVis)) return true;
            }
            else if(pathVis[it]==1) return true;
        }
        pathVis[i]=0;
        return false;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        Q_02_Representation_of_graphs_adjacency_list.buildGraphAdjacencyList(adj,n,m);
        int[] vis=new int[n];
        int[] pathVis=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
                if(dfs(i,adj,vis,pathVis))
                {
                    System.out.println("Cycle Exists");
                    return;
                }
            }
        }
        System.out.println("No Cycle");


    }
}
