package tenExercise;

import bean.LinkedNode;

/**
 * @author YuJoy
 * @date 2020/12/17 20:46
 * @description: LeetCode 1-10题解
 */
public class TenSolution {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     *
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 示例:
     *
     * 给定 nums = [2, 7, 11, 15], target = 9
     *
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int numOne = nums[i];
            for (int j = i + 1; j < nums.length ; j++) {
                if (numOne + nums[j] == target) {
                    result[0] = i;
                    result[1] = j;
                }
            }
        }
        return result;
    }

    /**
     * 给出两个 非空 的链表用来表示两个非负的整数。其中，它们各自的位数是按照 逆序 的方式存储的，并且它们的每个节点只能存储 一位 数字。
     *
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     *
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     *
     * 示例：
     *
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public LinkedNode addTwoNumbers(LinkedNode l1, LinkedNode l2) {
        //创建头节点，方便返回值
        LinkedNode headNode = new LinkedNode(-1);
        LinkedNode addNode = new LinkedNode();
        headNode.next = addNode;
        //标记位，不为0说明两数相加大于10，需要处理进位逻辑
        int needAdd = 0;
        //完整循环，需要处理一个链表遍历完之后，needAdd不为0，并且另一个链表剩下的节点val为9的特殊情况
        while (l1 != null || l2 != null) {
            //判空处理
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            LinkedNode LinkedNode = new LinkedNode();
            if (num1 + num2 + needAdd > 9) {
                LinkedNode.val = num1 + num2 + needAdd - 10;
                needAdd = 1;
            } else {
                LinkedNode.val = num1 + num2 + needAdd;
                needAdd = 0;
            }
            addNode.next = LinkedNode;
            addNode = addNode.next;
            //判空处理
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        //两个链表遍历完之后，needAdd不为0，说明还要进位1，创建新的节点，val为1
        if (needAdd != 0) {
            addNode.next = new LinkedNode(1);
        }
        return headNode.next.next;
    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     *
     *  
     *
     * 示例 1:
     *
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     *
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     *
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     *
     * 输入: s = ""
     * 输出: 0
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-substring-without-repeating-characters
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int lengthOfLongestSubstring(String s) {
        int length = s.length();
        //两个指针，slow记录上次出现当前字符的位置，fast一直移动
        int max = 0, slow = 0, fast = 0;
        while (slow < length && fast < length) {
            //两个指针之间的字符串
            String subString = s.substring(slow, fast);
            //当前需要比较的字符
            String sChar = s.substring(fast, fast + 1);
            //如果当前字符在字符串中有
            if (subString.contains(sChar)) {
                //slow指针需要移动到第一次出现sChar+1的地方，即当前slow的值+subString中sChar出现的位置+1
                slow = slow + subString.indexOf(s.charAt(fast)) + 1;
            } else {
                max = Math.max(max, subString.length() + 1);
            }
            fast++;
        }
        return max;
    }
}
