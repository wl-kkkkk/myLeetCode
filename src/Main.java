public class Main {
    public static void main(String[] args) {
        Solution5 s = new Solution5();
        ListNode head=new ListNode(1);
        ListNode head1=new ListNode(2);
        ListNode head2=new ListNode(3);
        ListNode head3=new ListNode(4);
        head.next=head1;
        head1.next=head2;
        head2.next=head3;
        System.out.println(s.longestPalindrome("aaaa"));
    }
    public static void print(int[] nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" ");
        }
        System.out.println();
    }
}

