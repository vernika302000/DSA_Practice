package T_1_Binary_Tree;

import java.util.LinkedList;
import java.util.*;

public class Q_2_PreOder_Traversal_Iterative
{
    //input -> 1 2 3 4 5 7 8 N N 6 N N N 9 10
    public static List<Integer> PreOrderIterative(Q_1_Constructing_the_binary_tree.Node root)
    {
        List<Integer> list=new LinkedList<>();
        Stack<Q_1_Constructing_the_binary_tree.Node> st=new Stack<>();
        st.push(root);
        while(!st.isEmpty())
        {
            root=st.pop();
            list.add(root.data);
            if(root.right!=null) st.push(root.right);
            if(root.left!=null) st.push(root.left);
        }
        return list;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        System.out.println("PreOrder Traversal -> ");
        List<Integer> list=PreOrderIterative(root);
        System.out.println(list);
    }
}
