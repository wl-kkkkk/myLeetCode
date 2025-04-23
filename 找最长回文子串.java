class Solution {
    public String longestPalindrome(String s) {
        //动态规划

        String res="";
        int slen=s.length();
        boolean[][] dp =new boolean[slen][slen];
        int cut=0;

        for(int r=0;r<slen;r++){
            for(int l=0;l<r;l++){
                if(s.charAt(l)==s.charAt(r)&&((r-l)<=2||dp[l+1][r-1])){
                    dp[l][r]=true;
                    if(r-l>cut){
                        cut=r-l;
                        res=s.substring(l,r+1);
                    }
                }
            }
        }
        if(s==null||s.length()<2){
            return s;
        }
        if(res==""){
            return s.substring(0,1);
        }
        return res;
    }
}
