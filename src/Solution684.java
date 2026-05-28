public class Solution684 {
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
