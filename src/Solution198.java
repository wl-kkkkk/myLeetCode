public class Solution198 {
    public int rob(int[] nums) {
        int length=nums.length;
        int[] dp = new int[length];

        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);

        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(nums[i-1],nums[i]+nums[i-2]);
        }

        return Math.max(dp[nums.length-1],dp[nums.length-1]);
    }
}
