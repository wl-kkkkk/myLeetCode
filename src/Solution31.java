import java.util.*;
public class Solution31 {
    public void nextPermutation(int[] nums) {
        //单调栈，单调递增
        //首尾两种情况
        Stack<Integer> s=new Stack<>();
        int cur=-1;
        int len=nums.length;
        s.push(len-1);
        for(int i=len-2;i>=0;i--){
            while(!s.isEmpty()&&nums[i]<nums[s.peek()]) {
                cur=s.pop();
            }
            if(cur!=-1){
                nums[cur]=nums[cur]^nums[i];
                nums[i]=nums[cur]^nums[i];
                nums[cur]=nums[cur]^nums[i];
                System.out.println(nums);
                return;
            }
            s.push(i);
        }
        Arrays.sort(nums);
        System.out.println(nums);
    }
}
