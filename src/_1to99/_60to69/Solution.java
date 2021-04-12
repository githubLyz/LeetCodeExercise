package _1to99._60to69;

import bean.LinkedNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author YuJoy
 * @date 2021/4/3 15:00
 * @description: 60~69题解
 */
public class Solution {
    /**
     * 给出集合[1,2,3,...,n]，其所有元素共有n! 种排列。
     * <p>
     * 按大小顺序列出所有排列情况，并一一标记，当n = 3 时, 所有排列如下：
     * <p>
     * "123"
     * "132"
     * "213"
     * "231"
     * "312"
     * "321"
     * 给定n 和k，返回第k个排列。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * 输入：n = 3, k = 3
     * 输出："213"
     * 示例 2：
     * <p>
     * 输入：n = 4, k = 9
     * 输出："2314"
     * 示例 3：
     * <p>
     * 输入：n = 3, k = 1
     * 输出："123"
     * <p>
     * 提示：
     * <p>
     * 1 <= n <= 9
     * 1 <= k <= n!
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/permutation-sequence
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String getPermutation(int n, int k) {
        if (n == 1) {
            return "1";
        }
        if (n == 2) {
            if (k == 2) {
                return "21";
            } else {
                return "12";
            }
        }
        //经过观察规律，距离n=4,一共有4*3*2*1=24种排列，1~6中排列，是1在首尾，移动234，即转化成3*2*1=6种排列顺序，我们看作第一段排列
        //以此类推，7~12，是2在首尾，移动134，也有6种情况，我们看成第二段排列
        //若k=20,即k在20/(n-1)！=4(向上取整)，在第4段排列，第20/(n-1)!=2个排列
        //此时，以4为开头，123开始排列，第二个就是答案，为4132
        List<Integer> list = new ArrayList<>(n);
        StringBuffer sb = new StringBuffer();
        for (int i = 1; i < n + 1; i++) {
            list.add(i);
        }
        fill(sb, list, n, k);
        System.out.println("sb = " + sb.toString());
        return sb.toString();
    }

    private void fill(StringBuffer sb, List<Integer> list, int n, int k) {


        //我们先计算每一段排列的大小
        int size = 1;

        for (int i = 1; i < n; i++) {
            size = size * i;
        }

        //计算是在第几段
        int index = k / size;
        int indexOfPart = k % size;
        index = indexOfPart == 0 ? index - 1 : index;
        indexOfPart = indexOfPart == 0 ? size : indexOfPart;
        sb.append(list.get(index));
        //计算在一小段中的第几个
        //剔除掉已经添加到首尾的元素
        list.remove(index);
        if (list.size() == 2) {
            if (indexOfPart == 2) {
                sb.append(list.get(1));
                sb.append(list.get(0));
            } else {
                sb.append(list.get(0));
                sb.append(list.get(1));
            }
            return;
        }
        fill(sb, list, n - 1, indexOfPart);
    }

    /**
     * 给你一个链表的头节点 head ，旋转链表，将链表每个节点向右移动k个位置。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：head = [1,2,3,4,5], k = 2
     * 输出：[4,5,1,2,3]
     * 示例 2：
     * <p>
     * <p>
     * 输入：head = [0,1,2], k = 4
     * 输出：[2,0,1]
     * <p>
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目在范围 [0, 500] 内
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     * <p>
     * 提示：
     * <p>
     * 链表中节点的数目在范围 [0, 500] 内
     * -100 <= Node.val <= 100
     * 0 <= k <= 2 * 109
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/rotate-list
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param head
     * @param k
     * @return
     */
    public LinkedNode rotateRight(LinkedNode head, int k) {
        if (k == 0 || head == null || head.next == null) {
            return head;
        }
        //思考，根据提示，k可能远远大于链表的总长度，会出现循环的问题，
        //所以先遍历节点，获取到链表长度，然后取余数，遍历的过程中，可以将链表成环，再断开就行了
        int size = 0;
        LinkedNode tempNode = new LinkedNode();
        tempNode.next = head;
        while (tempNode.next != null) {
            tempNode = tempNode.next;
            size++;
        }

        //遍历完之后，tempNode就是尾节点
        tempNode.next = head;
        int moveStep = k % size;
        //尾节点开始移动size-moveStep-1次，此时就是新链表的尾节点
        for (int i = 0; i < size - moveStep - 1; i++) {
            head = head.next;
        }
        LinkedNode newHeadNode = head.next;
        //断开
        head.next = null;
        return newHeadNode;
    }

    /**
     * 一个机器人位于一个 m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
     * <p>
     * 问总共有多少条不同的路径？
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：m = 3, n = 7
     * 输出：28
     * 示例 2：
     * <p>
     * 输入：m = 3, n = 2
     * 输出：3
     * 解释：
     * 从左上角开始，总共有 3 条路径可以到达右下角。
     * 1. 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右
     * 3. 向下 -> 向右 -> 向下
     * 示例 3：
     * <p>
     * 输入：m = 7, n = 3
     * 输出：28
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        dp[0][0] = 1;
        for (int i = 1; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int j = 1; j < m; j++) {
            dp[j][0] = 1;
        }
        for (int l = 1; l < m; l++) {
            for (int k = 1; k < n; k++) {
                dp[l][k] = dp[l - 1][k] + dp[l][k - 1];
            }
        }
        return dp[m - 1][n - 1];
    }


    /**
     * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为“Start” ）。
     * <p>
     * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为“Finish”）。
     * <p>
     * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
     * <p>
     * <p>
     * <p>
     * 网格中的障碍物和空位置分别用 1 和 0 来表示。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,0,0],[0,1,0],[0,0,0]]
     * 输出：2
     * 解释：
     * 3x3 网格的正中间有一个障碍物。
     * 从左上角到右下角一共有 2 条不同的路径：
     * 1. 向右 -> 向右 -> 向下 -> 向下
     * 2. 向下 -> 向下 -> 向右 -> 向右
     * 示例 2：
     * <p>
     * <p>
     * 输入：obstacleGrid = [[0,1],[0,0]]
     * 输出：1
     * <p>
     * <p>
     * 提示：
     * <p>
     * m ==obstacleGrid.length
     * n ==obstacleGrid[i].length
     * 1 <= m, n <= 100
     * obstacleGrid[i][j] 为 0 或 1
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/unique-paths-ii
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param obstacleGrid
     * @return
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length;
        int n = obstacleGrid[0].length;
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        boolean hasMObstacle = false;
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0 && !hasMObstacle) {
                dp[i][0] = 1;
            } else {
                hasMObstacle = true;
                dp[i][0] = 0;
            }
        }
        boolean hasNObstacle = false;
        for (int i = 0; i < n; i++) {
            if (obstacleGrid[0][i] == 0 && !hasNObstacle) {
                dp[0][i] = 1;
            } else {
                hasNObstacle = true;
                dp[0][i] = 0;

            }
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[m - 1][n - 1];
    }

    /**
     * 给定一个包含非负整数的 mxn网格grid ，请找出一条从左上角到右下角的路径，使得路径上的数字总和为最小。
     * <p>
     * 说明：每次只能向下或者向右移动一步。
     * <p>
     * <p>
     * <p>
     * 示例 1：
     * <p>
     * <p>
     * 输入：grid = [[1,3,1],[1,5,1],[4,2,1]]
     * 输出：7
     * 解释：因为路径 1→3→1→1→1 的总和最小。
     * 示例 2：
     * <p>
     * 输入：grid = [[1,2,3],[4,5,6]]
     * 输出：12
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/minimum-path-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for (int j = 1; j < n; j++) {
            dp[0][j] = dp[0][j - 1] + grid[0][j];
        }
        for (int l = 1; l < m; l++) {
            for (int k = 1; k < n; k++) {
                dp[l][k] = Math.min(dp[l][k - 1], dp[l - 1][k]) + grid[l][k];
            }
        }
        return dp[m - 1][n - 1];
    }

    /**
     * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。
     * <p>
     * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
     * <p>
     * 你可以假设除了整数 0 之外，这个整数不会以零开头。
     * <p>
     * <p>
     * <p>
     * 示例1：
     * <p>
     * 输入：digits = [1,2,3]
     * 输出：[1,2,4]
     * 解释：输入数组表示数字 123。
     * 示例2：
     * <p>
     * 输入：digits = [4,3,2,1]
     * 输出：[4,3,2,2]
     * 解释：输入数组表示数字 4321。
     * 示例 3：
     * <p>
     * 输入：digits = [0]
     * 输出：[1]
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/plus-one
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param digits
     * @return
     */
    public int[] plusOne(int[] digits) {
        int needAdd;
        int temp = digits[digits.length - 1] + 1;
        if (temp < 10) {
            digits[digits.length - 1] = temp;
            return digits;
        } else {
            needAdd = 1;
            digits[digits.length - 1] = temp - 10;
            for (int i = digits.length - 2; i > -1; i--) {
                temp = digits[i] + needAdd;
                if (temp > 9) {
                    needAdd = 1;
                    digits[i] = temp - 10;

                } else {
                    needAdd = 0;
                    digits[i] = temp;
                    break;
                }
            }
        }
        if (needAdd == 1) {
            int[] result = new int[digits.length + 1];
            result[0] = 1;
            System.arraycopy(digits, 0, result, 1, result.length - 1 - 1);
            return result;
        }
        return digits;
    }

    /**
     * 给你两个二进制字符串，返回它们的和（用二进制表示）。
     * <p>
     * 输入为 非空 字符串且只包含数字1和0。
     * <p>
     * <p>
     * <p>
     * 示例1:
     * <p>
     * 输入: a = "11", b = "1"
     * 输出: "100"
     * 示例2:
     * <p>
     * 输入: a = "1010", b = "1011"
     * 输出: "10101"
     * <p>
     * <p>
     * 提示：
     * <p>
     * 每个字符串仅由字符 '0' 或 '1' 组成。
     * 1 <= a.length, b.length <= 10^4
     * 字符串如果不是 "0" ，就都不含前导零。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-binary
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String addBinary(String a, String b) {
        StringBuilder stringBuffer = new StringBuilder();
        int aLength = a.length();
        int bLength = b.length();
        int indexA = aLength - 1;
        int indexB = bLength - 1;
        char aChar, bChar, plus;
        plus = '0';
        int sum = 0;
        while (indexA > -1 || indexB > -1) {
            aChar = indexA > -1 ? a.charAt(indexA) : '0';
            bChar = indexB > -1 ? b.charAt(indexB) : '0';
            sum = (aChar - '0') + (bChar - '0') + (plus - '0');
            if (sum > 1) {
                plus = '1';
                stringBuffer.insert(0, sum - 2);
            } else {
                plus = '0';
                stringBuffer.insert(0, sum);
            }
            indexA--;
            indexB--;
        }
        if (plus - '0' > 0) {
            stringBuffer.insert(0, "1");
        }
        return stringBuffer.toString();
    }

    /**
     * 给定一个单词数组和一个长度maxWidth，重新排版单词，使其成为每行恰好有maxWidth个字符，且左右两端对齐的文本。
     * <p>
     * 你应该使用“贪心算法”来放置给定的单词；也就是说，尽可能多地往每行中放置单词。必要时可用空格' '填充，使得每行恰好有 maxWidth个字符。
     * <p>
     * 要求尽可能均匀分配单词间的空格数量。如果某一行单词间的空格不能均匀分配，则左侧放置的空格数要多于右侧的空格数。
     * <p>
     * 文本的最后一行应为左对齐，且单词之间不插入额外的空格。
     * <p>
     * 说明:
     * <p>
     * 单词是指由非空格字符组成的字符序列。
     * 每个单词的长度大于 0，小于等于maxWidth。
     * 输入单词数组 words至少包含一个单词。
     * 示例:
     * <p>
     * 输入:
     * words = ["This", "is", "an", "example", "of", "text", "justification."]
     * maxWidth = 16
     * 输出:
     * [
     * "This  is   an",
     * "example of text",
     * "justification. "
     * ]
     * 示例2:
     * <p>
     * 输入:
     * words = ["What","must","be","acknowledgment","shall","be"]
     * maxWidth = 16
     * 输出:
     * [
     * "What  must   be",
     * "acknowledgment ",
     * "shall    be    "
     * ]
     * 解释: 注意最后一行的格式应为 "shall be    " 而不是 "shall     be",
     * 因为最后一行应为左对齐，而不是左右两端对齐。
     * 第二行同样为左对齐，这是因为这行只包含一个单词。
     * 示例3:
     * <p>
     * 输入:
     * words = ["Science","is","what","we","understand","well","enough","to","explain",
     * "to","a","computer.","Art","is","everything","else","we","do"]
     * maxWidth = 20
     * 输出:
     * [
     * "Science is   what we",
     * "understand      well",
     * "enough to explain to",
     * "a computer.   Art is",
     * "everything   else we",
     * "do                  "
     * ]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/text-justification
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> ans = new ArrayList<>();
        int currentLen = 0;
        int start = 0;
        int end = 0;
        for (int i = 0; i < words.length; ) {
            //判断加入该单词是否超过最长长度
            //分了两种情况，一种情况是加入第一个单词，不需要多加 1
            //已经有单词的话，再加入单词，需要多加个空格，所以多加了 1
            if (currentLen == 0 && currentLen + words[i].length() <= maxWidth
                    || currentLen > 0 && currentLen + 1 + words[i].length() <= maxWidth) {
                end++;
                if (currentLen == 0) {
                    currentLen = currentLen + words[i].length();
                } else {
                    currentLen = currentLen + 1 + words[i].length();
                }
                i++;
            } else {
                int sub = maxWidth - currentLen + (end - start) - 1;
                if (end - start == 1) {
                    String blank = getStringBlank(sub);
                    ans.add(words[start] + blank);
                } else {
                    StringBuilder temp = new StringBuilder();
                    temp.append(words[start]);
                    int averageBlank = sub / ((end - start) - 1);
                    //如果除不尽，计算剩余空格数
                    int missing = sub - averageBlank * ((end - start) - 1);
                    String blank = getStringBlank(averageBlank + 1);
                    int k = 1;
                    for (int j = 0; j < missing; j++) {
                        temp.append(blank).append(words[start + k]);
                        k++;
                    }
                    blank = getStringBlank(averageBlank);
                    for (; k < (end - start); k++) {
                        temp.append(blank).append(words[start + k]);
                    }
                    ans.add(temp.toString());

                }
                start = end;
                currentLen = 0;

            }
        }
        StringBuilder temp = new StringBuilder();
        temp.append(words[start]);
        for (int i = 1; i < (end - start); i++) {
            temp.append(" ").append(words[start + i]);
        }
        temp.append(getStringBlank(maxWidth - currentLen));
        ans.add(temp.toString());
        return ans;
    }

    //得到 n 个空白
    private String getStringBlank(int n) {
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < n; i++) {
            str.append(" ");
        }
        return str.toString();
    }

    /**
     * 实现int sqrt(int x)函数。
     * <p>
     * 计算并返回x的平方根，其中x 是非负整数。
     * <p>
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * <p>
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/sqrtx
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     *
     * @param x
     * @return
     */
    public int mySqrt(int x) {
        if (x == 1) {
            return 1;
        }
        int min = 0;
        int max = x;
        int mid;
        while (max > min + 1) {
            mid = (max + min) / 2;
            if (x / mid < mid) {
                max = mid;
            } else if (x / mid == mid) {
                min = mid;
                break;
            } else {
                min = mid;
            }
        }
        return min;
    }
}
