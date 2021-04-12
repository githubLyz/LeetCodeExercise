package _1to99._40to49;

import java.util.*;

/**
 * @author YuJoy
 * @date 2021/3/21 01:59
 * @description: LeetCode 40-49 题解
 */
public class Solution {
    /**
     * 给定一个数组candidates和一个目标数target，找出candidates中所有可以使数字和为target的组合。
     * <p>
     * candidates中的每个数字在每个组合中只能使用一次。
     * <p>
     * 说明：
     * <p>
     * 所有数字（包括目标数）都是正整数。
     * 解集不能包含重复的组合。
     * 示例1:
     * <p>
     * 输入: candidates =[10,1,2,7,6,1,5], target =8,
     * 所求解集为:
     * [
     * [1, 7],
     * [1, 2, 5],
     * [2, 6],
     * [1, 1, 6]
     * ]
     * 示例2:
     * <p>
     * 输入: candidates =[2,5,2,1,2], target =5,
     * 所求解集为:
     * [
     * [1,2,2],
     * [5]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combination-sum-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        //1.排序
        Arrays.sort(candidates);
        List<List<Integer>> resultLists = new ArrayList<>();
        if (candidates[0] > target) {
            return resultLists;
        }
        backTraceCombinationSum2(resultLists, new ArrayList<>(), target, candidates, 0);
        return resultLists;

    }

    private void backTraceCombinationSum2(List<List<Integer>> resultLists, List<Integer> list, int target, int[] candidates, int index) {
        if (target == 0) {
            resultLists.add(new ArrayList<>(list));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (i > index && candidates[i] == candidates[i - 1]) {
                continue;
            }
            int value = candidates[i];
            if (target >= value) {
                list.add(value);
                backTraceCombinationSum2(resultLists, list, target - value, candidates, i + 1);
                list.remove(list.size() - 1);
            } else {
                break;
            }

        }

    }

    /**
     * 给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。
     * <p>
     * <p>
     * <p>
     * 进阶：你可以实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案吗？
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,0]
     * 输出：3
     * 示例 2：
     * <p>
     * 输入：nums = [3,4,-1,1]
     * 输出：2
     * 示例 3：
     * <p>
     * 输入：nums = [7,8,9,11,12]
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * 0 <= nums.length <= 300
     * -231 <= nums[i] <= 231 - 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/first-missing-positive
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */

    public int firstMissingPositive(int[] nums) {
        //1.假设nums=[3,4,-1,1,9,-5]
        int length = nums.length;
        //2.负数先都设置为length+1 因为nums从0~length递增，返回的值最大，为length+1,此时数组变为[3,4,7,1,9,7]
        for (int i = 0; i < length; i++) {
            if (nums[i] <= 0) {
                nums[i] = length + 1;
            }
        }
        //3.经过上一步，nums里面全都是正数了，遍历数组，将小于等于length的数做一次标记。将数组中第nums[num[i]-1]置为负数
        //举例说明，i=0,nums[0]=3,将数组中第三个数，也就是num[3-1]置为负数，说明数组中出现了3，
        //同理，遍历完之后，数组变为[-3,4,-7,-1,9,7],说明正数出现了1，3，4
        for (int i = 0; i < length; i++) {
            //num[i]可能被上一个循环改成负数
            int num = Math.abs(nums[i]);
            if (num <= length) {
                nums[num - 1] = -Math.abs(nums[num - 1]);
            }
        }
        //4.找到第一个非负的数，第二个，返回1+1
        for (int i = 0; i < length; i++) {
            if (nums[i] > 0) {
                return i + 1;
            }
        }
        return length + 1;
    }

    /**
     * 给定n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * <p>
     * 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
     * 输出：6
     * 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/trapping-rain-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param height
     * @return
     */
    public int trap(int[] height) {
        int rain = 0;
        int length = height.length;
        if (length < 3) {
            return 0;
        }
        int[] highestBeginLeft = new int[length];
        int[] highestBeginRight = new int[length];

        highestBeginLeft[0] = height[0];
        highestBeginRight[length - 1] = height[length - 1];
        for (int i = 1; i < length; i++) {
            highestBeginLeft[i] = Math.max(highestBeginLeft[i - 1], height[i]);
        }

        for (int i = length - 2; i > -1; i--) {
            highestBeginRight[i] = Math.max(highestBeginRight[i + 1], height[i]);
        }

        for (int i = 0; i < length; i++) {
            rain += Math.min(highestBeginLeft[i], highestBeginRight[i]) - height[i];
        }

        return rain;
    }

    /**
     * 给定两个以字符串形式表示的非负整数num1和num2，返回num1和num2的乘积，它们的乘积也表示为字符串形式。
     * <p>
     * 示例 1:
     * <p>
     * 输入: num1 = "2", num2 = "3"
     * 输出: "6"
     * 示例2:
     * <p>
     * 输入: num1 = "123", num2 = "456"
     * 输出: "56088"
     * 说明：
     * <p>
     * num1和num2的长度小于110。
     * num1 和num2 只包含数字0-9。
     * num1 和num2均不以零开头，除非是数字 0 本身。
     * 不能使用任何标准库的大数类型（比如 BigInteger）或直接将输入转换为整数来处理。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/multiply-strings
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String multiply(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        StringBuffer result = new StringBuffer();
        char[] charsOne = num1.toCharArray();
        char[] charsTwo = num2.toCharArray();
        int carry;
        int charsOneIndex = charsOne.length - 1;
        int charsTwoIndex;
        StringBuffer tenSb = new StringBuffer();
        while (charsOneIndex > -1) {
            charsTwoIndex = charsTwo.length - 1;
            int multiplyNum = charsOne[charsOneIndex] - '0';
            StringBuffer s = new StringBuffer();
            carry = 0;
            while (charsTwoIndex > -1) {
                int number = (charsTwo[charsTwoIndex] - '0') * multiplyNum + carry;
                carry = number / 10;
                s.insert(0, number % 10);
                charsTwoIndex--;
            }
            if (carry > 0) {
                s.insert(0, carry);
            }
            if (charsOneIndex != charsOne.length - 1) {
                tenSb.append("0");
                s.append(tenSb);
            }
            result = add(result, s);
            charsOneIndex--;
        }
        return result.toString();
    }

    public StringBuffer add(StringBuffer s1, StringBuffer s2) {
        if (s1.toString().equals("") || s2.toString().equals("")) {
            return s1.toString().equals("") ? s2 : s1;
        }
        int carry = 0;
        char[] charsOne = s1.toString().toCharArray();
        char[] charsTwo = s2.toString().toCharArray();
        int indexOne = charsOne.length - 1;
        int indexTwo = charsTwo.length - 1;
        StringBuffer s = new StringBuffer();
        while (indexOne > -1 || indexTwo > -1) {
            int sum = (indexOne > -1 ? (charsOne[indexOne] - '0') : 0) + (indexTwo > -1 ? (charsTwo[indexTwo] - '0') : 0) + carry;
            if (sum > 9) {
                sum = sum - 10;
                carry = 1;
            } else {
                carry = 0;
            }
            String add = sum + "";
            s.insert(0, add);
            indexOne--;
            indexTwo--;
        }
        if (carry == 1) {
            s.insert(0, "1");
        }
        return s;
    }

    /**
     * 给定一个字符串(s) 和一个字符模式(p) ，实现一个支持'?'和'*'的通配符匹配。
     * <p>
     * '?' 可以匹配任何单个字符。
     * '*' 可以匹配任意字符串（包括空字符串）。
     * 两个字符串完全匹配才算匹配成功。
     * <p>
     * 说明:
     * <p>
     * s可能为空，且只包含从a-z的小写字母。
     * p可能为空，且只包含从a-z的小写字母，以及字符?和*。
     * 示例1:
     * <p>
     * 输入:
     * s = "aa"
     * p = "a"
     * 输出: false
     * 解释: "a" 无法匹配 "aa" 整个字符串。
     * 示例2:
     * <p>
     * 输入:
     * s = "aa"
     * p = "*"
     * 输出: true
     * 解释:'*' 可以匹配任意字符串。
     * 示例3:
     * <p>
     * 输入:
     * s = "cb"
     * p = "?a"
     * 输出: false
     * 解释:'?' 可以匹配 'c', 但第二个 'a' 无法匹配 'b'。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/wildcard-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        //1.s="",p全部都是*的特殊情況
        for (int i = 1; i <= pLength; i++) {
            if (p.charAt(i - 1) == '*') {
                dp[0][i] = true;
            } else {
                break;
            }
        }
        for (int i = 1; i <= sLength; i++) {
            for (int j = 1; j <= pLength; j++) {
                if (p.charAt(j - 1) == '*') {
                    dp[i][j] = dp[i][j - 1] || dp[i - 1][j];
                } else if (p.charAt(j - 1) == '?' || p.charAt(j - 1) == s.charAt(i - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                }
            }
        }

        return dp[sLength][pLength];
    }

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
     * <p>
     * 示例:
     * <p>
     * 输入: [2,3,1,1,4]
     * 输出: 2
     * 解释: 跳到最后一个位置的最小跳跃数是 2。
     * 从下标为 0 跳到下标为 1 的位置，跳1步，然后跳3步到达数组的最后一个位置。
     * 说明:
     * <p>
     * 假设你总是可以到达数组的最后一个位置。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int jump(int[] nums) {
        int steps = 0;
        int maxStep = 0;
        int end = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            maxStep = Math.max(maxStep, i + nums[i]);
            if (i == end) {
                steps++;
                end = maxStep;
            }
        }
        return steps;
    }

    /**
     * 给定一个 没有重复 数字的序列，返回其所有可能的全排列。
     * <p>
     * 示例:
     * <p>
     * 输入: [1,2,3]
     * 输出:
     * [
     * [1,2,3],
     * [1,3,2],
     * [2,1,3],
     * [2,3,1],
     * [3,1,2],
     * [3,2,1]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> resultList = new ArrayList<>();
        if (nums.length == 0) {
            return resultList;
        }
        boolean[] used = new boolean[nums.length];
        backTracePermute(nums, new ArrayList<>(), resultList, used);
        return resultList;
    }

    private void backTracePermute(int[] nums, List<Integer> list, List<List<Integer>> resultList, boolean[] used) {
        if (list.size() == nums.length) {
            resultList.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                list.add(nums[i]);
                used[i] = true;
                backTracePermute(nums, list, resultList, used);
                used[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

    /**
     * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,1,2]
     * 输出：
     * [[1,1,2],
     * [1,2,1],
     * [2,1,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutations-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    boolean[] used;

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums.length == 0) {
            return result;
        }
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backTracePermuteUnique(result, new ArrayList<>(), used, nums, 0);
        return result;

    }

    private void backTracePermuteUnique(List<List<Integer>> result, List<Integer> list, boolean[] used, int[] nums, int index) {
        if (list.size() == nums.length) {
            result.add(new ArrayList<>(list));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || (i > 0 && nums[i] == nums[i - 1] && !used[i - 1])) {
                continue;
            }
            list.add(nums[i]);
            used[i] = true;
            backTracePermuteUnique(result, list, used, nums, i + 1);
            used[i] = false;
            list.remove(list.size() - 1);
        }
    }

    /**
     * 给定一个 n×n 的二维矩阵matrix 表示一个图像。请你将图像顺时针旋转 90 度。
     * <p>
     * 你必须在 原地 旋转图像，这意味着你需要直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
     * <p>
     * }
     * <p>
     * 示例 1：
     * 1 2 3    7 4 1
     * 4 5 6    8 5 2
     * 7 8 9    9 6 3
     * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
     * 输出：[[7,4,1],[8,5,2],[9,6,3]]
     * 示例 2：
     * <p>
     * <p>
     * 输入：matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]
     * 输出：[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-image
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    public void rotate(int[][] matrix) {
        int length = matrix.length - 1;
        for (int i = 0; i < (length + 1) / 2; i++) {
            for (int j = 0; j < length / 2 + 1; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[length - j][i];
                matrix[length - j][i] = matrix[length - i][length - j];
                matrix[length - i][length - j] = matrix[j][length - i];
                matrix[j][length - i] = temp;
            }
        }
        for (int i = 0; i < length + 1; i++) {
            System.out.println(Arrays.toString(matrix[i]));
        }
    }

    /**
     * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
     * <p>
     * 示例:
     * <p>
     * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
     * 输出:
     * [
     * ["ate","eat","tea"],
     * ["nat","tan"],
     * ["bat"]
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/group-anagrams
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param strs
     * @return
     */
    public List<List<String>> groupAnagrams(String[] strs) {
        if (strs.length == 0) {
            return new ArrayList<>();
        }
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] array = s.toCharArray();
            Arrays.sort(array);
            String key = new String(array);
            List<String> list=map.getOrDefault(key,new ArrayList<>());
            list.add(s);
            map.put(key,list);
        }
        return new ArrayList<>(map.values());
    }
}
