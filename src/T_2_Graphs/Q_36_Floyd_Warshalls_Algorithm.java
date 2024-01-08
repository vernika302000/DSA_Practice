package T_2_Graphs;
import java.util.*;

public class Q_36_Floyd_Warshalls_Algorithm
{
    /* -> Multi-source shortest path algorithm
       -> Helps detecting negative cycle as well
       -> Basic Intuition => Go via every path
       -> dist[i][j] = dist[i][k] + dist[j][k]
    */
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) mat[i][j]=scn.nextInt();
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(mat[i][j]==-1) mat[i][j]=(int)(1e9);
                if(i==j) mat[i][j]=0;
            }
        }
        for(int k=0;k<n;k++)
        {
            for(int i=0;i<n;i++)
            {
                for(int j=0;j<n;j++)
                {
                    mat[i][j]=Math.min(mat[i][j],mat[i][k]+mat[k][j]);
                }
            }
        }
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<n;j++)
            {
                if(mat[i][j]==(int)(1e9)) mat[i][j]=-1;
            }
        }


    }
}
