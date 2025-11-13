class Solution {
   public int networkDelayTime(int[][] times, int n, int k) {
        int stat=0;
        //放图
        Adj adj=new Adj(n);
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int weight=times[i][2];
            adj.addDirE(u,v,weight);
        }
        //初始化
        int start=k;
        int[] visited=new int[n+1];
        int[] minDist=new int[n+1];
        Arrays.fill(minDist,Integer.MAX_VALUE);
        PriorityQueue<int[]> queue=new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[1]-o2[1];
            }
        });
        queue.add(new int[]{start,0});
        minDist[start]=0;
        while(!queue.isEmpty()){
            //找到最近点
            int cur=queue.poll()[0];
            if(visited[cur]==1) continue;
            visited[cur]=1;
            stat++;
            //更新minDist
            for(Edge edge:adj.graph[cur]){
                int to=edge.to;
                int weight=edge.weight;
                if(visited[to]==0&&minDist[cur]+weight<minDist[to]){
                    minDist[to]=weight+minDist[cur];
                    queue.add(new int[]{to,minDist[to]});
                }
            }
        }
        if(stat==n){
            Arrays.sort(minDist);
            return minDist[n-1];
        }
        return -1;
    }
}
class Edge{
    int to;
    int weight;
    public Edge(int to,int weight){
        this.to=to;
        this.weight=weight;
    }
}
class Adj{
    List<Edge>[] graph;
    public Adj(int n){
        graph=new ArrayList[n+1];
        for(int i=1;i<n+1;i++){
            graph[i]=new ArrayList<>();
        }
    }
    public void addDirE(int u,int v,int weight){
        graph[u].add(new Edge(v,weight));
    }
}
