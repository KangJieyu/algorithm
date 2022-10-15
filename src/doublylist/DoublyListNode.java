package doublylist;

/**
 * 定义双链表节点信息
 * @Date: 2022/10/15 09:23
 * @Author: KangJieyu
 */
public class DoublyListNode {
    int val;
    DoublyListNode prev;
    DoublyListNode next;

    public DoublyListNode() {
    }

    public DoublyListNode(int val) {
        this.val = val;
    }
}
