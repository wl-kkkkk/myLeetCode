这时候就来了动态规划,核心转换方程思路是dp[i]，我与答案不同的是我将所有匹配到的同时放入了哈希表中，（前i+1个字符是否存在与字典中）=（dp[j]（前j个字符是否存在于字典中）&&wordD.contains(s.substring(j+1,i+1)（后几个字符是否存在于字典中）)
  class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp=new boolean[s.length()];
        Set<String> wordD=new HashSet<>();
        for(String word:wordDict){
            wordD.add(word);
        }
        for(int i=0;i<s.length();i++){
            if(wordD.contains(s.substring(0,i+1))){
                dp[i]=true;
                continue;
            }
            for(int j=0;j<i;j++){
                if(dp[j]&&wordD.contains(s.substring(j+1,i+1))){
                    dp[i]=true;
                    wordD.add(s.substring(0,i+1));
                    break;
                }
            }
        }
        return dp[s.length()-1];
    }
    
}
