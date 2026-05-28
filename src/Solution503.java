import java.util.*;
public class Solution503 {
    public int[] nextGreaterElements(int[] nums) {
        Stack<Integer> s=new Stack<>();
        s.push(0);
        int[] ans=new int[nums.length];
        //第一个循环处理第一遍循环能找到比它大的
        for(int i=1;i<nums.length;i++){
            while(!s.isEmpty()&&nums[s.peek()]<nums[i]) ans[s.pop()]=nums[i];
            s.push(i);
        }
        //第二次遍历将找到前面的数字比后面大的
        for(int i=0;i<nums.length;i++){
            while(!s.isEmpty()&&nums[s.peek()]<nums[i]) ans[s.pop()]=nums[i];
            if(s.isEmpty()) break;
        }
        //这个时候应该是只剩下最大值了
        for(Integer num:s){
            ans[num]=-1;
        }
        return ans;
    }
}
