public class Solution1392 {
    public String longestPrefix(String s) {
        int l=1;int r=s.length()-1;
        StringBuffer sb=new StringBuffer("");
        while(l<s.length()||r>0){
            String str1=s.substring(0,l);
            String str2=s.substring(r);
            if(str1.equals(str2)) sb.replace(0,sb.length(),str1);
            l++;
            r--;
        }
        return sb.toString();
    }
}
