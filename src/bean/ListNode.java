package bean;

/**
 * @author YuJoy
 * @date 2020/12/17 20:44
 * @description: 链表的Node
 */
public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
