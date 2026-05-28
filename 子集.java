//这里先说明，递归中的for循环与普通的for循环是不同的，递归的for循环中，第一层的每个数都是一个根
//这道题首先可以确定用回溯，之后我的思路是找每一个长度的子集。在递归的for循环中，要用start去排除重复的数字，首先start不会影响本层循环，其次在每次递归时，可以起到一个遍历的作用，最后start比i大可以保证不重复
class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> lnums=new ArrayList<>();
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> ins = new ArrayList<>();
        for(int j=0;j<nums.length;j++){
            lnums.add(nums[j]);
        }
        for(int i=0;i<=nums.length;i++){
            backtracking(0,res,ins,lnums,i);
        }

        return res;
    }
    public void backtracking(int start,List<List<Integer>> res,List<Integer> ins,List<Integer> nums,int need){
        if(ins.size()==need){
            res.add(new ArrayList<>(ins));
            return;
        }
        for(int i=start;i<nums.size();i++){
            int num=nums.get(i);
            ins.add(num);
            backtracking(i+1,res,ins,nums,need);
            ins.remove(ins.size()-1);
        }
    }
}
