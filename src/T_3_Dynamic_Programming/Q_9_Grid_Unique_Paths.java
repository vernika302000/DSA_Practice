package T_3_Dynamic_Programming;
import java.util.*;

public class Q_9_Grid_Unique_Paths
{
    public static int solve(int i,int j,int m,int n)
    {
        if(i==0 && j==0) return 1;
        if(i<0 || j<0) return 0;
        int up=solve(i-1,j,m,n);
        int left=solve(i,j-1,m,n);
        return up+left;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int m=scn.nextInt();
        int n=scn.nextInt();

        System.out.println(solve(m-1,n-1,m,n));
    }

}
