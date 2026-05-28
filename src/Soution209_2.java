public class Soution209_2 {
    public int minSubArrayLen(int target, int[] nums) {
        int l=0,r=0;
        int min=Integer.MAX_VALUE;
        int sep=0;
        while(r<nums.length){
            sep+=nums[r];
            while(sep>=target){
                min=Math.min(r-l+1,min);
                sep-=nums[l++];
            }
            r++;
        }
        if(min==Integer.MAX_VALUE) return 0;
        else return min;
    }
}
