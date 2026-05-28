一开始先想暴力，但是这个题如果暴力去解应该只能回溯吧，我们没办法去直接确定最优路线，所以就想到了动态规划
从后往前遍历，这样就可以很好的利用之前产生的最大数，并且能很直接的知道现在这个数字之后每个数的最优解
状态转换方程dp[i]=Math.max(1+dp[j],dp[i])
  class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp=new int[nums.length];
        Arrays.fill(dp,1);
        dp[nums.length-1]=1;
        for(int i=nums.length-2;i>=0;i--){
            for(int j=i+1;j<nums.length;j++){
                if(nums[i]<nums[j]){
                    dp[i]=Math.max(1+dp[j],dp[i]);
                }
            }
        }
        Arrays.sort(dp);
        return dp[nums.length-1];
    }
}
