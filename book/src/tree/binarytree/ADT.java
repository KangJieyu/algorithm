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
     * 找二叉查找树中最小值的节点
     * @param root 二叉查找树的根节点
     * @return 二叉树为空返回null，否则返回最小值
     */
    public Node findMin(Node root) {
        if (root == null) {
            return null;
        }
        if (root.left == null) {
            return root;
        }
        return findMin(root.left);
    }

    /**
     * 找二叉查找树中的最大值的节点
     * @param root 二叉树的根节点
     * @return 二叉查找树为空返回null，否则返回最大值
     */
    public Node findMax(Node root) {
        if (root == null) {
            return null;
        }
        if (root.right == null) {
            return root;
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

    /**
     * 删除二叉查找树中的指定节点
     *                8
     *               / \
     *              4   12
     *             / \    \
     *            2   6   14
     *           /   / \
     *          1   5   7
     * 1)叶子节点
     * 2)有一个子节点
     * 3)有两个子节点
     * @param root 二叉树的根节点
     * @param val 要删除的节点值
     * @return 返回删除节点后的二叉查找树，若为空则返回null
     */
    public Node remove(Node root, Integer val) {
        if (root == null) {
            return root;
        }
        int compare = val.compareTo((Integer) root.element);
        if (compare == 0) {
            // 找到了 val
            if (root.left != null && root.right != null) {
                // 有两个子节点
                root.element = findMin(root.right).element;
                root.right = remove( root.right, (Integer) root.element);
            } else {
                /*// 左孩子
                if (root.left != null) {
                    root = root.left;
                }
                // 右孩子
                if (root.right != null) {
                    root = root.right;
                }
                // 无孩子
                if (root.left == null && root.right == null) {
                    root = null;
                }*/
                root = root.left != null ? root.left : root.right;
            }

        } else if (compare < 0) {
            // 在该当前节点的左子树中查找
            root.left = remove(root.left, val);
        } else {
            // 在当前节点的右子树中查找
            root.right = remove(root.right, val);
        }
        return root;
    }

    public static void main(String[] args) {
        /**
         *           6
         *        /     \
         *       2       9
         *      / \     / \
         *     1   4   7  11
         *        / \   \   \
         *       3   5   8  12
         */
        ADT adt = new ADT();
        Node root = adt.insert(null, 6);
        adt.insert(root, 2);
        adt.insert(root, 1);
        adt.insert(root, 4);
        adt.insert(root, 3);
        adt.insert(root, 9);
        adt.insert(root, 7);
        adt.insert(root, 11);
        adt.insert(root, 5);
        adt.insert(root, 8);
        adt.insert(root, 12);
        adt.insert(root, 15);
        System.out.println(adt.contains(root, 5));
        System.out.println(adt.contains(root, 20));
        System.out.println("min = "+adt.findMin(root).element+"\tmax = "+ adt.findMax(root).element);
        adt.remove(root, 11);
        System.out.println(root);



    }
}
