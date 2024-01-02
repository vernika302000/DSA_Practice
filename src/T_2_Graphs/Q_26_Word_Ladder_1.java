package T_2_Graphs;
import java.util.*;

public class Q_26_Word_Ladder_1
{
    /* 7 {"poon", "plee", "same" ,"poie" ,"plea" ,"plie" ,"poin"} , toon, plea
       output -> 7
    * */
    public static class Pair
    {
        String first;
        int second;
        public Pair(String f, int s)
        {
            this.first=f;
            this.second=s;
        }
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        String[] wordList=new String[n+1];
        for(int i=0;i<=n;i++) wordList[i]= scn.nextLine();
        String startWord= scn.nextLine();
        String targetWord= scn.nextLine();

        Set<String> set=new HashSet<>();
        Queue<Pair> q=new LinkedList<>();
        for(String word:wordList)
            set.add(word);
        q.add(new Pair(startWord,1));
        set.remove(startWord);
        while(!q.isEmpty())
        {
            String word=q.peek().first;
            int steps=q.peek().second;
            q.remove();
            int len=word.length();
            if(word.equals(targetWord))
            {
                System.out.println("Shortest Path -> "+steps);
                return;
            }
            for(int i=0;i<len;i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] seq=word.toCharArray();
                    seq[i]=ch;
                    String newWord=new String(seq);
                    if(set.contains(newWord))
                    {
                        set.remove(newWord);
                        q.add(new Pair(newWord,steps+1));
                    }
                }
            }
        }
        System.out.println("Unable to transform");

    }
}
