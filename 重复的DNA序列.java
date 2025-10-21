class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> ans=new ArrayList<>();
        Map<String,Integer> hm=new HashMap<>();
        for(int i=0;i<=s.length()-10;i++){
            String substr=s.substring(i,i+10);
            if(!hm.containsKey(substr)){
                hm.put(s.substring(i,i+10),1);
            }else{
                hm.merge(substr, 1, new BiFunction<Integer, Integer, Integer>() {
                    @Override
                    public Integer apply(Integer i1, Integer i2) {
                        return i1+i2;
                    }
                });
            }
            if(hm.get(substr)==2) ans.add(substr);
        }
        return ans;
    }
}
