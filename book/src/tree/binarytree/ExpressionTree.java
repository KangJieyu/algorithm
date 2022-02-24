package tree.binarytree;

import java.util.Scanner;
import java.util.Stack;

/**
 * 构造表达式树
 * 二叉树的后序遍历
 *                 +
 *               /  \
 *             /     \
 *           /        \
 *          +          *
 *         / \        / \
 *        a   *      +  g
 *           / \    / \
 *          b   c  *  f
 *                / \
 *               d   e
 * @Author: KangJieyu
 * @DATE: 2022/2/24 下午12:26
 */
public class ExpressionTree {

    private static Stack<Node> stack = new Stack<Node>();

    public static void createExpressionTree(Node node) {
        String val = (String) node.element;
        // 如果节点值为操作数，压栈；若为操作符，则出栈
        if (val.equals("+") || val.equals("-") || val.equals("*") || val.equals("/")) {
            Node right = stack.pop();
            Node left = stack.pop();
            node.left = left;
            node.right = right;
            stack.push(node);
        } else {
            stack.push(node);
        }
    }


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String s = sc.next();
            if (s.equals("!")) {
                break;
            }
            Node node = new Node();
            node.element = s;
            ExpressionTree.createExpressionTree(node);
        }
        Node node = stack.pop();
        System.out.println(node);
    }
}
