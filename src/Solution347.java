import java.util.*;

public class Solution347 {
    //这个就不用堆排序了
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map=new HashMap<>();
        int nlen=nums.length;
        for(int i=0;i<nlen;i++){
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        //将值放入list
        List<int[]> list=new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            list.add(new int[]{entry.getKey(),entry.getValue()});
        }
        int[] ret=new int[k];
        int index=0;
        qsort(list,0,list.size()-1);
        for(int[] values:list){
            ret[index++]=values[0];
            if(index==k) break;
        }
        return ret;
    }

    public void qsort(List<int[]> list,int l,int r){
        if(l>=r) return;
        int q = partition(list,l,r);
        qsort(list,l,q-1);
        qsort(list,q+1,r);
    }

    public int partition(List<int[]> list,int l,int r){
        int i=l,target=list.get(r)[1];
        for(int j=l;j<r;j++){
            if(list.get(j)[1]>target){
                Collections.swap(list,i,j);
                i++;
            }
        }
        Collections.swap(list,i,r);
        return i;
    }
}
