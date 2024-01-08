package T_2_Graphs;
import java.util.*;

public class Q_20_Find_Eventual_Safe_State_BFS
{
    //A node is a safe node - if every path starting from that node is a terminal node.
    //Terminal nodes do not have outgoing edges
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        List<List<Integer>> adj=new ArrayList<>();
        Q_16_Topological_Sorting.buildDirectedGraph(adj,n,m);


    }

}
