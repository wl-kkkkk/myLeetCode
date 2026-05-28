//方法1：暴力解5min解决战斗
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i-1]==nums[i]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j!=i+1&&nums[j]==nums[j-1]) continue;
                for(int k=j+1;k<nums.length;k++){
                    if(k!=j+1&&nums[k]==nums[k-1]) continue;
                    for(int l=k+1;l<nums.length;l++){
                        if(l!=k+1&&nums[l]==nums[l-1]) continue;
                        if((long)nums[i]+nums[j]+nums[k]+nums[l]==target){
                            List<Integer> list=new ArrayList<Integer>();
                            list.add(nums[i]);
                            list.add(nums[j]);
                            list.add(nums[k]);
                            list.add(nums[l]);
                            res.add(list);
                        }
                    }
                }
            }
        }
        return res;
    }
}
//方法2：像三数之和一样开始简化，原理如下
//数组排序后，先来两层for循环，后两层用双指针简化，规定左指针小于右指针，在和大于target后，右指针左移；反之左指针右移，在精简的在之前的三数之和已经说过了
class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            if(i!=0&&nums[i-1]==nums[i]) continue;
            for(int j=i+1;j<nums.length;j++){
                if(j!=i+1&&nums[j]==nums[j-1]) continue;
                int l=j+1,r=nums.length-1;
                while(l<r){
                    if((long)nums[i]+nums[j]+nums[l]+nums[r]==target){
                        List<Integer> list=new ArrayList<Integer>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        l++;
                        while(nums[l-1]==nums[l]&&l<r){
                            l++;
                        }
                        r--;
                        while(nums[r]==nums[r+1]&&l<r) {
                            r--;
                        }
                    }else if((long)nums[i]+nums[j]+nums[l]+nums[r]>target){
                        r--;
                        while(nums[r]==nums[r+1]&&l<r){
                            r--;}

                    }else{
                        l++;
                        while(nums[l-1]==nums[l]&&l<r) {
                            l++;
                        }
                    }
                }
            }
        }
        return res;
    }
}
