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
