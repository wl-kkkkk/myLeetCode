import java.util.*;
import java.util.function.BiFunction;

public class Solution508 {
    int cnt=0;
    public int[] findFrequentTreeSum(TreeNode root) {
        Map<Integer,Integer> couter=new HashMap<>();
        postorder(couter, root);
        List<Integer> ans=new ArrayList<>();
        for(Integer key: couter.keySet()){
            if(couter.get(key)==cnt) ans.add(key);
        }
        int[] res=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            res[i]=ans.get(i);
        }
        return res;
    }
    public int postorder(Map<Integer,Integer> couter,TreeNode root){
        if(root==null) return 0;
        int left=postorder(couter,root.left);
        int right=postorder(couter,root.right);
        int sum=left+right+root.val;
        couter.merge(sum, 1, new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer o1, Integer o2) {
                return o1+o2;
            }
        });
        cnt=Math.max(cnt,couter.get(sum));
        return sum;
    }
}
