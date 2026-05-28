import java.util.*;
public class Solution739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] ans=new int[temperatures.length];
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<temperatures.length;i++){
            if(s.isEmpty()||temperatures[s.peek()]>=temperatures[i]) s.push(i);
            else{
                while(!s.isEmpty()&&temperatures[s.peek()]<temperatures[i]){
                    ans[s.peek()]=i-s.peek();
                    s.pop();
                }
                s.push(i);
            }
        }
        return ans;
    }
}
