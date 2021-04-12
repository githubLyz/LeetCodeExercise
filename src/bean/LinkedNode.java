package bean;

/**
 * @author YuJoy
 * @date 2020/12/17 20:44
 * @description: 链表的Node
 */
public class LinkedNode {
    public int val;
    public LinkedNode next;

    public LinkedNode() {
    }

    public LinkedNode(int val) {
        this.val = val;
    }

    public LinkedNode(int val, LinkedNode next) {
        this.val = val;
        this.next = next;
    }
}
