class Solution {
    public int repeatedStringMatch(String a, String b) {
        int ans;
        if(b.equals("")) return 0;
        int numa=a.length();
        int numb=b.length();
        //处理a的初始长度比b大的情况
        if(numa>numb){
            if(kmp(a,b)) return 1;
            else if(kmp(String.join("",a,a),b)) return 2;
            else return -1;
        }
        //处理a的长度比b小的情况
        int deadline=(numb-2)/numa+2;
        int len=numb/numa;
        String str=a;
        for(int i=1;i<len;i++){
            a=String.join("",a,str);
        }
        for(int i=len;i<=deadline;i++){
            if(kmp(a,b)) return i;
            a=String.join("",a,str);
        }
        return -1;
    }
    public boolean kmp(String a,String b){
        int i=0;int j=0;
        int[] next=getNext(b);
        while(i<a.length()&&j<b.length()){
            while(j>0&&a.charAt(i)!=b.charAt(j)) j=next[j-1];
            if(a.charAt(i)==b.charAt(j)) j++;
            i++;
        }
        if(j==b.length()) return true;
        else return false;
    }
    public int[] getNext(String b){
        int[] next=new int[b.length()];
        int i=1,j=0;
        next[0]=0;
        for(;i<b.length();i++){
            while(j>0&&b.charAt(i)!=b.charAt(j)) j=next[j-1];
            if(b.charAt(i)==b.charAt(j)) j++;
            next[i]=j;
        }
        return next;
    }
}
