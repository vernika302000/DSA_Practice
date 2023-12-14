package T_1_Binary_Tree;

import java.util.Scanner;

public class Q_4_PreOrder_Traversal_Recursive
{
    //input -> 1 2 3 4 5 7 8 N N 6 N N N 9 10
    public static void PostOrder(Q_1_Constructing_the_binary_tree.Node root)
    {
        if(root==null) return;
        PostOrder(root.left);
        PostOrder(root.right);
        System.out.println(root.data);
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        System.out.println("Post Order Traversal -> ");
        PostOrder(root);
    }
}
