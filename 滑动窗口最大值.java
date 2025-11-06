class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {

        Deque<Integer> queue=new LinkedList<>();
        int[] ans=new int[nums.length-k+1];
        int len=0;
        //在队列长度小于k的情况下，满足队列的出口一定是最大的
        //在队列里放索引，就可以避免队列内的元素不在窗口
        for(int i=0;i<nums.length;i++){
            if(!queue.isEmpty()&&queue.peekFirst()<i-k+1) queue.pollFirst();//保证第二点
            while(!queue.isEmpty()&&nums[i]>nums[queue.peekLast()]) queue.pollLast();//保证递减
            queue.add(i);
            if(i>k-2) ans[len++]=nums[queue.peekFirst()];
        }
        return ans;
    }
}
