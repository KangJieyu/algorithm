package list;

/**
 * BM10 两个链表的第一个公共结点
 *
 * 描述
 * 输入两个无环的单向链表，找出它们的第一个公共结点，如果没有公共节点则返回空。
 * （注意因为传入数据是链表，所以错误测试数据的提示是用其他方式显示的，保证传入数据是正确的）
 *
 * 数据范围： n≤1000
 * 要求：空间复杂度 O(1)，时间复杂度 O(n)
 *
 * 例如，输入{1,2,3},{4,5},{6,7}时，两个无环的单向链表的结构如下图所示：
 * 1 -> 2 -> 3
 *            \
 *   4 -> 5 -> 6 -> 7
 * 可以看到它们的第一个公共结点的结点值为6，所以返回结点值为6的结点。
 *
 * 输入描述： 输入分为是3段，第一段是第一个链表的非公共部分，第二段是第二个链表的非公共部分，第三段是第一个链表和第二个链表的公共部分。
 *          后台会将这3个参数组装为两个链表，并将这两个链表对应的头节点传入到函数FindFirstCommonNode里面，用户得到的输入只有pHead1和pHead2。
 * 返回值描述： 返回传入的pHead1和pHead2的第一个公共结点，后台会打印以该节点为头节点的链表。
 *
 * 示例1
 * 输入： {1,2,3},{4,5},{6,7}
 * 返回值： {6,7}
 * 说明： 第一个参数{1,2,3}代表是第一个链表非公共部分，第二个参数{4,5}代表是第二个链表非公共部分，最后的{6,7}表示的是2个链表的公共部分 这3个参数最后在后台会组装成为2个两个无环的单链表，且是有公共节点的
 *
 * 示例2
 * 输入： {1},{2,3},{}
 * 返回值： {}
 * 说明： 2个链表没有公共节点 ,返回null，后台打印{}
 *
 * @Author: KangJieyu
 * @Date: 2022/6/3 下午3:39
 */
public class Bm10 {

    public static ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        ListNode node1 = pHead1;
        ListNode node2 = pHead2;
        int count = 0;
        while (node1 != null && node2 != null) {
            if (node1 == node2) {
                return node1;
            }
            node1 = node1.next;
            node2 = node2.next;
            if (node1 == null) {
                count++;
                node1 = pHead2;
            }
            if (node2 == null) {
                count++;
                node2 = pHead1;
            }
            if (count == 3) {
                break;
            }
        }
        return null;
    }

    public static void main(String[] args) {
//        ListNode pHead1 = new ListNode(1);
//        pHead1.next = new ListNode(2);
//        pHead1.next.next = new ListNode(3);
//        pHead1.next.next.next = new ListNode(4);
//        ListNode pHead2 = new ListNode(5);
//        pHead2.next = new ListNode(6);
//        pHead2.next.next = new ListNode(7);
//        ListNode res = Bm10.FindFirstCommonNode(pHead1, pHead2);
//        System.out.println(res);
        if (2 < 1 || 3 > 5) {
            System.out.println("eee");
        }
    }
}
