//需要满足两点：1、可重复：即（-1，-1，2）值是可重复的2、不可重复：ijk不可重复，答案中不能有重复的List
//当要满足两点时注定不能使用哈希表等类似物去重，或者说会很麻烦，必须去用三重循环，下面是原因

//三重循环天然的满足第一点和ijk不重复，要想满足第二点的第二，就要在每一层遍历时使它的下一位不能与本位相等这时候的时间复杂度O(n^3) 

//于是根据答案的思想用了双指针在第二层循环中，即在第二层中从右向左遍历第三层，这本质上还是 O(n^3) 又出现了另一种想法，我认为我做的比答案要好——直接在第一层循环中将两数遍历完

//原理：当你确定两个数后，第三个数(target)就已经明白了(两层意思)，当右指针所指向的数大于target时，向左遍历；其它情况就要向右遍历第二层指针(l)，这里只要注意l的第一点就好当l不同后，r一定不同，这样就能在 O(n) 的时间复杂度遍历后两层，最后的时间复杂度为 O(n^2) 

//tips：当你第一层遍历的数大于0时可直接退出
class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
        List<List<Integer>> res=new ArrayList<List<Integer>>();
        if(nums.length<3){
            return res; 
        }
        Arrays.sort(nums);
        //用三重循环避免ijk相等,同时可出现（-1，-1，2）的结果
        for(int i=0;i<nums.length;i++){//1
            //避免结果重复，出现-101，-101(-1,-1,0,1)
            if(i>0&&nums[i-1]==nums[i]) continue;
            //可极大减少时长
            if(nums[i]>0) break;
            int l=i+1;
            int r=nums.length-1;
            int n1=nums[i];
            while(l<r){//当到了极限位置后就会退出
                if(n1+nums[l]+nums[r]==0){
                    List<Integer> temp = new ArrayList<Integer>();
                    temp.add(n1);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                    while(l>=i+1&&l<r&&nums[l+1]==nums[l]){
                        l++;
                    }
                    l++;
                    r--;
                    continue;
                }
                if(n1+nums[l]+nums[r]<0){
                    while(l>=i+1&&l<r&&nums[l+1]==nums[l]){
                        l++;
                    }
                    l++;
                    continue;
                }
                r--;
            }
        }
        return res;
    }
}



