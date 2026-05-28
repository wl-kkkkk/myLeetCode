单调栈是一种利用栈结构来保持元素的单调性，从而解决一些与“单调”相关的问题。通常，单调栈有两种类型：单调递增栈和单调递减栈。它们主要用于解决一些优化问题，如查找数组中某个元素的“下一个更大元素”或“下一个更小元素”等。

保证栈里面的元素递增或者递减（指的是从栈底到栈顶的顺序）

[739. 每日温度 - 力扣（LeetCode）](https://leetcode.cn/problems/daily-temperatures/description/?envType=problem-list-v2&envId=NSx4vbVr)这个题目要单调递减，代码看一遍就会了
class Solution {
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
