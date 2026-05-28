//第一种
//在用StringBuffer时，做的改变会改变自身，不会像String一样去弄一个新的出来
//String的eauals();。StringBuffer的reverse()；
//第二种和答案一样
class Solution {
    public boolean isPalindrome(int x) {
        if(x<0){
            return false;
        }
        StringBuffer sb=new StringBuffer(String.valueOf(x));
        String sb2=sb.toString();
        if(sb2.equals(sb.reverse().toString())==true){
            return true;
        }
        return false;
    }
}

class Solution {
    public boolean isPalindrome(int x) {
        if(x<0||(x%10==0&&x!=0)){
            return false;
        }
        int com=0;
        while(com<x){
            com=com*10+x%10;
            x/=10;
        }
        return x==com||x==com/10;
    }
}
