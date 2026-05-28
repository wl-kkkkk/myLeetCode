import java.util.*;

public class Solution49 {
    public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> map=new HashMap<>();
        for(String str:strs){
            char[] arrays=str.toCharArray();
            Arrays.sort(arrays);
            String key=new String(arrays);
            List<String> list = map.getOrDefault(key,new ArrayList<>());
            list.add(str);
            map.put(key,list);
        }

        return new ArrayList<>(map.values());
    }
}
