class Solution {
        public int[] findRedundantDirectedConnection(int[][] edges) {
        //初始化
        DSU graph=new DSU(edges.length);
        int[] inDegree = new int[edges.length+1];
        int[] ans=new int[2];
        int s1=-1,s2=-1,wei=0;
        //遍历
        for(int i=0;i<edges.length;i++){
            int to=edges[i][1];
            inDegree[to]++;
            if(inDegree[to]==2) wei=to;
        }
        //找入度为2的点
        for(int i=0;i<edges.length;i++){
            if(edges[i][1]==wei&&s1!=-1) s2=i;
            if(edges[i][1]==wei&&s1==-1) s1=i;
        }
        //两种情况有没有入度为2的点
        if(s1==-1){
            //如果无，就找环
            for(int i=0;i<edges.length;i++){
                int u=edges[i][0];
                int v=edges[i][1];
                if(graph.find(u)!=graph.find(v)) graph.unnion(u,v);
                else{
                    ans[0]=u;
                    ans[1]=v;
                    break;
                }
            }
        }else{
            //有边就是看形成环不
            for(int i=0;i<edges.length;i++){
                if(i==s1||i==s2) continue;
                int u=edges[i][0];
                int v=edges[i][1];
                graph.unnion(u,v);
            }
            int u1=edges[s1][0];
            int v1=edges[s1][1];
            if(graph.find(u1)==graph.find(v1)){
                ans[0]=u1;
                ans[1]=v1;
            }else{
                System.out.println(1);
                ans[0]=edges[s2][0];
                ans[1]=edges[s2][1];
            }
        }
        return ans;
    }
}
class DSU{
    int[] father;
    int[] rank;
    public DSU(int n){
        father=new int[n+1];
        rank=new int[n+1];
        for(int i=1;i<n+1;i++){
            father[i]=i;
            rank[i]++;
        }
    }
    public int find(int i){
        if(father[i]!=i) father[i]=find(father[i]);
        return father[i];
    }
    public void unnion(int u,int v){
        int rootu=find(u);
        father[v]=rootu;
    }
}
