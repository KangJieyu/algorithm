package tree.binarytree;

import java.util.List;
import java.util.ArrayList;

/**
 * 递归二叉树的遍历
 *         7
 *        / \
 *       5   10
 *      / \
 *     2   6
 * @Author: KangJieyu
 * @DATE: 2022/2/26 上午9:23
 */
public class RecursiveTraversalTree {

    /**
     * 中序遍历结果
     */
    private List<Integer> inorderRes = new ArrayList<Integer>();
    /**
     * 前序遍历结果
     */
    private List<Integer> preorderRes = new ArrayList<Integer>();
    /**
     * 后序遍历结果
     */
    private List<Integer> postorderRes = new ArrayList<Integer>();

    /**
     * 二叉树的中序遍历
     * 左 根 右
     * @param root 要遍历的二叉树的根节点
     * @return 返回遍历的结果集
     */
    public List inorderTraversal(Node root) {
        if (root == null) {
            return null;
        }
        inorderTraversal(root.left);
        inorderRes.add((Integer) root.element);
        inorderTraversal(root.right);
        return inorderRes;
    }

    /**
     * 二叉树的前序遍历
     * 根 左 右
     * @param root 要遍历的二叉树的根节点
     * @return 返回遍历的结果集
     */
    public List preorderTraversal(Node root) {
        if (root == null) {
            return null;
        }
        preorderRes.add((Integer) root.element);
        preorderTraversal(root.left);
        preorderTraversal(root.right);
        return preorderRes;
    }

    /**
     * 二叉树的后序遍历
     * 左 右 根
     * @param root 要遍历的二叉树的根节点
     * @return 返回遍历的结果集
     */
    public List postorderTraversal(Node root) {
        if (root == null) {
            return null;
        }
        postorderTraversal(root.left);
        postorderTraversal(root.right);
        postorderRes.add((Integer) root.element);
        return postorderRes;
    }

    public static void main(String[] args) {
        Node root = new Node(7);
        root.left = new Node(5);
        root.right = new Node(10);
        root.left.left = new Node(2);
        root.left.right = new Node(6);
        RecursiveTraversalTree traversalTree = new RecursiveTraversalTree();
        List traversal = traversalTree.inorderTraversal(root);
        System.out.println("inorder : " + traversal);
        traversal = traversalTree.postorderTraversal(root);
        System.out.println("postorder : " + traversal);
        traversal = traversalTree.preorderTraversal(root);
        System.out.println("preorder : " + traversal);

    }
}
