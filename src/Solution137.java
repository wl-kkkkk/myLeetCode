import java.util.*;
public class Solution137 {
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
