package T_2_Graphs;
import java.util.*;

public class Q_7_Detect_cycle_Using_DFS
{
    //    7 7 -> 1 2 2 5 5 7 7 6 6 3 3 1 3 4
    public static boolean dfs(List<List<Integer>> adj,boolean[] vis,int node,int parent)
    {
        vis[node]=true;
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                if(dfs(adj,vis,it,node)) return true;
                else if(it!=parent) return true;
            }
        }
        return false;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        Q_2_Representation_of_graphs_adjacency_list.buildGraphAdjacencyList(adj,n,m);
        boolean[] vis=new boolean[n+1];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++)
        {
            if(!vis[i])
            {
                if(dfs(adj,vis,i,-1))
                {
                    System.out.println("Cycle exists");
                    return;
                }
            }
        }
        System.out.println("no cycle exists");

    }
}
