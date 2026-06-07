import java.util.ArrayList;
import java.util.List;

public class Solution46 {

    List<List<Integer>> res=new ArrayList<>();
    List<Integer> temp=new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {

        List<Integer> listNums=new ArrayList<>();

        int lnum=nums.length;
        for(int i=0;i<lnum;i++){
            listNums.add(nums[i]);
        }
        int tempLen=0;
        backtracking(lnum,listNums,tempLen);
        return res;
    }

    public void backtracking(int lnum,List<Integer> listNums,int tempLen){
        if(tempLen==lnum){
            res.add(temp);
            return;
        }
        for(int i=0;i<listNums.size();i++){
            int num=listNums.get(i);
            temp.add(num);
            listNums.remove(i);
            backtracking(lnum,listNums,++tempLen);
            listNums.add(i,num);
            temp.remove(--tempLen);
        }
    }

}
