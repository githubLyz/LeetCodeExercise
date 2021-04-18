package _1to99._70to79;

import java.util.*;

/**
 * @author YuJoy
 * @date 2021/4/12 22:30
 * @description: 70~79题解
 */
public class Solution {
    /**
     * 假设你正在爬楼梯。需要 n阶你才能到达楼顶。
     * <p>
     * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
     * <p>
     * 注意：给定 n 是一个正整数。
     * <p>
     * 示例 1：
     * <p>
     * 输入： 2
     * 输出： 2
     * 解释： 有两种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶
     * 2.  2 阶
     * 示例 2：
     * <p>
     * 输入： 3
     * 输出： 3
     * 解释： 有三种方法可以爬到楼顶。
     * 1.  1 阶 + 1 阶 + 1 阶
     * 2.  1 阶 + 2 阶
     * 3.  2 阶 + 1 阶
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/climbing-stairs
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int climbStairs(int n) {
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (n > 2) {
            int[] dp = new int[n + 1];
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
            return dp[n];
        }
        return 0;
    }

    /**
     * 给你一个字符串 path ，表示指向某一文件或目录的Unix 风格 绝对路径 （以 '/' 开头），请你将其转化为更加简洁的规范路径。
     * <p>
     * 在 Unix 风格的文件系统中，一个点（.）表示当前目录本身；此外，两个点 （..）表示将目录切换到上一级（指向父目录）；两者都可以是复杂相对路径的组成部分。任意多个连续的斜杠（即，'//'）都被视为单个斜杠 '/' 。 对于此问题，任何其他格式的点（例如，'...'）均被视为文件/目录名称。
     * <p>
     * 请注意，返回的 规范路径 必须遵循下述格式：
     * <p>
     * 始终以斜杠 '/' 开头。
     * 两个目录名之间必须只有一个斜杠 '/' 。
     * 最后一个目录名（如果存在）不能 以 '/' 结尾。
     * 此外，路径仅包含从根目录到目标文件或目录的路径上的目录（即，不含 '.' 或 '..'）。
     * 返回简化后得到的 规范路径 。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入：path = "/home/"
     * 输出："/home"
     * 解释：注意，最后一个目录名后面没有斜杠。
     * 示例 2：
     * <p>
     * 输入：path = "/../"
     * 输出："/"
     * 解释：从根目录向上一级是不可行的，因为根目录是你可以到达的最高级。
     * 示例 3：
     * <p>
     * 输入：path = "/home//foo/"
     * 输出："/home/foo"
     * 解释：在规范路径中，多个连续斜杠需要用一个斜杠替换。
     * 示例 4：
     * <p>
     * 输入：path = "/a/./b/../../c/"
     * 输出："/c"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/simplify-path
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String simplifyPath(String path) {
        Stack<String> stack = new Stack<>();
        String[] strArr = path.split("/");
        for (String s : strArr) {
            if (s.equals("") || s.equals(".")) {
                continue;
            }
            if (s.equals("..")) {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(s);
            }

        }
        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.isEmpty()) {
            stringBuilder.insert(0, stack.pop() + "/");
        }
        stringBuilder.insert(0, "/");
        if (stringBuilder.length() > 1) {
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
        }
        return stringBuilder.toString();
    }

    /**
     * 给你两个单词word1 和word2，请你计算出将word1转换成word2 所使用的最少操作数。
     * <p>
     * 你可以对一个单词进行如下三种操作：
     * <p>
     * 插入一个字符
     * 删除一个字符
     * 替换一个字符
     * <p>
     * <p>
     * 示例1：
     * <p>
     * 输入：word1 = "horse", word2 = "ros"
     * 输出：3
     * 解释：
     * horse -> rorse (将 'h' 替换为 'r')
     * rorse -> rose (删除 'r')
     * rose -> ros (删除 'e')
     * 示例2：
     * <p>
     * 输入：word1 = "intention", word2 = "execution"
     * 输出：5
     * 解释：
     * intention -> inention (删除 't')
     * inention -> enention (将 'i' 替换为 'e')
     * enention -> exention (将 'n' 替换为 'x')
     * exention -> exection (将 'n' 替换为 'c')
     * exection -> execution (插入 'u')
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/edit-distance
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minDistance(String word1, String word2) {
        int wordOneLength = word1.length();
        int wordTwoLength = word2.length();
        if (wordOneLength * wordTwoLength == 0) {
            return wordOneLength + wordTwoLength;
        }
        int[][] dp = new int[wordOneLength + 1][wordTwoLength + 1];
        for (int i = 0; i < wordOneLength + 1; i++) {
            dp[i][0] = i;
        }
        for (int j = 0; j < wordTwoLength + 1; j++) {
            dp[0][j] = j;
        }

        for (int l = 1; l < wordOneLength + 1; l++) {
            for (int m = 1; m < wordTwoLength + 1; m++) {
                int delete = dp[l - 1][m] + 1;//word1删除1个
                int insert = dp[l][m - 1] + 1;//word1插入一个
                int change = dp[l - 1][m - 1];//word替换一个
                if (word1.charAt(l - 1) != word2.charAt(m - 1)) {
                    change += 1;
                }
                dp[l][m] = Math.min(delete, Math.min(insert, change));
            }
        }
        return dp[wordOneLength][wordTwoLength];
    }

    /**
     * 给定一个m x n 的矩阵，如果一个元素为 0 ，则将其所在行和列的所有元素都设为 0 。请使用 原地 算法。
     * <p>
     * 进阶：
     * <p>
     * 一个直观的解决方案是使用 O(mn)的额外空间，但这并不是一个好的解决方案。
     * 一个简单的改进方案是使用 O(m+n) 的额外空间，但这仍然不是最好的解决方案。
     * 你能想出一个仅使用常量空间的解决方案吗？
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [[1,1,1],[1,0,1],[1,1,1]]
     * 输出：[[1,0,1],[0,0,0],[1,0,1]]
     * 示例 2：
     * <p>
     * <p>
     * 输入：matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     * 输出：[[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[0].length
     * 1 <= m, n <= 200
     * -231 <= matrix[i][j] <= 231 - 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/set-matrix-zeroes
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     */
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean lineHasZero = false;
        boolean columnHasZero = false;
        for (int i = 0; i < n; i++) {
            if (matrix[0][i] == 0) {
                lineHasZero = true;
                break;
            }
        }
        for (int[] ints : matrix) {
            if (ints[0] == 0) {
                columnHasZero = true;
                break;
            }
        }

        for (int l = 1; l < m; l++) {
            for (int k = 1; k < n; k++) {
                if (matrix[l][k] == 0) {
                    matrix[l][0] = matrix[0][k] = 0;
                }
            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if (columnHasZero) {
            for (int i = 0; i < m; i++) {
                matrix[i][0] = 0;
            }
        }
        if (lineHasZero) {
            for (int j = 0; j < n; j++) {
                matrix[0][j] = 0;
            }
        }
    }

    /**
     * 编写一个高效的算法来判断m x n矩阵中，是否存在一个目标值。该矩阵具有如下特性：
     * <p>
     * 每行中的整数从左到右按升序排列。
     * 每行的第一个整数大于前一行的最后一个整数。
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == matrix.length
     * n == matrix[i].length
     * 1 <= m, n <= 100
     * -104 <= matrix[i][j], target <= 104
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/search-a-2d-matrix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param matrix
     * @param target
     * @return
     */
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int lines;
        int left = -1;
        int right = m - 1;
        while (left < right) {
            int mid = (right - left + 1) / 2 + left;
            if (matrix[mid][0] <= target) {
                left = mid;
            } else {
                right = mid - 1;
            }
        }
        if (left < 0 || left > m) {
            return false;
        }
        lines = left;
        left = 0;
        right = n - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (matrix[lines][mid] == target) {
                return true;
            } else if (matrix[lines][mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return false;
    }


    /**
     * 给定一个包含红色、白色和蓝色，一共n 个元素的数组，原地对它们进行排序，使得相同颜色的元素相邻，并按照红色、白色、蓝色顺序排列。
     * <p>
     * 此题中，我们使用整数 0、1 和 2 分别表示红色、白色和蓝色。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [2,0,2,1,1,0]
     * 输出：[0,0,1,1,2,2]
     * 示例 2：
     * <p>
     * 输入：nums = [2,0,1]
     * 输出：[0,1,2]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[0]
     * 示例 4：
     * <p>
     * 输入：nums = [1]
     * 输出：[1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sort-colors
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     */
    public void sortColors(int[] nums) {
        //将数组化成三个区间，[0,zero),都是0，[zero,i)都是1,[i,length-1]都是2
        int length = nums.length;
        int i = 0;
        int zero = 0;
        int two = length;
        //遍历到之后全是2就停下来
        while (i < two) {
            if (nums[i] == 0) {
                //找到的第几个0就是第zero个，交换的位置为zero
                swap(nums, i, zero);
                zero++;
                i++;
            } else if (nums[i] == 1) {
                i++;
            } else if (nums[i] == 2) {
                two--;
                //找到的第几个2就是第length-two个，交换的位置为two
                swap(nums, i, two);
            }
        }
    }

    private void swap(int[] nums, int index1, int index2) {
        int temp = nums[index1];
        nums[index1] = nums[index2];
        nums[index2] = temp;
    }

    /**
     * 给你一个字符串 s 、一个字符串 t 。返回 s 中涵盖 t 所有字符的最小子串。如果 s 中不存在涵盖 t 所有字符的子串，则返回空字符串 "" 。
     * <p>
     * 注意：如果 s 中存在这样的子串，我们保证它是唯一的答案。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "ADOBECODEBANC", t = "ABC"
     * 输出："BANC"
     * 示例 2：
     * <p>
     * 输入：s = "a", t = "a"
     * 输出："a"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 1 <= s.length, t.length <= 105
     * s 和 t 由英文字母组成
     * <p>
     * <p>
     * 进阶：你能设计一个在 o(n) 时间内解决此问题的算法吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-window-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @param t
     * @return
     */
    HashMap<Character, Integer> targetMap = new HashMap<>();
    HashMap<Character, Integer> answerMap = new HashMap<>();

    public String minWindow(String s, String t) {
        for (int i = 0; i < t.length(); i++) {
            targetMap.put(t.charAt(i), targetMap.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = -1;
        int answerLength = Integer.MAX_VALUE, answerLeft = -1, answerRight = -1;
        int sLength = s.length();
        while (right < sLength) {
            ++right;
            if (right < sLength && targetMap.containsKey(s.charAt(right))) {
                answerMap.put(s.charAt(right), answerMap.getOrDefault(s.charAt(right), 0) + 1);
            }
            while (checkout() && left <= right) {
                if (right - left + 1 < answerLength) {
                    answerLength = right - left + 1;
                    answerLeft = left;
                    answerRight = left + answerLength;
                }
                if (targetMap.containsKey(s.charAt(left))) {
                    answerMap.put(s.charAt(left), answerMap.getOrDefault(s.charAt(left), 0) - 1);
                }
                ++left;
            }
        }
        return answerLeft == -1 ? "" : s.substring(answerLeft, answerRight);
    }

    private boolean checkout() {
        for (Map.Entry<Character, Integer> characterIntegerEntry : targetMap.entrySet()) {
            Character key = characterIntegerEntry.getKey();
            Integer value = characterIntegerEntry.getValue();
            if (answerMap.getOrDefault(key, 0) < value) {
                return false;
            }
        }
        return true;
    }

    /**
     * 给定两个整数 n 和 k，返回 1 ... n 中所有可能的 k 个数的组合。
     * <p>
     * 示例:
     * <p>
     * 输入:n = 4, k = 2
     * 输出:
     * [
     * [2,4],
     * [3,4],
     * [2,3],
     * [1,2],
     * [1,3],
     * [1,4],
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/combinations
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @param k
     * @return
     */
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> answer = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        backTraceCombine(answer, temp, n, k, 1);
        return answer;
    }

    private void backTraceCombine(List<List<Integer>> answer, List<Integer> temp, int n, int k, int startIndex) {
        if (temp.size() == k) {
            answer.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i <= n - (k - temp.size()) + 1; i++) {
            temp.add(i);
            backTraceCombine(answer, temp, n, k, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 给你一个整数数组nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
     * <p>
     * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,2,3]
     * 输出：[[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
     * 示例 2：
     * <p>
     * 输入：nums = [0]
     * 输出：[[],[0]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/subsets
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public List<List<Integer>> subsets(int[] nums) {
        int length = nums.length;
        List<List<Integer>> answerList = new ArrayList<>();
        for (int i = 0; i <= length; i++) {
            backTraceSubsets(answerList, i, 0, nums, new ArrayList<>(), length);
        }
        return answerList;
    }

    private void backTraceSubsets(List<List<Integer>> answerList, int size, int startIndex, int[] nums, List<Integer> temp, int length) {
        if (temp.size() == size) {
            answerList.add(new ArrayList<>(temp));
            return;
        }
        for (int i = startIndex; i <= length - (size - temp.size()); i++) {
            temp.add(nums[i]);
            backTraceSubsets(answerList, size, i + 1, nums, temp, length);
            temp.remove(temp.size() - 1);
        }
    }

    /**
     * 给定一个m x n 二维字符网格board 和一个字符串单词word 。如果word 存在于网格中，返回 true ；否则，返回 false 。
     * <p>
     * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCCED"
     * 输出：true
     * 示例 2：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "SEE"
     * 输出：true
     * 示例 3：
     * <p>
     * <p>
     * 输入：board = [["A","B","C","E"],["S","F","C","S"],["A","D","E","E"]], word = "ABCB"
     * 输出：false
     * <p>
     * <p>
     * 提示：
     * <p>
     * m == board.length
     * n = board[i].length
     * 1 <= m, n <= 6
     * 1 <= word.length <= 15
     * board 和 word 仅由大小写英文字母组成
     * <p>
     * <p>
     * 进阶：你可以使用搜索剪枝的技术来优化解决方案，使其在 board 更大的情况下可以更快解决问题？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/word-search
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param board
     * @param word
     * @return
     */
    private boolean mExist;

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int lines = board.length;
        int columns = board[0].length;
        for (int i = 0; i < lines; i++) {
            for (int j = 0; j < columns; j++) {
                if (board[i][j] == chars[0]) {
                    boolean[][] used = new boolean[lines][columns];
                    used[i][j] = true;
                    backTraceExit(chars, 1, lines, columns, i, j, board, used);
                }
            }
        }
        return mExist;
    }

    private void backTraceExit(char[] chars, int matchIndex, int lines, int columns, int line, int column, char[][] board, boolean[][] used) {
        if (mExist) {
            return;
        }
        if (matchIndex == chars.length) {
            mExist = true;
            return;
        }
        char matchChar = chars[matchIndex];
        //上面的
        if (line > 0 && board[line - 1][column] == matchChar && !used[line - 1][column]) {
            used[line - 1][column] = true;
            backTraceExit(chars, matchIndex + 1, lines, columns, line - 1, column, board, used);
            used[line - 1][column] = false;
        }
        //下面的
        if (line < lines - 1 && board[line + 1][column] == matchChar && !used[line + 1][column]) {
            used[line + 1][column] = true;
            backTraceExit(chars, matchIndex + 1, lines, columns, line + 1, column, board, used);
            used[line + 1][column] = false;
        }
        //左边的
        if (column > 0 && board[line][column - 1] == matchChar && !used[line][column - 1]) {
            used[line][column - 1] = true;
            backTraceExit(chars, matchIndex + 1, lines, columns, line, column - 1, board, used);
            used[line][column - 1] = false;
        }
        //右边的
        if (column < columns - 1 && board[line][column + 1] == matchChar && !used[line][column + 1]) {
            used[line][column + 1] = true;
            backTraceExit(chars, matchIndex + 1, lines, columns, line, column + 1, board, used);
            used[line][column + 1] = false;

        }
    }


}
