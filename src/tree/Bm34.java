package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * BM34 判断是不是二叉搜索树
 *
 * 描述
 * 给定一个二叉树根节点，请你判断这棵树是不是二叉搜索树。
 *
 * 二叉搜索树满足每个节点的左子树上的所有节点均严格小于当前节点且右子树上的所有节点均严格大于当前节点。
 *
 * 例：
 *       1
 *      / \
 *     2   3
 *
 *       2
 *      / \
 *     1   3
 * 示例1
 * 输入：{1,2,3}
 * 返回值：false
 *
 * 示例2
 * 输入：{2,1,3}
 * 返回值：true
 *
 * @Author: KangJieyu
 * @Date: 2022/7/9 上午8:56
 */
public class Bm34 {
    public static boolean isValidBST (TreeNode root) {
        // 中序遍历，将节点按顺序排列
        List<Integer> lists = new ArrayList<>();
        TreeNode node = root;
        Stack<TreeNode> stack = new Stack<>();
        while (node != null || !stack.empty()) {
            // 找左子节点，压栈
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 出栈
            if (!stack.empty()) {
                node = stack.pop();
            }
            // 集合中添加，若 list 中末端的元素大于或等于该节点值，则返回 false
            if (!lists.isEmpty() && node.val <= lists.get(lists.size() - 1)) {
                return false;
            }
            lists.add(node.val);
            node = node.right;
        }
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
        root.left.left.right = new TreeNode(3);
        root.right.left = new TreeNode(5);
        root.right.right = new TreeNode(9);
        System.out.println(Bm34.isValidBST(root));
    }
}
