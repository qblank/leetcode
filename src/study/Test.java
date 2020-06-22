package study;

import java.util.HashMap;
import java.util.LinkedList;

/**
 * @date 2018/10/26
 */
public class Test {
    public static void main(String[] args) {
        //int result = approachTwoCover(14);
//        System.out.println(result);
        //60 * 60 * 1000 = 3600000
        new HashMap<>();
        new LinkedList<>();
        System.out.println(String.format("%x",29414));
    }

    /**
     * 将所有的数趋近于2的幂(向上取值)
     * @return
     */
    public static int approachTwoCover(int num){
        num = num - 1;
        num |= num >>> 1;   // 1110 | 0111 = 1111
        num |= num >>> 2;   // 1111 | 0001 = 1111
        num |= num >>> 4;   // 1111 | 0000 = 1111
        num |= num >>> 8;   // 1111 | 0000 = 1111
        num |= num >>> 16;  // 1111 | 0000 = 1111
        return num + 1;
    }
}
