package list;

/**
 * @Author: KangJieyu
 * @Date: 2022/4/5 下午9:22
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
        next = null;
    }

    /**
     * 根据数组元素创建链表
     * @param arr 数组中的元素依次代表链表中的元素
     * @return 返回创建链表的头节点
     */
    public static ListNode create(int[] arr) {
        // 判空操作
        if (arr == null || arr.length == 0) {
            return null;
        }
        // 以数组第一个元素为头节点
        ListNode head = new ListNode(arr[0]);
        // 创建当前节点，用于连接的中间节点
        ListNode cur = head;
        // 从第二个元素开始遍历数组，创建节点，指定指针
        for (int i = 1; i < arr.length; i++) {
            // 创建i索引元素的节点
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        return head;
    }
}
