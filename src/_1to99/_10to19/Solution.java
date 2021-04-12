package _1to99._10to19;

import bean.LinkedNode;

import java.util.*;

/**
 * @author YuJoy
 * @date 2021/01/01 20:46
 * @description: LeetCode 10-19题解
 */
public class Solution {
    /**
     * 给你 n 个非负整数 a1，a2，...，an，每个数代表坐标中的一个点(i,ai) 。在坐标内画 n 条垂直线，垂直线 i的两个端点分别为(i,ai) 和 (i, 0) 。找出其中的两条线，使得它们与x轴共同构成的容器可以容纳最多的水。
     * <p>
     * 说明：你不能倾斜容器。
     * <p>
     * <p>
     * 输入：height = [1,1]
     * 输出：1
     * <p>
     * <p>
     * 输入：[1,8,6,2,5,4,8,3,7]
     * 输出：49
     * <p>
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/container-with-most-water
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length - 1;
        int area = 0;
        while (left < right) {
            area = Math.max(Math.min(height[left], height[right]) * (right - left), area);
            if (height[left] > height[right]) {
                right--;
            } else {
                left++;
            }
        }
        return area;
    }

    private final String[] romanString = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    private final int[] romanInt = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    /**
     * 罗马数字包含以下七种字符：I，V，X，L，C，D和M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
     * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
     * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
     * 给定一个整数，将其转为罗马数字。输入确保在 1到 3999 的范围内。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/integer-to-roman
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String intToRoman(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < romanString.length && num >= 0; i++) {
            while (num >= romanInt[i]) {
                num -= romanInt[i];
                sb.append(romanString[i]);
            }
        }
        return sb.toString();
    }

    /**
     * 罗马数字包含以下七种字符:I，V，X，L，C，D和M。
     * <p>
     * 字符          数值
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * 例如， 罗马数字 2 写做II，即为两个并列的 1。12 写做XII，即为X+II。 27 写做XXVII, 即为XX+V+II。
     * <p>
     * 通常情况下，罗马数字中小的数字在大的数字的右边。但也存在特例，例如 4 不写做IIII，而是IV。数字 1 在数字 5 的左边，所表示的数等于大数 5 减小数 1 得到的数值 4 。同样地，数字 9 表示为IX。这个特殊的规则只适用于以下六种情况：
     * <p>
     * I可以放在V(5) 和X(10) 的左边，来表示 4 和 9。
     * X可以放在L(50) 和C(100) 的左边，来表示 40 和90。
     * C可以放在D(500) 和M(1000) 的左边，来表示400 和900。
     * 给定一个罗马数字，将其转换成整数。输入确保在 1到 3999 的范围内。
     * <p>
     * 
     * <p>
     * 示例1:
     * <p>
     * 输入:"III"
     * 输出: 3
     * 示例2:
     * <p>
     * 输入:"IV"
     * 输出: 4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/roman-to-integer
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int romanToInt(String s) {
        int result = 0;
        int currentInt = 0;

        for (int i = s.length() - 1; i >= 0; i--) {
            int value = getValue(s.charAt(i));
            if (value >= currentInt) {
                //加法
                result += value;
            } else {
                //减法
                result -= value;

            }
            currentInt = value;
        }
        return result;
    }

    private int getValue(char ch) {
        switch (ch) {
            case 'I':
                return 1;
            case 'V':
                return 5;
            case 'X':
                return 10;
            case 'L':
                return 50;
            case 'C':
                return 100;
            case 'D':
                return 500;
            case 'M':
                return 1000;
            default:
                return 0;
        }
    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     * <p>
     * 如果不存在公共前缀，返回空字符串""。
     * <p>
     * 
     * <p>
     * 示例 1：
     * <p>
     * 输入：strs = ["flower","flow","flight"]
     * 输出："fl"
     * 示例 2：
     * <p>
     * 输入：strs = ["dog","racecar","car"]
     * 输出：""
     * 解释：输入不存在公共前缀。
     * 
     * <p>
     * 提示：
     * <p>
     * 0 <= strs.length <= 200
     * 0 <= strs[i].length <= 200
     * strs[i] 仅由小写英文字母组成
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/longest-common-prefix
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        //先假定数组中最短的字符是第0项
        int targetLength = strs[0].length();
        int count = strs.length;
        //这一层循环是从strs[0]的第0个字符开始，确认需要比较的char是什么
        for (int i = 0; i < targetLength; i++) {
            char c = strs[0].charAt(i);
            //这一层循环是从strs的第0项开始，拿每一个子字符串的第i个字符做比较，不满足条件就直接返回
            for (int j = 1; j < count; j++) {
                //当即将到当前对比字符串的最后一个字符，或者最后一个字符与当前需要比较的c不一致，返回
                if (i == strs[j].length() || c != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
     * <p>
     * 注意：答案中不可以包含重复的三元组。
     * <p>
     * 
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [-1,0,1,2,-1,-4]
     * 输出：[[-1,-1,2],[-1,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = []
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：nums = [0]
     * 输出：[]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> threeSum(int[] nums) {
        int length = nums.length;
        //1.排序
        Arrays.sort(nums);
        List<List<Integer>> doubleList = new ArrayList<>();
        //2.第一层循环，先确定第一个值A，把问题转化成剩下两个数之和为-A
        for (int i = 0; i < length; i++) {
            int numberOne = nums[i];
            //3.数组已经按顺序排列了，如果number>0，说明剩下的数都>0,不满足条件了
            if (numberOne > 0) {
                break;
            }
            //4.如果numberOne和它前面一位的数字相等，需要去重复，直接i++
            if (i > 0 && numberOne == nums[i - 1]) {
                continue;
            }
            //5.问题转化成找到数组num[] i 之后,相加为-number的两个数字，使用双指针
            int target = -numberOne;
            int left = i + 1;
            int right = length - 1;

            for (; left < length; left++) {
                //6.和第4步一样，也需要去重复
                if (left > i + 1 && nums[left] == nums[left - 1]) {
                    continue;
                }
                //7.这个时候，我们已经确定了第二个数numberTwo=num[left]，
                //也就说明我们只需要找到numberThree=num[right]满足numberTwo+numberThree=target即可
                //numberThree有且只有一个，如果numberTwo+numberThree>target,说明numberThree需要减小，right指针左移
                while (left < right && nums[left] + nums[right] > target) {
                    right--;
                }
                //8.如果移动到了right=left，说明left找不到满足条件的right，即nums[left]+nums[right]>target一直都满足，left右移也无效了
                //直接跳出循环
                if (left == right) {
                    break;
                }
                //9.如果走到了这里说明可能找到了满足条件的数，再做一次判断，因为有可能此时nums[left]+nums[right]<target
                if (nums[left] + nums[right] == target) {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[i]);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    doubleList.add(list);
                }
            }
        }
        return doubleList;
    }


    /**
     * 给定一个包括n 个整数的数组nums和 一个目标值target。找出nums中的三个整数，使得它们的和与target最接近。返回这三个数的和。假定每组输入只存在唯一答案。
     * <p>
     * 
     * <p>
     * 示例：
     * <p>
     * 输入：nums = [-1,2,1,-4], target = 1
     * 输出：2
     * 解释：与 target 最接近的和是 2 (-1 + 2 + 1 = 2) 。
     * 
     * <p>
     * 提示：
     * <p>
     * 3 <= nums.length <= 10^3
     * -10^3<= nums[i]<= 10^3
     * -10^4<= target<= 10^4
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/3sum-closest
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public int threeSumClosest(int[] nums, int target) {
        //1.排序
        Arrays.sort(nums);
        //2.返回值初始化
        int realResult = 10000000;
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int secondIndex = i + 1;
            int thirdIndex = nums.length - 1;
            while (secondIndex < thirdIndex) {
                int result = first + nums[secondIndex] + nums[thirdIndex];
                //3.说明result比target大，第三个数需要左移
                if (result - target > 0) {
                    if (Math.abs(realResult - target) > Math.abs(result - target)) {
                        realResult = result;
                    }
                    thirdIndex--;
                } else if (result - target < 0) {
                    //4.说明result比target小，第二个数需要右移
                    if (Math.abs(realResult - target) > Math.abs(result - target)) {
                        realResult = result;
                    }
                    secondIndex++;
                } else {
                    //5.找到了最接近的值，直接return
                    realResult = target;
                    break;
                }
            }

        }
        return realResult;
    }

    /**
     * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
     * <p>
     * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
     * <p>
     * <p>
     * <p>
     * 
     * <p>
     * 示例 1：
     * <p>
     * 输入：digits = "23"
     * 输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
     * 示例 2：
     * <p>
     * 输入：digits = ""
     * 输出：[]
     * 示例 3：
     * <p>
     * 输入：digits = "2"
     * 输出：["a","b","c"]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<String> letterCombinations(String digits) {
        int length = digits.length();
        List<String> letterList = new ArrayList<>();
        if (length == 0) {
            return letterList;
        }
        Map<Character, String> phoneMap = new HashMap<Character, String>() {{
            put('2', "abc");
            put('3', "def");
            put('4', "ghi");
            put('5', "jkl");
            put('6', "mno");
            put('7', "pqrs");
            put('8', "tuv");
            put('9', "wxyz");
        }};
        backtrack(letterList, phoneMap, digits, 0, new StringBuffer());
        return letterList;
    }

    public void backtrack(List<String> letterList, Map<Character, String> phoneMap, String digits, int index, StringBuffer stringBuffer) {
        if (index == digits.length()) {
            letterList.add(stringBuffer.toString());
        } else {
            char digit = digits.charAt(index);
            String letters = phoneMap.get(digit);
            int lettersCount = letters.length();
            for (int i = 0; i < lettersCount; i++) {
                stringBuffer.append(letters.charAt(i));
                backtrack(letterList, phoneMap, digits, index + 1, stringBuffer);
                stringBuffer.deleteCharAt(index);
            }
        }
    }

    /**
     * 给定一个包含n 个整数的数组nums和一个目标值target，判断nums中是否存在四个元素 a，b，c和 d，使得a + b + c + d的值与target相等？找出所有满足条件且不重复的四元组。
     * <p>
     * 注意：答案中不可以包含重复的四元组。
     * <p>
     * 
     * <p>
     * 示例 1：
     * <p>
     * 输入：nums = [1,0,-1,0,-2,2], target = 0
     * 输出：[[-2,-1,1,2],[-2,0,0,2],[-1,0,0,1]]
     * 示例 2：
     * <p>
     * 输入：nums = [], target = 0
     * 输出：[]
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/4sum
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> lists = new ArrayList<>();
        int length = nums.length;
        if (length == 0) {
            return lists;
        }

        for (int i = 0; i < length - 3; i++) {
            //1.第一个值去重
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            //2.数组单调递增，四个最小的数相加都大于target，就返回
            if (nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target) {
                break;
            }
            //3.第一个值加上最大的三个值都小于target,肯定找不到
            if (nums[i] + nums[length - 3] + nums[length - 2] + nums[length - 1] < target) {
                continue;
            }
            for (int j = i + 1; j < length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                if (nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target) {
                    break;
                }
                if (nums[i] + nums[j] + nums[length - 2] + nums[length - 1] < target) {
                    continue;
                }
                int thirdIndex = j + 1;
                int fourthIndex = length - 1;
                while (thirdIndex < fourthIndex) {
                    int sum = nums[i] + nums[j] + nums[thirdIndex] + nums[fourthIndex];
                    if (sum == target) {
                        lists.add(Arrays.asList(nums[i], nums[j], nums[thirdIndex], nums[fourthIndex]));
                        //4.第三第四个数只找到了一组，还需要继续，先去重
                        while (thirdIndex < fourthIndex && nums[thirdIndex] == nums[thirdIndex + 1]) {
                            thirdIndex++;
                        }
                        while (thirdIndex < fourthIndex && nums[fourthIndex] == nums[fourthIndex - 1]) {
                            fourthIndex--;
                        }
                    } else if (sum > target) {
                        fourthIndex--;
                    } else {
                        thirdIndex++;
                    }
                }
            }
        }
        return lists;
    }

    /**
     * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
     * <p>
     * 进阶：你能尝试使用一趟扫描实现吗？
     */
    public LinkedNode removeNthFromEnd(LinkedNode head, int n) {
        LinkedNode emptyNode = new LinkedNode(0, head);
        LinkedNode fastNode = head;
        LinkedNode slowNode = emptyNode;
        for (int i = 0; i < n; i++) {
            fastNode = fastNode.next;
        }

        while (fastNode != null) {
            fastNode = fastNode.next;
            slowNode = slowNode.next;
        }
        slowNode.next = slowNode.next.next;

        return emptyNode.next;
    }

    /**
     * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
     * <p>
     * 有效字符串需满足：
     * <p>
     * 左括号必须用相同类型的右括号闭合。
     * 左括号必须以正确的顺序闭合。
     * <p>
     * 来源：力扣（LeetCode）
     * 链接：https://leetcode-cn.com/problems/valid-parentheses
     * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
     */
    public boolean isValid(String s) {
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (char c : chars) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty() || stack.peek() != '(') {
                    return false;
                } else {
                    stack.pop();
                }
            } else if (c == '}') {
                if (stack.isEmpty() || stack.peek() != '{') {
                    return false;
                } else {
                    stack.pop();
                }
            } else {
                if (stack.isEmpty() || stack.peek() != '[') {
                    return false;
                } else {
                    stack.pop();
                }
            }

        }
        return stack.isEmpty();
    }

}
