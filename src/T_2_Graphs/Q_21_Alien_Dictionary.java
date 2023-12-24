package T_2_Graphs;
import java.util.*;

public class Q_21_Alien_Dictionary
{
    /*
       Given a sorted dictionary of an alien language having N words and k starting alphabets of
       standard dictionary.
       Find the order of characters in the alien language.
       N = 5, K = 4
       dict = {"baa","abcd","abca","cab","cad"} => o/p - 'b', 'd', 'a', 'c'
       Algorithm -> 1. Traverse in pairs in the strings and form a directed graph
                    2. Then perform the topological sorting of that directed graph
     */
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int k=scn.nextInt();
        String[] input=new String[n+1];
        for(int i=0;i<=n;i++) input[i]=scn.nextLine();
        List<List<Integer>> adj=new ArrayList<>();
        for(int i=0;i<k;i++)
        {
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<n-1;i++)
        {
            String str1=input[i];
            String str2=input[i+1];
            int len=Math.min(str1.length(),str2.length());
            for(int ptr=0;ptr<len;ptr++)
            {
                if(str1.charAt(ptr)!=str2.charAt(ptr))
                {
                    adj.get(str1.charAt(ptr)-'a').add(str2.charAt(ptr)-'a');
                    break;
                }
            }
        }
        List<Integer> ans=Q_17_Kahns_Algorithm.topo(adj,k);
        String output="";
        for(int val:ans)
        {
            output=output+(char)(val+(int)('a'));
        }
        System.out.println(output);

    }
}
