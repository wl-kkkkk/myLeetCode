//由暴力到简单，回溯暴力解决所有排列组合。在这个基础上回溯，将数组排列，当前面的和大于target后，直接跳出循环，到上一层回溯。这也就是剪枝
//还要解决一个问题，就是排除重复的问题，当for循环每次都从0开始时，就会出现[2,3,2]的情况(这里是题目中的例子，本来是[2,2,3])，这就要去改for循环，将i的初始值设置为for循环更新前的i即可，若是理解不了的话，我给了图，图中是到[2,3,2]的全部情况，没有省略，希望可以理解
class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ins=new ArrayList<>();
        Arrays.sort(candidates);
        backtracking(res,ins,candidates,target,0,0);
        return res;
    }
    public void backtracking(List<List<Integer>> res,List<Integer> ins,int[] candidates,int target,int sum,int start){
       if(sum>target) return;
       if(target==sum){
            res.add(new ArrayList<>(ins));
            return;
       }
       for(int i=start;i<candidates.length;i++){
            ins.add(candidates[i]);
            sum+=candidates[i];
            backtracking(res,ins,candidates,target,sum,i);
            ins.remove(ins.size()-1);
            if(sum>=target) break;
            sum-=candidates[i];
       }
    }
}
