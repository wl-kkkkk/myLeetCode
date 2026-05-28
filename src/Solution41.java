public class Solution41 {
    public int firstMissingPositive(int[] nums) {
        int nlen=nums.length;
        for(int i=0;i<nlen;i++){
            if(nums[i]<=0) nums[i]=nlen+1;
        }
        for(int i=0;i<nlen;i++){
            int num=Math.abs(nums[i]);
            if(num-1<nlen){
                nums[num-1]=-Math.abs(nums[num-1]);
            }
        }
        for(int i=0;i<nlen;i++){
            if(nums[i]>0) return i+1;
        }
        return nlen+1;
    }
}
