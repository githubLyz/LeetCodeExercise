package _100._1to9;


/**
 * @author YuJoy
 * @date 2020/12/17 20:46
 * @description: LeetCode 1-10 主函数
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //1.两数之和
        /*
        int[] randomArray = ParameterUtils.getInstance().getRandomArray(100);
        int target = (int) (200 * Math.random());
        int[] twoSum = tenSolution.twoSum(randomArray, target);
        System.out.println("两数之和 输入的target  ： " + target);
        System.out.println("两数之和输出  ： " + Arrays.toString(twoSum));
        */

        //2.两数相加
        /*
        LinkedNode linkedNodeOne=ParameterUtils.getInstance().getRandomLinked(5,10);
        ParameterUtils.getInstance().printlnLinked(linkedNodeOne);
        LinkedNode linkedNodeTwo=ParameterUtils.getInstance().getRandomLinked(3,10);
        ParameterUtils.getInstance().printlnLinked(linkedNodeTwo);
        LinkedNode linkedNodeResult=tenSolution.addTwoNumbers(linkedNodeOne,linkedNodeTwo);
        ParameterUtils.getInstance().printlnLinked(linkedNodeResult);
        */

        //3.无重复字符的最长子串
        /*
        String randomString = ParameterUtils.getRandomLowString(20);
        System.out.println("输入字符串 :" + randomString);
        System.out.println("无重复字符的最长子串 :" + tenSolution.lengthOfLongestSubstring(randomString));
         */

        //4.寻找两个正序数组的中位数
        /*
        int[] num1=ParameterUtils.getInstance().getRandomIncreasingArray(30,3);
        System.out.println("num1 = " + Arrays.toString(num1));
        int[] num2=ParameterUtils.getInstance().getRandomIncreasingArray(20,10);
        System.out.println("num2 = " + Arrays.toString(num2));
        System.out.println("两个正序数组的中位数 = " + tenSolution.findMedianSortedArrays(num1,num2));
         */

        //5.最长的回文子串
        /*
        System.out.println("最长子串" +tenSolution.longestPalindrome("adsdasdbdfkj"));
        */

        //6. Z 字形变换
        /*
        String zStringBefore = ParameterUtils.getInstance().getRandomCapitalString(30);
        System.out.println("zStringBefore = " + zStringBefore);
        System.out.println();
        String zStringAfter = tenSolution.convert(zStringBefore, 5);
        System.out.println("zStringAfter = " + zStringAfter);
         */

        //7. 整数反转
        /*
        int number = -5465431;
        System.out.println("整数反转 :" + number + "\n" +
                "反转后 :" + tenSolution.reverse(number));
        */
        //8. 字符串转换整数 (atoi)
        /*
        System.out.println("字符串转换整数 = " + tenSolution.myAtoi("-56asdf846484asfasgsarga"));
        */

        //9. 回文数
        /*
        System.out.println(" = " +tenSolution.isPalindromeBest(1234554321));
        */


    }

}
