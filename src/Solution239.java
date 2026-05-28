import java.util.*;
public class Solution239 {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //用一个变量维护栈的长度
        Deque<Integer> deque = new ArrayDeque<>();
        int[] ans=new int[nums.length-k+1];
        int index=0;

        //弄一个单调队列
        for(int i=0;i<nums.length;i++){
            while(!deque.isEmpty()&&nums[i]>=nums[deque.peekLast()]){
                deque.pollLast();
            }
            deque.offerLast(i);
            if(i-deque.peekFirst()>=k) deque.pollFirst();
            if(i>=k-1) ans[index++]=nums[deque.peekFirst()];
        }
        return ans;
    }
}
