import java.util.*;
public class Solution131 {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ins=new ArrayList<>();
        int num=s.length();
        backtracking(ans,ins,0,s,num);
        return ans;
    }
    public static void backtracking(List<List<String>> ans,List<String> ins,int len,String s,int num){
        if(len==num){
            ans.add(new ArrayList<>(ins));
            return;
        }
        for(int i=1;i<=s.length();i++){
            if(ishuiwen(s.substring(0,i))){
                ins.add(s.substring(0,i));
                len+=i;
                backtracking(ans,ins,len,s.substring(i),num);
                len-=i;
                ins.remove(ins.size()-1);
            }
        }
    }
    public static boolean ishuiwen(String s){
        if(s.length()==1) return true;
        else{
            int l=0;
            int r=s.length()-1;
            while(l<r){
                if(s.charAt(l++)!=s.charAt(r--)) return false;
            }
            return true;
        }
    }

}
