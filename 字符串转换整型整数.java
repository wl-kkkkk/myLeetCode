//(int)sb.charAt(j) 直接获取的是字符的ASCII码值（如'4'的ASCII是52），而不是数字值4
//应该使用 sb.charAt(j) - '0' 来获取实际数字值
class Solution {
    public int myAtoi(String s) {
        if(s.length()==0) return 0;
       StringBuffer sb=new StringBuffer(s);
       long res=0;
       int sta;//表示正负状态,0为负数
       while(sb.charAt(0)==' '){
        sb.deleteCharAt(0);
        if(sb.length()==0) return 0;
       }
       if(sb.length()==0) return 0;
       if(sb.charAt(0)=='-'){
        sta=0;
        sb.deleteCharAt(0);
       }else if(sb.charAt(0)=='+'){
        sta=1;
        sb.deleteCharAt(0);
       }else{
        sta=1;
       }
       int j=0;
       while(j<sb.length()&&Character.isDigit(sb.charAt(j))){
            res=res*10+(sb.charAt(j)-'0');
            if(res>Integer.MAX_VALUE){
                if (sta==0) return Integer.MIN_VALUE;
                return Integer.MAX_VALUE;
            }
            j++;
       }
       if(sta==0) return (int)-res;
       return (int) res;
 }
}
