package statck;

import java.util.Stack;

/**
 * 150. 逆波兰表达式求值
 * 给你一个字符串数组 tokens ，表示一个根据 逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 示例 1：
 * 输入：tokens = ["2","1","+","3","*"]
 * 输出：9
 * 解释：该算式转化为常见的中缀算术表达式为：((2 + 1) * 3) = 9
 * @Date: 2022/12/31 19:39
 * @Author: KangJieyu
 */
public class Leet150 {
    public static int evalRPN(String[] tokens) {
        // 存储数组数字 遇到运算符时出栈运算
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            switch (token) {
                case "+" :
                    stack.push(stack.pop() + stack.pop());
                    break;
                case "-" :
                    Integer val1 = stack.pop();
                    stack.push(stack.pop() - val1);
                    break;
                case "*" :
                    stack.push(stack.pop() * stack.pop());
                    break;
                case "/" :
                    Integer val2 = stack.pop();
                    stack.push(stack.pop() / val2);
                    break;
                default: stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        String[] tokens = {"2","1","+","3","*"};
//        String[] tokens = {"4","13","5","/","+"};
//        String[] tokens = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
//        String[] tokens = {"4","3","-"};
        String[] tokens = {"3","11","5","+","-"};
        System.out.println(evalRPN(tokens));
    }
}
