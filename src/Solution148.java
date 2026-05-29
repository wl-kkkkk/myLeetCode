/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution148 {
    public ListNode sortList(ListNode head) {

        if(head==null || head.next==null){
            return head;
        }

        ListNode fast=head.next;
        ListNode slow=head;

        while(fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        ListNode right=slow.next;
        slow.next=null;

        ListNode high=sortList(head);
        ListNode shor=sortList(right);
        ListNode sorted=merge(high,shor);

        return sorted;
    }

    public ListNode merge(ListNode first,ListNode second){
        ListNode res=new ListNode(0);
        ListNode dummy=res;
        while(first!=null&&second!=null){
            if(first.val<second.val){
                res.next=first;
                first=first.next;
            }else{
                res.next=second;
                second=second.next;
            }
            res=res.next;
        }
        if(first==null){
            res.next=second;
        }else{
            res.next=first;
        }

        return dummy.next;
    }
}