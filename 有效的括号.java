//用栈的方法解题，将左边的都push到栈里，遇到了右边的就pop，如果配对就继续，如果没有就返回false
class Solution {
    public boolean isValid(String s) {
        Stack<Character> st=new Stack<>();
        Map<Character,Character> map=new HashMap<>();
        map.put('(',')');
        map.put('{','}');
        map.put('[',']');
        for(int i=0;i<s.length();i++){
            if(map.containsKey(s.charAt(i))) st.push(s.charAt(i));
            else{
                if(st.empty()) return false;
                char c=st.pop();
                if(map.get(c)==s.charAt(i)) continue;
                return false;
            }
        }
        
        return st.empty();
    }
}
