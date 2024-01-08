package T_2_Graphs;

import java.util.Scanner;

public class Q_37_Minimim_number_of_cities_under_threshold
{   /* Input: N=4,M=4 edges = [[0,1,3],[1,2,1],[1,3,4],[2,3,1]] distanceThreshold = 4
       Output:3
    */
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        int m= scn.nextInt();
        int[][] edges=new int[n][3];
        for(int i=0;i<m;i++)
        {
            for(int j=0;j<3;j++)
            {
                edges[i][j]=scn.nextInt();
            }
        }
        int threshold= scn.nextInt();
        int[][] mat=new int[n][n];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++) mat[i][j]=Integer.MAX_VALUE;
        }
        for(int i=0;i<m;i++)
        {
            int u=edges[i][0];
            int v=edges[i][1];
            int wt=edges[i][2];
            mat[u][v]=wt;
            mat[v][u]=wt;
        }
        for(int i=0;i<n;i++) mat[i][i]=0;
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    if(mat[i][j]==Integer.MAX_VALUE || mat[j][i]==Integer.MAX_VALUE) continue;
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
        int cntMax=n;
        int city=-1;
        for(int i=0;i<n;i++)
        {
            int cnt=0;
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]<=threshold) cnt++;
            }
            if(cnt<=cntMax)
            {
                cntMax=cnt;
                city=i;
            }
        }

        System.out.println(city);

    }
}
