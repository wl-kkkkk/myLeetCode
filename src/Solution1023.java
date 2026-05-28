import java.util.*;
import java.lang.*;
public class Solution1023 {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        List<Boolean> ans= new ArrayList<>();
        for(String str:queries){
            if(kmp(str,pattern)) ans.add(true);
            else ans.add(false);
        }
        return ans;
    }
    public boolean kmp(String S,String T){
        int j=0,i=0;
        while(i<S.length()&&j<T.length()){
            //让T串始终在大写且符合规则的情况下
            int stat=0;
            if(T.charAt(j)>='a'&&T.charAt(j)<='z'){
                while(i<S.length()){
                    if(i==S.length()) return false;
                    if(T.charAt(j)==S.charAt(i)) break;
                    else if(S.charAt(i)>='a'&&S.charAt(i)<='z') i++;
                    else return false;
                }
                i++;
                j++;
                stat=1;
            }
            if(stat==1) continue;
            //
            if(S.charAt(i)>='A'&&S.charAt(i)<='Z'){
                if(T.charAt(j++)!=S.charAt(i)) return false;
            }
            i++;
        }
        //
        if(j!=T.length()) return false;
        //
        for(int m=i;m<S.length();m++){
            if(S.charAt(m)>='A'&&S.charAt(m)<='Z') return false;
        }
        return true;
    }
}
