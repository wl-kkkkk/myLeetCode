public class Solution647 {
    public int countSubstrings(String s) {
        int res=0;
        int dp[][]=new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            dp[i][i]=1;
            res++;
        }
        for(int i=s.length()-1;i>=0;i--){
            for(int j=i+1;j<s.length();j++){
                if(s.charAt(i)==s.charAt(j)){
                    if(j-i==1||dp[i+1][j-1]==1){
                        res++;
                        dp[i][j]=1;
                    }
                }
            }
        }
        for(int i=0;i<s.length();i++){
            for(int j=0;j<s.length();j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return res;
    }
}
