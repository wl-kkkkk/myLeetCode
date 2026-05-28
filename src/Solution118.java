import java.util.ArrayList;
import java.util.List;

public class Solution118 {
    public List<List<Integer>> generate(int numRows) {

        List<List<Integer>> ans=new ArrayList<>();

        for(int i=0;i<numRows;i++){
            List<Integer> temp=new ArrayList<>();
            temp.add(1);
            System.out.println(i);
            for(int j=1;j<i;j++){
                int res=ans.get(i-1).get(j)+ans.get(i-1).get(j-1);
                temp.add(res);
            }
            if(i>0) temp.add(1);
            ans.add(temp);
        }

        return ans;
    }
}
