package String.LengthofLastWord_58;

/**
 * @author evan_qb
 * @date 2018/8/8 8:28
 * 最后一个单词的长度
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串，返回其最后一个单词的长度。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指由字母组成，但不包含任何空格的字符串。
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 */
public class LastWord {
    public static void main(String[] args) {
        int result = lengthOfLastWord2("");
        System.out.println(String.format("长度为: %d",result));
    }

    /**
     * 方法一:通过截取字符串来实现
     * @param s
     * @return
     */
    public static int lengthOfLastWord1(String s) {
        s = s.trim();
        int index = s.lastIndexOf(' ');
        String result = s.substring(index + 1);
        return result.length();
    }

    /**
     * 方法二：通过总长度 - 最后一个空格的索引 - 1
     * @param s
     * @return
     */
    public static int lengthOfLastWord2(String s) {
        return s.trim().length() - s.trim().lastIndexOf(" ") - 1;
    }
}
