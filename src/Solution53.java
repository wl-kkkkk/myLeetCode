public class Solution53 {
    public int maxSubArray(int[] nums) {
        //新建一个dp数组，每个值为这个下标之前的最大和即可。中间用的就是动态规划思想，你要么本身就是最大的，要么如果加前面的(前面的也是要么本身是最大的要么...)最大值
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        int max=dp[0];
        for(int i=1;i<nums.length;i++){
            dp[i]=Math.max(nums[i],nums[i]+dp[i-1]);
            if(max<dp[i]) max=dp[i];
        }
        return max;
    }
}
