import java.util.*;
public class temp {
    public List<List<Integer>> combinationSum3(int k, int n) {
        //k个数，和为n
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ins = new ArrayList<>();
        backtracking(ans, ins, n, k, 0, 1);
        return ans;
    }

    public static void backtracking(List<List<Integer>> ans, List<Integer> ins, int n, int k, int sum, int start) {
        if (sum == n) {
            ans.add(new ArrayList<>(ins));
            return;
        }
        for (int i = start; i <= 9; i++) {
            ins.add(i);
            sum += i;
            if (ins.size() == k + 1){
                ins.remove(ins.size()-1);
                return;
            }
            System.out.println(sum);
            backtracking(ans, ins, n, k, sum, i+1);
            System.out.println(i);
            sum -= i;
            ins.remove(ins.size() - 1);
            if (sum + i == n) return;//剪枝
        }
    }
}
