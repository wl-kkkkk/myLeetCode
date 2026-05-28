import java.util.*;
public class Solution207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer> ans=new ArrayList<>();
        int degree[]=new int[numCourses];
        Adjacency adjg=new Adjacency(numCourses);
        for(int i=0;i< prerequisites.length;i++){
            adjg.addDirectedEdge(prerequisites[i][0],prerequisites[i][1]);
            degree[prerequisites[i][1]]++;
        }
        //开始拓扑
        Queue<Integer> queue=new LinkedList<>();
        for(int i=0;i<numCourses;i++){
            if(degree[i]==0) queue.add(i);
        }
        while(!queue.isEmpty()){
            int cur=queue.poll();
            ans.add(cur);
            for(Integer course:adjg.graph[cur]){
                degree[course]--;
                if(degree[course]==0) queue.add(course);
            }
        }
        return ans.size()==numCourses;
    }
}
class Adjacency{
    List<Integer>[] graph;
    public Adjacency(int n){
        graph=new List[n];
        for(int i=0;i<n;i++){
            graph[i]=new ArrayList<>();
        }
    }
    public void addDirectedEdge(int u,int v){
        graph[u].add(v);
    }
}
