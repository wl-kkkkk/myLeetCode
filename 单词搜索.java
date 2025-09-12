//核心就是深度优先遍历，但难点在用到回溯去防止污染visited。题目中表明，是不能让同一个结点出现两次，所以当你的循环退出的时候就是你回溯的时候，因为循环没退出意味着你找到了下一个结点，这样我们就回溯了sb和visited
                                                                                                                                                                                                                                               刚开始写可以只写dfs的关键步骤，就是上下左右扩展，然后就是怎样进入下一层循环以及如何退出循环。
//写完上面的这些自己之后怎么写思路就有喽
public class Solution {
    public boolean a=false;
    //79.单词搜索
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        int[][] visited=new int[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dfs(new StringBuffer(""),board,word,i,j,0,visited);
            }

        }
        return a;
    }
    public void dfs(StringBuffer sb,char[][] board,String word,int m,int n,int index,int[][] visited){
        if(a==true) return;
        if((index+1)>word.length()) return;
        if((m<0)||(m>board.length-1)||(n<0)||(n>board[0].length-1)||visited[m][n]==1) return;
        if(board[m][n]==word.charAt(index)){
            visited[m][n] = 1;
            sb.append(board[m][n]);
            if(sb.toString().equals(word)){
                da();
                return;
            }
        }else{
            return;
        }
        index++;
        dfs(sb,board,word,m-1,n,index,visited);//左
        dfs(sb,board,word,m+1,n,index,visited);//右
        dfs(sb,board,word,m,n-1,index,visited);//上
        dfs(sb,board,word,m,n+1,index,visited);//下
        sb.deleteCharAt(sb.length()-1);
        visited[m][n]=0;
    }
    public boolean da(){
        a=true;
        return a;
    }
}
