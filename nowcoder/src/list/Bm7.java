package list;

import java.util.Set;
import java.util.HashSet;

/**
 * BM7 链表中环的入口结点
 * 题目
 * 描述
 * 给一个长度为n链表，若其中包含环，请找出该链表的环的入口结点，否则，返回null。
 *
 * 例如，输入{1,2},{3,4,5}时，对应的环形链表如下图所示：  可以看到环的入口结点的结点值为3，所以返回结点值为3的结点。
 *
 * 输入描述： 输入分为2段，第一段是入环前的链表部分，第二段是链表环的部分，后台会根据第二段是否为空将这两段组装成一个无环或者有环单链表
 * 返回值描述： 返回链表的环的入口结点即可，我们后台程序会打印这个结点对应的结点值；若没有，则返回对应编程语言的空结点即可。
 *
 * 示例1
 * 输入： {1,2},{3,4,5}
 * 返回值： 3
 * 说明： 返回环形链表入口结点，我们后台程序会打印该环形链表入口结点对应的结点值，即3
 *
 * 示例2
 * 输入： {1},{}
 * 返回值： "null"
 * 说明： 没有环，返回对应编程语言的空结点，后台程序会打印"null"
 *
 * 示例3 输入： {},{2}
 * 返回值： 2
 * 说明： 环的部分只有一个结点，所以返回该环形链表入口结点，后台程序打印该结点对应的结点值，即2
 *
 * @Author: KangJieyu
 * @Date: 2022/4/5 下午9:59
 */
public class Bm7 {
    public static ListNode entryNodeOfLoop(ListNode pHead) {
        ListNode node = pHead;
        Set<ListNode> set = new HashSet<>();
        set.add(node);
        while (node != null) {
            node = node.next;
            // 判断是否有环，有则返回入口
            if (set.contains(node)) {
                return node;
            }
            set.add(node);
        }
        return null;
    }

    public static void main(String[] args) {
        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
//        node5.next = node3;
        ListNode res = Bm7.entryNodeOfLoop(node1);
        System.out.println();
    }
}
