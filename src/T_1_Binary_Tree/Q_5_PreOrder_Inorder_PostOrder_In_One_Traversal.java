package T_1_Binary_Tree;
import java.util.*;

public class Q_5_PreOrder_Inorder_PostOrder_In_One_Traversal
{
      /*    Sample Test Case ->    1 2 5 3 4 6 7
            PreOrder Traversal ->  [1, 2, 3, 4, 5, 6, 7]
            InOrder Traversal ->   [3, 2, 4, 1, 6, 5, 7]
            PostOrder Traversal -> [3, 4, 2, 6, 7, 5, 1] */


    public static class Pair
    {
        Q_1_Constructing_the_binary_tree.Node node;
        int num;
        public Pair(Q_1_Constructing_the_binary_tree.Node Node,int val)
        {
            num=val;
            node=Node;
        }
    }
    public static void OneTraversal(Q_1_Constructing_the_binary_tree.Node root)
    {
        Stack<Pair> st=new Stack<>();
        st.push(new Pair(root,1));
        List<Integer> pre=new LinkedList<>();
        List<Integer> post=new LinkedList<>();
        List<Integer> in=new LinkedList<>();

        if(root == null) return;
        while(!st.isEmpty())
        {
            Pair it=st.pop();
            if(it.num==1)
            {
                pre.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.left!=null) st.push(new Pair(it.node.left,1));
            }
            else if(it.num==2)
            {
                in.add(it.node.data);
                it.num++;
                st.push(it);

                if(it.node.right!=null) st.push(new Pair(it.node.right,1));
            }
            else
            {
                post.add(it.node.data);
            }
        }
        System.out.println("PreOrder Traversal ->  "+pre);
        System.out.println("InOrder Traversal -> "+in);
        System.out.println("PostOrder Traversal -> "+post);

    }
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        String str=scn.nextLine();
        Q_1_Constructing_the_binary_tree.Node root=Q_1_Constructing_the_binary_tree.Construct(str);
        OneTraversal(root);
    }
}
