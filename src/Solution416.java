public class Solution416 {
    public boolean canPartition(int[] nums) {

        if(nums.length<2) return false;

        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
        }
        if(sum%2==1) return false;

        int target=sum/2;

        for(int i=0;i<nums.length;i++){
            if(nums[i]>target) return false;
            if(nums[i]==target) return true;
        }

        //dp[i][j]代表前i个数字中是否可以和为j
        boolean[][] dp = new boolean[nums.length+1][target+1];
        for(int i=0;i<nums.length+1;i++){
            dp[i][0]=true;
        }

        for(int i=1;i<nums.length+1;i++){
            for(int j=1;j<target+1;j++){
                if(j>=nums[i-1]){
                    dp[i][j]=dp[i-1][j]||dp[i-1][j-nums[i-1]];
                }else{
                    dp[i][j]=dp[i-1][j];
                }
            }
        }

        return dp[nums.length][target];
    }
}
