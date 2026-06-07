import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution17 {
    public List<String> letterCombinations(String digits) {
        List<String> res = new ArrayList<>();
        int dlen = digits.length();
        Map<Character, String> mp = new HashMap<>();
        mp.put('2', "abc");
        mp.put('3', "def");
        mp.put('4', "ghi");
        mp.put('5', "jkl");
        mp.put('6', "mno");
        mp.put('7', "pqrs");
        mp.put('8', "tuv");
        mp.put('9', "wxyz");
        StringBuilder temp = new StringBuilder("");
        backtracking(res, temp, mp, digits, dlen, 0);
        return res;
    }

    public void backtracking(List<String> res, StringBuilder temp, Map<Character, String> mp, String digits, int dlen, int index) {
        if (temp.length() == dlen) {
            res.add(new String(temp));
            return;
        }
        String digitCharArray = mp.get(digits.charAt(index));
        int dcalen = digitCharArray.length();
        for (int i = 0; i < dcalen; i++) {
            temp.append(digitCharArray.charAt(i));
            backtracking(res, temp, mp, digits, dlen, index + 1);
            temp.deleteCharAt(index);
        }
    }

}
