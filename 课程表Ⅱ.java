class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        //初始化
        int[] inDegree=new int[numCourses];
        Adjacenc adj=new Adjacenc(numCourses);
        for(int i=0;i<prerequisites.length;i++){
            int from=prerequisites[i][1];
            int to=prerequisites[i][0];
            adj.graph[from].add(to);
            inDegree[to]++;
        }
        int[] res=new int[numCourses];
        int num=0;
        Queue<Integer> queue=new LinkedList<>();
        //开始拓扑
        for(int i=0;i<numCourses;i++){
            if(inDegree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            res[num++]=cur;
            for(Integer p:adj.graph[cur]){
                inDegree[p]--;
                if(inDegree[p]==0) queue.add(p);
            }
        }
        if(num!=numCourses) return new int[0];
        return res;
    }
}
class Adjacenc{
    List<Integer>[] graph;
    public Adjacenc(int n){
        graph=new List[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
    }
}
