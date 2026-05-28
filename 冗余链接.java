class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        DSU dsu=new DSU(edges.length);
        int[] ans=new int[2];
        for(int i=0;i<edges.length;i++){
            if(dsu.find(edges[i][0]-1)!=dsu.find(edges[i][1]-1)) dsu.unnion(edges[i][0]-1,edges[i][1]-1);
            else {
                ans=edges[i];
                break;
            }
        }
        return ans;
    }
}
class DSU{
    int[] parent;
    int[] rank;//树的深度
    public DSU(int n){
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        parent[x]=find(parent[x]);
        return parent[x];
    }
    public void unnion(int x,int y){
        int rootx=find(x);
        int rooty=find(y);
        if(rank[rootx]>rank[rooty]) parent[rooty]=rootx;
        else if(rank[rootx]<rank[rooty]) parent[rootx]=rooty;
        else{
            parent[rooty]=rootx;
            rank[rootx]+=1;
        }
    }
}
