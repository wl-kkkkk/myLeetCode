public class Solution25 {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode test=head;
        //判断是否够k个
        int count=0;
        while(count<k && test!=null){
            test=test.next;
            count++;
        }

        if(count<k) return head;

        ListNode prev=null;
        ListNode cur=head;
        ListNode next;
        for(int i=0;i<k;i++){
            next=cur.next;
            cur.next=prev;
            prev=cur;
            cur=next;
        }

        head.next=reverseKGroup(cur,k);

        return prev;
    }

}
