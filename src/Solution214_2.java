public class Solution214_2 {
    public String shortestPalindrome(String s) {
        StringBuffer temp1=new StringBuffer(s);
        StringBuffer temp2=new StringBuffer(s);
        temp2.append("#");
        temp2.append(temp1.reverse());
        temp1.reverse();
        //求next数组
        int[] next=new int[temp2.length()];
        next[0]=0;
        int j=0,i=1;
        for(;i<temp2.length();i++){
            while(j>0&&temp2.charAt(i)!=temp2.charAt(j)){
                j=next[j-1];
            }
            if(temp2.charAt(i)==temp2.charAt(j)) j++;
            next[i]=j;
        }
        int index=next[temp2.length()-1];
        StringBuffer str=new StringBuffer(temp1.substring(index));
        return str.reverse().append(s).toString();
    }
}
