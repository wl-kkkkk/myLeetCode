import java.util.*;

public class Solution128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set=new HashSet<>();
        int nlen=nums.length;
        for(int i=0;i<nlen;i++){
            set.add(nums[i]);
        }

        int ans=0;
        for(int num:set){
            if(!set.contains(num-1)){
                int cut=1;
                while(set.contains(num+1)){
                    cut++;
                    num++;
                }
                ans=Math.max(ans,cut);
            }
        }
        return ans;
    }
}

