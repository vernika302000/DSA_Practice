package T_3_Dynamic_Programming;
import java.util.*;

public class Q_3_Frog_Jumping
{
    /*
    * There is a frog on 1st step of a N long staircase, and wants to reach to the Nth stair
    *
    *
    *
    * */
    public static int frogJump(int n,int[] dp)
    {
        return 0;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]= scn.nextInt();
        int[] dp=new int[n+1];
        int ans=frogJump(n,dp);
        System.out.println(ans);
    }
}
