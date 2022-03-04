package tree.binarytree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 二叉树的深度
 * @Author: KangJieyu
 * @DATE: 2022/3/4 下午7:44
 */
public class Depth {

    /**
     * 通过二叉树的层次遍历计算树最大深度
     * @param root 二叉树的根节点
     * @return int类型，最高深度
     */
    public int floorTraversalGet(Node root) {
        // 初始化深度
        int depth = 0;
        // 二叉树为空
        if (root == null) {
            return 0;
        }
        // 二叉树不为空，入队 队列 先进先出，通过控制每层节点树，节点出队时左孩子和右孩子有序进队
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);

        while (!queue.isEmpty()) {
            depth ++;
            int size = queue.size();
            for (;size > 0; size --) {
                root = queue.poll();
                if (root.left != null) {
                    queue.add(root.left);
                }
                if (root.right != null) {
                    queue.add(root.right);
                }
            }
        }
        return depth;
    }

    /**
     * 递归得到二叉树的最大深度
     *          6
     *         / \
     *        3   5
     *       /
     *      2
     * @param root
     * @return
     */
    public int recursiveGet(Node root) {
        // 根节点为空
        if (root == null) {
            return 0;
        }
        // 左子树的深度
        int left = recursiveGet(root.left);
        // 右子树的深度
        int right = recursiveGet(root.right);
        // 左孩子和右孩子取最大的+1返回
        return left > right ? left + 1 : right + 1;
    }

    public static void main(String[] args) {
        Depth depthObj = new Depth();
        Node root = new Node(5);
//        root.left = new Node(10);
//        root.right = new Node(2);
//        root.right.right = new Node(3);
        int depth1 = depthObj.floorTraversalGet(root);
        System.out.println("depth1 = "+depth1);
        int depth2 = depthObj.recursiveGet(root);
        System.out.println("depth2 = "+depth2);

    }

}
