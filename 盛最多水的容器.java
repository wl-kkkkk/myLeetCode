//看到有人说简化了二层for循环，我认为很对，但这并不是核心，我认为核心是这个双指针一定会遍历最长的两条边，而不会跳过，这才是核心。简化只能说是结果之一。
class Solution {
    public int maxArea(int[] height) {
        /*暴力
        int max=0;
        int temp=0;
        for(int i=0;i<height.length;i++){
            for(int j=i;j<height.length;j++){
                if(height[j]>height[i]){
                    temp=height[i]*(j-i);
                }else{
                    temp=height[j]*(j-i);
                }
                if(max<temp){
                    max=temp;
                }
            }
        }
        return max;
        */
        int ret=0,temp=0;
        int i=0,j=height.length-1;
        while(i<j){
            temp=Math.min(height[i],height[j])*(j-i);
            if(ret<temp) ret=temp;
            if(height[i]<height[j]) i++;
            else j--;
        }
        return ret;
    }
}
