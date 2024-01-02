package T_2_Graphs;
import java.util.*;

public class Q_27_word_Ladder_2
{
    /* 5 {"des","der","dfr","dgt","dfs"} , der, dfs => output = der dfr dfs ,der des dfs */

    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n= scn.nextInt();
        String[] wordList=new String[n+1];
        for(int i=0;i<=n;i++) wordList[i]= scn.nextLine();
        String startWord= scn.nextLine();
        String targetWord= scn.nextLine();

        Set<String> set=new HashSet<>();
        for(String word:wordList) set.add(word);
        Queue<ArrayList<String>> q=new LinkedList<>();
        ArrayList<String> ls=new ArrayList<>();
        ls.add(startWord);
        q.add(ls);
        ArrayList<String> usedOnLevel=new ArrayList<>();
        usedOnLevel.add(startWord);
        int level=0;
        ArrayList<ArrayList<String>> ans=new ArrayList<>();

        while(!q.isEmpty())
        {
            ArrayList<String> vec=q.peek();
            q.remove();
            if(vec.size()>level)
            {
                level++;
                for(String it:usedOnLevel)
                {
                    set.remove(it);
                }
            }
            String word=vec.get(vec.size()-1);
            if(word.equals(targetWord))
            {
                if(ans.size()==0) ans.add(vec);
                else if(ans.get(0).size()==vec.size()) ans.add(vec);
            }
            for(int i=0;i<word.length();i++)
            {
                for(char ch='a';ch<='z';ch++)
                {
                    char[] seq=word.toCharArray();
                    seq[i]=ch;
                    String newWord=new String(seq);
                    if(set.contains(newWord))
                    {
                        vec.add(newWord);
                        ArrayList<String> temp=new ArrayList<>(vec);
                        q.add(temp);
                        usedOnLevel.add(newWord);
                        vec.remove(vec.size()-1);
                    }
                }
            }
        }
        System.out.println(ans);
    }
}
