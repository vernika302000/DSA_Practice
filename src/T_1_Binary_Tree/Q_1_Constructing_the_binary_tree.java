package T_1_Binary_Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Q_1_Constructing_the_binary_tree
{
    //input -> 1 2 3 4 5 7 8 N N 6 N N N 9 10
    public static class Node
    {
        int data;
        Node left;
        Node right;
        public Node(int val)
        {
            data=val;
            left=null;
            right=null;
        }

    }
    public static Node Construct(String str)
    {
        if(str.length()==0 || str.charAt(0)=='N') return null;

        String[] parts=str.split(" ");

        Node root=new Node(Integer.parseInt(parts[0]));

        Queue<Node> tree=new LinkedList<>();

        tree.add(root);

        int i=1;
        while(tree.size()>0 && i<parts.length)
        {
            Node currNode = tree.peek();
            tree.remove();

            String currVal=parts[i];
            if(!currVal.equals("N"))
            {
                currNode.left = new Node(Integer.parseInt(currVal));
                tree.add(currNode.left);
            }
            i++;

            if(i>=parts.length) break;
            currVal=parts[i];
            if(!currVal.equals("N"))
            {
                currNode.right = new Node(Integer.parseInt(currVal));
                tree.add(currNode.right);
            }
            i++;
        }
        return root;
    }
    public static void main(String[] args)
    {
        Scanner scn = new Scanner(System.in);
        String str = scn.nextLine();
        Node root=Construct(str);
    }
}
