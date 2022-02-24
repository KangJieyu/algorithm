package string;

/**
 *
 NC55 最长公共前缀
 描述
 给你一个大小为 n 的字符串数组 strs ，其中包含n个字符串 , 编写一个函数来查找字符串数组中的最长公共前缀，返回这个公共前缀。
 示例1
 输入：["abca","abc","abca","abc","abcc"]
 返回值："abc"

 示例2
 输入：["abc"]
 返回值："abc"

 * @Author: KangJieyu
 * @DATE: 2022/1/25 下午4:02
 */
public class Nc55 {

    public static String longestCommonPrefix (String[] strs) {
        // 字符串没有元素
        if (strs == null || strs.length == 0) {
            return "";
        }
        // 字符串中有一个元素
        if (strs.length == 1) {
            return strs[0];
        }
        // 以第一个元素进行截取，且定义最长公共前缀
        String first = strs[0];
        String maxSub = "";
        System.out.println("first = " + first);
        for (int i = 1; i <= first.length(); i++) {
            maxSub = first.substring(0,i);
            System.out.println("i = " + i + "\t" + "maxSub = " + maxSub);
            // 循环数组元素，从 index=1 开始依次比较
            for (int j = 1; j < strs.length; j++) {
                // 当前元素
                String ele = strs[j];
                // 当前元素的长度以及子串
                int len = ele.length();
                // 当前元素长度 < 最长公共前缀  当前元素截取的子串与 maxSub 不等
                if (len < i || !maxSub.equals(ele.substring(0, i))) {
                    return maxSub.substring(0, i - 1);
                }
            }
        }
        return maxSub;
    }

    public static void main(String[] args) {
//        String[] strs = {"abca","abc","abca","abc","abcc"};
//        String[] strs = {"abca","abc","abca","abc","abcc"};
        String[] strs = {"abca","abc","abca","abc","abcc","e"};
        System.out.println("res = " + Nc55.longestCommonPrefix(strs));
    }
}
