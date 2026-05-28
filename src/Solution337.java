import com.sun.source.tree.Tree;

public class Solution337 {
    public int rob(TreeNode root) {
        int[] dp=postorder(root);
        return Math.max(dp[0],dp[1]);
    }
    public int[] postorder(TreeNode node){
        if(node==null) return new int[]{0,0};

        int[] left=postorder(node.left);
        int[] right=postorder(node.right);

        //第一步看要不要抢本节点，发现要看后面的结点，倒推上面两步
        int[] robnode=new int[2];
        //抢本节点
        robnode[1]=node.val+left[0]+right[0];
        //不抢本节点,子结点可抢可不抢
        robnode[0]=Math.max(left[1],left[0])+Math.max(right[1],right[0]);
        return robnode;
    }
}
