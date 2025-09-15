//就是最基本的回溯，要注意ans中不能直接添加ins，虽然是值传递，但这里的ins指的是地址，后面ins内容改了之后原本添加到ans中的内容也会改变；另外因为每次回溯都会改变s，所以要单独拿到一个num来确定是否放到ans
class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans=new ArrayList<>();
        List<String> ins=new ArrayList<>();
        int num=s.length();
        backtracking(ans,ins,0,s,num);
        return ans;
    }
    public static void backtracking(List<List<String>> ans,List<String> ins,int len,String s,int num){
        if(len==num){
            ans.add(new ArrayList<>(ins));
            return;
        }
        for(int i=1;i<=s.length();i++){
            if(ishuiwen(s.substring(0,i))){
                ins.add(s.substring(0,i));
                len+=i;
                backtracking(ans,ins,len,s.substring(i),num);
                len-=i;
                ins.remove(ins.size()-1);
            }
        }
    }
    public static boolean ishuiwen(String s){
        if(s.length()==1) return true;
        else{
            int l=0;
            int r=s.length()-1;
            while(l<r){
                if(s.charAt(l++)!=s.charAt(r--)) return false;
            }
            return true;
        }
    }
}
