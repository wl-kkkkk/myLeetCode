public class Solution5 {
    public String longestPalindrome(String s) {

        int slen=s.length();
        if(slen<=1) return s;

        String res=String.valueOf(s.charAt(0));
        //dp[i][j]代表s从j到i是否是回文串
        boolean[][] dp = new boolean[slen][slen];
        for(int i=0;i<slen;i++){
            dp[i][i]=true;
        }

        for(int i=0;i<slen;i++){
            for(int j=0;j<i;j++){
                if( (s.charAt(i)==s.charAt(j)) && (i-j==1 || dp[i-1][j+1]==true) ){
                    dp[i][j]=true;
                    if(i-j+1>res.length()) res=s.substring(j,i+1);
                }
            }
        }

        return res;
    }
}
