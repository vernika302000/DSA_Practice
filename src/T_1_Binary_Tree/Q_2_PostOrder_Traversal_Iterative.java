package T_1_Binary_Tree;

import java.util.*;

public class Q_2_PostOrder_Traversal_Iterative
{
    public static List<Integer> PostOrderIterative(Q_1_Constructing_the_binary_tree.Node root)
    {
        List<Integer> list=new LinkedList<>();
        Stack<Q_1_Constructing_the_binary_tree.Node> st1=new Stack<>();
        Stack<Q_1_Constructing_the_binary_tree.Node> st2=new Stack<>();
        st1.push(root);
        while(!st1.isEmpty())
        {
            root=st1.pop();
            list.add(root.data);
            if(root.left!=null) st1.push(root.left);
            if(root.right!=null) st1.push(root.right);
        }
        while(!st2.isEmpty())
        {
            list.add(st2.pop().data);
        }
        return list;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str= scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        List<Integer> list=PostOrderIterative(root);
        System.out.println(list);
    }
}
