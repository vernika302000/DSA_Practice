package T_2_Graphs;
import java.util.*;

public class Q_17_Kahns_Algorithm
{
    // Kahn's Algorithm -> Algorithm for generating topological sort by BFS
    // 6 6 -> 2 3  3 1  4 0  4 1  5 0  5 2 => o/p 4 5 0 2 3 1
    public static List<Integer> topo(List<List<Integer>> adj,int n)
    {
        int[] indegree=new int[n+1];
        List<Integer> ans=new ArrayList<>();
        Queue<Integer> q=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            for(int it:adj.get(i))
            {
                indegree[it]++;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(indegree[i]==0) q.add(i);
        }
        int i=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            ans.add(node);
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        List<List<Integer>>adj=new LinkedList<>();
        Q_16_Topological_Sorting.buildDirectedGraph(adj,n,m);
        List<Integer> ans=topo(adj,n);
        System.out.println(ans);
    }
}
