package T_2_Graphs;

import java.util.*;

public class Q_29_Print_Shortest_Path_using_dijikstra
{   /* 5 6 => (1,2,2), (2,5,5), (2,3,4), (1,4,1), (4,3,3), (3,5,1) => output -> (1,n) - 1,4,3,5 */
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
        int m=scn.nextInt();
        int[][] edges=new int[m][3];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<3;j++)
            {
                edges[i][j]=scn.nextInt();
            }
        }
        ArrayList<ArrayList<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<m;i++)
        {
            adj.get(edges[i][0]).add(new Pair(edges[i][1],edges[i][2]));
            adj.get(edges[i][1]).add(new Pair(edges[i][0],edges[i][2]));
        }

        PriorityQueue<Pair> pq=new PriorityQueue<>((x,y)->x.first-y.first);
        int[] dist=new int[n+1];
        int[] parent=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            dist[i]=(int)(1e9);
            parent[i]=i;
        }
        dist[1]=0;
        pq.add(new Pair(0,1));
        while(pq.size()!=0)
        {
            Pair it=pq.peek();
            int node=it.second;
            int d=it.first;
            pq.remove();

            for(Pair iter:adj.get(node))
            {
                int aN=iter.first;
                int dis=iter.second;
                if(dis+d<dist[aN])
                {
                    dist[aN]=d+dis;
                    pq.add(new Pair(dis+d,aN));
                    parent[aN]=node;
                }

            }
        }
        ArrayList<Integer> path=new ArrayList<>();
        if(dist[n]==1e9)
        {
            path.add(-1);
            System.out.println(path);
            return;
        }
        int node=n;
        while(parent[node]!=node)
        {
            path.add(node);
            node=parent[node];
        }
        path.add(1);
        Collections.reverse(path);
        System.out.println(path);
    }
}
