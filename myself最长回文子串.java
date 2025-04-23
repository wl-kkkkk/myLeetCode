//遍历每一个字符，向两边扩散，但是要注意是否是一样的、是否和中间是一样的
//通过c来判断是否是完全一样的回文，因为完全一样的和有不一样的接下来的行为是不一样的，这从第一步就可以确定；通过li，ri来更新循环内的索引，这样不会引起后面的混乱；我写的不是很好，在判断只有两个字符的字串时，只能单独拿出来
class Solution {
    public String longestPalindrome(String s) {
        int cut=1;//记录长度
        String res="";
        //思路：定义一个字符数组，在遍历的时候放进去，从第二个开始找回文子串
        char[] sa=new char[s.length()];
        if(s.length()==2&&(s.charAt(0)==s.charAt(1))){
            return s;
        }
        for(int i=0;i<s.length();i++){
            sa[i]=s.charAt(i);
            int j=i;
            int l=j-1,r=j+1;
            int c=0;//用于判断是全相同回文还是，正常回文
            while(l>=0&&r<s.length()){
                int li=0,ri=0;//防止l，r变后影响下面if的判断
                //这里先看是否前后两个相等，如果相等加2，不等看有没有相同的
                sa[l]=s.charAt(l);
                sa[r]=s.charAt(r);
                if(c==0&&sa[l]==sa[j]){
                    cut++;
                    li++;
                } 
                if(c==0&&sa[r]==sa[j]){
                    cut++;
                    ri++;
                } 
                if((li==0||ri==0)&&sa[l]==sa[r]){
                    cut+=2;
                    li++;
                    ri++;
                    c=1;
                }
                if(li==0&&ri==0){
                    break;
                }
                l-=li;
                r+=ri;
                if(l<0&&r<s.length()&&c==0){
                    for(;r<s.length();){
                        if(s.charAt(r)==s.charAt(j)){
                            cut++;
                            r++;
                        }else{
                            break;
                        }
                    }
                }
                if(l>=0&&r>=s.length()&&c==0){
                    for(;l>=0;){
                        if(s.charAt(l)==s.charAt(j)){
                            cut++;
                            l--;
                        }else{
                            break;
                        }
                    }
                }
            }
            if(cut>res.length()){
                //r不减是因为substring不包括结尾
                res=s.substring(l+1,r);
            }  
            cut=1;
        }
        return res;
    }
}
