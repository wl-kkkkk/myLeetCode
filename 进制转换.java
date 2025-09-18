public class Change {
    //这里是n进制转10进制;例如：(1011)2、(7077)8(7*8的1次)
    public static void NtoD(String code,int n){
        long ans=0;
        int k=0;
        for(int i=code.length()-1;i>=0;i--){
            char c=code.charAt(i);
            int num = 0;
            if(c>='0'&&c<='9') num=c-'0';
            else if(c>='A'&&c<='Z') num=c-'A'+10;
            else System.out.println("输入错误");
            ans+=(long)Math.pow(n,k++)*num;
        }
        System.out.println(ans);
    }
    //这里是10进制转二进制,也就是除基取余法
    public static void DtoB(long code){
        long n=1;
        long ans=0;
        while(code!=0){
            ans+=(code%2)*n;
            n*=10;
        }
        System.out.println(ans);
    }
    //由上面那个可以得到10进制转r进制
    public static void DtoR(long code,int r){
        long n=1;
        long ans=0;
        while(code!=0){
            ans+=(code%r)*n;
            n*=10;
        }
        System.out.println(ans);
    }
}
