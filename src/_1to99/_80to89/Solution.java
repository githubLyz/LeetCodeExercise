package _1to99._80to89;

import bean.LinkedNode;

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
}
