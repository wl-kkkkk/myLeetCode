class Solution {
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

class Solution {
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
