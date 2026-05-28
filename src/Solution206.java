public class Solution206 {
    ListNode ans=new ListNode(1);
    ListNode res=ans;
    public ListNode reverseList(ListNode head) {
        dfs(head);
        return res.next;
    }
    public void dfs(ListNode node){
        if(node==null) return;
        dfs(node.next);
        ans.next=node;
        System.out.println(node.val);
        ans=ans.next;
    }
}
