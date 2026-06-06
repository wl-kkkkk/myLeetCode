import java.util.HashMap;
import java.util.Map;

class SolutionQ1 {
    public int digitFrequencyScore(int n) {
        int res=0;
        Map<Integer,Integer> map=new HashMap<>();
        while(n>0){
            int num=n%10;
            map.put(num,map.getOrDefault(num,0)+1);
            n/=10;
        }

        for(Map.Entry<Integer,Integer> entry:map.entrySet()){
            res+=entry.getKey()*entry.getValue();
        }

        System.out.println(6%3);
        return res;
    }

    public static void main(String[] args) {
        SolutionQ1 s1=new SolutionQ1();
        System.out.println(s1.digitFrequencyScore(122));
    }
}