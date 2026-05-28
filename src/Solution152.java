import java.util.Arrays;

public class Solution152 {
    public int maxProduct(int[] nums) {

        int[] maxDp = new int[nums.length];
        int[] minDp = new int[nums.length];
        for(int i=0;i<nums.length;i++){
            maxDp[i]=nums[i];
            minDp[i]=nums[i];
        }

        for(int i=1;i<nums.length;i++){
            maxDp[i]=Math.max(nums[i], Math.max( maxDp[i-1]*nums[i],minDp[i-1]*nums[i] ) );
            minDp[i]=Math.min(nums[i], Math.min( minDp[i-1]*nums[i],maxDp[i-1]*nums[i] ) );
        }

        int ans=Integer.MIN_VALUE;
        for(Integer num:maxDp){
            ans=(ans>num)?ans:num;
        }
        return ans;
    }
}
