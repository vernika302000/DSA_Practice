package T_1_Binary_Tree;
import java.util.*;

public class Q_7_Check_for_balanced_binary_tree
{
    // A binary tree is said to be balanced if height(left subtree) - height(right subtree) <=1
    public static int CheckBalanced(Q_1_Constructing_the_binary_tree.Node root)
    {
        if(root == null) return 0;
        int leftHeight=CheckBalanced(root.left);
        if(leftHeight==-1) return -1;
        int rightHeight=CheckBalanced(root.right);
        if(rightHeight==-1) return -1;

        if(Math.abs(leftHeight-rightHeight)>1) return -1;
        return Math.max(leftHeight,rightHeight)+1;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        System.out.println(CheckBalanced(root) !=-1);
    }
}
