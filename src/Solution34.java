import java.sql.Array;

public class Solution34 {
    public int[] searchRange(int[] nums, int target) {
        int l=-1,r=nums.length,tar=-1;

        while(l+1!=r){
            int mid=(l+r)/2;
            if(nums[mid]>target) r=mid;
            else if(nums[mid]<target) l=mid;
            else{
                tar=mid;
                break;
            }
        }

        if(tar==-1) return new int[]{-1,-1};

        int i,j;
        for(i=tar;i>=0;i--){
            if(nums[i]!=target) break;
        }
        l=i+1;

        for(j=tar;j<nums.length;j++){
            if(nums[j]!=target) break;
        }
        r=j-1;

        return new int[]{l,r};
    }
}
