package T_2_Graphs;
import java.util.*;

public class Q_2_Representation_of_graphs_adjacency_matrix
{
    /* n=5 m=6 (1,2),(1,3),(3,4),(2,4),(2,5),(4,5) */
    public static void buildGraphAdjacencyMatrix(int[][] adj,int n,int m)
    {
        Scanner scn=new Scanner(System.in);
        for(int i=0;i<m;i++)
        {
            int u,v;
            u=scn.nextInt();
            v= scn.nextInt();
            adj[u][v]=1;
            adj[v][u]=1;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] adj=new int[n+1][m+1];
        buildGraphAdjacencyMatrix(adj,n,m);
    }
}
