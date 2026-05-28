import java.util.*;

public class Solution187 {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans =new ArrayList<>();
        Set<String> set=new HashSet<>();
        for(int i=0;i<s.length();i++){
            if(KMP(s,s.substring(i,i+10))){
                ans.add(s.substring(i,i+10));
                set.add(s.substring(i,i+10));
            }
        }
        return ans;
    }
    public boolean KMP(String S,String T){
        return true;
    }
}
