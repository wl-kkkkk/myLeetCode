import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution216 {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //k个数，和为n
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ins=new ArrayList<>();
        backtracking(ans,ins,n,k,0,1);
        return ans;
    }
    public static void backtracking(List<List<Integer>> ans,List<Integer> ins,int n, int k,int sum,int start){
        if(ins.size()==k+1||sum>n) return;
        if(sum==n&&ins.size()==k){
            ans.add(new ArrayList<>(ins));
            return;
        }
        for(int i=start;i<=9;i++){
            ins.add(i);
            sum+=i;
            backtracking(ans,ins,n,k,sum,i+1);
            sum-=i;
            ins.remove(ins.size()-1);
        }
    }
}
