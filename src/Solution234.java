public class Solution234 {
    ListNode newnode=new ListNode();
    ListNode anode=newnode;
    public boolean isPalindrome(ListNode head) {
        ListNode cur=head;
        dfs(cur);
        while(anode.val==head.val){
            anode=anode.next;
            head=head.next;
            if(head==null||anode==null) return true;
        }
        return false;
    }
    public void dfs(ListNode cur){
        if(cur==null) return;
        dfs(cur.next);
        newnode.val=cur.val;
        newnode.next=new ListNode();
        newnode=newnode.next;
    }
}
