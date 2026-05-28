public class Solution718 {
    public int findLength(int[] nums1, int[] nums2) {
        int max=0;
        int l1=nums1.length,l2=nums2.length;
        int[][] dp=new int[l1][l2];
        for(int j=0;j<l2;j++){
            if(nums1[l1-1]==nums2[j]) dp[l1-1][j]=1;
            if(max<dp[l1-1][j]) max=dp[l1-1][j];
        }
        for(int i=0;i<l1;i++){
            if(nums2[l2-1]==nums1[i]) dp[i][l2-1]=1;
            if(max<dp[i][l2-1]) max=dp[i][l2-1];
        }
        //i,j代表的是以他俩为开头的后序最长相等长度
        for(int i=nums1.length-2;i>=0;i--){
            for(int j=nums2.length-2;j>=0;j--){
                if(nums1[i]==nums2[j]) {
                    dp[i][j]=dp[i+1][j+1]+1;
                    if(max<dp[i][j]) max=dp[i][j];
                }
            }
        }
        return max;
    }
}
