import java.util.HashMap;
import java.util.Map;

public class Solution560 {
    public int subarraySum(int[] nums, int k) {
        int res=0;
        int[] prefix_nums=new int[nums.length+1];
        Map<Integer,Integer> map = new HashMap<>();
        map.put(0,1);

        //计算前缀和
        //就可以计算是否以第i个位置为结尾的子串满足条件
        for(int i=0;i<nums.length;i++){
            prefix_nums[i+1]=nums[i]+prefix_nums[i];
            if(map.containsKey(prefix_nums[i+1]-k)){
                res+=map.get(prefix_nums[i+1]-k);
            }
            map.put(prefix_nums[i+1],map.getOrDefault(prefix_nums[i+1],0)+1);
        }
        return res;
    }
}
