//Problem: 70. 爬楼梯
//思路：和斐波那契数一样，从第三个阶梯开始，其实就是上一个阶梯走一步或者上上个阶梯走两步两种，只要将这两种的方法和加起来即可。从底层开始往上走，每一层需要用到上一层，也就是动态规划

class Solution {
    public int climbStairs(int n) {
        int[] fib=new int[n+1];
        fib[1]=1;
        if(n==1) return fib[1];
        fib[2]=2;
        if(n==2) return fib[2];
        for(int i=3;i<=n;i++){
            fib[i]=fib[i-1]+fib[i-2];
        }
        return fib[n];

    }
}
