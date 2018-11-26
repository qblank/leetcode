package String.ReverseVowelsOfStr_345;

import java.lang.reflect.Array;
import java.util.Arrays;

/**
 * @date 2018/11/5
 * 345.反转字符串中的元音字母
 * 编写一个函数，以字符串作为输入，反转该字符串中的元音字母。
 * 示例 1:
 * 输入: "hello"
 * 输出: "holle"
 *
 * 示例 2:
 * 输入: "leetcode"
 * 输出: "leotcede"
 * 说明:
 * 元音字母不包含字母"y"。
 */
public class ReverseVowerlsOfStr {
    public static void main(String[] args) {
        String result = reverseVowels(" ");
        System.out.println(result);
    }

    /**
     * 反转
     * @param s
     * @return
     */
    public static String reverseVowels(String s) {
        char[] strs = s.toCharArray();
        int len = strs.length,left = 0,right = len - 1;
        while (left < right){
            if (isVowel(strs[left]) && isVowel(strs[right])){
                char temp = strs[left];
                strs[left] = strs[right];
                strs[right] = temp;
                left++;
                right--;

            }else if (isVowel(strs[right])){
                left++;
            }else if (isVowel(strs[left])){
                right--;
            }else{
                left++;
            }
        }
        String result = String.copyValueOf(strs);
        return result;
    }

    /**
     * 判断是否是元音字母
     * @param c
     * @return
     */
    private static boolean isVowel(char c){
        String origin = "aeiouAEIOU";
        if (origin.indexOf(c) != -1){
            return true;
        }
        return false;
    }
}
