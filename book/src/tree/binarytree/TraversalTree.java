package tree.binarytree;

import java.util.List;
import java.util.ArrayList;
import java.util.Queue;
import java.util.Stack;
import java.util.LinkedList;

/**
 * 非递归二叉树的遍历
 *           7
 *          / \
 *         5  10
 *        / \
 *       2   6
 *          / \
 *         4   3
 * @Author: KangJieyu
 * @DATE: 2022/2/25 下午6:22
 */
public class TraversalTree {

    /**
     * 二叉树的中序遍历
     *      7
     *    5
     *  2
     * 左 根 右
     * @param root 要遍历的二叉树的根节点
     * @return 返回遍历的结果集
     */
    public List inorderTraversal(Node root) {
        // 遍历结果集
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || !stack.isEmpty()) {
            // 当前节点的左节点压栈，直至为空
            while (node != null) {
                stack.push(node);
                node = node.left;
            }
            // 当前节点为空后，若栈不为空，则出栈，将当前节点记为出栈的元素，
            if (!stack.empty()) {
                node = stack.pop();
                res.add((Integer) node.element);
                node = node.right;
            }
        }
        return res;
    }

    /**
     * 二叉树的前序遍历
     * 根 左 右
     * @param root 要遍历的二叉树的根节点
     * @return 返回遍历的结果集
     */
    public List preorderTraversal(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Stack<Node> stack = new Stack<Node>();
        Node node = root;
        while (node != null || !stack.empty()) {
            while (node != null) {
                res.add((Integer) node.element);
                stack.push(node);
                node = node.left;
            }
            if (!stack.empty()) {
                node = stack.pop();
                node = node.right;
            }
        }
        return res;
    }

    /**
     * 二叉树的后序遍历
     * 左 右 根
     * @param root 要遍历的二叉树的根节点
     * @return 返回遍历的结果集
     */
    public List postorderTraversal(Node root) {
        // 存放二叉树后序遍历节点值
        ArrayList<Integer> res = new ArrayList<Integer>();
        // 存储节点
        Stack<Node> stack = new Stack<Node>();
        // 定义当前节点
        Node curNode = root;
        // 定义前一个节点：出栈的前一个
        Node preNode = null;
        while (curNode != null || !stack.empty()) {
            // 压栈
            while (curNode != null) {
                stack.push(curNode);
                curNode = curNode.left;
            }
            // 出栈 当前节点无右孩子或前一个节点的右孩子为当前节点
            if (!stack.empty()) {
                curNode = stack.pop();
                if (curNode.right == null || preNode== curNode.right) {
                    res.add((Integer)curNode.element);
                    preNode = curNode;
                    curNode = null;
                } else {
                    // 不满足条件，重新压栈
                    stack.push(curNode);
                    curNode = curNode.right;
                }
            }
        }
        return res;
    }

    /**
     * 二叉树的层序遍历
     * @param root
     * @return
     */
    public List levelOrderTraversal(Node root) {
        List<Integer> res = new ArrayList<Integer>();
        Queue<Node> queue = new LinkedList<Node>();
        Node node = root;
        if (node == null) {
            return res;
        }
        queue.add(node);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (;size > 0; size--) {
                node = queue.poll();
                res.add((Integer) node.element);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        TraversalTree traversalTree = new TraversalTree();
        List traversal = traversalTree.inorderTraversal(null);
        System.out.println("inorder : " + traversal);
        traversal = traversalTree.preorderTraversal(root);
        System.out.println("preorder : " + traversal);

        traversal = traversalTree.postorderTraversal(root);
        System.out.println("postorder : " + traversal);

        traversal = traversalTree.levelOrderTraversal(root);
        System.out.println("level : " + traversal);

    }
}
