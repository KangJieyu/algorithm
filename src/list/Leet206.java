package list;

/**
 * 206. 反转链表
 * 给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
 * 原地反转法
 * @Date: 2022/10/3 14:13
 * @Author: KangJieyu
 */
public class Leet206 {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        // 保护头节点
        ListNode node = new ListNode(-1);
        node.next = head;
        // pre固定不变
        ListNode pre = head;
        ListNode post = pre.next;
        while (post != null) {
            pre.next = post.next;
            post.next = node.next;
            node.next = post;
            post = pre.next;
        }
        return node.next;
    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4, 5};
        ListNode head = ListNode.create(arr);
        ListNode node = reverseList(head);
        System.out.println(node);
    }
}