public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
        if(!jianzi(target,nums,0)) return 0;
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int step=0;
            for(int j=i;j<nums.length;j++){
                if(!jianzi(target,nums,j)) break;
                step++;
                sum+=nums[j];
                if(sum>=target){
                    min=Math.min(step,min);
                    break;
                }
            }
        }
        return min;
    }
    public boolean jianzi(int target,int[] nums,int i){
        int sep=0;
        for(int j=i;j<nums.length;j++){
            sep+=nums[i=j];
        }
        if(sep<target) return false;
        return true;
    }
}
