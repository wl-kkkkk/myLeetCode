
//应该是剪枝在我脑子里留下的痕迹，在回溯的过程中写个while循环跳过重复数字即可，没必要像官方答案一样
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ins=new ArrayList<>();
        backtracking(ans,ins,nums,0);
        return ans;
    }
    public static void backtracking(List<List<Integer>> ans,List<Integer> ins,int[] nums,int i){
        if(i==nums.length+1) return;
        ans.add(new ArrayList<>(ins));
        for(;i<nums.length;i++){
            ins.add(nums[i]);
            backtracking(ans,ins,nums,i+1);
            ins.remove(ins.size()-1);
            while(i+1!=nums.length&&nums[i+1]==nums[i]){
                i+=1;
            }
        }
    }
}
