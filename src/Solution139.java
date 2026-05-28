import java.util.Arrays;
import java.util.List;

public class Solution139 {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()+1];
        Arrays.fill(dp,false);
        dp[0]=true;

        for(int i=1;i<s.length()+1;i++){
            String str=s.substring(0,i);
            for(String word:wordDict){
                if( i-word.length()>=0 && ( str.endsWith(word) && dp[i-word.length()]==true )){
                    dp[i]=true;
                    break;
                }
            }
        }

        return dp[s.length()];
    }
}
