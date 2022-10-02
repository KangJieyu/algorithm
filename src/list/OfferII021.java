package list;

/**
 * 剑指 Offer II 021. 删除链表的倒数第 n 个结点
 * 给定一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * 方式一：
 * 先计算链表节点总个数，在找删除的目标节点，最后删除
 *
 * 方式二：
 * 快慢指针
 *
 * @Date: 2022/10/2 12:56
 * @Author: jieyukang
 */
public class OfferII021 {

    public static ListNode removeNthFromEnd1(ListNode head, int n) {
        // 保护头节点
        ListNode node = new ListNode(-1);
        node.next = head;
        // 链表节点个数
        int count = 0;
        // 当前节点
        ListNode cur = head;
        // 前一个节点
        ListNode pre = node;
        // 计算节点个数
        while (cur != null) {
            count++;
            cur = cur.next;
        }
        // 重置当前节点
        cur = head;
        // 找倒数n个节点
        for (int i = 0; i < count - n; i++) {
            pre = cur;
            cur = cur.next;
        }
        // 删除节点
        pre.next = cur.next;
        return node.next;
    }
    public static ListNode removeNthFromEnd2(ListNode head, int n) {
        // 保护头节点
        ListNode node = new ListNode(-1);
        node.next = head;
        // 设置快慢指针和慢指针的前一个节点
        ListNode fast = node;
        ListNode slow = head;
        ListNode pre = node;
        // 先让快指针走n个
        for (int i = 0; i < n; i++) {
            if (fast == null) {
                break;
            }
            fast = fast.next;
        }
        // 快慢指针和pre指针一个一个往前走，直到fast为空
        while (fast.next != null) {
            fast = fast.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = slow.next;
        return node.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
//        ListNode listNode = removeNthFromEnd2(head, 3);
        ListNode listNode1 = removeNthFromEnd1(head, 3);
//        System.out.println(listNode);

    }
}
