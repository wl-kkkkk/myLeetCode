//用动态规划的思路看，就是倒着看，看最后一个格子。那哪个格子可以到最后一个格子呢，上面的和左面的，所以最后一个格子的路径就是去上面格子和去右面格子的路径和。
//需要注意的是，最上面一行的路径和最左边一列的路径都是1，因为只能从一个方向来。
class Solution {
    public int uniquePaths(int m, int n) {
        int[][] dp=new int[m][n];
        for(int i=0;i<n;i++){
            dp[0][i]=1;
        }
        for(int i=0;i<m;i++){
            dp[i][0]=1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[i][j]=dp[i][j-1]+dp[i-1][j];
            }
        }
        return dp[m-1][n-1];
    }
}
