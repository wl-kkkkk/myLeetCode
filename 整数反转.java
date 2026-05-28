//要在得到结果前进行显示的大小判断
class Solution {
    public int reverse(int x) {
       int res=0;
       while(x!=0){
            if(res<Integer.MIN_VALUE/10||res>Integer.MAX_VALUE/10){
                return 0;
            }
            int temp=x%10;
            x=x/10;
            res=res*10+temp;
       }      
       
        return res;
    }
}
