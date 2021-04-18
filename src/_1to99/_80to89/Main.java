package _1to99._80to89;

import bean.LinkedNode;

/**
 * @author YuJoy
 * @date 2021/4/18 14:05
 * @description: 80~89Main
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //80.删除有序数组中的重复项 II
//        solution.removeDuplicates(new int[]{0,0,1,1,1,1,2,3,3});
        //81. 搜索旋转排序数组 II
//        solution.search(new int[]{0,0,1,2,2,5,6},3);
        LinkedNode linkedNode1 = new LinkedNode(1);
        LinkedNode linkedNode2 = new LinkedNode(1);
        LinkedNode linkedNode3 = new LinkedNode(3);
        LinkedNode linkedNode4 = new LinkedNode(3);
        LinkedNode linkedNode5 = new LinkedNode(4);
        LinkedNode linkedNode6 = new LinkedNode(4);
        LinkedNode linkedNode7 = new LinkedNode(5);
        linkedNode1.next = linkedNode2;
//        linkedNode2.next = linkedNode3;
//        linkedNode3.next = linkedNode4;
//        linkedNode4.next = linkedNode5;
//        linkedNode5.next = linkedNode6;
//        linkedNode6.next = linkedNode7;
        solution.deleteDuplicates(linkedNode1);
    }
}
