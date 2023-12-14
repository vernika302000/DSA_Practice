package T_1_Binary_Tree;
import java.util.*;

public class Q_6_Maximum_Depth_of_Binary_Tree
{
    //1 2 3 N N 4 6 N N N N 5 N N N
    public static int MaximumDepth(Q_1_Constructing_the_binary_tree.Node root)
    {
        if(root == null) return 0;
        int lh=MaximumDepth(root.left);
        int rh=MaximumDepth(root.right);
        return 1+Math.max(rh,lh);
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        int maxDepth= MaximumDepth(root);
        System.out.println(maxDepth);

    }
}
