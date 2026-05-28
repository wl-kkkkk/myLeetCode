import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution15 {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length;i++){

            if(i>0&&nums[i-1]==nums[i]) continue;

            int l=i+1;
            int r=nums.length-1;
            int num1=nums[i];

            while(l<r){
                int ans=num1+nums[l]+nums[r];
                if(ans==0){
                    List<Integer> temp=new ArrayList<>();
                    temp.add(num1);
                    temp.add(nums[l]);
                    temp.add(nums[r]);
                    res.add(temp);
                }else if(ans>0){
                    r--;
                }else{
                    l++;
                }
            }

        }

        return res;
    }
}
