package String.CountandSay_38;

import java.util.Scanner;

/**
 * @author evan_qb
 * @date 2018/8/7 8:54
 * 38.报数
 * 报数序列是指一个整数序列，按照其中的整数的顺序进行报数，得到下一个数。其前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 被读作  "one 1"  ("一个一") , 即 11。
 * 11 被读作 "two 1s" ("两个一"）, 即 21。
 * 21 被读作 "one 2",  "one 1" （"一个二" ,  "一个一") , 即 1211。
 * 给定一个正整数 n ，输出报数序列的第 n 项。
 * 注意：整数顺序将表示为一个字符串。
 * 输入: 1
 * 输出: "1"
 *
 * 输入: 4
 * 输出: "1211"
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println("*****请输入第n个人报数*****");
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String result = countAndSay2(n);
        System.out.println(result);
    }

    /**
     * 嵌套for循环
     * @param n
     * @return
     */
    public static String countAndSay1(int n) {
        String start = "1";
        char[] chars = String.valueOf(n).toCharArray();
        StringBuffer temp = new StringBuffer();
        //外层循环:控制进行的次数
        for (int i = 1; i < n; i++) {
            //清空temp
            temp.setLength(0);
            int count = 1;
            int j = 0;
            //内层循环：存储每次输入的值
            for (;j < start.length() - 1; j++) {
                //相同则统计个数，不同则先输出再重新统计
                if (start.charAt(j) == start.charAt(j + 1)){
                    count++;
                }else{
                    temp.append(count).append(start.charAt(j));
                    count = 1;
                }
            }
            //只有上述循环执行完才能到达这步，但还需设置j > 0，因为当start="1"时，即第一次不会进入内层循环
            //如果是最后一个数，则与前面的数进行比较，如果相同，count加一，否则就为1个数
            if (j > 0 && (start.charAt(j) == start.charAt(j - 1))){
                temp.append(count).append(start.charAt(j));
            }else{
                temp.append(1).append(start.charAt(j));
            }
            start = temp.toString();
        }
        return start;
    }

    /**
     * 方法二: 进行递归
     * @param n
     * @return
     */
    public static String countAndSay2(int n){
        if (n == 1){
            return "1";
        }
        StringBuffer sb = new StringBuffer();
        //递归
        String forward = countAndSay2(n - 1);
        int index = 0;
        while (index < forward.length()){
            int curr = index;
            while (curr < forward.length() && forward.charAt(index) ==  forward.charAt(curr)){
                curr++;
            }
            sb.append(curr - index).append(forward.charAt(index));
            index = curr;
        }
        return sb.toString();
    }
}
