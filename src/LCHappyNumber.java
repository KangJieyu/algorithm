import java.util.HashSet;
import java.util.Set;

/**
 * @Description:
 * LC 快乐数
 * 编写一个算法来判断一个数 n 是不是快乐数。
 *
 * 「快乐数」定义为：
 *
 * 对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和。
 * 然后重复这个过程直到这个数变为 1，也可能是 无限循环 但始终变不到 1。
 * 如果这个过程 结果为 1，那么这个数就是快乐数。
 * 如果 n 是 快乐数 就返回 true ；不是，则返回 false 。
 *
 * 示例 1：
 *
 * 输入：n = 19
 * 输出：true
 * 解释：
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * 示例 2：
 *
 * 输入：n = 2
 * 输出：false
 *
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode.cn/leetbook/read/hash-table/xh1k9i/
 * 来源：力扣（LeetCode）
 * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 * @Date: 2022/9/20 21:37
 * @Author: jieyukang
 */
public class LCHappyNumber {

    private static Set<Integer> set = new HashSet<>();

    public static boolean isHappy(int n) {

        int num = n;
//        int pow = 0;
        int pow;
        int sum = 0;
        while (num != 0) {
            pow = num % 10;
            sum = sum + pow * pow;
            num = num / 10;
        }
        if (sum == 1) {
            return true;
        }
        if (set.contains(sum)) {
            return false;
        }
        set.add(sum);
        return isHappy(sum);
    }

    public static void main(String[] args) {
        System.out.println(isHappy(13));
    }

}
