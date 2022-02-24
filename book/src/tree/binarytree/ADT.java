package tree.binarytree;

/**
 * 查找树
 * 二叉查找树
 *    每个节点的值都比其左子树节点值大，且比其右子树节点的值小
 * @Author: KangJieyu
 * @DATE: 2022/2/24 下午1:24
 */
public class ADT {

    /**
     * 找二叉查找树中最小值
     * @param root 二叉查找树的根节点
     * @return 二叉树为空返回null，否则返回最小值
     */
    public Object findMin(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root.element;
        }
        return findMin(root.left);
    }

    /**
     * 找二叉查找树中的最大值
     * @param root 二叉树的根节点
     * @return 二叉查找树为空返回null，否则返回最大值
     */
    public Object findMax(Node root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root.element;
        }
        return findMax(root.right);
    }

    /**
     * 在搜索二叉树中查找值
     * 对象.compareTo(参数) < 0 => 对象 < 参数
     * 对象.compareTo(参数) > 0 => 对象 > 参数
     * @param root 二叉查找树的根节点
     * @param val 要查找的参数值
     * @return boolean值，找到 val 返回true，没有找到 val 返回 false
     */
    public boolean contains(Node root, int val) {
        if (root == null) {
            return false;
        }
        Integer o = (int) root.element;
        if (o.compareTo(val) == 0) {
            return true;
        } else if (o.compareTo(val) < 0) {
            return contains(root.right, val);
        } else {
            return contains(root.left, val);
        }
    }

    /**
     * 向二叉查找树中插入节点
     * @param val 要插入的值
     * @return 返回二叉查找树的根节点
     */
    public Node insert(Node root, Integer val) {
        // 递归出口
        if (root == null) {
            return new Node(val);
        }
        int compare = val.compareTo((Integer) root.element);
        if (compare < 0) {
            // val < root.element root.left相当于Node(val)的父节点
            root.left = insert(root.left, val);
        } else if (compare > 0) {
            // val > root.element root.left相当于Node(val)的父节点
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        /**
         *         5
         *        / \
         *       2   8
         *      / \
         *     0   3
         */
        Node root = new Node(5);
        root.left = new Node(2);
        root.right = new Node(8);
        root.left.left = new Node(1);
        root.left.right = new Node(3);
        ADT adt = new ADT();
        System.out.println(adt.contains(root, 1));
        System.out.println(adt.findMin(root));
        System.out.println(adt.findMax(root));
        System.out.println(adt.insert(root, 10));
        System.out.println();
    }
}
