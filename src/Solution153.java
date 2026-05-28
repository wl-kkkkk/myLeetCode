public class Solution153 {
    public int findMin(int[] nums) {
        int l=-1,r=nums.length;
        while(l+1!=r){
            int mid=(l+r)/2;
            if(nums[mid]<nums[r-1]) r=mid+1;
            else l=mid;
        }
        return nums[l];
    }
}
