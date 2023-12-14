package T_2_Graphs;
import java.util.*;

public class Q_2_Representation_of_graphs_adjacency_list
{
    /* n=5 m=6 (1,2),(1,3),(3,4),(2,4),(2,5),(4,5) */

    public static void buildGraphAdjacencyList(List<List<Integer>> adj,int n,int m)
    {
        Scanner scn=new Scanner(System.in);
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++)
        {
            int u=scn.nextInt();
            int v=scn.nextInt();
            adj.get(u).add(v);
            adj.get(v).add(u);
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        buildGraphAdjacencyList(adj,n,m);
        for(int i=1;i<n;i++)
        {
            System.out.print(i+" -> ");
            for(int j=0;j<adj.get(i).size();j++)
            {
                System.out.print(adj.get(i).get(j)+" ");
            }
            System.out.println();
        }
    }
}
