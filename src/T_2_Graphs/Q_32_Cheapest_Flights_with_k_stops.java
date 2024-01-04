package T_2_Graphs;
import java.util.*;

public class Q_32_Cheapest_Flights_with_k_stops
{
    /*
    n = 4
    flights = [[0,1,100],[1,2,100],[2,0,100],[1,3,600],[2,3,200]]
    src = 0
    dst = 3
    k = 1
    Output:
    700
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
    public static class tuple
    {
        int first;
        int second;
        int third;
        public tuple(int a,int b,int c)
        {
            this.first=a;
            this.second=b;
            this.third=c;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] mat=new int[n+1][3];
        for(int i=0;i<=n;i++)
        {
            for(int j=0;j<3;j++) mat[i][j]=scn.nextInt();
        }
        int src=scn.nextInt();
        int dst= scn.nextInt();
        int k=scn.nextInt();
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++) adj.add(new ArrayList<>());
        int m=mat.length;
        for (int[] ints : mat) {
            adj.get(ints[0]).add(new Pair(ints[1], ints[2]));
        }
        int[] dist=new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i]=(int)(1e9);
        }
        dist[src]=0;
        Queue<tuple> q=new LinkedList<>();
        q.add(new tuple(0,src,0));
        while(!q.isEmpty())
        {
            int stops=q.peek().first;
            int node=q.peek().second;
            int d=q.peek().third;
            q.remove();
            for(Pair iter:adj.get(node))
            {
                int aN=iter.first;
                int eW=iter.second;
                if(eW+d<dist[aN] && stops<=k)
                {
                    dist[aN]=eW+d;
                    q.add(new tuple(stops+1, aN, eW+d));
                }
            }
        }
        if(dist[dst]==(int)(1e9))
        {
            System.out.println("-1");
        }
        else
        {
            System.out.println(dist[dst]);
        }
    }
}
