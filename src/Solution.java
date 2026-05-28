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
