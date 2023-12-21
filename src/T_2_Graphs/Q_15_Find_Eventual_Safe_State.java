package T_2_Graphs;
import java.util.*;

/* A directed graph of V vertices and E edges is given in the form of an adjacency
   list adj. Each node of the graph is labelled with a distinct integer in the range 0 to V - 1.
   A node is a terminal node if there are no outgoing edges. A node is a safe node if every
   possible path starting from that node leads to a terminal node.
   You have to return an array containing all the safe nodes of the graph.
   The answer should be sorted in ascending order.
   For being a safe node -> outdegree of a node must be 0
   Also any node part of a cycle or any node leading to a cycle cannot be a safe node



*/
public class Q_15_Find_Eventual_Safe_State
{
    //    11 13 -> 0 1  1 2  2 3  3 5  3 4  4 6  5 6  6 7  7 8  8 9  9 10  10 8  8 1  11 9

    public static boolean dfs(List<List<Integer>> adj,int[] vis,int[] pathVis,int[] check,int node)
    {
        vis[node]=1;
        pathVis[node]=1;
        check[node]=0;
        for(int it:adj.get(node))
        {
            if(vis[it]==0)
            {
                if(dfs(adj,vis,pathVis,check,it)) return true;
            }
            else if(pathVis[it]==1) return true;
        }
        check[node]=1;
        pathVis[node]=0;
        return false;

    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        Q_16_Topological_Sorting.buildDirectedGraph(adj,n,m);
        int[] vis=new int[n];
        int[] pathVis=new int[n];
        int[] check=new int[n];
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0)
            {
               dfs(adj,vis,pathVis,check,i);
            }
        }
        int cnt=0;
        List<Integer> safe=new LinkedList<>();
        for(int i=0;i<n;i++)
        {
            if (check[i] == 1) safe.add(i);
        }
        System.out.println(safe);


    }

}
