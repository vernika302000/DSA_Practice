package T_2_Graphs;
import java.util.*;

public class Q_19_Course_Schedule_I_and_II
{
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
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
        List<Integer> topo=new ArrayList<>();
        while(!q.isEmpty())
        {
            int node=q.peek();
            q.remove();
            topo.add(node);
            for(int it:adj.get(node))
            {
                indegree[it]--;
                if(indegree[it]==0) q.add(it);
            }
        }
        if(topo.size()==n)
        {
            for(int val:topo) System.out.println(val+" ");
            return;
        }
        System.out.println("Not Possible");


    }
}
