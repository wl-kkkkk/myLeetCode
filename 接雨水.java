class Solution {
    public int trap(int[] height) {
        int ans=0;
        Stack<Integer> s=new Stack<>();
        for(int i=0;i<height.length;i++){
            if(!s.isEmpty()&&height[i]==height[s.peek()]) s.pop();
            while(!s.isEmpty()&&height[i]>height[s.peek()]){
                int mid=s.pop();
                if(s.isEmpty()) break;
                int left=s.peek();
                int h=Math.min(height[left],height[i])-height[mid];
                int w=i-left-1;
                ans+=w*h;
            }
            s.push(i);
        }
        return ans;
    }
}
