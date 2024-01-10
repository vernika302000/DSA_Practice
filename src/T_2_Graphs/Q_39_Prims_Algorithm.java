package T_2_Graphs;
import java.util.*;

public class Q_39_Prims_Algorithm
{
    /* Prims Algorithm - used to find the minimum spanning tree
    *  A visited array and a priority queue is needed to solve the problem using prims.
    *  */
    public static class DisjointSet
    {
        List<Integer> rank=new ArrayList<>();
        List<Integer> parent=new ArrayList<>();
        public DisjointSet(int n)
        {
            for (int i = 0; i <= n; i++)
            {
                rank.add(0);
                parent.add(i);
            }
        }
        public int findUPar(int node)
        {
            if(node == parent.get(node)) return node;
            int ulp=findUPar(parent.get(node));
            parent.set(node,ulp);
            return parent.get(node);
        }
        public void UnionByRank(int u,int v)
        {
            int ulp_u=findUPar(u);
            int ulp_v=findUPar(v);
            if(ulp_u == ulp_v) return;
            if(rank.get(ulp_u) < rank.get(ulp_v)) rank.set(ulp_u,ulp_v);
            else if(rank.get(ulp_v) < rank.get(ulp_u)) rank.set(ulp_v,ulp_u);
            else
            {
                parent.set(ulp_v,ulp_u);
                int rankU=rank.get(ulp_u);
                rank.set(ulp_u,rankU+1);
            }
        }
    }
    public static void main(String[] args)
    {
        DisjointSet ds=new DisjointSet(7);
        ds.UnionByRank(1,2);
        ds.UnionByRank(2,3);
        ds.UnionByRank(4,5);
        ds.UnionByRank(6,7);
        ds.UnionByRank(5,6);

        // does 3 & 7 are same or not
        if(ds.findUPar(3) == ds.findUPar(7)) System.out.println("same");
        else System.out.println("not same");

        ds.UnionByRank(3,7);

        if(ds.findUPar(3) == ds.findUPar(7)) System.out.println("same");
        else System.out.println("not same");
    }
}
