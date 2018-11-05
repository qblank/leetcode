package Array.PositionsOfLargeGroups_830;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author evan_qb
 * @date 2018/10/10
 * 830.较大分组的位置
 *
 * 在一个由小写字母构成的字符串 S 中，包含由一些连续的相同字符所构成的分组。
 * 例如，在字符串 S = "abbxxxxzyy" 中，就含有 "a", "bb", "xxxx", "z" 和 "yy" 这样的一些分组。
 * 我们称所有包含大于或等于三个连续字符的分组为较大分组。找到每一个较大分组的起始和终止位置。
 * 最终结果按照字典顺序输出。
 *
 * 示例 1:
 * 输入: "abbxxxxzzy"
 * 输出: [[3,6]]
 * 解释: "xxxx" 是一个起始于 3 且终止于 6 的较大分组。
 *
 * 示例 2:
 * 输入: "abc"
 * 输出: []
 * 解释: "a","b" 和 "c" 均不是符合要求的较大分组。
 *
 * 示例 3:
 * 输入: "abcdddeeeeaabbbcd"
 * 输出: [[3,5],[6,9],[12,14]]
 * 说明:  1 <= S.length <= 1000
 */
public class PositionsOfLargeGroups {
    public static void main(String[] args) {
        String S = "abcdddeeeeaabbbcd";
        List<List<Integer>> results = largeGroupPositions(S);
        System.out.println(results.toString());
    }

    /**
     * 思路:
     * 从索引start开始到end,当start的值等于end的值时，end++,
     * 否则判断start到end之间的间距是否大于等于3，大于就将其添加到集合中
     * 否则将end值赋值给start，继续判断索引为start的值与end的值是否相等
     * @param S
     * @return
     */
    public static List<List<Integer>> largeGroupPositions(String S) {
        int start = 0,end = 0,len = S.length();
        List<List<Integer>> result = new ArrayList<>();
        while (end < len){
            while (end < len && S.charAt(end) == S.charAt(start)) end++;
            if (end - start >= 3) result.add(Arrays.asList(start,end - 1));
            start = end;
        }
        return result;
    }
}
