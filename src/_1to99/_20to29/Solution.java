package _1to99._20to29;

import bean.LinkedNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author YuJoy
 * @date 2021/3/5 20:49
 * @description: 21-30题
 */
public class Solution {
    /**
     * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
     */
    private LinkedNode mergeTwoLists(LinkedNode l1, LinkedNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        LinkedNode prehead = new LinkedNode(-1);
        LinkedNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     */
    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        backTrack(list, 0, 0, n, stringBuilder);
        return list;
    }

    private void backTrack(List<String> list, int left, int right, int max, StringBuilder stringBuilder) {
        if (stringBuilder.length() == max * 2) {
            list.add(stringBuilder.toString());
            return;
        }

        if (left < max) {
            stringBuilder.append("(");
            backTrack(list, left + 1, right, max, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }

        if (right < left) {
            stringBuilder.append(")");
            backTrack(list, left, right + 1, max, stringBuilder);
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
    }

    /**
     * 给你一个链表数组，每个链表都已经按升序排列。
     * <p>
     * 请你将所有链表合并到一个升序链表中，返回合并后的链表。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入：lists = [[1,4,5],[1,3,4],[2,6]]
     * 输出：[1,1,2,3,4,4,5,6]
     * 解释：链表数组如下：
     * [
     * 1->4->5,
     * 1->3->4,
     * 2->6
     * ]
     * 将它们合并到一个有序链表中得到。
     * 1->1->2->3->4->4->5->6
     * 示例 2：
     * <p>
     * 输入：lists = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：lists = [[]]
     * 输出：[]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-k-sorted-lists
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public LinkedNode mergeKLists(LinkedNode[] lists) {
        return merge(lists, 0, lists.length - 1);
    }

    public LinkedNode merge(LinkedNode[] lists, int l, int r) {
        if (l == r) {
            return lists[l];
        }
        if (l > r) {
            return null;
        }
        int mid = (l + r) >> 1;
        return mergeTwoLists(merge(lists, l, mid), merge(lists, mid + 1, r));
    }


    /**
     * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
     * <p>
     * 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4]
     * 输出：[2,1,4,3]
     * 示例 2：
     * <p>
     * 输入：head = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：head = [1]
     * 输出：[1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/swap-nodes-in-pairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public LinkedNode swapPairs(LinkedNode head) {
        LinkedNode nullNode = new LinkedNode();
        nullNode.next = head;
        LinkedNode changeNode = nullNode;
        while (changeNode.next != null && changeNode.next.next != null) {
            LinkedNode firstNode = changeNode.next;
            LinkedNode secondNode = changeNode.next.next;
            changeNode.next = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;
            changeNode = firstNode;
        }
        return nullNode.next;
    }

    /**
     * 给你一个链表，每k个节点一组进行翻转，请你返回翻转后的链表。
     * <p>
     * k是一个正整数，它的值小于或等于链表的长度。
     * <p>
     * 如果节点总数不是k的整数倍，那么请将最后剩余的节点保持原有顺序。
     * <p>
     * 进阶：
     * <p>
     * 你可以设计一个只使用常数额外空间的算法来解决此问题吗？
     * 你不能只是单纯的改变节点内部的值，而是需要实际进行节点交换。
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[2,1,4,3,5]
     * <p>
     * 输入：head = [1,2,3,4,5], k = 3
     * 输出：[3,2,1,4,5]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-nodes-in-k-group
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public LinkedNode reverseKGroup(LinkedNode head, int k) {
        //1.创建一个节点，next指向head
        LinkedNode beforeHeadNode = new LinkedNode(0);
        beforeHeadNode.next = head;
        LinkedNode tempNode = beforeHeadNode;
        while (head != null) {
            //3.从head节点之前的节点开始循环，k次之后，从tempNode到lastOfKNode就是需要反转的链表
            LinkedNode lastOfKNode = tempNode;
            for (int i = 0; i < k; i++) {
                lastOfKNode = lastOfKNode.next;
                if (lastOfKNode == null) {
                    //4.说明不足k个，直接返回
                    return beforeHeadNode.next;
                }
            }
            //5.找到待反转链表之后的节点，反转之后需要连接
            LinkedNode nextOfKNode = lastOfKNode.next;
            //6.链表反转
            LinkedNode[] reversalNode = reversalNode(head, lastOfKNode);

            head = reversalNode[0];
            lastOfKNode = reversalNode[1];

            //7.反转之后的头节点和之前添加的空节点连接
            tempNode.next = head;
            //8.反转之后的尾节点指向之前的nextOfKNode
            lastOfKNode.next = nextOfKNode;
            //9.连接完成，需要将之前空节点移动k个节点，即为反转链表的尾节点，等待下一次反转
            tempNode = lastOfKNode;
            //10.和之前一致，移动遍历的链表到tempNode后面
            head = tempNode.next;
        }
        return beforeHeadNode.next;
    }

    /**
     * 链表反转
     */
    private LinkedNode[] reversalNode(LinkedNode head, LinkedNode last) {
        LinkedNode prev = last.next;
        LinkedNode p = head;
        while (prev != last) {
            LinkedNode next = p.next;
            p.next = prev;
            prev = p;
            p = next;
        }
        //反转之后，last为头节点，head为尾节点
        return new LinkedNode[]{last, head};
    }

    /**
     * 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * <p>
     * <p>
     * 示例1:
     * <p>
     * 给定数组 nums = [1,1,2],
     * <p>
     * 函数应该返回新的长度 2, 并且原数组 nums 的前两个元素被修改为 1, 2。
     * <p>
     * 你不需要考虑数组中超出新长度后面的元素。
     * 示例2:
     * <p>
     * 给定 nums = [0,0,1,1,1,2,2,3,3,4],
     * <p>
     * 函数应该返回新的长度 5, 并且原数组 nums 的前五个元素被修改为 0, 1, 2, 3, 4。
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        /*
           思考：O(1)的额外空间，说明只能使用一个变量，很容易想到这个变量是int类型
           原地删除，说明只能交换复制，例如nums[2]=3,返回值也是int,需要新赋值的角标
           即为第几个不重复的数字
         */
        if (nums.length == 0) {
            return 0;
        }
        //1.默认有一个不重复的数字
        int count = 1;
        for (int i = 1; i < nums.length; i++) {
            //2.此时出现不重复的数字
            if (nums[i] != nums[i - 1]) {
                nums[count] = nums[i];
                count++;
            }
        }
        return count;
    }

    /**
     * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素，并返回移除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
     * <p>
     * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * 输入：nums = [3,2,2,3], val = 3
     * 输出：2, nums = [2,2]
     * 解释：函数应该返回新的长度 2, 并且 nums 中的前两个元素均为 2。你不需要考虑数组中超出新长度后面的元素。例如，函数返回的新长度为 2 ，而 nums = [2,2,3,3] 或 nums = [2,2,0,0]，也会被视作正确答案。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-element
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param val
     * @return
     */
    public int removeElement(int[] nums, int val) {
        /*
           思考，和上面一题一样 O(1) 额外空间 只能使用一个常量
           思路就是遍历nums，找到一个角标same等于val的值(nums[same]==val)，然后再从same+1开始找，
           找到一个角标为diff,不等于val的值nums[diff]!=val,然后交换位置
         */
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != val) {
                        nums[count] = nums[j];
                        nums[j] = val;
                        count++;
                        break;
                    }
                }
            } else {
                count++;
            }
        }
        return count;
    }

    /**
     * 实现strStr()函数。
     * <p>
     * 给定一个haystack 字符串和一个 needle 字符串，在 haystack 字符串中找出 needle 字符串出现的第一个位置 (从0开始)。如果不存在，则返回 -1。
     * <p>
     * 示例 1:
     * <p>
     * 输入: haystack = "hello", needle = "ll"
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: haystack = "aaaaa", needle = "bba"
     * 输出: -1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/implement-strstr
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int strStr(String haystack, String needle) {
        int needleLength = needle.length();
        if (needleLength == 0) {
            return 0;
        }
        for (int i = 0; i < haystack.length() - needleLength + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (i + needleLength < haystack.length() + 1 && haystack.substring(i, i + needleLength).equals(needle)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * 给定两个整数，被除数dividend和除数divisor。将两数相除，要求不使用乘法、除法和 mod 运算符。
     * <p>
     * 返回被除数dividend除以除数divisor得到的商。
     * <p>
     * 整数除法的结果应当截去（truncate）其小数部分，例如：truncate(8.345) = 8 以及 truncate(-2.7335) = -2
     * <p>
     * <p>
     * <p>
     * 示例1:
     * <p>
     * 输入: dividend = 10, divisor = 3
     * 输出: 3
     * 解释: 10/3 = truncate(3.33333..) = truncate(3) = 3
     * 示例2:
     * <p>
     * 输入: dividend = 7, divisor = -3
     * 输出: -2
     * 解释: 7/-3 = truncate(-2.33333..) = -2
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/divide-two-integers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int divide(int dividend, int divisor) {
        boolean isPositive = (dividend > 0) ^ (divisor > 0);
        int count = 0;
        //1.int型最大为2147483647，最小为-2147483648，正数先转成负数，是不会越界的
        dividend = dividend > 0 ? -dividend : dividend;
        divisor = divisor > 0 ? -divisor : divisor;
        while (dividend <= divisor) {
            int tempResult = -1;
            int tempDivisor = divisor;
            while (dividend <= (tempDivisor << 1)) {
                if (tempDivisor <= (Integer.MIN_VALUE >> 1)) break;
                tempResult = tempResult << 1;
                tempDivisor = tempDivisor << 1;
            }
            dividend = dividend - tempDivisor;
            count += tempResult;
        }
        if (!isPositive) {
            if (count <= Integer.MIN_VALUE) return Integer.MAX_VALUE;
            count = -count;
        }
        return count;
    }
}
