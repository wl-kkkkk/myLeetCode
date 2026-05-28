import java.util.*;
public class Solution42 {
    public int trap(int[] height) {
        int ans=0;
        Stack<Integer> stack=new Stack<>();
        stack.push(0);
        for(int i=1;i<height.length;i++){
            while(!stack.isEmpty()&&height[i]>height[stack.peek()]){
                int mid=stack.pop();
                if(stack.isEmpty()) break;;
                int left = i;
                int right= stack.peek();
                ans += (Math.min(height[left],height[right])-height[mid]) * (left-right-1);
            }
            stack.push(i);
        }
        return ans;
    }
}
