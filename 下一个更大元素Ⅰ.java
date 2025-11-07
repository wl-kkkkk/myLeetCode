class Solution {
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans=new int[nums1.length];
        //先求出下一个最大值表
        Map<Integer,Integer> map=new HashMap<>();
        Stack<Integer> s=new Stack();
        s.push(0);
        for(int i=1;i<nums2.length;i++){
            while(!s.isEmpty()&&nums2[i]>nums2[s.peek()]) map.put(nums2[s.pop()],nums2[i]);
            s.push(i);
        }
        //开始遍历nums1
        for(int i=0;i<nums1.length;i++){
            if(map.containsKey(nums1[i])) ans[i]=map.get(nums1[i]);
            else ans[i]=-1;
        }
        return ans;
    }
}
