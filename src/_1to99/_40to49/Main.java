package _1to99._40to49;


import java.util.Arrays;

/**
 * @author YuJoy
 * @date 2021/3/21 01:59
 * @description: LeetCode 40-49 主函数
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //40. 组合总和 II
//        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
        //41. 缺失的第一个正数
//        solution.firstMissingPositive(new int[]{3,4,-1,1});
        //42. 接雨水
//        solution.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1});
        //43. 字符串相乘
//        solution.multiply("2", "3");
        //44. 通配符匹配
//        solution.isMatch("aa","*");
        //45.跳跃游戏 II
//        solution.jump(new int[]{2,3,1,1,4});
        //46. 全排列
//        solution.permute(new int[]{});
        //47. 全排列 II
//        solution.permuteUnique(new int[]{1,1,1,2,2,2,3,3,3,3,3,3});
        //48. 旋转图像
//        int[][] ma=new int[][]{{1,2,3},{4,5,6},{7,8,9}};
//        for (int i = 0; i < ma.length; i++) {
//            System.out.println(Arrays.toString(ma[i]));
//        }
//        System.out.println("=============" );
//        solution.rotate(new int[][]{{1,2,3},{4,5,6},{7,8,9}});
        //49. 字母异位词分组
        solution.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"});
    }


}
