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
//方法一：先求链表长度，然后直接删除
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp=new ListNode();
        temp=head;
        int num=1;
        while(temp.next!=null){
            temp=temp.next;
            num++;
        }
        if(num==n){
            head=head.next;
            return head;
        }else{
            temp=head;
            for(int i=0;i<num-n-1;i++){
                temp=temp.next;
            }
            temp.next=temp.next.next;
            return head;
        }
        
    }
}
//方法二：双指针，让两个指针距离为n，当后面的指针遍历到末尾后，现在的指针自然在倒数第n个位置,注意处理要删除的点是首结点的情况(PS：没有用哨兵)
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode left=new ListNode();
        left=head;
        ListNode right=new ListNode();
        right=head;
        for(int i=0;i<n;i++){
            right=right.next;
        }
        if(right==null){
            head=head.next;
            return head;
        }
        while(right.next!=null){
            left=left.next;
            right=right.next;
        }
        left.next=left.next.next;
        return head;

        
    }
}
//方法三：用哨兵
//用哨兵
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy=new ListNode(0,head);
        ListNode left=new ListNode();
        left=dummy;
        ListNode right=new ListNode();
        right=head;
        for(int i=0;i<n;i++){
            right=right.next;
        }
        while(right!=null){
            left=left.next;
            right=right.next;
        }
        left.next=left.next.next;
        return dummy.next;

        
    }
}
