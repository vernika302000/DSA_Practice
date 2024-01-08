package T_2_Graphs;
import java.util.*;

public class Q_39_Prims_Algorithm
{
    /* Prims Algorithm - used to find the minimum spanning tree
    *  A visited array and a priority queue is needed to solve the problem using prims.
    *  */
    public static class Pair
    {
        int wt;
        int node;
        public Pair(int a,int b)
        {
            this.wt=a;
            this.node=b;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] mat=new int[n][3];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<3;j++) mat[i][j]= scn.nextInt();
        }
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        for(int i=0;i<m;i++)
        {
            int u=mat[i][0];
            int v=mat[i][1];
            int wt=mat[i][2];
            adj.get(u).add(new Pair(v,wt));
            adj.get(v).add(new Pair(u,wt));
        }
        int[] vis=new int[n];
        Arrays.fill(vis,0);
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)-> x.wt-y.wt);
        pq.add(new Pair(0,0));
        int sum=0;
        while(!pq.isEmpty())
        {
            int w=pq.peek().wt;
            int node=pq.peek().node;
            pq.remove();
            if(vis[node]==1) continue;
            vis[node]=1;
            sum+=w;
            for(Pair it:adj.get(node))
            {
                int eW=it.wt;
                int aN=it.node;
                if(vis[aN]==0) pq.add(new Pair(eW,aN));
            }
        }
        System.out.println(sum);
    }
}
