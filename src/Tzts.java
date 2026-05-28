public class Tzts {

    //Solution33
    public int search(int[] nums, int target) {
        //先找到key
        int k=0;
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]>nums[i+1]){
                k=i;
                break;
            }
        }
        //寻找target
        int ans;
        if(nums[k]==target) return k;
        if(target>nums[nums.length-1]){
            int left=-1,right=k,mid;
            ans=findnum(left,right,nums,target);
        }else{
            int left=k,right=nums.length,mid;
            ans=findnum(left,right,nums,target);
        }
        return ans;
    }
    public int findnum(int left,int right,int[] nums,int target){
        int mid;
        while(left+1!=right){
            mid=(left+right)/2;
            if(nums[mid]==target) return mid;
            else if(nums[mid]<target) left=mid;
            else right=mid;
        }
        return -1;
    }
}
