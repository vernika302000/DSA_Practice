package T_3_Dynamic_Programming;
import java.util.*;

public class Q_7_House_Robber_2
{
    static long solve(ArrayList<Integer> arr){
        int n = arr.size();
        long prev = arr.get(0);
        long prev2 =0;

        for(int i=1; i<n; i++){
            long pick = arr.get(i);
            if(i>1)
                pick += prev2;
            long nonPick = prev;

            long cur_i = Math.max(pick, nonPick);
            prev2 = prev;
            prev= cur_i;

        }
        return prev;
    }

    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++) arr[i]=scn.nextInt();

        ArrayList<Integer> arr1=new ArrayList<>();
        ArrayList<Integer> arr2=new ArrayList<>();

        if(n==1)
        {
            System.out.println(arr[0]);
            return ;
        }
        for(int i=0; i<n; i++){

            if(i!=0) arr1.add(arr[i]);
            if(i!=n-1) arr2.add(arr[i]);
        }

        long ans1 = solve(arr1);
        long ans2 = solve(arr2);

        System.out.println(Math.max(ans1,ans2));


    }
}
