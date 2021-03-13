package _100._1to9;

import bean.ListNode;

import java.util.ArrayList;
import java.util.Stack;

/**
 * @author YuJoy
 * @date 2020/12/17 20:46
 * @description: LeetCode 1-9题解
 */
public class Solution {
    /**
     * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。
     * <p>
     * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。
     * 示例:
     * <p>
     * 给定 nums = [2, 7, 11, 15], target = 9
     * <p>
     * 因为 nums[0] + nums[1] = 2 + 7 = 9
     * 所以返回 [0, 1]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/two-sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        for (int i = 0; i < nums.length - 1; i++) {
            int numOne = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
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
     * <p>
     * 如果，我们将这两个数相加起来，则会返回一个新的链表来表示它们的和。
     * <p>
     * 您可以假设除了数字 0 之外，这两个数都不会以 0 开头。
     * <p>
     * 示例：
     * <p>
     * 输入：(2 -> 4 -> 3) + (5 -> 6 -> 4)
     * 输出：7 -> 0 -> 8
     * 原因：342 + 465 = 807
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/add-two-numbers
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //创建头节点，方便返回值
        ListNode headNode = new ListNode(-1);
        ListNode addNode = new ListNode();
        headNode.next = addNode;
        //标记位，不为0说明两数相加大于10，需要处理进位逻辑
        int needAdd = 0;
        //完整循环，需要处理一个链表遍历完之后，needAdd不为0，并且另一个链表剩下的节点val为9的特殊情况
        while (l1 != null || l2 != null) {
            //判空处理
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            ListNode ListNode = new ListNode();
            if (num1 + num2 + needAdd > 9) {
                ListNode.val = num1 + num2 + needAdd - 10;
                needAdd = 1;
            } else {
                ListNode.val = num1 + num2 + needAdd;
                needAdd = 0;
            }
            addNode.next = ListNode;
            addNode = addNode.next;
            //判空处理
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
        }
        //两个链表遍历完之后，needAdd不为0，说明还要进位1，创建新的节点，val为1
        if (needAdd != 0) {
            addNode.next = new ListNode(1);
        }
        return headNode.next.next;
    }


    /**
     * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
     * <p>
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: s = "abcabcbb"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
     * 示例 2:
     * <p>
     * 输入: s = "bbbbb"
     * 输出: 1
     * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
     * 示例 3:
     * <p>
     * 输入: s = "pwwkew"
     * 输出: 3
     * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
     *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
     * 示例 4:
     * <p>
     * 输入: s = ""
     * 输出: 0
     * <p>
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

    /**
     * 给定两个大小为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的中位数。
     * <p>
     * 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？
     * <p>
     *  
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums1 = [1,3], nums2 = [2]
     * 输出：2.00000
     * 解释：合并数组 = [1,2,3] ，中位数 2
     * 示例 2：
     * <p>
     * 输入：nums1 = [1,2], nums2 = [3,4]
     * 输出：2.50000
     * 解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
     * 示例 3：
     * <p>
     * 输入：nums1 = [0,0], nums2 = [0,0]
     * 输出：0.00000
     * 示例 4：
     * <p>
     * 输入：nums1 = [], nums2 = [1]
     * 输出：1.00000
     * 示例 5：
     * <p>
     * 输入：nums1 = [2], nums2 = []
     * 输出：2.00000
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/median-of-two-sorted-arrays
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int lengthOne = nums1.length;
        int lengthTwo = nums2.length;
        int length = lengthOne + lengthTwo;
        int[] recombinantNum = new int[length / 2 + 1];
        int oneCount = 0, twoCount = 0, recombinantCount = 0;
        while (recombinantCount < length / 2 + 1) {
            if (oneCount >= lengthOne && twoCount < lengthTwo) {
                recombinantNum[recombinantCount] = nums2[twoCount];
                twoCount++;
                recombinantCount++;
            } else if (twoCount >= lengthTwo && oneCount < lengthOne) {
                recombinantNum[recombinantCount] = nums1[oneCount];
                oneCount++;
                recombinantCount++;
            } else {
                if (nums1[oneCount] < nums2[twoCount]) {
                    recombinantNum[recombinantCount] = nums1[oneCount];
                    oneCount++;
                    recombinantCount++;
                } else if (nums1[oneCount] > nums2[twoCount]) {
                    recombinantNum[recombinantCount] = nums2[twoCount];
                    twoCount++;
                    recombinantCount++;
                } else {
                    recombinantNum[recombinantCount] = nums1[oneCount];
                    oneCount++;
                    recombinantCount++;
                }
            }
        }
        if (length % 2 == 0) {
            return (double) (recombinantNum[length / 2 - 1] + recombinantNum[length / 2]) / 2;
        } else {
            return recombinantNum[length / 2];
        }
    }

    /**
     * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。
     * <p>
     * 示例 1：
     * <p>
     * 输入: "babad"
     * 输出: "bab"
     * 注意: "aba" 也是一个有效答案。
     * 示例 2：
     * <p>
     * 输入: "cbbd"
     * 输出: "bb"
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-palindromic-substring
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestPalindrome(String s) {
        int length = s.length();
        //长度为1的时候，一定是回文
        if (length < 2) {
            return s;
        }
        int max = 1;
        int beginIndex = 0;
        //dp[i][i]代表s[i]到s[j]这段字符串是否为回文，j>i，
        boolean[][] dp = new boolean[length][length];
        for (int i = 0; i < length; i++) {
            dp[i][i] = true;
        }
        char[] chars = s.toCharArray();
        for (int j = 1; j < length; j++) {
            for (int i = 0; i < j; i++) {
                //chars[i] != chars[j]说明s[i]到s[j]首尾两个字符不相等，因此不是回文
                if (chars[i] != chars[j]) {
                    dp[i][j] = false;
                } else {
                    //比较回文是一步一步从两端往中间比较，s[i+1]到s[j—1]长度小于2的时候，就不需要比较，肯定是回文
                    //即满足j - 1 - (i + 1) + 1 < 2
                    if (j - i < 3) {
                        dp[i][j] = true;
                    } else {
                        //不满足就首尾收缩各一位dp[i + 1][j - 1]，如果是回文，那么dp[i][j]也是
                        dp[i][j] = dp[i + 1][j - 1];
                    }
                }
                //比较长度，记录开始的角标
                if (dp[i][j] && j - i + 1 > max) {
                    beginIndex = i;
                    max = j - i + 1;
                }
            }
        }
        return s.substring(beginIndex, beginIndex + max);
    }

    /**
     * 将一个给定字符串根据给定的行数，以从上往下、从左到右进行 Z 字形排列。
     * <p>
     * 比如输入字符串为 "LEETCODEISHIRING" 行数为 3 时，排列如下：
     * <p>
     * L   C   I   R
     * E T O E S I I G
     * E   D   H   N
     * 之后，你的输出需要从左往右逐行读取，产生出一个新的字符串，比如："LCIRETOESIIGEDHN"。
     * <p>
     * 请你实现这个将字符串进行指定行数变换的函数：
     * <p>
     * string convert(string s, int numRows);
     * 示例 1:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 3
     * 输出: "LCIRETOESIIGEDHN"
     * 示例 2:
     * <p>
     * 输入: s = "LEETCODEISHIRING", numRows = 4
     * 输出: "LDREOEIIECIHNTSG"
     * 解释:
     * <p>
     * L     D     R
     * E   O E   I I
     * E C   I H   N
     * T     S     G
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/zigzag-conversion
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String convert(String s, int numRows) {
        if (numRows == 1) {
            return s;
        }
        //最终输出的是按照一行一行的顺序，创建numRows个StringBuilder分别记录每一行的字符
        ArrayList<StringBuilder> stringBuilders = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            stringBuilders.add(new StringBuilder());
        }
        //记录当前是第几列
        int currentRow = 0;
        //记录当前是否按照从上到下的顺寻添加
        boolean goingDown = false;

        for (char c : s.toCharArray()) {
            stringBuilders.get(currentRow).append(c);
            //只有当currentRow == 0是第一行了或者currentRow == numRows - 1是最后一行了
            //方向goingDown需要改变
            if (currentRow == 0 || currentRow == numRows - 1) {
                goingDown = !goingDown;
            }
            currentRow += goingDown ? 1 : -1;
        }
        StringBuilder ret = new StringBuilder();
        for (StringBuilder stringBuilder : stringBuilders) ret.append(stringBuilder);
        return ret.toString();
    }

    /**
     * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 123
     * 输出: 321
     *  示例 2:
     * <p>
     * 输入: -123
     * 输出: -321
     * 示例 3:
     * <p>
     * 输入: 120
     * 输出: 21
     * 注意:
     * <p>
     * 假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为 [−231,  231 − 1]。
     * 请根据这个假设，如果反转后整数溢出那么就返回 0。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/reverse-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int reverse(int x) {
        int result = 0;
        while (x != 0) {
            int pop = x % 10;
            //判断下一步*10是否可能导致越界，直接返回0
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + pop;
            x /= 10;
        }
        return result;
    }

    /**
     * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
     * <p>
     * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。接下来的转化规则如下：
     * <p>
     * 如果第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字字符组合起来，形成一个有符号整数。
     * 假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成一个整数。
     * 该字符串在有效的整数部分之后也可能会存在多余的字符，那么这些字符可以被忽略，它们对函数不应该造成影响。
     * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换，即无法进行有效转换。
     * <p>
     * 在任何情况下，若函数不能进行有效的转换时，请返回 0 。
     * <p>
     * 提示：
     * <p>
     * 本题中的空白字符只包括空格字符 ' ' 。
     * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−231,  231 − 1]。如果数值超过这个范围，请返回  INT_MAX (231 − 1) 或 INT_MIN (−231) 。
     *  
     * <p>
     * 示例 1:
     * <p>
     * 输入: "42"
     * 输出: 42
     * 示例 2:
     * <p>
     * 输入: "   -42"
     * 输出: -42
     * 解释: 第一个非空白字符为 '-', 它是一个负号。
     *      我们尽可能将负号与后面所有连续出现的数字组合起来，最后得到 -42 。
     * 示例 3:
     * <p>
     * 输入: "4193 with words"
     * 输出: 4193
     * 解释: 转换截止于数字 '3' ，因为它的下一个字符不为数字。
     * 示例 4:
     * <p>
     * 输入: "words and 987"
     * 输出: 0
     * 解释: 第一个非空字符是 'w', 但它不是数字或正、负号。
     * 因此无法执行有效的转换。
     * 示例 5:
     * <p>
     * 输入: "-91283472332"
     * 输出: -2147483648
     * 解释: 数字 "-91283472332" 超过 32 位有符号整数范围。
     *      因此返回 INT_MIN (−231) 。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/string-to-integer-atoi
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int myAtoi(String s) {
        int length = s.length();
        if (length == 0) {
            return 0;
        }
        int index = 0;
        int result = 0;
        //1.去掉开始的空格
        while (index < length && s.charAt(index) == ' ') {
            index++;
        }
        //2.如果全都是空格，返回0
        if (index >= length) {
            return 0;
        }
        //3.1为正，-1为负
        int sign = 1;
        // 2.找到正负号
        if (s.charAt(index) == '+' || s.charAt(index) == '-') {
            sign = s.charAt(index) == '-' ? -1 : 1;
            index++;
        }
        while (index < length) {
            //3.判断是否是数字,
            int digit = s.charAt(index) - '0';
            if (digit < 0 || digit > 9) {
                break;
            }
            //4.判断是否越界,如果Integer.MAX_VALUE % 10 > =digit，说明再+digit就会越界
            if (Integer.MAX_VALUE / 10 < result
                    || (Integer.MAX_VALUE / 10 == result && Integer.MAX_VALUE % 10 < digit)) {
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            result = result * 10 + digit;
            index++;
        }
        return result * sign;
    }

    /**
     * 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
     * <p>
     * 示例 1:
     * <p>
     * 输入: 121
     * 输出: true
     * 示例 2:
     * <p>
     * 输入: -121
     * 输出: false
     * 解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
     * 示例 3:
     * <p>
     * 输入: 10
     * 输出: false
     * 解释: 从右向左读, 为 01 。因此它不是一个回文数。
     * 进阶:
     * <p>
     * 你能不将整数转为字符串来解决这个问题吗？
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/palindrome-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isPalindrome(int x) {
        //1.负数肯定不是回文数
        if (x < 0) {
            return false;
        }
        //2.创建两个栈，一个记录，一个用作构建第三个栈
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> stackCopy = new Stack<>();

        int value = x;
        //3.将每一位的数存储起来
        while (value != 0) {
            int pop = value % 10;
            value /= 10;
            stack.push(pop);
            stackCopy.push(pop);
        }
        //4.将每一位的数弹出，存入新的栈stackCompare，这样就是之前的栈反过来
        Stack<Integer> stackCompare = new Stack<>();
        while (!stackCopy.isEmpty()) {
            stackCompare.push(stackCopy.pop());
        }
        //5.只需要比较stackCompare与stack的每一位
        while (!stackCompare.isEmpty()) {
            if (!stack.pop().equals(stackCompare.pop())) {
                return false;
            }
        }
        return true;
    }

    /**
     * 判断一个整数是否是回文数。 最优解
     */
    public boolean isPalindromeBest(int x) {
        // 特殊情况：
        // 如上所述，当 x < 0 时，x 不是回文数。
        // 同样地，如果数字的最后一位是 0，为了使该数字为回文，
        // 则其第一位数字也应该是 0
        // 只有 0 满足这一属性
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        //只需要找到中位，判断revertedNumber与x即可，不需要全部判断
        //举例说明，若x=123454321（位数为奇数）
        //当x=12345 revertedNumber=12345 两者相等了，说明x代表原数的左边，revertedNumber代表右边
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // 当数字长度为奇数时，我们可以通过 revertedNumber/10 去除处于中位的数字。
        // 例如，当输入为 12321 时，在 while 循环的末尾我们可以得到 x = 12，revertedNumber = 123，
        // 由于处于中位的数字不影响回文（它总是与自己相等），所以我们可以简单地将其去除。
        return x == revertedNumber || x == revertedNumber / 10;
    }


    /**
     * 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
     * <p>
     * '.' 匹配任意单个字符
     * '*' 匹配零个或多个前面的那一个元素
     * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/regular-expression-matching
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isMatch(String s, String p) {
        int sLength = s.length();
        int pLength = p.length();
        //1.动态规划，dp[0][0]=true,所以需要sLength+1 pLength+1
        boolean[][] dp = new boolean[sLength + 1][pLength + 1];
        dp[0][0] = true;
        for (int i = 0; i < sLength; i++) {
            for (int j = 1; j < pLength; j++) {
                //2.处理*的特殊情况
                if (s.charAt(j - 1) == '*') {
                    //3.*需要比较他之前的那个字符,比如abc*，需要c*一起比较
                    dp[i][j] = dp[i][j - 2];
                    if (matches(s, p, i, j - 1)) {
                        dp[i][j] = dp[i][j] || dp[i - 1][j];
                    }
                } else {
                    //非*号的好处理
                    if (matches(s, p, i, j)) {
                        dp[i][j] = dp[i - 1][j - 1];
                    }
                }
            }
        }
        return dp[sLength][pLength];
    }


    private boolean matches(String s, String p, int i, int j) {
        if (i == 0) {
            return false;
        }

        if (p.charAt(j - 1) == '.') {
            return true;
        }

        return s.charAt(i - 1) == p.charAt(j - 1);
    }
}
