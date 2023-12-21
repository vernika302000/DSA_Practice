package T_2_Graphs;

import java.util.*;

public class Q_16_Topological_Sorting
{
    static Scanner scn=new Scanner(System.in);
    /*
    * linear ordering of the edges such that if there is an edge between u and v, u comes before v in ordering
    * It only gets applicable to Directed-Acyclic-Graph
    * 6 6 -> 2 3  3 1  4 0  4 1  5 0  5 2 => o/p 5 4 2 3 1 0
    * */
    public static void buildDirectedGraph(List<List<Integer>> adj,int n,int m)
    {
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            int u=scn.nextInt();
            int v=scn.nextInt();
            adj.get(u).add(v);
        }
    }
    public static void topo(int[] vis,List<List<Integer>> adj,Stack<Integer> st,int node)
    {
        vis[node]=1;
        for(int it:adj.get(node))
        {
            if(vis[it]==0) topo(vis,adj,st,it);
        }
        st.push(node);

    }
    public static void main(String[] args)
    {
        int n=scn.nextInt();
        int m=scn.nextInt();
        List<List<Integer>> adj=new LinkedList<>();
        buildDirectedGraph(adj,n,m);
        int[] vis=new int[n+1];
        Stack<Integer> st=new Stack<>();
        for(int i=0;i<n;i++)
        {
            if(vis[i]==0) topo(vis,adj,st,i);
        }
        List<Integer> ans=new LinkedList<>();
        while(!st.isEmpty())
        {
            int val=st.pop();
            ans.add(val);
        }
        System.out.println(ans);
    }
}
