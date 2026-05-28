class Solution {
    public int countSubstrings(String s) {
        int res=0;
        for(int i=0;i<s.length();i++){
            for(int j=i;j<s.length();j++){
                if(isH(s.substring(i,j+1))) res++;
            }
        }
        return res;
    }
    public boolean isH(String s){
        int i=0,j=s.length()-1;
        while(i<=j){
            if(i==j) return true;
            if(s.charAt(i)!=s.charAt(j)) return false;
            else{
                i++;
                j--;
            }
        }
        return true;
    }
}

class Solution {
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
        return res;
    }
}
