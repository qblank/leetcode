package String.ValidPalindrome_125;

/**
 * @date 2018/11/2
 * 125.验证回文串
 * 给定一个字符串，验证它是否是回文串，只考虑字母和数字字符，可以忽略字母的大小写。
 * 说明：本题中，我们将空字符串定义为有效的回文串。
 * 示例 1:
 * 输入: "A man, a plan, a canal: Panama"
 * 输出: true
 *
 * 示例 2:
 * 输入: "race a car"
 * 输出: false
 */
public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        boolean result = isPalindrome(s);
        System.out.println(result);
    }

    /**
     * 思路:
     * 去掉空格和符号接着将其全部转换为大写/小写，接着将前面后面的值进行对比
     * @param s
     * @return
     */
    public static boolean isPalindrome(String s) {
        if (s == null || s.length() == 0) return true;
        s = s.toLowerCase().replaceAll("\\p{Punct}+","").replaceAll("\\s+","");
        int left = 0,right = s.length() - 1;
        while (left < right){
            if (s.charAt(right) == s.charAt(left)){
                left++;
                right--;
            }else{
                return false;
            }
        }
        return true;
    }
}
