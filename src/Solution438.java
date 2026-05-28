import java.util.*;

public class Solution438 {

    HashMap<Character,Integer> target=new HashMap<>();
    HashMap<Character,Integer> current=new HashMap<>();

    public List<Integer> findAnagrams(String s, String p) {

        List<Integer> ans=new ArrayList<>();

        //构造target
        int plen=p.length();
        for(int i=0;i<plen;i++){
            char c=p.charAt(i);
            target.put(c,target.getOrDefault(c,0)+1);
        }

        //开始遍历
        int slen=s.length(),l=0,r=0;
        while(r<slen){

            //保证窗口的都是该有的
            char c=s.charAt(r);
            if(!target.containsKey(c)){
                current.clear();
                r++;
                l=r;
                continue;
            }
            current.put(c,current.getOrDefault(c,0)+1);
            r++;

            if( r-l==plen ){
                if(check()) ans.add(l);
                char temp=s.charAt(l);
                current.put(temp,current.getOrDefault(temp,1)-1);
                l++;
            }
        }

        return ans;
    }

    public boolean check(){
        Set<Map.Entry<Character,Integer>> set=target.entrySet();
        for(Map.Entry<Character,Integer> entry:set){
            if(!entry.getValue().equals(current.getOrDefault(entry.getKey(),0))){
                return false;
            }
        }
        return true;
    }
}
