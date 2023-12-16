package T_2_Graphs;
import java.util.*;

public class Q_10_Surrounded_Regions
{
    // Algorithm -> DFS
    // Visit the boundary of the matrix and convert all the 0's and 0's connected to it and mark them as-
    // -1 in visited array.
    // Now then traverse the inner part of matrix and for every 0 check -
    // - if the boundary of it in visited array is marked 1 or not if not then convert it into X else not.
    // Input -> 5 4 -> X X X X | X 0 X X | X 0 0 X | X 0 X X | X X 0 0
    // Output -> X X X X | X X X X | X X X X | X X X X | X X 0 0
    public static void main(String[] args)
    {
        Scanner scn=new Scanner(System.in);
        int n=scn.nextInt();
        int m= scn.nextInt();
        int[][] mat=new int[n][m];
        for(int i=0;i<n;i++)
        {
            for(int j=0;j<m;j++)
            {
                mat[i][j]=scn.nextInt();
            }
        }
        int[][] vis=new int[n][m];
        Arrays.fill(vis,0);



    }
}
