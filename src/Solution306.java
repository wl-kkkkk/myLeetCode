import java.util.ArrayList;
import java.util.List;

public class Solution306 {
    public boolean isAdditiveNumber(String num) {
        List<Boolean> ans = new ArrayList<>();
        ans.add(false);
        List<Integer> ins = new ArrayList<>();
        backtracking(ans,ins,num);
        return ans.getLast();
    }
    public static void backtracking(List<Boolean> ans,List<Integer> ins,String num){
        if(isAdd(ins)){
            ans.add(true);
            return;
        }
        for(int i=1;i<=num.length();i++){
            if(ans.getLast()==true) return;
            ins.add(Integer.parseInt(num.substring(0,i)));
            backtracking(ans,ins,num.substring(i));
            ins.removeLast();
        }
    }
    public static boolean isAdd(List<Integer> ins){
        if(ins.size()<3) return false;
        else{
            int n1=ins.get(0);
            int n2=ins.get(1);
            int n3;
            for(int i=2;i<ins.size();i++){
                n3=ins.get(i);
                if(n1+n2!=n3) return false;
                n1=n2;
                n2=n3;
            }
            return true;
        }
    }
}
