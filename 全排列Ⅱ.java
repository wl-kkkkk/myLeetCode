//方法一：相比于全排列1来说，最简单的思路就是在if条件处加上一个哈希表判断是否重复，代码如下
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Set<List<Integer>> tres=new HashSet<>();
        List<Integer> ins=new ArrayList<>();
        List<Integer> lnums=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            lnums.add(nums[i]);
        }
        backtracking(res,tres,ins,lnums,nums.length);
        return res;
    }
    public void backtracking(List<List<Integer>> res,Set<List<Integer>> tres,List<Integer> ins,List<Integer> nums,int l){
        if(ins.size()==l){
            if(!tres.contains(ins)){
                tres.add(new ArrayList<>(ins));
                res.add(new ArrayList<>(ins));
            }
            return;
        }
        for(int i=0;i<nums.size();i++){
            int num=nums.get(i);
            ins.add(num);
            nums.remove(i);
            backtracking(res,tres,ins,nums,l);
            nums.add(i,num);
            ins.remove(ins.size()-1);
        }
    }
}
//方法二：这个题可以类比到三数之和中间的思路，就是当你发现你的数字在前面被用过时，可以直接跳过，为方便看是否相同，排序即可。
//详细理解：当循环完成一次时，也就是第一个根节点全部遍历完了到第二个根结点时，如果与第一个根结点相同，那么他们最后的子结点一定也是相同的
//代码如下
class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ins=new ArrayList<>();
        List<Integer> lnums=new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++){
            lnums.add(nums[i]);
        }
        backtracking(res,ins,lnums,nums.length);
        return res;
    }
    public void backtracking(List<List<Integer>> res,List<Integer> ins,List<Integer> nums,int l){
        if(ins.size()==l){
            res.add(new ArrayList<>(ins));
            return;
        }
        for(int i=0;i<nums.size();i++){
            if(i!=0&&nums.get(i)==nums.get(i-1)) continue;
            int num=nums.get(i);
            ins.add(num);
            nums.remove(i);
            backtracking(res,ins,nums,l);
            nums.add(i,num);
            ins.remove(ins.size()-1);
        }
    }
}
