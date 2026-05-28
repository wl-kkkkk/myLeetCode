import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Solution76 {

    Map<Character,Integer> target=new HashMap<>();
    Map<Character,Integer> cur=new HashMap<>();

    public String minWindow(String s, String t) {

        String ans="";

        //构造目标
        int tlen=t.length();
        for(int i=0;i<tlen;i++){
            char c=t.charAt(i);
            target.put(c,target.getOrDefault(c,0)+1);
        }

        //进行遍历
        int slen = s.length(),anslen=Integer.MAX_VALUE;
        int l=0,r=0;
        while(r<slen){

            char c=s.charAt(r);
            if(target.containsKey(c)){
                cur.put(c,cur.getOrDefault(c,0)+1);
            }
            r++;

            while(l<r&&check()){
                ans= (r-l) <anslen?s.substring(l,r):ans;
                anslen=ans.length();
                char ctemp=s.charAt(l);
                if(target.containsKey(ctemp)){
                    cur.put(ctemp,cur.getOrDefault(ctemp,1)-1);
                }
                l++;
            }
        }

        return ans;
    }

    public boolean check(){

        Set<Map.Entry<Character,Integer>> entrySet=target.entrySet();
        for(Map.Entry<Character,Integer> entry:entrySet){
            if(!cur.containsKey(entry.getKey())){
                return false;
            }
            if(cur.get(entry.getKey())<entry.getValue()){
                return false;
            }
        }
        return true;
    }
}
