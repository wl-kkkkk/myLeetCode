题目要求用最少数量的硬币换出值为amount的价值，已经给出了硬币的面值，并且数量不限。
一般求最优解都是用动态规划，那我们就要用动态规划的思路去做，由底层往上走。注意：这里我们理解的时候要自顶向下，而程序运行要自下而上。
我们要换出amount的面值，自上也就是看最后一步，换某个面值的硬币，我们用for循环一个一个试，通过Math.min求出最小的。转换方程也就出来了，dp[i]=Math.min(1+dp[i-coin],dp[i]);用递归的思想我们就一定会知道，他会遍历所有的情况，并且dp[1-coin]是一定已知的
除此之外，因为amount一定要大于硬币之和，所以我将硬币排序，用剪枝去减少时间
class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount==0) return 0;
        Arrays.sort(coins);
        int[] dp=new int[amount+1];
        Arrays.fill(dp,amount+1);
        dp[0]=0;
        for(int i=1;i<=amount;i++){
            for(Integer coin:coins){
                if((i-coin)<0) break;
                dp[i]=Math.min(1+dp[i-coin],dp[i]);
            }
        }
        return dp[amount]==amount+1?-1:dp[amount];
    }
}
