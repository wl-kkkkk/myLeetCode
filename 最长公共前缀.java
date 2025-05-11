//第一次写看错了题，以为是任意两个，我把那个代码放在下面，有兴趣的看一看。
//第二次对了，方法是纵向比较，一旦有不同直接返回；还有一种方法是横向比较，即先将第一个字符串存储起来然后挨个比较，一旦有比较结果是0，立刻返回（这个我没写）
class Solution {
    public String longestCommonPrefix(String[] strs) {
        //先找出长度最短的字符串，然后按那个长度来比较
        StringBuffer res=new StringBuffer("");
        int len=201;
        for(int i=0;i<strs.length;i++){
            int temp=strs[i].length();
            if(len>temp) len=temp;
        }
        for(int i=0;i<len;i++){//第几个字符
            while(true){
                char c=strs[0].charAt(i);
                int j=1;
                for(;j<strs.length;j++){
                    if(strs[j].charAt(i)==c) continue;
                    else break;
                }
                if(j==strs.length){
                    res.append(c);
                    break;
                }else{
                    return String.valueOf(res);
                }
            }
        }
        return String.valueOf(res);
    }
}
----------------------------------------------------------------------------------------------------------------------------
class Solution {
    public String longestCommonPrefix(String[] strs) {
        StringBuffer res=new StringBuffer("");
        for(int i=0;i<strs.length-1;i++){
            int s1=0;
            for(int j=i+1;j<strs.length;j++){
                int s2=0;
                StringBuffer temp=new StringBuffer("");
                while(true){
                    if(strs[i].charAt(s1)==strs[j].charAt(s2)){
                        temp.append(strs[i].charAt(s1));
                        s1++;
                        s2++;
                        if(s1==strs[i].length()||s2==strs[j].length()){
                            if(temp.length()>res.length()){
                                res=temp;
                            }
                            break;
                        }
                    }else{
                        break;
                    }
                }
            }
        }
        return String.valueOf(res);
    }
}

