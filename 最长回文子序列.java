class Solution {
int[][] cache;
    public int longestPalindromeSubseq(String s) {
        cache=new int[s.length()][s.length()];
        return dfs(s,0,s.length()-1,cache);
    }
    public int dfs(String s,int l,int r,int[][] cache){
        if(l==r) return 1;
        if(l>r) return 0;
        if(cache[l][r]!=0) return cache[l][r];
        int res;
        if(s.charAt(l)==s.charAt(r)) res=dfs(s,l+1,r-1,cache)+2;
        else res=Math.max(dfs(s,l+1,r,cache),dfs(s,l,r-1,cache));
        cache[l][r]=res;
        return res;
    }
}
