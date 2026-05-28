class Solution {
    List<String>res=new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtracking(n,new StringBuffer(""),0,0);
        return res;
    }
    public void backtracking(int n,StringBuffer temp,int open,int close){
        if(temp.length()==n*2){
            res.add(temp.toString());
            return;
        }
        if(open<n){
            temp.append("(");
            backtracking(n,temp,open+1,close);
            temp.deleteCharAt(temp.length()-1);
        }
        if(close<open){
            temp.append(")");
            backtracking(n,temp,open,close+1);
            temp.deleteCharAt(temp.length()-1);
        }
    }
}
