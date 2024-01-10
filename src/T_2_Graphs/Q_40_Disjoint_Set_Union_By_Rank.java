package T_2_Graphs;
import java.util.*;

public class Q_40_Disjoint_Set_Union_By_Rank
{
    //Most important topic in graphs
    //It offers majorly two functionalities => find Parent
    //                                      => find union - a) by rank b) by size
    //It uses the concept of dynamic graphs
    /* Algorithm for finding union of set ->
       1) find ultimate parent of u and v -> pu and pv
       2) find rank of those ultimate parents
       3) connect smaller rank to larger rank always
       4)
    * */
    public static class Pair
    {
        int first;
        int second;
        public Pair(int a,int b)
        {
            this.first=a;
            this.second=b;
        }
    }
    public static void pathCompression()
    {

    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        ArrayList<Pair> adj=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            int u=scn.nextInt();
            int v=scn.nextInt();
            adj.add(new Pair(u,v));
        }
        int[] rank=new int[n+1];
        Arrays.fill(rank,0);
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++) parent[i]=i;

    }
}
