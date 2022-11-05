package list;

/**
 * 92. 反转链表 II
 * 给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。
 * 请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
 * @Date: 2022/11/5 10:44
 * @Author: KangJieyu
 */
public class Leet92 {

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode node = new ListNode(0);
        node.next = head;
        // left 位置的前一个节点
        ListNode pre = node;
        // left 位置的节点
        ListNode first = head;
        // right 位置的节点
        ListNode end = head;
        // 获得反转链表区间
        for (int n = left; n < right; n++) {
            end = end.next;
        }
        for (int n = 1; n < left; n++) {
            pre = first;
            first = first.next;
            end = end.next;
        }
        // right 位置的后一个节点
        ListNode post = end.next;
        // 反转区间为 pre -> first -> node..... -> end -> post；不包含 pre 和 post
        // 反转方式：让后一个节点前移
        while (first.next != post && first.next != null) {
            // 防止要前置的节点丢失
            ListNode temp = first.next;
            first.next = temp.next;
            temp.next = pre.next;
            pre.next = temp;
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
//        head.next = new ListNode(2);
//        head.next.next = new ListNode(3);
//        head.next.next.next = new ListNode(4);
//        head.next.next.next.next = new ListNode(5);
        ListNode res = reverseBetween(head, 1, 1);
        System.out.println(res);
    }

}
