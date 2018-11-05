package Array.PlaceFlowers_605;

/**
 * @author evan_qb
 * @date 2018/9/6
 * 605.种花问题
 * 假设你有一个很长的花坛，一部分地块种植了花，另一部分却没有。
 * 可是，花卉不能种植在相邻的地块上，它们会争夺水源，两者都会死去。
 * 给定一个花坛（表示为一个数组包含0和1，其中0表示没种植花，1表示种植了花），
 * 和一个数 n 。能否在不打破种植规则的情况下种入 n 朵花？能则返回True，不能则返回False。
 *
 * 示例 1:
 * 输入: flowerbed = [1,0,0,0,1], n = 1
 * 输出: True
 *
 * 示例 2:
 * 输入: flowerbed = [1,0,0,0,1], n = 2
 * 输出: False
 * 注意:
 * 1.数组内已种好的花不会违反种植规则。
 * 2.输入的数组长度范围为 [1, 20000]。
 * 3.n 是非负整数，且不会超过输入数组的大小。
 */
public class PlaceFlowers {
    public static void main(String[] args) {
        int[] flowerbed = {1,0,1,0,0};
        int n = 1;
        boolean result = canPlaceFlowers2(flowerbed, n);
        System.out.println(result);
    }

    /**
     * 思路:
     * 当前值为零时
     * 判断下一个数是否为0，如果下一个数为最后一位，则也当作0处理
     * 判断上一个数是否为0，如果上一个数位第一位数，当0处理，
     * 最后判断当前值、上一位、下一位数都为0时，将当前值进行插花(将0设置为1),count++
     * 最后判断count与n是否相等，如果相等，则返回true
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers1(int[] flowerbed, int n) {
        int count = 0;
        int len = flowerbed.length;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0){
                int next = i == len - 1 ? 0 : flowerbed[i + 1];
                int prev = (i == 0) ? 0 : flowerbed[i - 1];
                if (next == 0 && prev == 0){
                    flowerbed[i] = 1;
                    count++;
                }
            }
        }
        return count >= n;
    }

    /**
     * 思路：
     * 能量槽类型
     * 用t(初始为1，用于满足左边有两个0的情况)凑集能量，当t = 3时，空位space+1
     * 最后space += space /2 (用于满足右边只有两个0的情况)
     * 最后如果n < spance，则表示能养花，否则不能
     * @param flowerbed
     * @param n
     * @return
     */
    public static boolean canPlaceFlowers2(int[] flowerbed, int n) {
        int len = flowerbed.length;
        //表示空位的数量
        int space = 0;
        //当t = 3时，空位space+1，清空
        int t = 1;
        for (int i = 0; i < len; i++) {
            if (flowerbed[i] == 0){
                t++;
            }else{
                space += (t - 1) / 2;
                t = 0;
            }
        }
        //满足后面两个0的情况
        space += t / 2;
        return n <= space;
    }

}
