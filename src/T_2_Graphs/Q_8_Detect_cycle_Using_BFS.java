package T_2_Graphs;
import java.util.*;

public class Q_8_Detect_cycle_Using_BFS
{
    public static class pair
    {
        int first;
        int second;
        public pair(int First,int Second)
        {
            this.first=First;
            this.second=Second;
        }
    }
    public static boolean checkForCycle(List<List<Integer>> adj,boolean[] vis,int n,int i)
    {
        vis[i]=true;
        Queue<pair> q=new LinkedList<>();
        q.add(new pair(i,-1));
        while(!q.isEmpty())
        {
            int node=q.peek().first;
            int parent=q.peek().second;
            q.remove();
            for(int it:adj.get(node))
            {
                if(!vis[it])
                {
                    vis[it]=true;
                    q.add(new pair(it,node));

                }
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
        List<List<Integer>> adj=new ArrayList<>();
        Q_2_Representation_of_graphs_adjacency_list.buildGraphAdjacencyList(adj,n,m);
        boolean[] vis=new boolean[n+1];
        Arrays.fill(vis,false);
        for(int i=0;i<n;i++)
        {
            if(checkForCycle(adj,vis,n,i))
            {
                System.out.println("Cycle exist");
                return;
            }
        }
        System.out.println("Cycle Doesn't exists");
    }
}
