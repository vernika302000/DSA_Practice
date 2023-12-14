package T_1_Binary_Tree;

import java.util.Scanner;

public class Q_4_PostOrder_Traversal_Recursive
{
    //input -> 1 2 3 4 5 7 8 N N 6 N N N 9 10
    public static void PreOrder(Q_1_Constructing_the_binary_tree.Node root)
    {
        if(root==null) return;
        System.out.print(root.data+"    ");
        PreOrder(root.left);
        PreOrder(root.right);
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        System.out.println("PreOrder Traversal is ->    ");
        PreOrder(root);
    }
}
