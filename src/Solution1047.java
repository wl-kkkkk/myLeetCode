import java.util.*;
public class Solution1047 {
    public String removeDuplicates(String s) {
        Stack<Character> st=new Stack<>();
        for(int i=0;i<s.length();i++){
            if(st.isEmpty()||st.peek()!=s.charAt(i)) st.push(s.charAt(i));
            else st.pop();
        }
        StringBuffer ans=new StringBuffer("");
        for(Character c:st){
            ans.append(c);
        }
        return ans.toString();
    }
}
