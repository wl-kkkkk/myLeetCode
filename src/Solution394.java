import java.util.ArrayDeque;
import java.util.Deque;

public class Solution394 {
    public String decodeString(String s) {
        Deque<String> stack = new ArrayDeque<>();
        StringBuilder res = new StringBuilder();

        int i=s.length()-1;
        while(i>=0){
            if(s.charAt(i)!='['){
                stack.push(String.valueOf(s.charAt(i)));
            }else{
                StringBuilder temp1=new StringBuilder();
                while(!stack.peek().equals("]")){
                    temp1.append(stack.pop());
                }
                stack.pop();
                //获取数字
                String numStr=getNum(s,i-1);
                StringBuilder temp2=new StringBuilder();
                int numLength=numStr.length();
                i=i-numLength;
                int num=Integer.parseInt(numStr);
                for(int j=0;j<num;j++){
                    temp2.append(temp1);
                }
                stack.push(temp2.toString());
            }
            i--;
        }

        while(!stack.isEmpty()){
            res.append(stack.pop());
        }
        return res.toString();
    }

    public String getNum(String s,int i){
        StringBuilder stringBuilder = new StringBuilder();
        for(int j=i;j>=0;j--){
            char c=s.charAt(j);
            if(!Character.isDigit(c)) break;
            stringBuilder.insert(0,c);
        }
        return stringBuilder.toString();
    }
}
