public class Solution1392_2 {
    public String longestPrefix(String s) {
        StringBuffer ans=new StringBuffer("");
        int[] next=getnext(s);
        for(int i=s.length()-1;i>0;i--){
            String str=s.substring(i);
            if(kmp(s.substring(0,i),str,next)) ans.replace(0,ans.length(),str);
            else break;
        }
        return ans.toString();
    }
    public int[] getnext(String s){
        int[] next=new int[s.length()];
        int i=1,j=0;
        next[0]=0;
        for(;i<s.length();i++){
            while(j>0&&s.charAt(i)!=s.charAt(j)) j=next[j-1];
            if(s.charAt(i)==s.charAt(j)) j++;
            next[i]=j;
        }
        return next;
    }
    public boolean kmp(String S,String T,int[] next){
        int i=0,j=0;
        while(i<S.length()&&j<T.length()){
            while(j>0&&S.charAt(i)!=T.charAt(j)) j=next[j-1];
            if(S.charAt(i)==T.charAt(j)) j++;
            i++;
        }
        if(j==T.length()) return true;
        return false;
    }
}
