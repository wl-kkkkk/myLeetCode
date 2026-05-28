import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class Solution3 {
    public int lengthOfLongestSubstring(String s) {
        //字符和索引
        Set<Character> set=new HashSet<>();
        int res=0;

        int slen=s.length(),l=0,r=0;
        while(r<slen){
            char c=s.charAt(r);
            if(set.contains(c)){
                char temp=s.charAt(l);
                while(temp!=c){
                    set.remove(temp);
                    l++;
                    temp=s.charAt(l);
                }
                set.remove(temp);
                l++;
            }
            set.add(c);
            r++;
            res=Math.max(res,r-l);
        }

        return res;
    }
}
