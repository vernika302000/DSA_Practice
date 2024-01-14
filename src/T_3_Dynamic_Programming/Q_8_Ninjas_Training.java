package T_3_Dynamic_Programming;
import java.util.*;

public class Q_8_Ninjas_Training
{
    // n=3 -> 10 40 70  20 50 80  30 60 90 => output -> 210

    public static int Task_maximum(int day,int last,int[][] task)
    {
        if(day==0)
        {
            int maxi=0;
            for(int i=0;i<=2;i++)
            {
                if(i!=last) maxi=Math.max(maxi,task[0][i]);
            }
            return maxi;
        }
        int maxi=0;
        for(int i=0;i<=2;i++)
        {
            if(i!=last)
            {
                int points=task[day][i]+Task_maximum(day-1,i,task);
                maxi=Math.max(maxi,points);
            }
        }
        return maxi;
    }
//    public static int Task_maximum_DP(int day,int last,int[][] dp,int[][] task)
//    {
//        if(dp[day][last]!=-1) return dp[day][last];
//        if(day==0)
//        {
//            int maxi=0;
//            for(int i=0;i<=2;i++)
//            {
//                if(i!=last) maxi=Math.max(maxi,task[0][i]);
//            }
//            return dp[day][last]=maxi;
//        }
//        int maxi=0;
//        for(int i=0;i<=2;i++)
//        {
//            if(i!=last)
//            {
//                int points=task[day][i]+Task_maximum_DP(day-1,i,task,dp);
//                maxi=Math.max(maxi,points);
//            }
//        }
//        return dp[day][last]=maxi;
//    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[][] mat=new int[n][3];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<3;j++)
            {
                mat[i][j]= scn.nextInt();
            }
        }

        System.out.println(Task_maximum(n-1,3,mat)); // Simple Recursion

//        int[][] dp=new int[n][3];
//        for(int[] row:dp) Arrays.fill(row,-1);
//        System.out.println(Task_maximum_DP(n-1,3,dp,mat)); // DP memoization approach

        //better approach
        int[][] DP=new int[n][4];

        DP[0][0]= Math.max(mat[0][1],mat[0][2]);
        DP[0][1]= Math.max(mat[0][0],mat[0][2]);
        DP[0][2]= Math.max(mat[0][0],mat[0][1]);
        DP[0][3]= Math.max(mat[0][0],Math.max(mat[0][1],mat[0][2]));

        for(int day=0;day<n;day++)
        {
            for(int last=0;last<4;last++)
            {
                DP[day][last]=0;
                for(int i=0;i<3;i++)
                {
                    if(i!=last)
                    {
                        int points=mat[day][i]+DP[day-1][i];
                        DP[day][last]=Math.max(DP[day][last],points);
                    }
                }
            }
        }
        System.out.println(DP[n-1][3]);

    }
}
