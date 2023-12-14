package T_1_Binary_Tree;
import java.util.*;

public class Q_2_Inorder_Traversal_Iterative
{
    //input -> 1 2 3 4 5 7 8 N N 6 N N N 9 10
    public static List<Integer> InOrderIterative(Q_1_Constructing_the_binary_tree.Node root)
    {
        List<Integer> ans=new LinkedList<>();
        Stack<Q_1_Constructing_the_binary_tree.Node> st=new Stack<>();

        Q_1_Constructing_the_binary_tree.Node node=root;
        while(true)
        {
            if(node!=null)
            {
                st.push(node);
                node=node.left;
            }
            else
            {
                if(st.isEmpty()) break;
                node=st.pop();
                ans.add(node.data);
                node=node.right;
            }
        }
        return ans;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str= scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        System.out.print("Inorder Traversal -> ");
        List<Integer> ans=InOrderIterative(root);
        System.out.println(ans);
    }
}
