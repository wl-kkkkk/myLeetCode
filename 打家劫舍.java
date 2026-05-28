//和爬楼梯一样，这个问题也能拆分成最小子问题，也就是当你到最后一步时，你要求前面的最优解去加上这最后一步，用递归的思路直接就得到了这个问题的解。
//这个问题关键就是，当你偷第n家时，你要算出前n-1家的最优解。Math.max(dp[i-1],dp[i-2]+nums[i]);
class Solution {
    public int rob(int[] nums) {
        if(nums.length==1) return nums[0];
        if(nums.length==2) return Math.max(nums[0],nums[1]);
        int[] dp=new int[nums.length];
        dp[0]=nums[0];
        dp[1]=Math.max(nums[0],nums[1]);
        for(int i=2;i<nums.length;i++){
            dp[i]=Math.max(dp[i-1],dp[i-2]+nums[i]);
        }
        return dp[nums.length-1];
    }
}
