class Solution {
    public int calculate(String s) {
        // 将中缀转换成后缀
        String[] postfix = posts(s);
        // 开始计算
        Map<String, Integer> operand = new HashMap<>();
        operand.put("+", 1);
        operand.put("-", 2);
        operand.put("*", 3);
        operand.put("/", 4);
        Stack<Integer> nums = new Stack<>();

        for (int i = 0; i < postfix.length; i++) {
            String str = postfix[i];
            if (!operand.containsKey(str)) {
                nums.push(Integer.parseInt(str));
            } else {
                int num2 = nums.pop();
                int num1 = nums.pop();
                if (operand.get(str) == 1) nums.push(num1 + num2);
                else if (operand.get(str) == 2) nums.push(num1 - num2);
                else if (operand.get(str) == 3) nums.push(num1 * num2);
                else nums.push(num1 / num2);
            }
        }
        return nums.pop();
    }

    public String[] posts(String s) {
        List<String> res = new ArrayList<>();
        Stack<Character> operators = new Stack<>();  // 改个名字更清晰
        Map<Character, Integer> op = new HashMap<>();
        op.put('+', 1);
        op.put('-', 1);
        op.put('*', 2);
        op.put('/', 2);

        int i = 0;
        while (i < s.length()) {
            char c = s.charAt(i);

            // 跳过空格
            if (c == ' ') {
                i++;
                continue;
            }

            // 如果是数字
            if (Character.isDigit(c)) {
                int j = i;
                while (j < s.length() && Character.isDigit(s.charAt(j))) {
                    j++;
                }
                res.add(s.substring(i, j));
                i = j;  // 重要：更新i到数字末尾
                continue;  // 重要：跳过后续处理
            }

            // 如果是左括号
            if (c == '(') {
                operators.push(c);
            }
            // 如果是右括号
            else if (c == ')') {
                // 弹出直到遇到左括号
                while (!operators.isEmpty() && operators.peek() != '(') {
                    res.add(String.valueOf(operators.pop()));
                }
                operators.pop();  // 弹出左括号
            }
            // 如果是操作符 (+ - * /)
            else {
                // 当前操作符优先级 <= 栈顶优先级时，弹出栈顶
                while (!operators.isEmpty() && operators.peek() != '('
                        && op.getOrDefault(operators.peek(), 0) >= op.get(c)) {
                    res.add(String.valueOf(operators.pop()));
                }
                operators.push(c);
            }

            i++;  // 处理下一个字符
        }

        // 弹出所有剩余的操作符
        while (!operators.isEmpty()) {
            res.add(String.valueOf(operators.pop()));
        }

        // 转换为数组返回
        return res.toArray(new String[0]);
    }
}
