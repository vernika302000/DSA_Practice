package T_3_Dynamic_Programming;
import java.util.*;

public class Q_5_Frog_jump_wit_k_distance
{
    // 5 3 => 10 30 40 50 20 => output -> 30
    public static int KJumps_Recursion(int ind,int k,int[] a)
    {
        if(ind==0) return 0;
        int minSteps=Integer.MAX_VALUE;
        for(int i=1;i<=k;i++)
        {
            int jumps=Integer.MAX_VALUE;
            if(ind-i>=0) jumps=KJumps_Recursion(ind-i,k,a)+Math.abs(a[ind-i]-a[ind]);
            minSteps=Math.min(minSteps,jumps);
        }
        return minSteps;
    }
    public static void KJumps_memoization(int ind,int k,int[] a,int[] dp)
    {

        int n=a.length;
        for(int i=1;i<n;i++)
        {
            int min_steps=Integer.MAX_VALUE;
            for(int j=1;j<=k;j++)
            {
                int jumps=0;
                if(i-j>=0)
                {
                    jumps=dp[i-j]+Math.abs(a[ind-j]-a[ind]);
                    min_steps=Math.min(jumps,min_steps);
                }

            }
            dp[i]=min_steps;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        int[] heights=new int[n];
        for(int i=0;i<n;i++) heights[i]=scn.nextInt();

        System.out.println(KJumps_Recursion(n-1,k,heights)); // simple recursion

        int[] dp=new int[n+1];
        Arrays.fill(dp,-1);
        dp[0]=0;
        KJumps_memoization(n-1,k,heights,dp); // DP technique with memoization
        System.out.println(dp[n-1]);
    }
}
