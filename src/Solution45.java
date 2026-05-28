import java.util.*;
import java.lang.*;

public class Solution45 {
    public int jump(int[] nums) {
        //dp[i]表示从前面跳过来需要几步    dp[0]=0; dp[1]=1 dp[2]=dp[i],dp[i-j]
        if(nums.length==0) return 0;
        if(nums.length==1) return 1;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(i<=j+nums[j]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        System.out.println(dp[3]);
        return dp[nums.length-1];
    }
}
