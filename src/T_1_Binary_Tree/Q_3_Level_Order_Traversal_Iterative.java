package T_1_Binary_Tree;
import java.util.*;

public class Q_3_Level_Order_Traversal_Iterative
{
    //input -> 1 2 3 4 5 7 8 N N 6 N N N 9 10
    public static List<List<Integer>> levelOrder(Q_1_Constructing_the_binary_tree.Node root)
    {
        Queue<Q_1_Constructing_the_binary_tree.Node> q=new LinkedList<>();
        List<List<Integer>> ans=new LinkedList<List<Integer>>();
        if(root == null) return ans;
        q.offer(root);
        while(!q.isEmpty())
        {
            int level=q.size();
            List<Integer> list=new LinkedList<>();
            for(int i=0;i<level;i++)
            {
                if(q.peek().left!=null) q.offer(q.peek().left);
                if(q.peek().right!=null) q.offer(q.peek().right);
                list.add(q.poll().data);
            }
            ans.add(list);
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        List<List<Integer>> ans=levelOrder(root);
        System.out.println(ans);
    }
}
