//第一种是哈希表计数；第二种是将数组的每一个二进制位都遍历求和，如果%3！=0说明该位就是1，如果==0就不用管，因为不影响数字的大小
class Solution {
public int singleNumber(int[] nums) {
        Map<Integer,Integer> map=new HashMap<>();
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(nums[i])) map.merge(nums[i],1,(oldValue, newValue) -> oldValue + newValue);
            else map.put(nums[i],1);
        }
        Set<Map.Entry<Integer,Integer>> set=map.entrySet();
        for(Map.Entry<Integer,Integer> entry:set){
            if(entry.getValue()==1) return entry.getKey();
        }
        return 0;
    }
}

class Solution {
public int singleNumber(int[] nums){
        int ans=0;
        for(int i=0;i<32;i++){
            int temp=0;
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
