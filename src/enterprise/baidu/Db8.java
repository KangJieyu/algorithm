package enterprise.baidu;

import java.util.Scanner;
import java.util.Stack;

/**
 *
 BD8 完成括号匹配

 题目
 描述
 合法的括号匹配序列被定义为:
 1. 空串""是合法的括号序列
 2. 如果"X"和"Y"是合法的序列,那么"XY"也是一个合法的括号序列
 3. 如果"X"是一个合法的序列,那么"[X]"也是一个合法的括号序列
 4. 每个合法的括号序列都可以由上面的规则生成
 例如"", "[]", "[][][]", "[[][]]", "[[[[]]]]"都是合法的。
 牛牛现在给出一个括号序列s,牛牛允许你执行的操作是:在s的开始和结尾处添加一定数量的左括号('[')或者右括号(']')使其变为一个合法的括号匹配序列。
 牛牛希望你能求出添加最少的括号之后的合法的括号匹配序列是什么。
 输入描述：
 输入包括一个字符串s,s的长度length(1 ≤ length ≤ 50),s中只包含'['和']'。
 输出描述：
 输出一个字符串,表示括号完全匹配的序列。
 示例1
 输入：][
 输出：[][]
 * @Author: KangJieyu
 * @DATE: 2022/2/23 上午11:09
 */
public class Db8 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // 输入字符串
        // [][     [[     ]][[
        // [][]   [[]]   [[]][[]]
        String s = sc.nextLine();
        // 结果字符串
        StringBuilder builder = new StringBuilder();
        // 创栈
        Stack stack = new Stack();
        // 循环压栈，匹配出栈，生成结果字符串
        for (int i = 0; i < s.length(); i++) {
            // '[' ']'
            char c = s.charAt(i);
            if (stack.empty() && c == '[') {
                stack.push(c);
            } else if (stack.empty() && c == ']'){
                // 拼串
                builder.insert(0, '[');
                builder.append(']');
            } else if (!stack.empty() && c == ']') {
                // 出栈，拼串
                stack.pop();
                builder.insert(0, '[');
                builder.append(']');
            } else if (!stack.empty() && c == '[') {
                // 压栈
                stack.push(c);
            }
        }
        int size = stack.size();
        for (; size > 0; size --) {
            builder.insert(builder.length(), '[');
//            builder.insert(0, '[');
            builder.append(']');
        }
        System.out.println(builder);
    }
}
