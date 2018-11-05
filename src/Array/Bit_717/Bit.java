package Array.Bit_717;

/**
 * @author evan_qb
 * @date 2018/10/8
 * 717.1比特与2比特字符
 *
 * 有两种特殊字符。第一种字符可以用一比特0来表示。第二种字符可以用两比特(10 或 11)来表示。
 * 现给一个由若干比特组成的字符串。问最后一个字符是否必定为一个一比特字符。给定的字符串总是由0结束。
 * 示例 1:
 * 输入:
 * bits = [1, 0, 0]
 * 输出: True
 * 解释:
 * 唯一的编码方式是一个两比特字符和一个一比特字符。所以最后一个字符是一比特字符。
 *
 * 示例 2:
 * 输入:
 * bits = [1, 1, 1, 0]
 * 输出: False
 * 解释:
 * 唯一的编码方式是两比特字符和两比特字符。所以最后一个字符不是一比特字符。
 *
 * 注意:
 * 1 <= len(bits) <= 1000.
 * bits[i] 总是0 或 1.
 */
public class Bit {
    public static void main(String[] args) {
        int[] bits = {1,1,0,0};
        boolean result = isOneBitCharacter2(bits);
        System.out.println(result);
    }

    /**
     * 方法一
     * 思路:
     * 可以统计最后一个数之前的1的个数
     * 如果1的个数为偶数，则为true，否则为false
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter1(int[] bits) {
        int count = 0;
        for (int i = bits.length - 2; i >= 0 && bits[i] != 0; i--) {
            count++;
        }
        return count % 2 == 0;
    }

    /**
     * 方法二:
     * 思路:
     * 从头到倒数第2个数开始遍历，当遇到1时，跳过下一个数（即为2bit字符），
     * 否则遍历下一个数(即为1bit字符)继续判断是否为1
     * 最后判断索引是否为最后一个数(即判断最后一个是否一定不为2bit字符)
     * @param bits
     * @return
     */
    public static boolean isOneBitCharacter2(int[] bits) {
        int i = 0;
        while (i < bits.length - 1) {
            if (bits[i] == 1){
                i += 2;
            }else{
                i++;
            }
        }
        return i == bits.length - 1;
    }
}
