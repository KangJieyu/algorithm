package tree;

/**
 *
 NC184 判断是不是二叉搜索树

 描述
 给定一个二叉树根节点，请你判断这棵树是不是二叉搜索树。

 二叉搜索树满足每个节点的左子树上的所有节点均小于当前节点且右子树上的所有节点均大于当前节点。


 数据范围：节点数量满足 1≤n≤104，节点上的值满足 −2^31≤val≤2^31−1

 示例1
 输入：{1,2,3}
 返回值：false
   1
  / \
 2   3

 示例2
 输入：{2,1,3}
 返回值：true
   2
  / \
 1   3
 * @Author: KangJieyu
 * @DATE: 2022/2/25 下午5:13
 */
public class Nc184 {

    public static boolean isValidBST (TreeNode root) {
        // write code here
        if (root == null) {
            return true;
        }
        boolean left = true;
        boolean right = true;
        if (root.left != null) {
            if (root.left.val < root.val) {
                left = isValidBST(root.left);
            } else {
                return false;
            }
        }
        if (root.right != null) {
            if (root.right.val > root.val) {
                right = isValidBST(root.right);
            } else {
                return false;
            }
        }
        return left && right;
    }

    public static void main(String[] args) {
//               3
//              / \
//             2   5
//            / \
//           1   4
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(4);
        System.out.println(Nc184.isValidBST(root));

    }
}
