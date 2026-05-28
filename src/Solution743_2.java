import java.util.*;

public class Solution743_2 {
    public int networkDelayTime(int[][] times, int n, int k){
        //存储图
        Adj adj1=new Adj(n);
        for(int i=0;i<times.length;i++){
            int u=times[i][0];
            int v=times[i][1];
            int weight=times[i][2];
            adj1.addDirE(u,v,weight);
        }
        //初始化
        int[] closeEdge=new int[n+1];
        int[] isInTree=new int[n+1];
        Arrays.fill(closeEdge,0);
        Arrays.fill(closeEdge,Integer.MAX_VALUE);
        isInTree[0]=1;
        isInTree[k]=1;
        closeEdge[k]=0;
        int ans=0;
        //进入循环
        int cur=k;
        for(int i=0;i<n-1;i++){
            //更新距离最小生成树的长度
            for(Edge edge:adj1.graph[cur]){
                int to=edge.to;
                int weight=edge.weight;
                if(isInTree[to]==0&&closeEdge[to]>weight) {
                    closeEdge[to]=weight;
                }
            }
            //选取距离最小的点
            int min=Integer.MAX_VALUE;
            for(int j=1;j<closeEdge.length;j++){
                if(isInTree[j]==0&&closeEdge[j]<min) {
                    cur=j;
                    min=closeEdge[cur];
                }
            }
            ans+=closeEdge[cur];
            isInTree[cur]=1;
        }
        for(int i=1;i<closeEdge.length;i++){
            if(closeEdge[i]==Integer.MAX_VALUE) return -1;
        }
        return ans;
    }
}


