//方法一：三重循环暴力求解，但其实用了两个指针，写着好看一点
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=Integer.MAX_VALUE;
        int temp=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                int k=nums.length-1;
                while(k>j){
                    int res=nums[i]+nums[j]+nums[k];
                    if(Math.abs(res-target)<Math.abs(temp)){
                        ans=res;
                        temp=res-target;
                    } 
                    k--;
                }
            }
        }
        return ans;
    }
}
//方法二：简化三层循环，先排序，在第三层循环中添加判断若和已经大于target且比上一次的结果大就跳出第二层，但本质上时间复杂度是不变的，这里就不写了
//方法三：先排序，然后一层循环后用双指针，如果和小于target，让二层循环指针右移；否则，三重循环指针左移
//原理：当三数之和大于target时，之后二层循环的遍历与在现在三重循环之后之和一定大于现在这个数，一定离target更远，我们自然的就减少了冗余。同理，三数之和小于target时，现在二层循环之数与现在三重循环之前之数一定要离
class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int ans=Integer.MAX_VALUE;
        int temp=Integer.MAX_VALUE;
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            int j=i+1,k=nums.length-1;
            while(j<k){
                int res=nums[i]+nums[j]+nums[k];
                if(target>res){
                    if(target-res<temp){
                        temp=target-res;
                        ans=res;
                    }
                    j++;
                }else if(target<res){
                    if(res-target<temp){
                        temp=res-target;
                        ans=res;
                    }
                    k--;
                }else{
                    return target;
                }
            }
        }
        return ans;
    }
}
