import java.util.*;
public class Solution77 {
    //[1,n]中k个数的组合
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ins=new ArrayList<>();
        backtracking(ans,ins,n,k,0,1);
        return ans;
    }
    public static void backtracking(List<List<Integer>> ans,List<Integer> ins,int n,int k,int num,int i){
        if(num==k){
            ans.add(new ArrayList<>(ins));
            return;
        }
        for(;i<=n;i++){
            ins.add(i);
            backtracking(ans,ins,n,k,num+1,i+1);
            ins.remove(ins.size()-1);
        }
    }
}
