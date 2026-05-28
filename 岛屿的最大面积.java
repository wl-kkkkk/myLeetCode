
class Solution {
    int[][] visited=new int[50][50];
    public int maxAreaOfIsland(int[][] grid) {
        int[][] dirs=new int[][]{{-1,0},{0,1},{1,0},{0,-1}};
        int ans=0;

        int borderx=grid.length,bordery=grid[0].length;
        for(int i=0;i<borderx;i++){
            for(int j=0;j<bordery;j++){
                if(visited[i][j]==0&&grid[i][j]==1){
                    ans=Math.max(bfs(grid,dirs,i,j,borderx,bordery),ans);
                }
            }
        }
        return ans;
    }
    public int bfs(int[][] grid,int dirs[][],int i,int j,int bx,int by){
        int ans=1;
        Queue<Point> q=new LinkedList<>();
        visited[i][j]=1;
        q.add(new Point(i,j));
        while(!q.isEmpty()){
            Point temp=q.poll();
            i=temp.x;
            j=temp.y;
            for(int n=0;n<4;n++){
                int nextx=i+dirs[n][0];
                int nexty=j+dirs[n][1];
                if(nextx>=0&&nextx<bx && nexty>=0&&nexty<by &&visited[nextx][nexty]==0&&grid[nextx][nexty]==1){
                    ans++;
                    q.add(new Point(nextx,nexty));
                    visited[nextx][nexty]=1;
                }
            }
        }
        return ans;
    }
}
class Point{
    int x;
    int y;
    public Point(){}
    public Point(int x,int y){
        this.x=x;
        this.y=y;
    }
}
