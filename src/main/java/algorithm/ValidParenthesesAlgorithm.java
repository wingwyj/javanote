package algorithm;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * 算法：给定一个字符串，包含只由 ()、[]、{} 三种括号组成的字符串，判断字符串是否有效。
 *
 * @author wyj
 * @version 1.0
 * @date 2025/5/24
 */
public class ValidParenthesesAlgorithm {

    /**
     * 判断字符串是否有效
     */
    public boolean isValidStr(String string) {
        if (string == null || string.isEmpty()) {
            return false;
        }
        // Deque<String> stack = new ArrayDeque<>(); 比stack高效
        Stack<Character> stack = new Stack<>();
        Map<Character, Character> map = new HashMap<>();
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
        for (int i = 0; i < string.length(); i++) {
            char c = string.charAt(i);
            if (map.containsKey(c)) {
                if (stack.isEmpty() || stack.pop() != map.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

}
