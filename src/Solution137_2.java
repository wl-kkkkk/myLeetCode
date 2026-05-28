public class Solution137_2 {
    public int singleNumber(int[] nums){
        int ans=0;
        int temp=0;
        for(int i=0;i<32;i++){
            for(Integer num:nums){
                temp+=(num>>i)&1;
            }
            if(temp%3!=0){
                ans=(1<<i)|ans;
            }
        }
        return ans;
    }
}
