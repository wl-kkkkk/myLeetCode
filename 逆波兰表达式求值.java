class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> s=new Stack<>();
        Map<String,Integer> operand=new HashMap<>();
        operand.put("+",1);
        operand.put("-",2);
        operand.put("*",3);
        operand.put("/",4);
        for(int i=0;i<tokens.length;i++){
            if(!operand.containsKey(tokens[i])) s.push(Integer.parseInt(tokens[i]));
            else op(s,tokens[i],operand);
        }
        return s.pop();
    }
    public void op(Stack<Integer> s,String oper,Map<String,Integer> operand){
        int op2=s.pop();
        int op1=s.pop();
        int ope=operand.get(oper);
        if(ope==1) s.push(op1+op2);
        else if(ope==2) s.push(op1-op2);
        else if(ope==3) s.push(op1*op2);
        else s.push(op1/op2);
    }
}
