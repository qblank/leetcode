package String.LongestCommonPrefix_14;

/**
 * @author evan_qb
 * @date 2018/8/5 15:47
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 */
public class LongestPrefix {
    public static void main(String[] args) {
        String[] strs = {"flower","flow","floght"};
        String result = longestCommonPrefix(strs);
        System.out.println(result);
    }


    public static String longestCommonPrefix(String[] strs) {
        int index = 0;
        if (strs.length <= 0){
            return "";
        }
        //遍历第一个数组的字符串
        for (int i = 0; i < strs[0].length(); i++) {
            //获取第一个字符串的每个元素
            char current = strs[0].charAt(index);
            for(String str: strs){
                //判断其他字符串是否和第一个字符串的元素相同
                if (str.length() == i || current != str.charAt(index)){
                    return str.substring(0,index);
                }
            }
            index++;
        }
        return strs[0].substring(0,index);
    }
}
