package list;

import java.util.List;

/**
 * NC23 划分链表
 *
 * 描述
 * 给出一个长度为 n 的单链表和一个值 x ，单链表的每一个值为 listi ，请返回一个链表的头结点，要求新链表中小于 x 的节点全部在大于等于
 * x 的节点左侧，并且两个部分之内的节点之间与原来的链表要保持相对顺序不变。
 *
 * 例如：
 * 给出 1→4→3→2→5→2 和 x=3 返回 1→2→2→4→3→5
 *
 * 示例1
 * 输入： {1,4,3,2,5,2},3
 * 返回值： {1,2,2,4,3,5}
 *
 * 示例2
 * 输入： {1,2,3,4,1},5
 * 返回值： {1,2,3,4,1}
 *
 * @Author: KangJieyu
 * @Date: 2022/4/12 下午8:40
 */
public class Nc23 {
    public static ListNode partition (ListNode head, int x) {
        if (head == null) {
            return null;
        }
        ListNode node = head;
        // 声明前一个节点
        ListNode pre = null;
        // 声明最后一个节点
        ListNode last = null;
        // 节点个数
        int count = 0;
        while (node != null) {
            count ++;
            System.out.println(count);
            if (node.next == null) {
                last = node;
            }
            node = node.next;
        }
        // 重新赋值
        node = head;
        // 确定返回的头节点
        ListNode res = node;
        if (res.val < x) {
            res = node;
        } else {
            boolean boo = true;
            // 遍历链表，找出第一个小于x的节点
            while (node != null) {
                if (node.val < x) {
                    res = node;
                    boo = false;
                    break;
                }
                node = node.next;
            }
            // 若链表里的节点值都比x要大，则返回的头节点为链表的最后一个节点
            if (boo) {
                res = last;
            }
        }
        node = head;
        while (node != null) {
            if (count <= 0) {
                break;
            }
            count --;
            int value = node.val;
            if (value >= x) {
                if (pre != null) {
                    pre.next = node.next;
                }
                ListNode temp = node;
                node = node.next;
                temp.next = null;
                last.next = temp;
                last = temp;
            } else {
                pre = node;
                node = node.next;
            }
        }
        return res;
    }

    public static void main(String[] args) {
//        5,2,3,4,1     5
//        ListNode node1 = new ListNode(5);
//        ListNode node4 = new ListNode(2);
//        ListNode node3 = new ListNode(3);
//        ListNode node2 = new ListNode(4);
//        ListNode node5 = new ListNode(1);
//        node1.next = node4;
//        node4.next = node3;
//        node3.next = node2;
//        node2.next = node5;

//        1→4→3→2→5→2   3
//        ListNode node1 = new ListNode(1);
//        ListNode node4 = new ListNode(4);
//        ListNode node3 = new ListNode(3);
//        ListNode node2 = new ListNode(2);
//        ListNode node5 = new ListNode(5);
//        ListNode node2_2 = new ListNode(2);
//        node1.next = node4;
//        node4.next = node3;
//        node3.next = node2;
//        node2.next = node5;
//        node5.next = node2_2;

//        1 0
//        ListNode node1 = new ListNode(4);
//        ListNode node1_1 = new ListNode(3);
//        ListNode node1_1_1 = new ListNode(5);
//        node1.next = node1_1;
//        node1_1.next = node1_1_1;

        ListNode node1 = new ListNode(1);
        ListNode node2 = new ListNode(2);
        node1.next = node2;

//        ListNode res = Nc23.partition(node1, 3);
//        ListNode res = Nc23.partition(node1, 5);
//        ListNode res = Nc23.partition(node1, 4);
        ListNode res = Nc23.partition(node1, 0);
        System.out.println(res);
    }

}
