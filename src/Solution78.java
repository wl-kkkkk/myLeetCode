import java.util.ArrayList;
import java.util.List;

public class Solution78 {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        List<Integer> temp=new ArrayList<>();

        int nlen=nums.length;
        for(int i=0;i<=nlen;i++){
            backtracking(res,temp,i,nums,nlen,0);
        }
        return res;
    }

    public void backtracking(List<List<Integer>>res,List<Integer> temp,int need,int[] nums,int nlen,int index){
        if(temp.size()==need){
            res.add(new ArrayList<>(temp));
            return;
        }

        for(int i=index;i<nlen;i++){
            temp.add(nums[i]);
            backtracking(res,temp,need,nums,nlen,i+1);
            temp.remove(temp.size()-1);
        }
    }

}
