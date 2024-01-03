package T_2_Graphs;
import java.util.*;

public class Q_28_Dijikstra_Algorithm_Priority_Queue
{
    /*  2
1
1
9
1
0
9
0
*/
    public static class Pair1
    {
        int dist;
        int node;
        public Pair1(int d,int n)
        {
            this.dist=d;
            this.node=n;
        }
    }
    public static class pair
    {
        int node;
        int wt;
        public pair(int n,int w)
        {
            this.node=n;
            this.wt=w;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        ArrayList<ArrayList<pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n;i++)
        {

            int t=scn.nextInt();
            for(int j=0;j<t;j++)
            {
                int u=scn.nextInt();
                int w=scn.nextInt();
                adj.get(i).add(new pair(u,w));
            }

        }
        int S= scn.nextInt();

        PriorityQueue<Pair1> pq=new PriorityQueue<Pair1>((x,y)-> x.dist-y.dist);
        int[] dist=new int[n+1];
        Arrays.fill(dist, (int) (1e9));
        dist[S]=0;
        pq.add(new Pair1(S,0));
        while(!pq.isEmpty())
        {
            int d=pq.peek().dist;
            int node=pq.peek().node;
            pq.remove();
            for(int i=0;i<adj.get(node).size();i++)
            {
                int eW=adj.get(node).get(i).wt;
                int aN=adj.get(node).get(i).node;
                if(d+eW<dist[aN])
                {
                    dist[aN]=d+eW;
                    pq.add(new Pair1(dist[aN],eW));
                }

            }
        }
        for(int val:dist) System.out.println(val+" ");
    }
}
