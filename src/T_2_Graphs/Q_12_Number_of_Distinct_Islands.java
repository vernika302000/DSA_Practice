package T_2_Graphs;
import java.util.*;

public class Q_12_Number_of_Distinct_Islands
{
    /*
    * Given a boolean 2D matrix grid of size n * m. You have to find the
    * number of distinct islands where a group of connected 1s (horizontally
    * or vertically) forms an island.Two islands are considered to be distinct
    * if and only if one island is not equal to another (not rotated or reflected).
    */
    public static void dfs(int row,int col,int[][] mat,int[][] vis,ArrayList<String> vec,int row0,int col0,int n,int m)
    {
        vis[row][col]=1;
        vec.add(toString(row-row0,col-col0));
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        for(int i=0;i<4;i++)
        {
            int nrow=row+drow[i];
            int ncol=col+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==0 && mat[nrow][ncol]==1)
            {
                dfs(nrow,ncol,mat,vis,vec,row0,col0,n,m);
            }
        }
    }
    private static String toString(int r,int c)
    {
        return Integer.toString(r)+" "+Integer.toString(c);
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=scn.nextInt();
            }
        }

        int[][] vis=new int[n][m];
        HashSet<ArrayList<String>> st=new HashSet<>();
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                if(vis[i][j]==0 && mat[i][j]==1)
                {
                    ArrayList<String> vec=new ArrayList<>();
                    dfs(i,j,mat,vis,vec,i,j,n,m);
                    st.add(vec);
                }
            }
        }
        System.out.println(st.size());

    }
}
