package tenExercise;


import bean.LinkedNode;
import com.sun.deploy.util.ParameterUtil;
import utils.ParameterUtils;

import java.util.Arrays;

/**
 * @author YuJoy
 * @date 2020/12/17 20:46
 * @description: LeetCode 1-10 主函数
 */
public class TenMain {
    public static void main(String[] args) {
        TenSolution tenSolution = new TenSolution();
        //1.两数之和测试
        /*
        int[] randomArray = ParameterUtils.getInstance().getRandomArray(100);
        int target = (int) (200 * Math.random());
        int[] twoSum = tenSolution.twoSum(randomArray, target);
        System.out.println("两数之和 输入的target  ： " + target);
        System.out.println("两数之和输出  ： " + Arrays.toString(twoSum));
        */

        //2.两数相加测试
        /*
        LinkedNode linkedNodeOne=ParameterUtils.getInstance().getRandomLinked(5,10);
        ParameterUtils.getInstance().printlnLinked(linkedNodeOne);
        LinkedNode linkedNodeTwo=ParameterUtils.getInstance().getRandomLinked(3,10);
        ParameterUtils.getInstance().printlnLinked(linkedNodeTwo);
        LinkedNode linkedNodeResult=tenSolution.addTwoNumbers(linkedNodeOne,linkedNodeTwo);
        ParameterUtils.getInstance().printlnLinked(linkedNodeResult);
        */

        //3.无重复字符的最长子串
        String randomString = ParameterUtils.getRandomLowString(20);
        System.out.println("输入字符串 :" + randomString);
        System.out.println("无重复字符的最长子串 :" + tenSolution.lengthOfLongestSubstring(randomString));
    }

}
