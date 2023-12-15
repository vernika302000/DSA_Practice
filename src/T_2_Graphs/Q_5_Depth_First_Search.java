package T_2_Graphs;
import java.util.*;

public class Q_5_Depth_First_Search
{
    //Depth First Search is done using Recursion
    public static void dfs(int node, boolean[] vis,List<List<Integer>> adj,List<Integer> ans)
    {
        vis[node]=true;
        ans.add(node);
        for(int it:adj.get(node))
        {
            if(!vis[it])
            {
                dfs(it,vis,adj,ans);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        Q_2_Representation_of_graphs_adjacency_list.buildGraphAdjacencyList(adj,n,m);
        boolean[] vis=new boolean[n+1];
        vis[1]=true;
        List<Integer> ans=new ArrayList<>();
        dfs(1,vis,adj,ans);
        System.out.println(ans);
    }
}
