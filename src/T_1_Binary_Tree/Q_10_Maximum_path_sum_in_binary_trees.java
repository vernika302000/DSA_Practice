package T_1_Binary_Tree;

import java.util.Scanner;

public class Q_10_Maximum_path_sum_in_binary_trees
{
    // -10 9 20 N N 15 7
    public static int maxPathSum(Q_1_Constructing_the_binary_tree.Node root,int[] maxValue) //Logic - Always val+max(left,right)
    {
        if(root==null) return 0;
        int left=Math.max(0,maxPathSum(root.left,maxValue));
        int right=Math.max(0,maxPathSum(root.right,maxValue));
        maxValue[0]=Math.max(maxValue[0],left+right+root.data);
        return Math.max(left,right)+root.data;
    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        int[] maxValue=new int[1];
        maxValue[0]=Integer.MIN_VALUE;
        int ans=maxPathSum(root,maxValue);
        System.out.println(ans);

    }
}
