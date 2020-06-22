package String.ValidParentheses_20;

import java.util.Stack;

/**
 * @author evan_qb
 * @date 2018/8/5 18:11
 * 有效的括号
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 1.左括号必须用相同类型的右括号闭合。
 * 2.左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 */
public class Valid {
    public static void main(String[] args) {
        String str = "";
        boolean flag = isValid(str);
        System.out.println(flag);

    }

    /**
     * 使用栈
     * @param s
     * @return
     */
    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c:s.toCharArray()){
            if (c == '('){
                stack.push(')');
            }else if (c == '{'){
                stack.push('}');
            }else if (c == '['){
                stack.push(']');
            }else if (stack.isEmpty() || stack.pop() != c){
                return false;
            }
        }
        return stack.isEmpty();
    }
}
