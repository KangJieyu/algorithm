package tree.tree;

/**
 * 数的实现
 *    A
 *   /
 *  B——C——D——E————F——————G
 *       /  /    /       \
 *      H  I——J K——L——M   N
 *           /
 *          P——Q
 *
 * @Author: KangJieyu
 * @DATE: 2022/1/28 上午11:19
 */
class TreeNode {
    Object element;
    /**
     * 指向第一个儿子（向下）
     */
    TreeNode firstChild;
    /**
     * 指向兄弟（水平）
     */
    TreeNode nextSibling;
}
