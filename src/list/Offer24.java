package list;

/**
 * 剑指 Offer 24. 反转链表
 * 头插法：
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * @Date: 2022/10/3 19:26
 * @Author: KangJieyu
 */
public class Offer24 {
    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode node = new ListNode(-1);
        ListNode pre = head;
        ListNode post = head.next;
        while (pre != null) {
            pre.next = node.next;
            node.next = pre;
            pre = post;
            if (post != null) {
                post = post.next;
            }
        }
        return node.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNode.create(new int[]{1,2,3,4,5});
        ListNode listNode = reverseList(head);
        System.out.println(listNode);
    }
}
