//从题目看，求所有可能的全排列，已经是摆明了告知是回溯法，套用模板即可。
//将其看成一个数结构，深度就是数组的长度，宽度就是每一层数组的长度(是每层往下减一的)
class Solution {
    public List<List<Integer>> res=new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> ins=new ArrayList<>();
        ArrayList<Integer> lnums=new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            lnums.add(nums[i]);
        }
        backtracing(lnums,ins,nums.length);
        return res;
    }
    public void backtracing(ArrayList<Integer> nums,List<Integer> ins,int l){
        if(ins.size()==l){
            res.add(new ArrayList<>(ins));
            return;
        }
        for(int j=0;j<nums.size();j++){
            int num=nums.get(j);
            ins.add(num);
            nums.remove(j);
            backtracing(nums,ins,l);
            nums.add(j,num);
            ins.remove(ins.size()-1);
        }
    }
}
