package String.FirstUniqueCharStr_387;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. 字符串中的第一个唯一字符
 *
 * 给定一个字符串，找到它的第一个不重复的字符，并返回它的索引。如果不存在，则返回 -1。
 * 案例:
 * s = "leetcode"
 * 返回 0.
 * s = "loveleetcode",
 * 返回 2.
 * @version 1.0
 * @date 2019/1/31 10:08
 */
public class FirstUniquecharStr {
    public static void main(String[] args) {
        int result = firstUniqChar("loveleetcode");
        System.out.println(result);
    }

    /**
     * 思路: 先通过HashMap统计每个字符的个数
     * 然后重新遍历字符串找出个数为1的第一个字符，并将其返回
     *
     * @param s
     * @return
     */
    public static int firstUniqChar(String s) {
        Map<Character,Integer> map = new HashMap<>();
        int len = s.length();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            map.put(c,map.getOrDefault(c,0) + 1);
        }

        for (int i = 0; i < len; i++) {
            if (map.get(s.charAt(i)) == 1){
                return i;
            }
        }
        return -1;
    }
}
