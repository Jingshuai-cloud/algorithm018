package week01;

import javax.swing.*;
import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {
    public static void main(String[] args) {
        String s = "{[]}()";
        boolean result = isValidParentheses(s);
        boolean result2 = isValidParenthesesSimple(s);
        System.out.println(result);
        System.out.println(result2);

    }

    private static boolean isValidParenthesesSimple(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(')
                stack.push(')');
            else if (s.charAt(i) == '{')
                stack.push('}');
            else if (s.charAt(i) == '[')
                stack.push(']');
            else if (stack.isEmpty() || stack.pop() != s.charAt(i))
                return false;
        }
        return stack.isEmpty();
    }

    private static boolean isValidParentheses(String s) {
        HashMap<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('(',')');
        parenthesesMap.put('{','}');
        parenthesesMap.put('[',']');
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {

            if (parenthesesMap.containsKey(s.charAt(i)))
                stack.push(s.charAt(i));
            else if (stack.isEmpty() || s.charAt(i) != parenthesesMap.get(stack.pop()))
                    return false;
        }
        return stack.isEmpty();
    }


}
