//不需要管列的部分，用了StringBuffer，最后处理时方便
class Solution {
    public String convert(String s, int numRows) {
        StringBuffer res=new StringBuffer("");
        if(numRows==1||numRows>=s.length()){
            return s;
        }
        StringBuffer[] sb=new StringBuffer[numRows];
        for(int i=0;i<numRows;i++){
            sb[i]=new StringBuffer();
        }
        int r=0;
        for(int i=0;i<s.length();i++){
            sb[r].append(s.charAt(i));
            r++;
            if(r==numRows){
                r-=2;
                while(r!=-1){
                    i++;
                    if(i==s.length()) break;
                    sb[r].append(s.charAt(i));
                    r--;
                }
                r=1;
            }
            
        }


        for(int i=0;i<numRows;i++){
            res.append(sb[i]);
        }
        return res.toString();
    }
}
