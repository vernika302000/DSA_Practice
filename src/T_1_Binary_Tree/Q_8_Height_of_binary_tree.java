package T_1_Binary_Tree;

import java.util.Scanner;

public class Q_8_Height_of_binary_tree
{
    public static int height(Q_1_Constructing_the_binary_tree.Node root)
    {
        if(root == null) return 0;
        int lh=height(root.left);
        int rh=height(root.right);
        return 1+Math.max(rh,lh);
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        int Height= height(root);
        System.out.println(Height);

    }
}
