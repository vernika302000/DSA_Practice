package T_2_Graphs;
import java.util.*;

public class Q_18_Detect_Cycle_In_Directed_Graph_BFS
{
    // Using Kahn's Algorithm to generate the topological sort -
    // if topo sort has exactly N elements - DAG
    // else if topo sort has < N elements - Cycle is present
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        Q_16_Topological_Sorting.buildDirectedGraph(adj,n,m);
        int[] indegree=new int[n];
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
        int cnt=0;
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            cnt++;
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(cnt==n) System.out.println("No Cycle Detected");
        else System.out.println("Cycle Detected");


    }
}
