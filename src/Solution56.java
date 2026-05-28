import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class Solution56 {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0]-o2[0];
            }
        });

        List<int[]> ans=new ArrayList<>();
        int ilen = intervals.length;
        if(ilen==0) return null;
        ans.add(intervals[0]);
        for(int i=1;i<ilen;i++){
            int l=intervals[i][0],r=intervals[i][1];
            int[] curArray=ans.get(ans.size()-1);
            if(curArray[1]<l){
                ans.add(intervals[i]);
            }else{
                ans.get(ans.size()-1)[1]= (curArray[1]<r)?r:curArray[1];
            }
        }

        return  ans.toArray(new int[ans.size()][]);
    }
}
