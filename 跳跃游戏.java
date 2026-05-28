//首先是非常明显的动态规划题目，求最短路径。找到思路即可，就是看能不能从前面一步到最后。
//举例子：就2，3，1，1，4来看，倒着才是正确的想法，从倒数第二个开始找那个可以到最后一个，这样子递归着想我们就知道应该先求从第一个位置到前面每一个位置的最短路径，也就完成了思路的闭合
class Solution {
    public int jump(int[] nums) {
        //dp[i]表示从前面跳过来需要几步    dp[0]=0; dp[1]=1 dp[2]=dp[i],dp[i-j]
        if(nums.length==1) return 0;
        int[] dp=new int[nums.length];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0]=0;
        dp[1]=1;
        for(int i=2;i<nums.length;i++){
            for(int j=0;j<i;j++){
                if(i<=j+nums[j]){
                    dp[i]=Math.min(dp[i],dp[j]+1);
                }
            }
        }
        return dp[nums.length-1];
    }
}
