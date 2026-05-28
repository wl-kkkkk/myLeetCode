public class Solution214 {
    public String shortestPalindrome(String s) {
        StringBuffer temp1=new StringBuffer(s);
        StringBuffer temp2=new StringBuffer(temp1.reverse());
        temp1=temp1.reverse();
        int i=temp1.length(),j=0;
        while(i>=0){
            if(temp1.substring(0,i).equals(temp2.substring(j))) break;
            i--;
            j++;
        }
        StringBuffer str=new StringBuffer("");
        str=str.append(temp2.substring(0,j));
        return str.append(s).toString();
    }
}
