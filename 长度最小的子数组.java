//不能暴力，我的暴力代码也放到了下面，有剪枝；可以双指针，遍历一遍数组
class Solution {
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
//暴力加剪枝
public class Solution209 {
    public int minSubArrayLen(int target, int[] nums) {
    //这里判断特殊情况，即整个数组加起来比target小
        if(!jianzi(target,nums,0)) return 0;
        //
        int min=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int step=0;
            for(int j=i;j<nums.length;j++){
            //剪枝
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
