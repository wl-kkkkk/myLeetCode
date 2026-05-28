import java.util.ArrayDeque;
import java.util.Deque;

public class Solution84 {
    public int largestRectangleArea(int[] heights) {
        int ans=0;
        Deque<Integer> stack = new ArrayDeque<>();
        int[] newheights=new int[heights.length+2];
        newheights[0]=0;
        for(int i=1;i<=heights.length;i++){
            newheights[i]=heights[i-1];
        }
        newheights[heights.length+1]=0;

        for(int i=0;i<newheights.length;i++){
            while( !stack.isEmpty() && newheights[i]<newheights[stack.peek()]){
                int mid=stack.pop();
                int right=i;
                int left=stack.peek();
                ans=Math.max(ans,newheights[mid]*(right-left-1));
            }
            stack.push(i);
        }

        return ans;
    }
}
