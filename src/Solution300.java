import java.util.Arrays;

public class Solution300 {
    public int lengthOfLIS(int[] nums) {
        int maxNum=1;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,1);

        for(int i=1;i<nums.length;i++){
            for(int j=i-1;j>=0;j--){
                if(nums[i]>nums[j]){
                    dp[i]=Math.max(dp[i],dp[j]+1);
                }
            }
            if(dp[i]>maxNum)maxNum=dp[i];
        }

        return maxNum;
    }
}
