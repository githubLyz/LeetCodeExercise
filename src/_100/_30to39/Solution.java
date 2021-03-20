package _100._30to39;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author YuJoy
 * @date 2021/3/13 14:06
 */
public class Solution {
    /**
     * 给定一个字符串s和一些长度相同的单词words。找出 s 中恰好可以由words 中所有单词串联形成的子串的起始位置。
     * <p>
     * 注意子串要与words 中的单词完全匹配，中间不能有其他字符，但不需要考虑words中单词串联的顺序。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：
     * s = "barfoothefoobarman",
     * words = ["foo","bar"]
     * 输出：[0,9]
     * 解释：
     * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
     * 输出的顺序不重要, [9,0] 也是有效答案。
     * 示例 2：
     * <p>
     * 输入：
     * s = "wordgoodgoodgoodbestword",
     * words = ["word","good","best","word"]
     * 输出：[]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> list = new ArrayList<>();
        if (words.length == 0) {
            return list;
        }
        int wordLength = words[0].length();
        int wordsNum = words.length;
        HashMap<String, Integer> wordsMap = new HashMap<>();
        for (String word : words) {
            int value = wordsMap.getOrDefault(word, 0);
            wordsMap.put(word, value + 1);
        }
        for (int i = 0; i < s.length() - wordLength * wordsNum + 1; i++) {
            HashMap<String, Integer> tempWordMap = new HashMap<>();
            int num = 0;
            while (num < wordsNum) {
                String word = s.substring(i + num * wordLength, i + (num + 1) * wordLength);
                if (wordsMap.containsKey(word)) {
                    int value = tempWordMap.getOrDefault(word, 0);
                    tempWordMap.put(word, value + 1);
                    if (value + 1 > wordsMap.get(word)) {
                        break;
                    }
                } else {
                    break;
                }
                num++;
            }

            if (num == wordsNum) {
                list.add(i);
            }
        }
        return list;
    }

    /**
     * 实现获取 下一个排列 的函数，算法需要将给定数字序列重新排列成字典序中下一个更大的排列。
     * <p>
     * 如果不存在下一个更大的排列，则将数字重新排列成最小的排列（即升序排列）。
     * <p>
     * 必须 原地 修改，只允许使用额外常数空间。
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[1,3,2]
     * 示例 2：
     * <p>
     * 输入：nums = [3,2,1]
     * 输出：[1,2,3]
     * 示例 3：
     * <p>
     * 输入：nums = [1,1,5]
     * 输出：[1,5,1]
     * 示例 4：
     * <p>
     * 输入：nums = [1]
     * 输出：[1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/next-permutation
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public void nextPermutation(int[] nums) {
        int i = nums.length - 2;
        //1.找到非降序排列 [1,5,8,4,7,6,3,1]  此时i=3 nums[i] = 4;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        //2.说明找到了,接下来找到i~nums.length-1这个区间大于4的值，j=5 nums[5]=6
        if (i >= 0) {
            int j = nums.length - 1;
            while (j >= 0 && nums[i] >= nums[j]) {
                j--;
            }
            //3.i,j 交换位置，此时数组为[1,5,8,6,7,4,3,1]
            swap(nums, i, j);
        }
        //4.将i~nums.length-1的数组反转[1,5,8,6,1,3,4,7]
        reverse(nums, i + 1);
    }

    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public void reverse(int[] nums, int start) {
        int left = start, right = nums.length - 1;
        while (left < right) {
            swap(nums, left, right);
            left++;
            right--;
        }
    }

    /**
     * 给你一个只包含 '('和 ')'的字符串，找出最长有效（格式正确且连续）括号子串的长度。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "(()"
     * 输出：2
     * 解释：最长有效括号子串是 "()"
     * 示例 2：
     * <p>
     * 输入：s = ")()())"
     * 输出：4
     * 解释：最长有效括号子串是 "()()"
     * 示例 3：
     * <p>
     * 输入：s = ""
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int longestValidParentheses(String s) {
        int result = 0;
        int[] dp = new int[s.length()];
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == ')') {
                if (s.charAt(i - 1) == '(') {
                    dp[i] = (i >= 2 ? dp[i - 2] : 0) + 2;
                } else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
                    dp[i] = dp[i - 1] + (i - dp[i - 1] >= 2 ? dp[i - dp[i - 1] - 2] : 0) + 2;
                }
            }
            result = Math.max(result, dp[i]);
        }
        return result;
    }


    /**
     * 整数数组 nums 按升序排列，数组中的值 互不相同 。
     * <p>
     * 在传递给函数之前，nums 在预先未知的某个下标 k（0 <= k < nums.length）上进行了 旋转，使数组变为 [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]]（下标 从 0 开始 计数）。例如， [0,1,2,4,5,6,7] 在下标 3 处经旋转后可能变为[4,5,6,7,0,1,2] 。
     * <p>
     * 给你 旋转后 的数组 nums 和一个整数 target ，如果 nums 中存在这个目标值 target ，则返回它的索引，否则返回-1。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 0
     * 输出：4
     * 示例2：
     * <p>
     * 输入：nums = [4,5,6,7,0,1,2], target = 3
     * 输出：-1
     * 示例 3：
     * <p>
     * 输入：nums = [1], target = 0
     * 输出：-1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-in-rotated-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int search(int[] nums, int target) {
        int result = -1;
        int length = nums.length;
        for (int i = 0; i < length - 1; i++) {
            if (nums[i] == target) {
                result = i;
                break;
            }

            if (target > nums[i] && nums[i] > nums[i + 1]) {
                break;
            }
        }
        if (nums[length - 1] == target) {
            result = length - 1;
        }
        return result;
    }

    /**
     * 给定一个按照升序排列的整数数组 nums，和一个目标值 target。找出给定目标值在数组中的开始位置和结束位置。
     * <p>
     * 如果数组中不存在目标值 target，返回[-1, -1]。
     * <p>
     * 进阶：
     * <p>
     * 你可以设计并实现时间复杂度为O(log n)的算法解决此问题吗？
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 8
     * 输出：[3,4]
     * 示例2：
     * <p>
     * 输入：nums = [5,7,7,8,8,10], target = 6
     * 输出：[-1,-1]
     * 示例 3：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[-1,-1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 105
     * -109<= nums[i]<= 109
     * nums是一个非递减数组
     * -109<= target<= 109
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] searchRange(int[] nums, int target) {
        //O(log n),二分法
        int[] result = new int[]{-1, -1};
        int length = nums.length;
        if (length == 0) {
            return result;
        }
        int left = 0;
        int right = length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] == target) {
                //1.往前找
                int front = mid;
                boolean frontChange = false;
                while (front > -1 && nums[front] == target) {
                    frontChange = true;
                    front--;
                }
                //2.往后找
                int last = mid;
                boolean lastChange = false;
                while (last < length && nums[last] == target) {
                    lastChange = true;
                    last++;
                }
                result[0] = frontChange ? front + 1 : front;
                result[1] = lastChange ? last - 1 : last;
                return result;

            } else if (nums[mid] > target) {
                //在左边
                right = mid - 1;
            } else {
                //在右边
                left = mid + 1;
            }

        }
        return result;
    }


    /**
     * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
     * <p>
     * 你可以假设数组中无重复元素。
     * <p>
     * 示例 1:
     * <p>
     * 输入: [1,3,5,6], 5
     * 输出: 2
     * 示例2:
     * <p>
     * 输入: [1,3,5,6], 2
     * 输出: 1
     * 示例 3:
     * <p>
     * 输入: [1,3,5,6], 7
     * 输出: 4
     * 示例 4:
     * <p>
     * 输入: [1,3,5,6], 0
     * 输出: 0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-insert-position
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int searchInsert(int[] nums, int target) {
        int length = nums.length;
        if (length == 0 || nums[0] > target) {
            return 0;
        }
        if (nums[length - 1] < target) {
            return length;
        }
        int left = 0;
        int right = length - 1;
        int mid;
        while (left <= right) {
            mid = (left + right) / 2;
            if (nums[mid] < target) {
                if (mid + 1 < length && nums[mid + 1] > target) {
                    return mid + 1;
                }
                left = mid + 1;
            } else if (nums[mid] == target) {
                return mid;
            } else {
                if (mid - 1 > -1 && nums[mid - 1] < target) {
                    return mid;
                }
                right = mid - 1;

            }
        }
        return -1;
    }

    /**
     * 判断一个9x9 的数独是否有效。只需要根据以下规则，验证已经填入的数字是否有效即可。
     * <p>
     * 数字1-9在每一行只能出现一次。
     * 数字1-9在每一列只能出现一次。
     * 数字1-9在每一个以粗实线分隔的3x3宫内只能出现一次。
     * <p>
     * <p>
     * 上图是一个部分填充的有效的数独。
     * <p>
     * 数独部分空格内已填入了数字，空白格用'.'表示。
     * 输入:
     * [
     * ["5","3",".",".","7",".",".",".","."],
     * ["6",".",".","1","9","5",".",".","."],
     * [".","9","8",".",".",".",".","6","."],
     * ["8",".",".",".","6",".",".",".","3"],
     * ["4",".",".","8",".","3",".",".","1"],
     * ["7",".",".",".","2",".",".",".","6"],
     * [".","6",".",".",".",".","2","8","."],
     * [".",".",".","4","1","9",".",".","5"],
     * [".",".",".",".","8",".",".","7","9"]
     * ]
     * 输出: true
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-sudoku
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValidSudoku(char[][] board) {
        HashMap<Integer, Integer>[] rows = new HashMap[9];
        HashMap<Integer, Integer>[] columns = new HashMap[9];
        HashMap<Integer, Integer>[] boxes = new HashMap[9];
        for (int i = 0; i < 9; i++) {
            rows[i] = new HashMap<>();
            columns[i] = new HashMap<>();
            boxes[i] = new HashMap<>();
        }
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char num = board[i][j];
                if (num != '.') {
                    int box_index = (i / 3) * 3 + j / 3;

                    rows[i].put((int) num, rows[i].getOrDefault((int) num, 0) + 1);
                    columns[j].put((int) num, columns[j].getOrDefault((int) num, 0) + 1);
                    boxes[box_index].put((int) num, boxes[box_index].getOrDefault((int) num, 0) + 1);

                    if (rows[i].get((int) num) > 1 || columns[j].get((int) num) > 1 || boxes[box_index].get((int) num) > 1)
                        return false;
                }
            }
        }
        return true;
    }

    /**
     * 编写一个程序，通过填充空格来解决数独问题。
     * <p>
     * 一个数独的解法需遵循如下规则：
     * <p>
     * 数字'1-9'在每一行只能出现一次。
     * 数字'1-9'在每一列只能出现一次。
     * 数字'1-9'在每一个以粗实线分隔的'3x3'宫内只能出现一次。
     * 空白格用'.'表示。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sudoku-solver
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    private final boolean[][] line = new boolean[9][9];//line[5][4]=true 表示第6行的5已经出现过
    private final boolean[][] column = new boolean[9][9];//column[3][7]=true 表示第4行的8已经出现过
    private final boolean[][][] nineCell = new boolean[3][3][9];//nineCell[2][1][8]表示第三行的第二个九宫格出现了9
    private boolean isValid = false;
    private List<int[]> space = new ArrayList<>();//记录没有值的坐标位置

    public void solveSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    //1.添加没有值的坐标
                    space.add(new int[]{i, j});
                } else {
                    //2.转化， board[i][j]='8' '8'-'0' =8(int) int从0开始，需要-1
                    int digit = board[i][j] - '0' - 1;
                    line[i][digit] = column[j][digit] = nineCell[i / 3][j / 3][digit] = true;
                }
            }
        }

        //3.回溯
        backTrac(board, 0);

    }

    private void backTrac(char[][] board, int size) {
        //4.当list中的坐标全部被赋值，说明已经找出了一个正确答案，将isValid置为ture,停止回溯
        if (size == space.size()) {
            isValid = true;
            for (int i = 0; i < 9; i++) {
                System.out.println(Arrays.toString(board[i]));
            }
            return;
        }

        //5.拿到当前的坐标
        int[] pos = space.get(size);
        int linePos = pos[0];
        int columnPos = pos[1];
        //6.当前需要赋值的可能值有9种
        for (int value = 0; value < 9 && !isValid; value++) {
            //7.在三种记录是否存在的容器中都不存在，可以赋值了
            if (!line[linePos][value] && !column[columnPos][value] && !nineCell[linePos / 3][columnPos / 3][value]) {
                line[linePos][value] = column[columnPos][value] = nineCell[linePos / 3][columnPos / 3][value] = true;
                board[linePos][columnPos] = (char) (value + '0' + 1);
                //8.寻找下一个值
                backTrac(board, size + 1);
                //9.走到这里，说明不符合条件了，重新赋值为false
                line[linePos][value] = column[columnPos][value] = nineCell[linePos / 3][columnPos / 3][value] = false;
            }
        }
    }

    /**
     * 给定一个无重复元素的数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
     * <p>
     * candidates中的数字可以无限制重复被选取。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括target）都是正整数。
     * 解集不能包含重复的组合。
     * 示例1：
     * <p>
     * 输入：candidates = [2,3,6,7], target = 7,
     * 所求解集为：
     * [
     * [7],
     * [2,2,3]
     * ]
     * 示例2：
     * <p>
     * 输入：candidates = [2,3,5], target = 8,
     * 所求解集为：
     * [
     * [2,2,2,2],
     * [2,3,3],
     * [3,5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> resultLists = new ArrayList<>();
        backTraceCombinationSum(resultLists, new ArrayList<>(), target, candidates, 0);
        return resultLists;
    }

    private void backTraceCombinationSum(List<List<Integer>> resultLists, List<Integer> resultList, int currentTarget, int[] candidates, int candidatesIndex) {
        if (candidatesIndex == candidates.length) {
            return;
        }
        if (currentTarget == 0) {
            //1.容易出错点，没有新创建对象
            resultLists.add(new ArrayList<>(resultList));
            return;
        }
        //2.解决重复选用的问题
        int value = candidates[candidatesIndex];
        if (currentTarget >= value) {
            resultList.add(candidates[candidatesIndex]);
            backTraceCombinationSum(resultLists, resultList, currentTarget - value, candidates, candidatesIndex);
            resultList.remove(resultList.size() - 1);
        }
        //3.解决不用数的问题
        backTraceCombinationSum(resultLists, resultList, currentTarget, candidates, candidatesIndex+1);

    }
}
