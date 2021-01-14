package String.ReverseString_344;

/**
 * @date 2018/11/2
 * 344.反转字符串
 * 编写一个函数，其作用是将输入的字符串反转过来。
 *
 * 示例 1:
 * 输入: "hello"
 * 输出: "olleh"
 *
 * 示例 2:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: "amanaP :lanac a ,nalp a ,nam A"
 *
 */
public class ReverseString {
    public static void main(String[] args) {
        String s = "hello";
        String result = reverseString2(s);
        System.out.println(result);
    }

    /**
     * 反转字符串
     * @param s
     * @return
     */
public static String reverseString(String s) {
    int len = s.length();
    char[] chars = s.toCharArray();
    for (int i = 0; i < len / 2; i++) {
        char tmp = chars[i];
        chars[i] = chars[len - i - 1];
        chars[len - i - 1] = tmp;
    }
    s = String.copyValueOf(chars);
    return s;
}

    public static String reverseString2(String s){
        int len = s.length();
        char[] chars = s.toCharArray();
        for (int i = 0; i < len / 2; i++) {
            int tmp = len - i - 1;
            chars[i] ^= chars[tmp];
            chars[tmp] ^= chars[i];
            chars[i] ^= chars[tmp];
        }
        s = String.copyValueOf(chars);
        return s;
    }


}
