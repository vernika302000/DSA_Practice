package T_2_Graphs;
import java.util.*;

public class Q_34_Number_of_ways_to_reach_destination
{
    /* n=7, m=10
       edges= [[0,6,7],[0,1,2],[1,2,3],[1,3,3],[6,3,3],[3,5,1],[6,5,1],[2,5,1],[0,4,5],[4,6,2]]

       Output: 4
    */
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
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        ArrayList<ArrayList<Integer>> roads=new ArrayList<>();
        for(int i=0;i<m;i++)
        {
            ArrayList<Integer> temp=new ArrayList<>();
            temp.add(scn.nextInt());
            temp.add(scn.nextInt());
            temp.add(scn.nextInt());
            roads.add(temp);
        }
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(roads.get(i).get(0)).add(new Pair(roads.get(i).get(1),roads.get(i).get(2)));
            adj.get(roads.get(i).get(1)).add(new Pair(roads.get(i).get(0),roads.get(i).get(2)));
        }
        int[] dist=new int[n];
        int[] ways=new int[n];
        for(int i=0;i<n;i++)
        {
            dist[i]=(int)(1e9);
            ways[i]=0;
        }
        dist[0]=0;
        ways[0]=1;
        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        pq.add(new Pair(0,0));
        int mod=(int)(1e9+7);
        while(!pq.isEmpty())
        {
            int d=pq.peek().first;
            int node=pq.peek().second;
            pq.remove();
            for(Pair iter:adj.get(node))
            {
                int aN=iter.first;
                int eW=iter.second;
                if(eW+d<dist[aN])
                {
                    dist[aN]=eW+d;
                    pq.add(new Pair(eW+d,aN));
                    ways[aN]=ways[node];
                }
                else if(eW+d==dist[aN])
                {
                    ways[aN]=(ways[aN]+ways[node])%mod;
                }
            }
        }
        System.out.println("Number of ways to reach the destination -> "+ways[n-1]%mod);


    }
}
