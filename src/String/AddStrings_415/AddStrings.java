package String.AddStrings_415;

/**
 * 给定两个字符串形式的非负整数 num1 和num2 ，计算它们的和。
 * 注意：
 *   1.num1 和num2 的长度都小于 5100.
 *   2.num1 和num2 都只包含数字 0-9.
 *   3.num1 和num2 都不包含任何前导零。
 *   4.你不能使用任何內建 BigInteger 库， 也不能直接将输入的字符串转换为整数形式。
 *
 * @author evan_qb
 * @version 1.0
 * @date 2019/8/5 21:41
 */
public class AddStrings {
    public static void main(String[] args) {
        String result = addStrings("1", "9");
        System.out.println(result);
    }


    /**
     * 思路一：单个字符串转数字
     * 定义两个索引值i和j，初始值分别为num1和num2的最后一位数的索引。
     * 然后两两转数字相加并加上进位值carry(默认为0)，
     * 判断是否进位，如果进位，则直接将结果置0
     * 两者相加，如果不够，则直接补零
     * 使用StringBuffer从末尾开始拼接,最后将结果反转即可
     * 该方法执行效率比较低
     * @param num1 字符串1
     * @param num2 字符串2
     * @return
     */
    public static String addStrings(String num1, String num2) {
        int i = num1.length() - 1,j = num2.length() - 1;
        int carry = 0;
        StringBuffer sb = new StringBuffer();
        while (i >= 0 || j >= 0 || carry != 0){
            int n1 = i < 0 ? 0:num1.charAt(i--)-'0';
            //效率太低
            //int n2 = j < 0 ? 0:Integer.parseInt(String.valueOf(num2.charAt(j--)));
            int n2 = j < 0 ? 0:num2.charAt(j--)-'0';
            int result = n1 + n2 + carry;
            carry = result / 10;
            result %= 10;
            sb.append(result);
        }
        return sb.reverse().toString();
    }


    /**
     * 思路2:
     * @param num1
     * @param num2
     * @return
     */
    public static String addStrings2(String num1, String num2) {
        StringBuffer sb = new StringBuffer();
        int i = num1.length() - 1,j = num2.length() - 1;
        int carry = 0;
        while (i >= 0 || j >= 0 || carry != 0){
            if (i >= 0){
                carry += num1.charAt(i--)-'0';
            }
            if (j >= 0){
                carry += num2.charAt(j--)-'0';
            }
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
}
