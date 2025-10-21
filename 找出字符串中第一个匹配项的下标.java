class Solution {
    public int strStr(String haystack, String needle) {
        int[] next=getNext(needle);
        int i=0,j=0;
        while(i<haystack.length()&&j<needle.length()){
            while(j>0&&haystack.charAt(i)!=needle.charAt(j)){
                j=next[j-1];
            }
            if(haystack.charAt(i)==needle.charAt(j)) j++;
            i++;
        }
        if(j==needle.length()) return i-needle.length();
        else return -1;
    }
    public int[] getNext(String T){
        int [] next = new int[T.length()];
        int i=1,j=0;
        next[0]=0;
        for(;i<T.length();i++){
            while(j>0&&T.charAt(i)!=T.charAt(j)) j=next[j-1];
            if(T.charAt(i)==T.charAt(j)) next[i]=++j;
        }
        return next;
    }
}
