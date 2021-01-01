package utils;

import bean.LinkedNode;

import java.util.Arrays;
import java.util.Random;

/**
 * @author YuJoy
 * @date 2020/12/17 20:51
 * @description: 构造参数的工具类
 */
public class ParameterUtils {
    private static final String LOWERCASE_LETTER = "abcdefghijklmnopqrstuvwxyz";

    private static final String CAPITAL_LETTER = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    private ParameterUtils() {
    }

    static class ParameterUtilsHolder {
        private static final ParameterUtils instance = new ParameterUtils();
    }

    public static ParameterUtils getInstance() {
        return ParameterUtilsHolder.instance;
    }

    /**
     * 构造非负随机数组
     *
     * @param max 数组最大值
     */
    public int[] getRandomArray(int max) {
        int[] result = new int[max];
        for (int i = 0; i < max; i++) {
            result[i] = i;
        }
        for (int i = 0; i < max; i++) {
            int random = (int) (max * Math.random());
            int temp = result[i];
            result[i] = result[random];
            result[random] = temp;
        }
        System.out.println("两数之和 生成的随机数组为  :" + Arrays.toString(result));
        return result;
    }

    /**
     * 生成一个非负随机数
     *
     * @param max 最大值
     */
    public int getRandom(int max) {
        return (int) (max * Math.random());
    }

    /**
     * 生成一个随机数链表
     *
     * @param size 链表长度
     * @param max  链表中元素最大值
     */
    public LinkedNode getRandomLinked(int size, int max) {
        LinkedNode linkedNodeHead = new LinkedNode();
        LinkedNode linkedNodeAdd = new LinkedNode();
        linkedNodeHead.next = linkedNodeAdd;
        int i = 0;
        while (i < size) {
            LinkedNode linkedNode = new LinkedNode((int) (max * Math.random()));
            linkedNodeAdd.next = linkedNode;
            linkedNodeAdd = linkedNode;
            i++;
        }
        return linkedNodeHead.next.next;
    }

    /**
     * 打印链表
     */
    public void printlnLinked(LinkedNode linkedNode) {
        LinkedNode linkedNodeHead = linkedNode;
        System.out.print("[");
        while (linkedNodeHead != null) {
            String append = (null == linkedNodeHead.next) ? "" : " -> ";
            System.out.print(linkedNodeHead.val + append);
            linkedNodeHead = linkedNodeHead.next;
        }
        System.out.print("]");
    }

    /**
     * 构建指定长度的小写字母字符串
     */
    public String getRandomLowString(int length) {
        return getRandomString(length, LOWERCASE_LETTER);
    }

    /**
     * 构建指定长度的大写字母字符串
     */
    public String getRandomCapitalString(int length) {
        return getRandomString(length, CAPITAL_LETTER);
    }

    /**
     * 根据rule构建随机字符串
     *
     * @param rule 字符串集，现有全大写和全小写
     */
    public String getRandomString(int length, String rule) {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            int number = random.nextInt(26);
            sb.append(rule.charAt(number));
        }
        return sb.toString();
    }

    /**
     * 获取指定长度，指定递增最大值的递增数组
     *
     * @param max    递增最大值
     * @param length 长度
     */
    public int[] getRandomIncreasingArray(int max, int length) {
        int[] result = new int[length];
        int maxValue = 0;
        for (int i = 0; i < length; i++) {
            int value = (int) (maxValue + max * Math.random());
            result[i] = value;
            maxValue = value;

        }
        return result;
    }

}
