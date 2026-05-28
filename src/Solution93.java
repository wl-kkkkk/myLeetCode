import java.util.*;
public class Solution93 {
    public List<String> restoreIpAddresses(String s) {
        List<String> ans=new ArrayList<>();
        List<Integer> ins=new ArrayList<>();
        backtracking(s,ans,ins,1);
        return ans;
    }
    public static void backtracking(String s,List<String> ans,List<Integer> ins,int i){
        if(ins.size()>3) return;
        if(ins.size()==3&&check(s,ins)){
            addAns(ans,ins,s);
        }
        for(;i<s.length();i++){
            ins.add(i);
            backtracking(s,ans,ins,i+1);
            ins.remove(ins.size()-1);
        }
    }
    public static boolean check(String s,List<Integer> ins){
        String[] sub=new String[4];
        sub[0]=s.substring(0,ins.get(0));
        sub[1]=s.substring(ins.get(0),ins.get(1));
        sub[2]=s.substring(ins.get(1),ins.get(2));
        sub[3]=s.substring(ins.get(2));
        for(String su:sub){
            if(Integer.parseInt(su)-255>0) return false;
            if(su.length()>1&&su.charAt(0)=='0') return false;
        }
        return true;
    }
    public static void addAns(List<String> ans,List<Integer> ins,String s){
        String[] sub=new String[4];
        sub[0]=s.substring(0,ins.get(0));
        sub[1]=s.substring(ins.get(0),ins.get(1));
        sub[2]=s.substring(ins.get(1),ins.get(2));
        sub[3]=s.substring(ins.get(2));
        sub[0]=sub[0].concat(".").concat(sub[1]).concat(".").concat(sub[2]).concat(".").concat(sub[3]);
        ans.add(sub[0]);
    }
}
