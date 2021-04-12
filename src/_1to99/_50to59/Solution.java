package _1to99._50to59;

import bean.LinkedNode;

import java.util.*;

/**
 * @author YuJoy
 * @date 2021/3/28 23:11
 * @description: 50-59题解
 */
public class Solution {
    /**
     * 实现pow(x, n)，即计算 x 的 n 次幂函数（即，xn）。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：x = 2.00000, n = 10
     * 输出：1024.00000
     * 示例 2：
     * <p>
     * 输入：x = 2.10000, n = 3
     * 输出：9.26100
     * 示例 3：
     * <p>
     * 输入：x = 2.00000, n = -2
     * 输出：0.25000
     * 解释：2-2 = 1/22 = 1/4 = 0.25
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/powx-n
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @param n
     * @return
     */
    public double myPow(double x, int n) {
        return n >= 0 ? quickMul(x, n) : 1.0 / quickMul(x, -(long) n);
    }

    private double quickMul(double x, long n) {
        if (n == 0) {
            return 1.0;
        }
        double y = quickMul(x, n / 2);
        return n % 2 == 0 ? y * y : y * y * x;

    }

    /**
     * n皇后问题 研究的是如何将 n个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
     * <p>
     * 给你一个整数 n ，返回所有不同的n皇后问题 的解决方案。
     * <p>
     * 每一种解法包含一个不同的n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
     * <p>
     * 输入：n = 4
     * 输出：[[".Q..","...Q","Q...","..Q."],["..Q.","Q...","...Q",".Q.."]]
     * 解释：如上图所示，4 皇后问题存在两个不同的解法。
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：[["Q"]]
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/n-queens
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */

    public List<List<String>> solveNQueens(int n) {
        List<List<String>> solutions = new ArrayList<>();
        int[] queens = new int[n];
        Arrays.fill(queens, -1);
        Set<Integer> columns = new HashSet<>();
        Set<Integer> diagonals1 = new HashSet<>();
        Set<Integer> diagonals2 = new HashSet<>();
        backTraceQueens(solutions, queens, n, 0, columns, diagonals1, diagonals2);
        return solutions;
    }

    private void backTraceQueens(List<List<String>> solutions, int[] queens, int n, int row, Set<Integer> columns, Set<Integer> diagonals1, Set<Integer> diagonals2) {
        if (row == n) {
            List<String> board = generateBoard(queens, n);
            solutions.add(board);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (columns.contains(i)) {
                continue;
            }
            if (diagonals1.contains(row - i)) {
                continue;
            }
            if (diagonals2.contains(row + i)) {
                continue;
            }
            queens[row] = i;
            columns.add(i);
            diagonals1.add(row - i);
            diagonals2.add(row + i);
            backTraceQueens(solutions, queens, n, row + 1, columns, diagonals1, diagonals2);
            queens[row] = -1;
            columns.remove(i);
            diagonals1.remove(row - i);
            diagonals2.remove(row + i);
        }
    }

    public List<String> generateBoard(int[] queens, int n) {
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            char[] row = new char[n];
            Arrays.fill(row, '.');
            row[queens[i]] = 'Q';
            board.add(new String(row));
        }
        return board;
    }

    /**
     * 给定一个整数数组 nums，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-2,1,-3,4,-1,2,1,-5,4]
     * 输出：6
     * 解释：连续子数组[4,-1,2,1] 的和最大，为6 。
     * 示例 2：
     * <p>
     * 输入：nums = [1]
     * 输出：1
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：0
     * 示例 4：
     * <p>
     * 输入：nums = [-1]
     * 输出：-1
     * 示例 5：
     * <p>
     * 输入：nums = [-100000]
     * 输出：-100000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/maximum-subarray
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public int maxSubArray(int[] nums) {
        int pre = 0, max = nums[0];
        for (int value : nums) {
            pre = Math.max(value, pre + value);
            max = Math.max(pre, max);
        }
        return max;
    }

    /**
     * 给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
     * 输入：matrix = [[1,2,3],
     * [4,5,6],
     * [7,8,9]]
     * 输出：[1,2,3,6,9,8,7,4,5]
     * 输入：matrix = [[1,2,3,4],
     * [5,6,7,8],
     * [9,10,11,12]]
     * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
     *
     * @param matrix
     * @return
     */
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> results = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return results;
        }
        int left = 0;
        int right = matrix[0].length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (left <= right && top <= bottom) {
            for (int i = left; i <= right; i++) {
                results.add(matrix[top][i]);
            }
            for (int j = top + 1; j <= bottom; j++) {
                results.add(matrix[j][right]);
            }
            if (left < right && top < bottom) {
                for (int l = right - 1; l > left; l--) {
                    results.add(matrix[bottom][l]);
                }
                for (int k = bottom; k > top; k--) {
                    results.add(matrix[k][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return results;
    }

    /**
     * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
     * <p>
     * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
     * <p>
     * 判断你是否能够到达最后一个下标。
     * <p>
     * <p>
     * <p>
     * 示例1：
     * <p>
     * 输入：nums = [2,3,1,1,4]
     * 输出：true
     * 解释：可以先跳 1 步，从下标 0 到达下标 1, 然后再从下标 1 跳 3 步到达最后一个下标。
     * 示例2：
     * <p>
     * 输入：nums = [3,2,1,0,4]
     * 输出：false
     * 解释：无论怎样，总会到达下标为 3 的位置。但该下标的最大跳跃长度是 0 ， 所以永远不可能到达最后一个下标。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/jump-game
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param nums
     * @return
     */
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i <= max) {
                max = Math.max(max, i + nums[i]);
                if (max >= nums.length - 1) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。
     * <p>
     *
     * <p>
     * 示例 1：
     * <p>
     * 输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
     * 输出：[[1,6],[8,10],[15,18]]
     * 解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
     * 示例2：
     * <p>
     * 输入：intervals = [[1,4],[4,5]]
     * 输出：[[1,5]]
     * 解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。
     *
     * @param intervals
     * @return
     */
    public int[][] merge(int[][] intervals) {
        if (intervals.length == 0 || intervals.length == 1) {
            return intervals;
        }
        List<int[]> results = new ArrayList<>();
        for (int[] interval : intervals) {
            for (int i = 0; i < results.size(); i++) {
                int[] item = results.get(i);
                //1.相交，可以合并
                if ((interval[0] >= item[0] && interval[0] <= item[1]) ||
                        (interval[1] >= item[0] && interval[1] <= item[1]) ||
                        (item[1] >= interval[0] && item[1] <= interval[1]) ||
                        (item[0] >= interval[0] && item[0] <= interval[1])) {
                    interval[0] = Math.min(item[0], interval[0]);
                    interval[1] = Math.max(item[1], interval[1]);
                    results.remove(item);
                    //2.移除之后，需要继续比较当前位置的item
                    i--;
                }
            }
            results.add(interval);

        }
        return results.toArray(new int[0][]);
    }

    /**
     * 给你一个 无重叠的 ，按照区间起始端点排序的区间列表。
     * <p>
     * 在列表中插入一个新的区间，你需要确保列表中的区间仍然有序且不重叠（如果有必要的话，可以合并区间）。
     * <p>
     *
     * <p>
     * 示例1：
     * <p>
     * 输入：intervals = [[1,3],[6,9]], newInterval = [2,5]
     * 输出：[[1,5],[6,9]]
     * 示例 2：
     * <p>
     * 输入：intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
     * 输出：[[1,2],[3,10],[12,16]]
     * 解释：这是因为新的区间 [4,8] 与 [3,5],[6,7],[8,10]重叠。
     * 示例 3：
     * <p>
     * 输入：intervals = [], newInterval = [5,7]
     * 输出：[[5,7]]
     * 示例 4：
     * <p>
     * 输入：intervals = [[1,5]], newInterval = [2,3]
     * 输出：[[1,5]]
     * 示例 5：
     * <p>
     * 输入：intervals = [[1,5]], newInterval = [2,7]
     * 输出：[[1,7]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/insert-interval
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param intervals
     * @param newInterval
     * @return
     */
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> results = new ArrayList<>();
        int left = newInterval[0];
        int right = newInterval[1];
        boolean hasInsert = false;
        for (int[] interval : intervals) {
            if (interval[1] < left) {
                results.add(interval);
            } else if (interval[0] > right) {
                if (!hasInsert) {
                    hasInsert = true;
                    results.add(new int[]{left, right});
                }
                results.add(interval);
            } else {
                left = Math.min(left, interval[0]);
                right = Math.max(right, interval[1]);
            }

        }
        if (!hasInsert) {
            results.add(new int[]{left, right});
        }

        return results.toArray(new int[0][]);
    }

    /**
     * 给你一个字符串 s，由若干单词组成，单词之间用空格隔开。返回字符串中最后一个单词的长度。如果不存在最后一个单词，请返回 0。
     * <p>
     * 单词 是指仅由字母组成、不包含任何空格字符的最大子字符串。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：s = "Hello World"
     * 输出：5
     * 示例 2：
     * <p>
     * 输入：s = " "
     * 输出：0
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/length-of-last-word
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param s
     * @return
     */
    public int lengthOfLastWord(String s) {
        int length = 0;
        for (int i = s.length() - 1; i > -1; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length != 0) {
                //最后一个单词是空格
                return length;
            }

        }
        return length;
    }

    /**
     * 给你一个正整数n ，生成一个包含 1 到n2所有元素，且元素按顺时针顺序螺旋排列的n x n 正方形矩阵 matrix 。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：n = 3
     * 输出：[[1,2,3],[8,9,4],[7,6,5]]
     * 示例 2：
     * <p>
     * 输入：n = 1
     * 输出：[[1]]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/spiral-matrix-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param n
     * @return
     */
    public int[][] generateMatrix(int n) {
        //每次填充n*n的最外边，分四步，横数横竖
        int[][] matrix = new int[n][n];
        int x = 0, y = 0;
        int startX = 0;
        int startY = 0;
        int endX = n - 1;
        int endY = n - 1;
        int value = 1;
        while (value < n * n + 1) {
            if (x == startX && y == startY) {
                //填充第一步
                while (y < endY + 1) {
                    matrix[x][y] = value;
                    value++;
                    y++;
                }
                y = endY;
            } else if (y == endY && x == startX) {
                x++;
                //填充第二步
                while (x < endX + 1) {
                    matrix[x][y] = value;
                    value++;
                    x++;
                }
                x = endX;
            } else if (x == endX && y == endY) {
                //填充第三步
                y--;
                while (y > startY - 1) {
                    matrix[x][y] = value;
                    value++;
                    y--;
                }
                y = startY;
            } else if (y == startY && x == endX) {
                //填充第四步
                x--;
                while (x > startX) {
                    matrix[x][y] = value;
                    value++;
                    x--;
                }
                startY++;
                startX++;
                endX--;
                endY--;
                x=startX;
                y=startY;
            }
        }

        for (int[] a : matrix) {
            System.out.println(Arrays.toString(a));
        }

        return matrix;
    }
}
