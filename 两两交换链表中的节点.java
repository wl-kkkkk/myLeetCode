//写这种恶心东西，首先弄个哨兵。然后把变量名弄好，我倾向于弄prev，current，future
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
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head==null||head.next==null) return head;
        ListNode dummy=new ListNode(0,null);
        dummy.next=head.next;
        ListNode current=head,future=head.next,prev=current;
        while(current!=null&&future!=null){
            prev.next=future;
            prev=current;
            current.next=future.next;
            future.next=prev;
            current=current.next;
            if(current==null) break;
            future=current.next;
        }
        return dummy.next;
    }
}
