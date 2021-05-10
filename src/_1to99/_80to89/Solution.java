package _1to99._80to89;

import bean.LinkedNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @author YuJoy
 * @date 2021/4/18 14:05
 * @description: 80~89 Solution
 */
public class Solution {
    /**
     * 给你一个有序数组 nums ，请你 原地 删除重复出现的元素，使每个元素 最多出现两次 ，返回删除后数组的新长度。
     * <p>
     * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
     * <p>
     * <p>
     * <p>
     * 说明：
     * <p>
     * 为什么返回数值是整数，但输出的答案是数组呢？
     * <p>
     * 请注意，输入数组是以「引用」方式传递的，这意味着在函数里修改输入数组对于调用者是可见的。
     * <p>
     * 你可以想象内部操作如下:
     * <p>
     * // nums 是以“引用”方式传递的。也就是说，不对实参做任何拷贝
     * int len = removeDuplicates(nums);
     * <p>
     * // 在函数里修改输入数组对于调用者是可见的。
     * // 根据你的函数返回的长度, 它会打印出数组中 该长度范围内 的所有元素。
     * for (int i = 0; i < len; i++) {
     * print(nums[i]);
     * }
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,1,2,2,3]
     * 输出：5, nums = [1,1,2,2,3]
     * 解释：函数应返回新长度 length = 5, 并且原数组的前五个元素被修改为 1, 1, 2, 2, 3 。 不需要考虑数组中超出新长度后面的元素。
     * 示例 2：
     * <p>
     * 输入：nums = [0,0,1,1,1,1,2,3,3]
     * 输出：7, nums = [0,0,1,1,2,3,3]
     * 解释：函数应返回新长度 length = 7, 并且原数组的前五个元素被修改为0, 0, 1, 1, 2, 3, 3 。 不需要考虑数组中超出新长度后面的元素。
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 3 * 104
     * -104 <= nums[i] <= 104
     * nums 已按升序排列
     * 通过次数125,323提交次数205,304
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length <= 2) {
            return nums.length;
        }
        int slow = 2;
        int fast = 2;
        while (fast < nums.length) {
            if (nums[fast] != nums[slow - 2]) {
                nums[slow] = nums[fast];
                slow++;
            }
            fast++;
        }
        return slow;
    }

    /**
     * 已知存在一个按非降序排列的整数数组 nums ，数组中的值不必互不相同。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转 ，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,4,4,5,6,6,7] 在下标 5 处经旋转后可能变为 [4,5,6,6,7,0,1,2,4,4] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，请你编写一个函数来判断给定的目标值是否存在于数组中。如果 nums 中存在这个目标值 target ，则返回 true ，否则返回 false 。
     * <p>
     * <p>
     * <p>
     * 示例1：
     * <p>
     * 输入：nums = [2,5,6,0,0,1,2], target = 0
     * 输出：true
     * 示例2：
     * <p>
     * 输入：nums = [2,5,6,0,0,1,2], target = 3
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= nums.length <= 5000
     * -104 <= nums[i] <= 104
     * 题目数据保证 nums 在预先未知的某个下标上进行了旋转
     * -104 <= target <= 104
     * <p>
     * <p>
     * 进阶：
     * <p>
     * 这是 搜索旋转排序数组的延伸题目，本题中的nums 可能包含重复元素。
     * 这会影响到程序的时间复杂度吗？会有怎样的影响，为什么？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @param target
     * @return
     */
    public boolean search(int[] nums, int target) {
        //如果下标k为0，还是正序排列的，说明nums[0]<nums[nums.length-1]
        //反之，k不为0，那么nums[0]>=nums[nums.length-1]
        int length = nums.length;
        if (length == 1) {
            return nums[0] == target;
        }
        if (nums[0] < nums[length - 1]) {
            //没有反转，直接使用二分法查找target
            int left = 0;
            int right = length - 1;
            while (left <= right) {
                int mid = (right + left) / 2;
                if (nums[mid] < target) {
                    left = mid + 1;
                } else if (nums[mid] == target) {
                    return true;
                } else {
                    right = mid - 1;
                }
            }
        } else {
            if (nums[0] == target) {
                return true;
            } else if (nums[0] > target) {
                //说明target可能在左边
                for (int i = length - 1; i >= 0; i--) {
                    if (nums[i] == target) {
                        return true;
                    }
                    if (nums[i] < target) {
                        return false;
                    }
                }
            } else {
                //说明target可能在右边
                for (int num : nums) {
                    if (num == target) {
                        return true;
                    }
                    if (num > target) {
                        return false;
                    }
                }
            }
        }
        return false;
    }

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除链表中所有存在数字重复情况的节点，只保留原始链表中没有重复出现的数字。
     * <p>
     * 返回同样按升序排列的结果链表。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,3,4,4,5]
     * 输出：[1,2,5]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [1,1,1,2,3]
     * 输出：[2,3]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public LinkedNode deleteDuplicates(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode emptyNode = new LinkedNode(-1);
        LinkedNode realHeadNode = emptyNode;
        LinkedNode slow = head;
        LinkedNode fast = head;
        while (fast != null) {
            if (fast.next != null && fast.next.val == slow.val) {
                fast = fast.next;
                while (fast != null && fast.val == slow.val) {
                    fast = fast.next;
                }
            } else {
                realHeadNode.next = new LinkedNode(slow.val);
                realHeadNode = realHeadNode.next;
                fast = fast.next;
            }
            slow = fast;
        }

        return emptyNode.next;
    }

    /**
     * 存在一个按升序排列的链表，给你这个链表的头节点 head ，请你删除所有重复的元素，使每个元素 只出现一次 。
     * <p>
     * 返回同样按升序排列的结果链表。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,1,2]
     * 输出：[1,2]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [1,1,2,3,3]
     * 输出：[1,2,3]
     *
     * <p>
     * 提示：
     * <p>
     * 链表中节点数目在范围 [0, 300] 内
     * -100 <= Node.val <= 100
     * 题目数据保证链表已经按升序排列
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/remove-duplicates-from-sorted-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @return
     */
    public LinkedNode deleteDuplicatesEasy(LinkedNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        LinkedNode emptyNode = new LinkedNode(Integer.MAX_VALUE);
        LinkedNode realHeadNode = emptyNode;
        while (head != null) {
            if (head.val != realHeadNode.val) {
                realHeadNode.next = new LinkedNode(head.val);
                realHeadNode = realHeadNode.next;
                head = head.next;
            } else {
                head = head.next;
                while (head != null && head.val == realHeadNode.val) {
                    head = head.next;
                }
            }
        }
        return emptyNode.next;
    }

    /**
     * 给定 n 个非负整数，用来表示柱状图中各个柱子的高度。每个柱子彼此相邻，且宽度为 1 。
     * <p>
     * 求在该柱状图中，能够勾勒出来的矩形的最大面积。
     * 示例:
     * <p>
     * 输入: [2,1,5,6,2,3]
     * 输出: 10
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/largest-rectangle-in-histogram
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param heights
     * @return
     */
    public int largestRectangleArea(int[] heights) {
        int length = heights.length;
        if (length == 0) {
            return 0;
        }
        if (length == 1) {
            return heights[0];
        }
        int res = 0;
        int[] newHeights = new int[length + 2];
        newHeights[0] = 0;
        System.arraycopy(newHeights, 0, heights, 1, length);
        newHeights[length + 1] = 0;
        length += 2;
        heights = newHeights;
        Deque<Integer> stack = new ArrayDeque<>(length);
        stack.addLast(0);
        for (int i = 1; i < length; i++) {
            while (heights[i] < heights[stack.peekLast()]) {
                int curHeight = heights[stack.pollLast()];
                int curWidth = i - stack.peekLast() - 1;
                res = Math.max(res, curHeight * curWidth);
            }
            stack.addLast(i);
        }
        return res;
    }

    /**
     * 给定一个仅包含0 和 1 、大小为 rows x cols 的二维二进制矩阵，找出只包含 1 的最大矩形，并返回其面积。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
     * 输出：6
     * 解释：最大矩形如上图所示。
     * 示例 2：
     * <p>
     * 输入：matrix = []
     * 输出：0
     * 示例 3：
     * <p>
     * 输入：matrix = [["0"]]
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximal-rectangle
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @return
     */
    public int maximalRectangle(char[][] matrix) {
        int lines = matrix.length;
        if (lines == 0) {
            return 0;
        }
        int columns = matrix[0].length;
        int[] heights = new int[columns + 2];
        heights[0] = 0;
        heights[columns + 1] = 0;
        int ans = 0;
        for (char[] chars : matrix) {
            for (int j = 0; j < columns; j++) {
                if (chars[j] == '1') {
                    heights[j + 1] += 1;
                } else {
                    heights[j + 1] = 0;
                }
            }
            Deque<Integer> deque = new ArrayDeque<>(columns + 2);
            deque.addLast(0);
            for (int k = 0; k < heights.length; k++) {
                while (heights[k] < heights[deque.peekLast()]) {
                    int curHeight = heights[deque.pollLast()];
                    int curWidth = k - deque.peekLast() - 1;
                    ans = Math.max(ans, curHeight * curWidth);
                }
                deque.addLast(k);
            }
        }
        return ans;
    }

    /**
     * 给你一个链表的头节点 head 和一个特定值 x ，请你对链表进行分隔，使得所有 小于 x 的节点都出现在 大于或等于 x 的节点之前。
     * <p>
     * 你应当 保留 两个分区中每个节点的初始相对位置。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     * 示例 2：
     * <p>
     * 输入：head = [2,1], x = 2
     * 输出：[1,2]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/partition-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param x
     * @return
     */
    public LinkedNode partition(LinkedNode head, int x) {
        LinkedNode small = new LinkedNode(0);
        LinkedNode smallHead = small;
        LinkedNode large = new LinkedNode(0);
        LinkedNode largeHead = large;
        while (head != null) {
            if (head.val < x) {
                small.next = head;
                small = small.next;
            } else {
                large.next = head;
                large = large.next;
            }
            head = head.next;
        }
        large.next = null;
        small.next = largeHead.next;
        return smallHead.next;
    }

    /**
     * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
     * 如果字符串的长度为 1 ，算法停止
     * 如果字符串的长度 > 1 ，执行下述步骤：
     * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
     * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
     * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
     * 给你两个 长度相等 的字符串 s1 和s2，判断s2是否是s1的扰乱字符串。如果是，返回 true ；否则，返回 false 。
     *
     *
     *
     * 示例 1：
     *
     * 输入：s1 = "great", s2 = "rgeat"
     * 输出：true
     * 解释：s1 上可能发生的一种情形是：
     * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
     * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
     * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
     * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
     * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
     * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
     * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
     * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
     * 示例 2：
     *
     * 输入：s1 = "abcde", s2 = "caebd"
     * 输出：false
     * 示例 3：
     *
     * 输入：s1 = "a", s2 = "a"
     * 输出：true
     *
     *
     * 提示：
     *
     * s1.length == s2.length
     * 1 <= s1.length <= 30
     * s1 和 s2 由小写英文字母组成
     *
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/scramble-string
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     * @param s1
     * @param s2
     * @return
     *
     * todo  give up
     */

//    public boolean isScramble(String s1, String s2) {
//
//    }


    /**
     * 给你两个有序整数数组nums1 和 nums2，请你将 nums2 合并到nums1中，使 nums1 成为一个有序数组。
     * <p>
     * 初始化nums1 和 nums2 的元素数量分别为m 和 n 。你可以假设nums1 的空间大小等于m + n，这样它就有足够的空间保存来自 nums2 的元素。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
     * 输出：[1,2,2,3,5,6]
     * 示例 2：
     * <p>
     * 输入：nums1 = [1], m = 1, nums2 = [], n = 0
     * 输出：[1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/merge-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums1
     * @param m
     * @param nums2
     * @param n
     */
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1, p2 = n - 1;
        int tail = m + n - 1;
        int cur;
        while (p1 >= 0 || p2 >= 0) {
            if (p1 == -1) {
                cur = nums2[p2--];
            } else if (p2 == -1) {
                cur = nums1[p1--];
            } else if (nums1[p1] > nums2[p2]) {
                cur = nums1[p1--];
            } else {
                cur = nums2[p2--];
            }
            nums1[tail--] = cur;
        }
    }

    /**
     * 格雷编码是一个二进制数字系统，在该系统中，两个连续的数值仅有一个位数的差异。
     * <p>
     * 给定一个代表编码总位数的非负整数 n，打印其格雷编码序列。即使有多个不同答案，你也只需要返回其中一种。
     * <p>
     * 格雷编码序列必须以 0 开头。
     * <p>
     * <p>
     * <p>
     * 示例 1:
     * <p>
     * 输入:2
     * 输出:[0,1,3,2]
     * 解释:
     * 00 - 0
     * 01 - 1
     * 11 - 3
     * 10 - 2
     * <p>
     * 对于给定的n，其格雷编码序列并不唯一。
     * 例如，[0,2,3,1]也是一个有效的格雷编码序列。
     * <p>
     * 00 - 0
     * 10 - 2
     * 11 - 3
     * 01 - 1
     * 示例2:
     * <p>
     * 输入:0
     * 输出:[0]
     * 解释: 我们定义格雷编码序列必须以 0 开头。
     * 给定编码总位数为 n 的格雷编码序列，其长度为 2n。当 n = 0 时，长度为 20 = 1。
     * 因此，当 n = 0 时，其格雷编码序列为 [0]。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/gray-code
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public List<Integer> grayCode(int n) {
        List<Integer> ansList = new ArrayList<>();
        ansList.add(0);
        int head = 1;
        for (int i = 0; i < n; i++) {
            for (int j = ansList.size() - 1; j >= 0; j--) {
                ansList.add(head + ansList.get(j));
            }
            head <<= 1;
        }
        return ansList;
    }
}
