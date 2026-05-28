//这类回溯问题都是从暴力开始，经过剪枝，去重然后变得轻巧
//首先暴力弄出所有情况，剪枝是在排序后如果sum已经大于target，就跳过后边的所有遍历，回到上一层
//去重则是在不影响一颗树的前提下，如果第二棵树的根与第一棵树相同，就跳过所以理所应当的放在了回溯后的步骤。要学会回溯，必须要将问题看成树。
class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ins = new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res,candidates,target,ins,0,0);
        return res;
    }
    public void backtracking(List<List<Integer>> res,int[] candidates,int target,List<Integer> ins,int start,int sum){
        if(sum>target) return;
        if(sum==target){
            res.add(new ArrayList<>(ins));
            return;
        }
        for(int i=start;i<candidates.length;i++){
            ins.add(candidates[i]);
            sum+=candidates[i];
            backtracking(res,candidates,target,ins,i+1,sum);
            ins.remove(ins.size()-1);
            if(sum>target) return;//剪枝
            sum-=candidates[i];
            while(i!=candidates.length-1&&candidates[i+1]==candidates[i]){
                i=i+1;
            } 
        }
    }
}
