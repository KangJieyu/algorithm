package list;

/**
 * 237. 删除链表中的节点
 * 有一个单链表的 head，我们想删除它其中的一个节点 node。
 *
 * 给你一个需要删除的节点 node 。你将 <b>无法访问 第一个节点  head</b>。
 *
 * 链表的所有值都是 唯一的，并且保证<b>给定的节点 node 不是链表中的最后一个节点</b>。
 * 删除给定的节点。注意，删除节点并不是指从内存中删除它。这里的意思是：
 * 给定节点的值不应该存在于链表中。
 * 链表中的节点数应该减少 1。
 * node 前面的所有值顺序相同。
 * node 后面的所有值顺序相同。
 *
 * 自定义测试：
 * 对于输入，你应该提供整个链表 head 和要给出的节点 node。node 不应该是链表的最后一个节点，而应该是链表中的一个实际节点。
 * 我们将构建链表，并将节点传递给你的函数。
 * 输出将是调用你函数后的整个链表。
 * @Date: 2022/10/22 21:30
 * @Author: KangJieyu
 */
public class Leet237 {
    public static void deleteNode(ListNode node) {
        // 4,  5,     1,      9,      10   删除 5
        //    post
        // 4   1      1       9       10
        //    pre    post
        // 4   1      9       9       10
        //           pre     post
        // 4   1      9      10       10
        //                   pre      post
        // pre 为要删除节点的前一个节点
        ListNode pre = null;
        // 遍历的当前节点，需将 post.val = post.next.val 值替换
        // 当post.next = null 时停止
        ListNode post = node;
        while (post.next != null) {
            pre = post;
            post.val = post.next.val;
            post = post.next;
        }
        pre.next = null;
    }

    public static void main(String[] args) {
        // 4,5,1,9,10
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(10);
        deleteNode(head.next);
        System.out.println(head);
    }
}
