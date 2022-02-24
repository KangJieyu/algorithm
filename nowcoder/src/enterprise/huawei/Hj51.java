package enterprise.huawei;

import java.util.Scanner;

/**
 *
 HJ51 输出单向链表中倒数第k个结点
 描述

 输入一个单向链表，输出该链表中倒数第k个结点，链表的倒数第1个结点为链表的尾指针。

 链表结点定义如下：
 struct ListNode {
    int m_nKey;
    ListNode* m_pNext;
 };

 正常返回倒数第k个结点指针，异常返回空指针

 数据范围：链表长度满足 1≤n≤1000，k≤n，链表中数据满足 0≤val≤10000
 本题有多组样例输入。

 输入描述：
        1 输入链表结点个数
        2 输入链表的值
        3 输入k的值
 输出描述：
        输出一个整数
 示例：
 输入：
    8
    1 2 3 4 5 6 7 8
    4
 输出：
    5
 * @Author: KangJieyu
 * @DATE: 2022/2/21 下午2:46
 */
public class Hj51 {

    /**
     * 构建链表
     * @param n 节点个数
     * @param s 链表值
     * @return  链表头节点
     */
    public static ListNode getList(int n, String s) {
        String[] strings = s.split(" ");
        ListNode head = new ListNode();
        head.m_nKey = Integer.valueOf(strings[0]);
        ListNode temp = head;
        for (int i = 1; i < n; i++) {
            ListNode node = new ListNode();
            node.m_nKey = Integer.valueOf(strings[i]);
            temp.n_pNext = node;
            temp = node;
        }
        return head;
    }

    /**
     * 返回单链表的倒数第 k 个节点
     * @param n 链表的个数
     * @param head 链表的头
     * @param k 返回节点的位置
     * @return 正常返回节点，否则返回{@code null}
     */
    public static ListNode getKth(int n, ListNode head, int k) {
        if (k <= 0) {
            return null;
        }
        ListNode temp = head;
        for (int i = 1; i+k<=n; i++) {
            temp = temp.n_pNext;
        }
        return temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            // 个数
            int n = Integer.valueOf(sc.nextLine());
            // 链表值
            String s = sc.nextLine();
            // k的值
            int k = Integer.valueOf(sc.nextLine());
            ListNode head = getList(n, s);
            ListNode node = getKth(n, head, k);
            if (node == null) {
                System.out.println(0);
            } else {
                System.out.println(node.m_nKey);
            }
        }
    }
}
class ListNode {
    int m_nKey;
    ListNode n_pNext;
}
