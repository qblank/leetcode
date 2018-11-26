package String.RansomNote_383;

import java.util.HashSet;
import java.util.Set;

/**
 * @date 2018/11/26
 * 383.赎金信
 * 给定一个赎金信 (ransom) 字符串和一个杂志(magazine)字符串，
 * 判断第一个字符串ransom能不能由第二个字符串magazines里面的字符构成。
 * 如果可以构成，返回 true ；否则返回 false。
 * (题目说明：为了不暴露赎金信字迹，要从杂志上搜索各个需要的字母，组成单词来表达意思。)
 *
 * 注意：
 * 你可以假设两个字符串均只含有小写字母。
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 */
public class RansomNote {
    public static void main(String[] args) {
        boolean result = canConstruct("fihjjjjei", "hjibagacbhadfaefdjaeaebgi");
        System.out.println(result);
    }

    /**
     * 思路:
     * 将左边字符串拆散，然后在右边通过indexOf逐一进行搜索，当索引不返回-1时，给其位置标记为*并使flag=true,否则返回flag=false
     * @param ransomNote
     * @param magazine
     * @return
     */
    public static boolean canConstruct(String ransomNote, String magazine) {
        StringBuffer sb = new StringBuffer(magazine);
        for (int i = 0; i < ransomNote.length(); i++) {
            int index = sb.indexOf(ransomNote.charAt(i)+"");
            if (index != -1){
                sb.replace(index,index + 1,"*");
            }else{
                return false;
            }
        }
        return true;
    }
}
