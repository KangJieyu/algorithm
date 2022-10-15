package doublylist;

/**
 * 双链表操作
 * @Date: 2022/10/15 09:26
 * @Author: KangJieyu
 */
public class DoublyListOperate {

    /**
     * 双链表中添加节点
     * @param head 双链表头节点
     * @param target 插入位置的前一个节点
     * @param val 添加节点的值
     * @return 添加节点后链表头节点
     */
    public static DoublyListNode add(DoublyListNode head, Integer target, Integer val) {
        DoublyListNode node = new DoublyListNode();
        node.next = head;
        // 当前节点，即为插入位置的前一个节点
        DoublyListNode pre = head;
        // 开头插入
        if (target == null) {
            DoublyListNode cur = new DoublyListNode(val);
            cur.next = head;
            if (head != null) {
                head.prev = cur;
            }
            node.next = cur;
            return node.next;
        }
        while (pre != null) {
            // 找到了位置
            if (pre.val == target) {
                // 创建插入节点
                DoublyListNode cur = new DoublyListNode(val);
                // 修改插入节点的前指针指向和后指针指向
                cur.prev = pre;
                cur.next = pre.next;
                // 修改pre的下一个指向和pre.next的前一个指向
                // 验证pre.next是否为空，为空时表明双链表末尾插入
                if (pre.next != null) {
                    pre.next.prev = cur;
                }
                pre.next = cur;
            }
            pre = pre.next;
        }
        return node.next;
    }

    /**
     * 删除双链表中的目标节点
     * @param head 双链表头节点
     * @param target 目标节点，即为要删除的节点
     * @return 删除后链表的头节点
     */
    public static DoublyListNode delete(DoublyListNode head, int target) {
        if (head == null) {
            return null;
        }
        DoublyListNode node = new DoublyListNode();
        node.next = head;
        DoublyListNode cur = head;
        while (cur != null) {
            // 找到了目标节点
            if (cur.val == target) {
                // 删除头节点
                if (cur.prev == null) {
                    if (cur.next != null) {
                        cur.next.prev = null;
                        node.next = cur.next;
                    } else {
                        node.next = null;
                    }
                } else {
                    cur.prev.next = cur.next;
                    // cur.next == null 为删除尾节点
                    if (cur.next != null) {
                        cur.next.prev = cur.prev;
                    }
                }
            }
            cur = cur.next;
        }
        return node.next;
    }

}
