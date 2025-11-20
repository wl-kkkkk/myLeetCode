public static void Astar(){
    //初始化
    Scanner sc=new Scanner(System.in);
    int x=sc.nextInt();
    int y=sc.nextInt();
    int endx=sc.nextInt();
    int endy=sc.nextInt();
    int[][] dir=new int[][]{{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1},{-2,1},{-1,2}};
    int[][] mov=new int[1000][1000];
    PriorityQueue<Knight> queue=new PriorityQueue<>(new Comparator<Knight>() {
        @Override
        public int compare(Knight o1, Knight o2) {
            return o1.F-o2.F;
        }
    });
    //开始算法
    queue.add(new Knight(x,y,0,0,0));
    while(!queue.isEmpty()){
        Knight cur=queue.poll();
        if(cur.x==endx&&cur.y==endy) break;
        for(int i=0;i<8;i++){
            int x1=cur.x+dir[i][0];
            int y1=cur.y+dir[i][1];
            if(x1>=0&&x1<1000&&y1>=0&&y1<1000&&mov[x1][y1]==0){
                mov[x1][y1]=mov[cur.x][cur.y]+1;
                int res=Ca(x1,y1,endx,endy);
                queue.add(new Knight(x1,y1,cur.G+5,res,cur.G+5+res));
            }
        }
    }
    System.out.println(mov[endx][endy]);
}
public static int Ca(int x,int y,int endx,int endy){
    return (int)Math.pow(x-endx,2)+(int)Math.pow(y-endy,2);
}

public class Knight{
    int x,y,G,H,F;
    public Knight(){}
    public Knight(int x,int y,int G,int H,int F){
        this.x=x;
        this.y=y;
        this.G=G;
        this.H=H;
        this.F=F;
    }
}
