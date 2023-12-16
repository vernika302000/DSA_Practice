package T_2_Graphs;
import java.util.*;
public class Q_13_Bipartite_Graph_DFS
{
    //     6 6 -> 1 2 2 3 3 4 4 6 4 5 2 5 -> Bipartite Graph
    public static boolean dfs(int col,int i,int[] color,List<List<Integer>> adj)
    {
        color[i]=col;
        for(int it:adj.get(i))
        {
            if(color[it]==-1)
            {
                if(!dfs(1-col,it,color,adj)) return false;
            }
            else if(color[it]==col) return false;
        }
        return true;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        Q_02_Representation_of_graphs_adjacency_list.buildGraphAdjacencyList(adj,n,m);
        int[] color=new int[n+1];
        Arrays.fill(color,-1);
        for(int i=0;i<n;i++)
        {
            if(color[i]==-1)
            {
                if(!dfs(0,i,color,adj))
                {
                    System.out.println("Not Bipartite");
                    return;
                }
            }
        }
        System.out.println("Bipartite Graph");


    }
}
