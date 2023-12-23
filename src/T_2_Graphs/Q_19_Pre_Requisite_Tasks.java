package T_2_Graphs;
import java.util.*;

public class Q_19_Pre_Requisite_Tasks
{
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int m= scn.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        Q_16_Topological_Sorting.buildDirectedGraph(adj,n,m);
        Queue<Integer> q=new LinkedList<>();
        int[] indegree=new int[n];
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
        if(cnt==n)
        {
            System.out.println("Possible");
            return;
        }
        System.out.println("Not Possible");
    }
}
