package tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * BM35 判断是不是完全二叉树
 *
 *
 * 描述
 * 给定一个二叉树，确定他是否是一个完全二叉树。
 *
 * 完全二叉树的定义：若二叉树的深度为 h，除第 h 层外，其它各层的结点数都达到最大个数，第 h 层所有的叶子结点都连续集中在最左边，这就是完全二叉树。（第 h 层可能包含 [1~2h] 个节点）
 *
 * 样例图1：
 *              1
 *            /    \
 *           2      3
 *          / \    /
 *         4  5   6
 * 样例图2：
 *              1
 *            /   \
 *           2     3
 *          / \   / \
 *         4  5  6   7
 * 样例图3：
 *              1
 *            /   \
 *           2     3
 *          / \     \
 *         4  5      6
 * 示例1
 * 输入：{1,2,3,4,5,6}
 * 返回值：true
 *
 * 示例2
 * 输入：{1,2,3,4,5,6,7}
 * 返回值：true
 *
 * 示例3
 * 输入：{1,2,3,4,5,#,6}
 * 返回值：false
 *
 * @Author: KangJieyu
 * @Date: 2022/7/9 上午9:50
 */
public class Bm35 {
    public static boolean isCompleteTree(TreeNode root) {
        // 求二叉树的深度
        int depth = completeTreeDepth(root);
        if (depth == 1) {
            return true;
        }
        // 层序遍历二叉树，在倒数第二层中节点数是否等于 2^(floor-1)，floor = depth-1
        TreeNode node = root;
        List<TreeNode> lists = new LinkedList<>();
        lists.add(node);
        int count = 1;
        while (node != null) {
            if (count == depth - 1) {
                break;
            }
            int size = lists.size();
            for (int i = 0; i < size; i++) {
                // 删除时不能删除 i 位置的，删除后链表中的元素会向前移动
                node = lists.remove(0);
                if (node.left != null) {
                    lists.add(node.left);
                }
                if (node.right != null) {
                    lists.add(node.right);
                }
            }
            count++;
        }
        // depth - 1 层的节点数
        int size = lists.size();
        // 记录最后一层的节点数
        count = 0;
        // 将最后一层的节点都放入 List 集合中
        for (int i = 0; i < size; i++) {
            node = lists.remove(0);
            if (node.left != null) {
                count++;
            }
            lists.add(node.left);
            if (node.right != null) {
                count++;
            }
            lists.add(node.right);
        }
        // 只遍历前 count 个元素，如果前 count 个元素中有一个为 null，则返回 false
        for (int i = 0; i < count; i++) {
            node = lists.get(i);
            if (node == null) {
                return false;
            }
        }
        return size == Math.pow(2, depth - 2);
    }


    public static int completeTreeDepth(TreeNode root) {
        // 二叉树为空
        if (root == null) {
            return 0;
        } else {
            // 左子树为空，右子树不为空，二叉树的深度：右子树深度+1
            // 左子树不为空，右子树为空，二叉树的深度：左子树深度+1
            // 左右子树都不为空，二叉树的深度：左右子树最大深度+1
            int left = completeTreeDepth(root.left);
            int right = completeTreeDepth(root.right);
            return left > right ? left + 1 : right + 1;
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(2);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(3);
//        root.left.left.right = new TreeNode(3);
        root.left.left.left = new TreeNode(3);
        root.right.left = new TreeNode(5);
//        root.right.right = new TreeNode(9);
//        System.out.println(Bm35.completeTreeDepth(root));
        System.out.println(isCompleteTree(root));
    }
}
