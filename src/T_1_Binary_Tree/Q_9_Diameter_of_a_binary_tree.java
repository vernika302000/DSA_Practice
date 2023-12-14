package T_1_Binary_Tree;
import java.util.*;

public class Q_9_Diameter_of_a_binary_tree
{
    public static int diameter(Q_1_Constructing_the_binary_tree.Node root)
    {
        int[] dia=new int[1];
        int val=height(root,dia);
        return dia[0];
    }
    public static int height(Q_1_Constructing_the_binary_tree.Node root, int[] dia)
    {
        if(root == null) return 0;
        int lh=height(root.left,dia);
        int rh=height(root.right,dia);
        dia[0]=Math.max(dia[0],lh+rh);
        return 1+Math.max(lh,rh);

    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        System.out.println(diameter(root));

    }
}
