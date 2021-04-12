package _1to99._30to39;

/**
 * @author YuJoy
 * @date 2021/3/13 14:06
 * @description: 30~39
 */
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();
        //30. 串联所有单词的子串
//        solution.findSubstring("barfoothefoobarman",new String[]{"foo","bar"});
        //31. 下一个排列
//        solution.nextPermutation(new int[]{1,2,3});
        //32. 最长有效括号
//        solution.longestValidParentheses("()()((()())()()()()");
        //33. 搜索旋转排序数组
//        solution.search(new int[]{4,5,6,7,0,1,2},0);
        //34. 在排序数组中查找元素的第一个和最后一个位置
//        solution.searchRange(new int[]{5,7,7,8,8,10},8);
        //35. 搜索插入位置
//        solution.searchInsert(new int[]{1,3,5,6},2);
        //36. 有效的数独
        char[][] sudoku = new char[][]{
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
//        solution.isValidSudoku(sudoku);
        //37. 解数独
//        solution.solveSudoku(sudoku);
        //39.组合总和
        solution.combinationSum(new int[]{2, 3, 6, 7}, 7);
    }
}
