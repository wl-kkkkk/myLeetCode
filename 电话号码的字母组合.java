//回溯算法，模板如下。所有的回溯都可以抽象为一个**树形结构**。树的宽度就是处理的集合大小(for)，深度就是递归
public void backtracking(参数){//参数一开始无法确定，可以慢慢加
    if(终止条件){
        收集结果;
        return;
    }
    for(集合元素){//遍历集合的每一个元素
        处理节点;
        递归;
        回溯操作;//撤销处理节点的情况
    }
}
class Solution {
    public List<String> res=new ArrayList<String>();
    public List<String> letterCombinations(String digits) {
        if(digits.length()==0){
            return res;
        }
        //回溯算法
        int end=0;
        Map<Character,String> mp=new HashMap<>();
        mp.put('2',"abc");
        mp.put('3',"def");
        mp.put('4',"ghi");
        mp.put('5',"jkl");
        mp.put('6',"mno");
        mp.put('7',"pqrs");
        mp.put('8',"tuv");
        mp.put('9',"wxyz");
        StringBuffer temp=new StringBuffer("");
        backtracking(digits,mp,0,temp);
        return res;
    }
    public void backtracking(String digits,Map<Character,String> mp,int index,StringBuffer temp){
        if(index==digits.length()){
            res.add(temp.toString());
            return;
        }
        String letters=mp.get(digits.charAt(index));
        for(int i=0;i<letters.length();i++){
            temp.append(letters.charAt(i));
            backtracking(digits,mp,index+1,temp);
            temp.deleteCharAt(index);
        }
    }                                                        
}
