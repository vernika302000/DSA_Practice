package T_3_Dynamic_Programming;
import java.util.*;

public class Q_6_Maximum_sum_non_adjacent
{
    // Sample Input - 4, 2 1 4 9 => output - 11
    public static int max_sum_recursion(int ind,int[] a)
    {
        if(ind==0) return a[ind];
        if(ind<0) return 0;
        int pick=a[ind]+max_sum_recursion(ind-2,a);
        int notPick=max_sum_recursion(ind-1,a);

        return Math.max(pick,notPick);

    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=scn.nextInt();

        System.out.println(max_sum_recursion(n-1,arr));

    }
}
