

public class Solution160 {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int numA=0,numB=0;

        ListNode testA=headA;
        ListNode testB=headB;

        while(testA!=null){
            numA++;
            testA=testA.next;
        }

        while(testB!=null){
            numB++;
            testB=testB.next;
        }

        testA=headA;
        testB=headB;

        if(numA>numB){
            for(int i=0;i<numA-numB;i++){
                testA=testA.next;
            }
        }else{
            for(int i=0;i<numB-numA;i++){
                testB=testB.next;
            }
        }

        ListNode ans=null;

        while(testA!=null&&testB!=null){
            if(testA==testB){
                ans=testA;
                break;
            }
            testA=testA.next;
            testB=testB.next;
        }
        return ans;
    }
}
