package T_2_Graphs;

import java.util.Scanner;

public class Q_24_Flood_Fill_Algorithm
{
    /*
     Input: image = {{1,1,1},{1,1,0},{1,0,1}},
     sr = 1, sc = 1, newColor = 2.
     Output: {{2,2,2},{2,2,0},{2,0,1}}
    */
    public static void dfs(int[][] image,int sr,int sc,int[] drow,int[] dcol,int inicolor,int newcolor,int[][] ans)
    {
        ans[sr][sc]=newcolor;
        int n=image.length;
        int m=image[0].length;
        for(int i=0;i<4;i++)
        {
            int nrow=sr+drow[i];
            int ncol=sc+dcol[i];
            if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && image[nrow][ncol]==inicolor && ans[nrow][ncol]!=newcolor)
            {
                dfs(image,nrow,ncol,drow,dcol,inicolor,newcolor,ans);
            }
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m=scn.nextInt();
        int[][] image=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                image[i][j]=scn.nextInt();
            }
        }
        int sr=scn.nextInt();
        int sc=scn.nextInt();
        int newColor=scn.nextInt();
        int inicolor=image[sr][sc];
        int[] drow={-1,0,1,0};
        int[] dcol={0,1,0,-1};
        int[][] ans=image;
        dfs(image,sr,sc,drow,dcol,inicolor,newColor,ans);
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++) System.out.print(ans[i][j]+" ");
        }
        System.out.println();
    }
}
