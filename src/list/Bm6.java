package list;

import java.util.*;

/**
 * BM6 判断链表中是否有环
 *
 * 描述
 * 判断给定的链表中是否有环。如果有环则返回true，否则返回false。
 *
 * 输入分为两部分，第一部分为链表，第二部分代表是否有环，然后将组成的head头结点传入到函数里面。-1代表无环，
 * 其它的数字代表有环，这些参数解释仅仅是为了方便读者自测调试。实际在编程时读入的是链表的头节点。
 *
 * 例如输入{3,2,0,-4},1时，对应的链表结构如下图所示：
 *
 * 可以看出环的入口结点为从头结点开始的第1个结点（注：头结点为第0个结点），所以输出true。
 *
 * 示例1
 * 输入：{3,2,0,-4},1
 * 返回值：true
 * 说明：第一部分{3,2,0,-4}代表一个链表，第二部分的1表示，-4到位置1（注：头结点为位置0），
 * 即-4->2存在一个链接，组成传入的head为一个带环的链表，返回true
 *
 * 示例2
 * 输入：{1},-1
 * 返回值：false
 * 说明：第一部分{1}代表一个链表，-1代表无环，组成传入head为一个无环的单链表，返回false
 *
 * 示例3
 * 输入：{-1,-7,7,-4,19,6,-9,-5,-2,-5},6
 * 返回值：true
 *
 * @Author: KangJieyu
 * @Date: 2022/4/5 下午9:13
 */
public class Bm6 {

    public static boolean hasCycle(ListNode head) {
        ListNode node = head;
        Set<ListNode> set = new HashSet<>();
        set.add(node);
        while (node != null) {
            node = node.next;
            if (set.contains(node)) {
                return true;
            }
            set.add(node);
        }
        return false;
    }

    public static void main(String[] args) {
        // {3,2,0,-4},1
        ListNode node3 = new ListNode(3);
        ListNode node2 = new ListNode(2);
        ListNode node0 = new ListNode(0);
        ListNode node_4 = new ListNode(-4);
        node3.next = node2;
        node2.next = node0;
        node0.next = node_4;
//        node_4.next = node2;
        System.out.println(Bm6.hasCycle(node3));

    }

}
