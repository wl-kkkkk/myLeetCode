//将对应的数字放到map中去，中间比较的时候两个字符一起去比较，如果小于后者则先做减法，否则直接做加法
//切记要用String.valueOf(s.charAt()),因为在我的方法中get方法只接收字符串，而（）.toString（）不能用于基本数据类型
class Solution {
    public int romanToInt(String s) {
        int res=0;
        Map<String,Integer> rnton=new HashMap();
        rnton.put("I",1);
        rnton.put("V",5);
        rnton.put("X",10);
        rnton.put("L",50);
        rnton.put("C",100);
        rnton.put("D",500);
        rnton.put("M",1000);
        if(s.length()==1){
            return rnton.get(s);
        }
        int[] snum=new int[s.length()];
        for(int i=0;i<s.length();i++){
            snum[i]=rnton.get(String.valueOf(s.charAt(i)));
        }
        for(int i=0;i<s.length()-1;i++){
            if(snum[i]<snum[i+1]){
                res+=(snum[i+1]-snum[i]);
                i++;
            }else{
                res+=snum[i];
            }
        }
        if(snum[s.length()-2]>=snum[s.length()-1]){
            res+=snum[s.length()-1];
        }
        return res;
    }
}
