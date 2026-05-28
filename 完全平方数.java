//方法1：动态规划
class Solution {
    public int numSquares(int n) {
        int[] dp=new int[n+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=1;
        for(int i=2;i<=n;i++){
            if((int)(Math.sqrt(i))*(int)(Math.sqrt(i))==i){
                dp[i]=1;
                continue;
            }
            for(int j=i-1;j>=1;j--){
                dp[i]=Math.min(dp[i],dp[j]+dp[i-j]);
            }
        }
        return dp[n];
    }
}
//方法二
class Solution {
    public int numSquares(int n) {
        if(iss(n)) return 1;
        while(n%4==0){
            n/=4;
        }
        if(n%8==7) return 4;
        for(int i=1;i<=(int)(Math.sqrt(n));i++){
            if(iss(n-i*i)) return 2;
        }
        return 3;
    }
    public static boolean iss(int n){
        int num=(int)(Math.sqrt(n));
        if(num*num==n){
            return true;
        }
        return false;
    }
}
