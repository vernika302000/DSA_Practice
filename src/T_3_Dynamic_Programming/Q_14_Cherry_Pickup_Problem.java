package T_3_Dynamic_Programming;
import java.util.*;

public class Q_14_Cherry_Pickup_Problem
{
    /*
          3 4
          2 3 1 2
          3 4 2 2
          5 6 3 5 => output - 21
     */
    public static int solve(int i,int j1,int j2,int[][] matrix)
    {
        if(j1<0 || j1>=matrix[0].length || j2<0 || j2>=matrix[0].length) return (int)(-1e8);
        if(i==matrix.length-1)
        {
            if(j1==j2) return matrix[i][j1];
            else return matrix[i][j1]+matrix[i][j2];
        }
        int maxi=(int)(-1e8);
        for(int dj1=-1;dj1<=1;dj1++)
        {
            for(int dj2=-1;dj2<=1;dj2++)
            {
                int value=0;
                if(j1==j2) return matrix[i][j1];
                else value= matrix[i][j1]+matrix[i][j2];
                value+=solve(i+1,j1+dj1,j2+dj2,matrix);
                maxi=Math.max(maxi,value);
            }
        }
        return maxi;
    }
    public static int solve_DP(int i,int j1,int j2,int[][] matrix,int[][] dp)
    {
        if(j1<0 || j1>=matrix[0].length || j2<0 || j2>=matrix[0].length) return (int)(-1e8);
        if(i==matrix.length-1)
        {
            if(j1==j2) return matrix[i][j1];
            else return matrix[i][j1]+matrix[i][j2];
        }
        int maxi=(int)(-1e8);
        for(int dj1=-1;dj1<=1;dj1++)
        {
            for(int dj2=-1;dj2<=1;dj2++)
            {
                int value=0;
                if(j1==j2) return matrix[i][j1];
                else value= matrix[i][j1]+matrix[i][j2];
                value+=solve_DP(i+1,j1+dj1,j2+dj2,matrix,dp);
                maxi=Math.max(maxi,value);
            }
        }
        return maxi;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int r = scn.nextInt();
        int c = scn.nextInt();
        int[][] grid=new int[r][c];
        for(int i=0;i<r;i++)
        {
            for(int j=0;j<c;j++) grid[i][j]=scn.nextInt();
        }

        System.out.println(solve(0,0,c-1,grid)); //simple recursive approach

        int[][] dp=new int[r][c];
        System.out.println(solve_DP(0,0,c-1,grid,dp));



    }
}
