import java.util.HashSet;
import java.util.Set;

public class Solution142 {
    public ListNode detectCycle(ListNode head) {
        if(head==null) return null;
        ListNode fast=head,slow=head;
        while(fast!=null){
            slow=slow.next;
            if(fast.next!=null) fast=fast.next.next;
            else return null;
            if(fast==slow){
                ListNode ptr=head;
                while(ptr!=slow){
                    ptr=ptr.next;
                    slow=slow.next;
                }
                return ptr;
            }
        }
        return null;
     }
}
