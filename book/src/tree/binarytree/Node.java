package tree.binarytree;

/**
 * 数节点的声明
 *
 * @Author: KangJieyu
 * @DATE: 2022/2/2 下午1:19
 */
class Node {
    Object element;
    Node left;
    Node right;

    public Node() {

    }

    public Node(Object element) {
        this.element = element;
    }
}
