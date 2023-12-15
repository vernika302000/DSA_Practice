package T_2_Graphs;
import java.util.*;

public class Q_4_Breadth_First_Search
{
    // For BFS - using Queue data structure
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();

        Q_2_Representation_of_graphs_adjacency_list.buildGraphAdjacencyList(adj,n,m);
        int V=scn.nextInt();
        boolean[] vis=new boolean[V+1];
        List<Integer> bfs=new ArrayList<>();
        vis[1]=true;
        Queue<Integer> q=new LinkedList<>();
        q.add(1);
        while(!q.isEmpty())
        {
            int node=q.poll();
            bfs.add(node);
            for(int it:adj.get(node))
            {
                if(!vis[it])
                {
                    vis[it] =true;
                    q.add(it);
                }
            }
        }
        System.out.println(bfs);
    }
}